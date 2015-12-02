import org.eclipse.persistence.jaxb.JAXBContextFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.client.ClientBuilder;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;
import java.io.IOException;
import java.io.StringReader;

/**
 * Created by Dmytro.Palets on 01.12.2015.
 */
@WebServlet("/NewsController")

public class NewsController extends HttpServlet {

    @Override
    public void doGet (HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        processRequest(req, resp);
    }


    @Override
    public void doPost (HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException  {
        processRequest(req, resp);
    }

    protected void processRequest(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String responseStringNews = ClientBuilder.newClient()
                .target("http://rss.unian.net").path("/site/news_rus.rss").request().get(String.class);

        try {
            JAXBContext context = JAXBContextFactory.createContext(new Class[] {AllNews.class}, null);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            AllNews newsItems = (AllNews) unmarshaller.unmarshal(new StreamSource(new StringReader(responseStringNews)));
        }
        catch (JAXBException je) {
            je.printStackTrace();
        }

        HttpSession session = req.getSession(true);

        if (session.getAttribute("currentUser") instanceof User) {
            User currentUser = (User)session.getAttribute("currentUser");
        }
        req.getRequestDispatcher("jsp/welcome.jsp").forward(req, resp);
    }
}
