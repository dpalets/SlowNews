import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * Created by Dmytro.Palets on 15.11.2015.
 */
public class SlowNewsServlet extends HttpServlet {

    ArrayList<User> allUsers = new ArrayList<>();

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        processRequest(req, resp);
    }


    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        processRequest(req, resp);
    }

    protected void processRequest(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {


        if (loginFree(req.getParameter("login"))) {

            User currentUser = new User(req.getParameter("firstName"), req.getParameter("lastName"),
                    req.getParameter("login"), req.getParameter("password"));


            currentUser.saveUserCredentials();

            allUsers.add(currentUser);

            HttpSession session = req.getSession(true);
            if (session.getAttribute("currentUser") == null) {
                session.setAttribute("currentUser", currentUser);
            }

            req.setAttribute("currentUser", currentUser);
            req.getRequestDispatcher("welcome.jsp").forward(req, resp);

        }

        else {
            req.getRequestDispatcher("registrationerror.jsp").forward(req, resp);
            }
    }

    public boolean loginFree(String login) {

        for (int i = 0; i < allUsers.size(); i++)
        {  if (!(allUsers.get(i).getLogin().isEmpty()) && allUsers.get(i).getLogin().equals(login)) return false; }

        return true;
    }

    }


