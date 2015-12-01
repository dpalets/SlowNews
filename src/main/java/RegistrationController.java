import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * Created by Dmytro.Palets on 16.11.2015.
 */
public class RegistrationController extends HttpServlet {

    @Override
    public void doGet (HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        processRequest(req, resp);
    }


    @Override
    public void doPost (HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        processRequest(req, resp);
    }

    protected void processRequest(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        req.getRequestDispatcher("jsp/registration.jsp").forward(req, resp);
    }
}
