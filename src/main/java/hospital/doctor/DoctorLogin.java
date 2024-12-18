package hospital.doctor;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/doctorlogin")
public class DoctorLogin extends HttpServlet { 
    private static final long serialVersionUID = 1L;
    private DoctorDao doctorDao = new DoctorDao();
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");       
        Doctor doctor = doctorDao.getDoctorByEmail(email);
        if (doctor != null && doctor.getPassword().equals(password)) {
            // Passwords match
            HttpSession session = request.getSession(true);
            session.setAttribute("loggedInDoctor", doctor);
            response.sendRedirect("doctorSectionInfo.html");
        } else {
            // Invalid email or password
            request.setAttribute("errorMessage", "Invalid email or password");
            request.getRequestDispatcher("doctor.jsp").forward(request, response);
        }
    }
}
