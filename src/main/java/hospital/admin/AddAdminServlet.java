package hospital.admin;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/addAdmin")
public class AddAdminServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private AdminDao adminDao = new AdminDao();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("admininfo.html").forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Retrieve form parameters
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String qualification = request.getParameter("qualification");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        int age = Integer.parseInt(request.getParameter("age"));
        String bloodGroup = request.getParameter("blood");
        String password = request.getParameter("password");
        Admin admin = new Admin(name, email, qualification, phone, address, age, bloodGroup, password);
        adminDao.addAdmin(admin);
        response.sendRedirect("listAdmins");
    }
}
