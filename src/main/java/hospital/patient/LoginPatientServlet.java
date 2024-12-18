package hospital.patient;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/patientLogin")
public class LoginPatientServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private PatientDao patientDao = new PatientDao();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password"); 

        Patient patient = patientDao.getPatientByEmail(email);

        if (patient != null) {
            
            if (patient!= null && patient.getPassword().equals(password)) {
                // Passwords match
                HttpSession session = request.getSession(true);
                session.setAttribute("loggedInPatient", patient);
                response.sendRedirect("PatientPage.jsp");
            }
            else {
                // Invalid password
                request.setAttribute("errorMessage", "Invalid email or password");
                request.getRequestDispatcher("patient.jsp").forward(request, response);
            }
        } 
    }
}
