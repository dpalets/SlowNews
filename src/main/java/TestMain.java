import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.eclipse.persistence.jaxb.JAXBContextFactory; /* MOXy added here*/

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;
import java.io.IOException;
import java.io.StringReader;


/**
 * Created by Dmytro.Palets on 23.11.2015.
 */
public class TestMain {


//   @JsonIgnoreProperties(ignoreUnknown = true)

    public static void main(String[] args) throws IOException, JAXBException {
        String responseStringWeather = ClientBuilder.newClient()
                .target("http://api.openweathermap.org/data/2.5/weather?q=Kiev&appid=2de143494c0b295cca9337e1e96b00e0").path("")
                .request().get(String.class);

        System.out.println(responseStringWeather);

        String responseStringNews = ClientBuilder.newClient()
                .target("http://rss.unian.net").path("/site/news_rus.rss").request().get(String.class);


        ObjectMapper mapper = new ObjectMapper();
 //       mapper.configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES, false);

        WeatherConditions currentWeather = mapper.readValue(responseStringWeather, WeatherConditions.class);

        System.out.println(currentWeather.getTemperature());

        /*JAXBContext context = JAXBContextFactory.createContext(new Class[] {NewsItem.class}, null);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        NewsItem newsItem = (NewsItem) unmarshaller.unmarshal(new StreamSource(new StringReader(responseStringNews)));*/

        JAXBContext context = JAXBContextFactory.createContext(new Class[] {AllNews.class}, null);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        AllNews newsItems = (AllNews) unmarshaller.unmarshal(new StreamSource(new StringReader(responseStringNews)));

     /*   System.out.println(newsItem.getNewsTitle());
        System.out.println(newsItem.getNewsBody());
        System.out.println(newsItem.getNewsLink());
        System.out.println(newsItem.getPubDate());  */

    //   System.out.println(responseStringNews);

        System.out.println(newsItems.getNewsItems());

    }

}
