package hospital.doctor;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/updateDoctor")
public class UpdateDoctorServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private DoctorDao doctorDao = new DoctorDao();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String doctorIdParam = request.getParameter("id");
        if (doctorIdParam != null) {
            Long doctorId = Long.parseLong(doctorIdParam);
            Doctor doctor = doctorDao.getDoctor(doctorId);
            request.setAttribute("doctor", doctor);
            request.getRequestDispatcher("updateDoctor.jsp").forward(request, response);
        } else {
            response.sendRedirect("listDoctors");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String doctorIdParam = request.getParameter("id");
        if (doctorIdParam != null) {
            Long doctorId = Long.parseLong(doctorIdParam);

            String name = request.getParameter("name");
            String email = request.getParameter("email");
            String specialization = request.getParameter("specialization");
            String phone = request.getParameter("phone");
            String address = request.getParameter("address");
            String ageParam = request.getParameter("age");
            String bloodGroup = request.getParameter("bloodGroup");
            String password = request.getParameter("password");

            // Update doctor information
            Doctor doctor = doctorDao.getDoctor(doctorId);
            doctor.setName(name);
            doctor.setEmail(email);
            doctor.setSpecialization(specialization);
            doctor.setPhone(phone);
            doctor.setAddress(address);
            doctor.setAge(Integer.parseInt(ageParam));
            doctor.setBloodGroup(bloodGroup);
            doctor.setPassword(password);

            doctorDao.updateDoctor(doctor);

            response.sendRedirect("listDoctors");
        } else {
            response.sendRedirect("listDoctors");
        }
    }
}
