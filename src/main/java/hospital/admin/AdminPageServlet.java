package hospital.admin;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/adminpage")
public class AdminPageServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 
        HttpSession session = request.getSession(false); 
        if (session == null || session.getAttribute("loggedInAdmin") == null) {
        
            response.sendRedirect("adminLogin.html");
        } else {
     
            request.getRequestDispatcher("adminpage.html").forward(request, response);
        }
    }
}
