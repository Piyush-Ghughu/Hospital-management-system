package hospital.patient;

import hospital.doctor.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/patientDoctorList")
public class ListDoctorPatient extends HttpServlet  {
		private static final long serialVersionUID = 1L;

		private DoctorDao doctorDao = new DoctorDao();
		@Override
		protected void doGet(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			List<Doctor> doctors = doctorDao.getDoctors();
			request.setAttribute("doctors", doctors);
			request.getRequestDispatcher("patientDoctorList.jsp").forward(request, response);
		}

	}








