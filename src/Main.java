import org.jsoup.*;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
    /*Document doc = Jsoup.connect("https://terramare.vn.ua/menu-dostavki/pizza/").get();

    Elements prices = doc.getElementsByClass("products columns-4");


    for(Element price : prices){

        String title = price.getElementsByClass("woocommerce-loopproduct__title").text();

        String desc = price.getElementsByClass("description").text();


        System.out.println(title);*/


        Document doc = Jsoup.connect("http://en.wikipedia.org/").get();
        log(doc.title());

        Elements newsHeadlines = doc.select("#mp-itn b a");
        for (Element headline : newsHeadlines) {
            log("%s\n\t%s", headline.attr("title"), headline.absUrl("href"));
        }
    }

    private static void log(String msg, String... vals) {
        System.out.println(String.format(msg, vals));
    }

    }





