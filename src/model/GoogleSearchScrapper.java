package src.model;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javax.swing.*;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

    public class GoogleSearchScrapper {
        //private static Logger logger;
        public static void main(String[] args) {
            ArrayList links=new ArrayList();
            links=new GoogleSearchScrapper().getLinksFromGoogle("what is List View?");
            ArrayList names=new ArrayList();
            names=new GoogleSearchScrapper().getLinksNamesFromGoogle("what is List View?");
            for (Object i:names) {
                System.out.println(i);
            }
            for (Object i:links){
                System.out.println(i);
            }
        }
        private static ArrayList linksNamesFromGoogle=new ArrayList();
        private static ArrayList linksFromGoogle=new ArrayList();
        public ArrayList getLinksFromGoogle(String searchKey){
            String encoding = "UTF-8";
            try {
                String searchText = searchKey;
                Document google = Jsoup.connect("https://www.google.com/search?q=" + URLEncoder.encode(searchText,encoding)).userAgent("Mozilla/5.0").get();

                Elements webSitesLinks = google.getElementsByTag("cite");
                Elements names=google.getElementsByClass("r");
                if (webSitesLinks.isEmpty()) {
                    System.out.println("No results found");
                }
                webSitesLinks.forEach(new Consumer<Element>() {
                    @Override
                    public void accept(Element link) {
                        GoogleSearchScrapper.linksFromGoogle.add(link.text());
                    }
                });
            } catch (IOException e) {
                e.printStackTrace();
            }
            return linksFromGoogle;
        }
        public ArrayList getLinksNamesFromGoogle(String searchKey){

            String encoding = "UTF-8";
            try {
                String searchText = searchKey;
                Document google = Jsoup.connect("https://www.google.com/search?q=" + URLEncoder.encode(searchText,encoding)).userAgent("Mozilla/5.0").get();

                Elements webSitesLinks = google.getElementsByTag("cite");
                Elements names=google.getElementsByClass("r");
                if (webSitesLinks.isEmpty()) {
                    System.out.println("No results found");
                }
                names.forEach(new Consumer<Element>() {
                                  @Override
                                  public void accept(Element element) {
                                      //System.out.println(element.text());
                                      GoogleSearchScrapper.linksNamesFromGoogle.add(element.text());
                                  }
                              }
                );
            } catch (IOException e) {
                e.printStackTrace();
            }
            return linksNamesFromGoogle;
        }
    }