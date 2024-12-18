package hospital.doctor;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/addDoctor")
public class AddDoctorServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private DoctorDao doctorDao = new DoctorDao();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("doctorinfo.html").forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Retrieve form parameters
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String specialization = request.getParameter("specialization");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        int age = Integer.parseInt(request.getParameter("age"));
        String bloodGroup = request.getParameter("blood");
        String password = request.getParameter("password");
        Doctor doctor = new Doctor(name, email, specialization, phone, address, age, bloodGroup, password);
        doctorDao.addDoctor(doctor);
        response.sendRedirect("listDoctors");
    }
}
