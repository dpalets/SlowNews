import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Dmytro.Palets on 17.11.2015.
 */
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

 //           req.getRequestDispatcher("login.jsp").forward(req, resp);


        }



    
    private boolean loginCorrect(String login, String password, ArrayList<User> allUsers) {
        for (int i = 0; i < allUsers.size(); i++) {
            if (!(allUsers.get(i).getLogin().isEmpty()) &&
                    allUsers.get(i).getLogin().equals(login) &&
                    allUsers.get(i).getPassword().equals(password))
            {return true;}
        }
        return false;
    }

    }

