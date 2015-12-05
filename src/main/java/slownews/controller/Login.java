package slownews.controller;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import slownews.model.User;


/**
 * Created by Dmytro.Palets on 17.11.2015.
 */
@WebServlet("/Login")

public class Login extends HttpServlet {

    private static final String LOGINPAGE = "/WEB-INF/view/login.jsp";
    private static final String NEWSPAGE = "/WEB-INF/view/newspage.jsp";
    private static final String LOGINERROR = "/WEB-INF/view/loginerror.jsp";


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        HashMap<String, User> allUsers = null;

        if (req.getSession().getServletContext().getAttribute("allUsers") instanceof HashMap) {
            allUsers = (HashMap) req.getSession().getServletContext().getAttribute("allUsers");

            String login = req.getParameter("login");
            String password = req.getParameter("password");

            if (login == null || login.isEmpty()) {
                req.getRequestDispatcher(LOGINPAGE).forward(req, resp);
            }

            if (allUsers.containsKey(login) &&
                    allUsers.get(login).getPassword().equals(password)) {
                req.getSession().setAttribute("currentUser", allUsers.get(login));
                req.getRequestDispatcher(NEWSPAGE).forward(req, resp);
            } else {
                req.setAttribute("errormessage", "Incorrect credentials");
                req.getRequestDispatcher(LOGINPAGE).forward(req, resp);
            }
        }


    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        if (req.getSession().getAttribute("currentUser") == null) {
            req.getRequestDispatcher(LOGINPAGE).forward(req, resp);
        } else {
            req.getRequestDispatcher("/").forward(req, resp);
        }
    }


/*        protected void service(HttpServletRequest req, HttpServletResponse resp)
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
                    req.getRequestDispatcher(NEWSPAGE).forward(req, resp);
                }
            }

            else {
                req.getRequestDispatcher(LOGINERROR).forward(req, resp);
            }

        }*/


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

