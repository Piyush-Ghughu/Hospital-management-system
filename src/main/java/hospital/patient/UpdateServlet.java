package hospital.patient;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/updatePatient")
public class UpdateServlet extends HttpServlet {

    private PatientDao patientDao = new PatientDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = Long.parseLong(req.getParameter("id"));
        Patient patient = patientDao.getPatient(id);
        req.setAttribute("patient", patient);
        req.getRequestDispatcher("updatePatient.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = Long.parseLong(req.getParameter("id"));
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        Patient patient = new Patient(id, name, email, password);
        patientDao.updatePatient(patient);

        // Redirect to the patient list page after updating
        resp.sendRedirect("listPatients");
    }
}
