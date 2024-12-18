package hospital.appointment;


import hospital.appointment.Appointment;
import hospital.patient.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

public class AppointmentDao {

    // Create a new appointment
    public void createAppointment(Appointment appointment) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(appointment);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    // Get appointments by doctor
    public List<Appointment> getAppointmentsByDoctor(Long doctorId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM Appointment WHERE doctorId = :doctorId", Appointment.class)
                    .setParameter("doctorId", doctorId)
                    .list();
        }
    }

    // Get appointments by patient
    public List<Appointment> getAppointmentsByPatient(Long patientId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM Appointment WHERE patientId = :patientId", Appointment.class)
                    .setParameter("patientId", patientId)
                    .list();
        }
    }

    // Update the appointment status (e.g., "Approved", "Denied", "Cancelled")
    public void updateAppointmentStatus(Long appointmentId, String status) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Appointment appointment = session.get(Appointment.class, appointmentId);
            appointment.setStatus(status);
            session.update(appointment);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    // Delete an appointment
    public void deleteAppointment(Long appointmentId) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Appointment appointment = session.get(Appointment.class, appointmentId);
            if (appointment != null) {
                session.delete(appointment);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
}
