package hospital.patient;

import hospital.doctor.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/listPatients")
public class ListServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private PatientDao patientDao = new PatientDao();

    public ListServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Patient> patients = patientDao.getPatients();
 

        request.setAttribute("patients", patients);

        request.getRequestDispatcher("ListPatient.jsp").forward(request, response);
    }
}
