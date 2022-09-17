import org.jsoup.*;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.URL;

public class Main {

    public static void main(String[] args) throws IOException {

        Document doc = Jsoup.connect("https://terramare.vn.ua/menu-dostavki/pizza/").get();


        Elements pizzas = doc.getElementsByClass("product-item");
        //System.out.println(pizzas.toString());

        for (Element pizza : pizzas){
            
            String desc = pizza.getElementsByClass("woocommerce-loop-product__title").text();

            System.out.println(desc);

        }



    }
}

