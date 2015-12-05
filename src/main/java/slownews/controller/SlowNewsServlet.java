package slownews.controller;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;
import slownews.model.User;

/**
 * Created by Dmytro.Palets on 15.11.2015.
 */
@WebServlet("/SlowNewsServlet")

public class SlowNewsServlet extends HttpServlet {

    private final String registrationError = "/WEB-INF/view/registrationerror.jsp";

   public ArrayList<User> allUsers = new ArrayList<>();

//    AllUsers allUsers = new AllUsers();

/*    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        processRequest(req, resp);
    }


    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        processRequest(req, resp);
    }*/

    protected void service(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

           if (loginFree(req.getParameter("login"))) {

            User currentUser = new User(req.getParameter("firstName"), req.getParameter("lastName"),
                    req.getParameter("login"), req.getParameter("password"));




            allUsers.add(currentUser);

            HttpSession session = req.getSession(true);
            if (session.getAttribute("currentUser") == null) {
                session.setAttribute("currentUser", currentUser);
            }

            ServletContext slowNewsContext = getServletContext();
            if (slowNewsContext.getAttribute("allUsers") == null) {
                slowNewsContext.setAttribute("allUsers", allUsers);
            }

            req.setAttribute("currentUser", currentUser);
            req.getRequestDispatcher("/NewsController").forward(req, resp);

        }

        else {
            req.getRequestDispatcher(registrationError).forward(req, resp);
            }
    }

    public boolean loginFree(String login) {

        for (int i = 0; i < allUsers.size(); i++)
        {  if (!(allUsers.get(i).getLogin().isEmpty()) && allUsers.get(i).getLogin().equals(login))
            return false; }

        return true;
    }


}


