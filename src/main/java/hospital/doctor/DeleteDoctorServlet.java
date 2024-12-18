package hospital.doctor;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteDoctor")
public class DeleteDoctorServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private DoctorDao doctorDao = new DoctorDao();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        String doctorIdParam = request.getParameter("id");
        if (doctorIdParam != null) {
            Long doctorId = Long.parseLong(doctorIdParam);
            doctorDao.deleteDoctor(doctorId);
        }
        response.sendRedirect("listDoctors");  
    }
}
