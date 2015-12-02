import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Dmytro.Palets on 17.11.2015.
 */
@WebServlet("/")

public class LoginController extends HttpServlet {


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

            ServletContext loginControllerContext = getServletContext();

            ArrayList<User> allUsers = new ArrayList<>();
 //           allUsers.add(new User("dummy", "dummy", "dummy", "dummy"));

            if (loginControllerContext.getAttribute("allUsers") instanceof ArrayList) {
                allUsers = (ArrayList<User>)loginControllerContext.getAttribute("allUsers");
            }

            if (req.getParameter("login") != null &&
                    currentUser(req.getParameter("login"), req.getParameter("password"),
                    allUsers) != null) {
                HttpSession session = req.getSession(true);
                if (session.getAttribute("currentUser") == null) {

                    User currentUser = currentUser(req.getParameter("login"),
                            req.getParameter("password"), allUsers);

                    session.setAttribute("currentUser", currentUser);
                    req.setAttribute("currentUser", currentUser);
                    req.getRequestDispatcher("jsp/welcome.jsp").forward(req, resp);
                }
            }

            else {
                req.getRequestDispatcher("jsp/loginerror.jsp").forward(req, resp);
            }

        }


    User currentUser(String login, String password, ArrayList<User> allUsers) {

        for (int i = 0; i < allUsers.size(); i++) {
            if (allUsers.get(i).getLogin() != null &&
                    allUsers.get(i).getLogin().equals(login) &&
                    allUsers.get(i).getPassword().equals(password)) {
                return allUsers.get(i);
            }
        }
        return null;
    }

    }

