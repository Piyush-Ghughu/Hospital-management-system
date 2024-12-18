package hospital.doctor;

import hospital.patient.HibernateUtil;

import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

public class DoctorDao {
	public Doctor getDoctorByEmail(String email) {
	    Transaction transaction = null;
	    Doctor doctor = null;

	    try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	       
	        transaction = session.beginTransaction();
	       
	        doctor = (Doctor) session.createQuery("FROM Doctor WHERE email = :email", Doctor.class)
	                                 .setParameter("email", email)
	                                 .uniqueResult();
	        transaction.commit();
	    } catch (Exception e) {
	        if (transaction != null) {
	            transaction.rollback();
	        }
	        e.printStackTrace();
	    }
	    return doctor;
	}


	public void addDoctor(Doctor doctor) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			session.save(doctor);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	public void updateDoctor(Doctor doctor) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			session.update(doctor);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	public void deleteDoctor(Long doctorId) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			Doctor doctor = session.get(Doctor.class, doctorId);
			if (doctor != null) {
				session.delete(doctor);
			}
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	public List<Doctor> getDoctorsBySpecialization(String specialization) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			return session.createQuery("FROM Doctor WHERE specialization = :specialization", Doctor.class)
					.setParameter("specialization", specialization).list();
		}
	}

	public List<Doctor> getDoctors() {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			return session.createQuery("FROM Doctor", Doctor.class).list();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public Doctor getDoctor(Long doctorId) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			return session.get(Doctor.class, doctorId);
		} catch (Exception e) {
			e.printStackTrace(); // Or use a logger to log the exception
			return null;
		}
	}

}
