package slownews;

import slownews.model.User;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

/**
 * Created by Dmytro.Palets on 05.12.2015.
 */
@WebServlet("/")
public class Start extends HttpServlet {

    private HashMap<String, User> allUsers;

    @Override
    public void init() {
        allUsers = new HashMap<>();
        User dummyUser = new User("dummy", "dummy", "dummy", "dummy");
        allUsers.put(dummyUser.getLogin(), dummyUser);
    }

    protected void service(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        req.getSession().getServletContext().setAttribute("allUsers", allUsers);

        if (req.getSession().getAttribute("currentUser") == null) {
            req.getRequestDispatcher("Login").forward(req, resp);
        } else {
            req.getRequestDispatcher("News").forward(req, resp);
        }
    }
}
