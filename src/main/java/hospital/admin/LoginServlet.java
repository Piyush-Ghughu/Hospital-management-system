package hospital.admin;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private AdminDao adminDao = new AdminDao();
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        // Fetch admin by email
        Admin admin = adminDao.getAdminByEmail(email);

        if (admin != null && admin.getPassword().equals(password)) {
            // Passwords match
            HttpSession session = request.getSession(true);
            session.setAttribute("loggedInAdmin", admin);
            response.sendRedirect("adminpage.jsp"); // Redirect to the dashboard or any other page
        } else {
            // Invalid email or password
            request.setAttribute("errorMessage", "Invalid email or password");
            request.getRequestDispatcher("admin.jsp").forward(request, response);
        }
    }
}
