package hospital.patient;
import hospital.doctor.Doctor;
import hospital.doctor.ListServletDoctor;
import org.hibernate.Session;
import org.hibernate.Transaction;
import javax.persistence.TypedQuery;
import com.mysql.cj.Query;

import java.util.List;

public class PatientDao {
	
	public Patient getPatientByEmail(String email) {
		Transaction transaction = null;
		Patient patient = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			patient = (Patient) session.createQuery("FROM Patient WHERE email = :email")
					.setParameter("email", email)
					.uniqueResult();
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return patient;
	}
	

	public void addPatient(Patient patient) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			session.save(patient);
			transaction.commit(); // Ensure the transaction is committed before returning
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback(); // Rollback if there's an error
			}
			e.printStackTrace();
		}
		// No need to close the session manually; try-with-resources handles it.
	}



	public void updatePatient(Patient patient) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			session.update(patient);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	public void deletePatient(Long patientId) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			Patient patient = session.get(Patient.class, patientId);
			if (patient != null) {
				session.delete(patient);
			}
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	public List<Patient> getPatients() {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			return session.createQuery("FROM Patient", Patient.class).list();
		}
	}

	public Patient getPatient(Long patientId) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			return session.get(Patient.class, patientId);
		}
	}

	public List<Doctor> getDoctorsBySpecialization(String specialization) {
	    List<Doctor> doctors = null;
	    Transaction transaction = null;
	    try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	        transaction = session.beginTransaction();
	        TypedQuery<Doctor> query = session.createQuery("FROM Doctor WHERE specialization = :specialization", Doctor.class);
	        query.setParameter("specialization", specialization);
	        doctors = query.getResultList();
	        transaction.commit();
	    } catch (Exception e) {
	        if (transaction != null) transaction.rollback();
	        e.printStackTrace();
	    }
	    return doctors;
	}
}
