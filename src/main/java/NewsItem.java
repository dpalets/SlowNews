import org.eclipse.persistence.oxm.annotations.XmlPath;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Dmytro.Palets on 25.11.2015.
 */
@XmlRootElement(name="rss")
@XmlAccessorType(XmlAccessType.FIELD)
public class NewsItem {

    @XmlPath("channel/item/title/text()")
    private String newsTitle;

    @XmlPath("channel/item/description/text()")
    private String newsBody;


    public String getNewsTitle() {
        return newsTitle;
    }


    public void setNewsTitle(String newsTitle) {
        this.newsTitle = newsTitle;
    }

    public String getNewsBody() {
        return newsBody;
    }

    public void setNewsBody(String newsBody) {
        this.newsBody = newsBody;
    }
}
