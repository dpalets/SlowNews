package slownews.model;

import org.eclipse.persistence.oxm.annotations.XmlPath;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Dmytro.Palets on 25.11.2015.
 */
//@XmlRootElement(name="rss")
//@XmlAccessorType(XmlAccessType.FIELD)
public class NewsItem {

    @XmlPath("title/text()")
    private String newsTitle;

    @XmlPath("description/text()")
    private String newsBody;

    @XmlPath("link/text()")
    private String newsLink;

    @XmlPath("pubDate/text()")
    private String pubDate;


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

    public String getNewsLink() {
        return newsLink;
    }

    public String getPubDate() {
        return pubDate;
    }

    @Override
    public String toString() {
        return "NewsItem{" +
                "newsTitle='" + newsTitle + '\'' +
                ", newsBody='" + newsBody + '\'' +
                ", newsLink='" + newsLink + '\'' +
                ", pubDate='" + pubDate + '\'' +
                '}';
    }
}


