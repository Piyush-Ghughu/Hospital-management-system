package hospital.admin;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/updateAdmin")
public class UpdateAdminServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private AdminDao adminDao = new AdminDao();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String adminIdParam = request.getParameter("id");
        if (adminIdParam != null && !adminIdParam.trim().isEmpty()) {
            try {
                Long adminId = Long.parseLong(adminIdParam);
                Admin admin = adminDao.getAdmin(adminId);
                request.setAttribute("admin", admin);
                request.getRequestDispatcher("updateAdmin.jsp").forward(request, response);
            } catch (NumberFormatException e) {
                e.printStackTrace();
                response.sendRedirect("listAdmins");
            }
        } else {
            response.sendRedirect("listAdmins");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String adminIdParam = request.getParameter("id");
        if (adminIdParam != null && !adminIdParam.trim().isEmpty()) {
            try {
                Long adminId = Long.parseLong(adminIdParam);

                String name = request.getParameter("name");
                String email = request.getParameter("email");
                String qualification = request.getParameter("qualification");
                String phone = request.getParameter("phone");
                String address = request.getParameter("address");
                String ageParam = request.getParameter("age");
                String bloodGroup = request.getParameter("bloodGroup");
                String password = request.getParameter("password");
                // Update admin information
                Admin admin = adminDao.getAdmin(adminId);
                admin.setName(name);
                admin.setEmail(email);
                admin.setQualification(qualification);
                admin.setPhone(phone);
                admin.setAddress(address);
                admin.setAge(Integer.parseInt(ageParam));
                admin.setBloodGroup(bloodGroup);
                admin.setPassword(password);
                adminDao.updateAdmin(admin);

                response.sendRedirect("listAdmins");
            } catch (NumberFormatException e) {
                e.printStackTrace();
                response.sendRedirect("listAdmins");
            }
        } else {
            response.sendRedirect("listAdmins");
        }
    }
}
