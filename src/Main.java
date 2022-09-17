import org.jsoup.*;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;


public class Main {

    public static void main(String[] args) throws IOException {

        Document doc = Jsoup.connect("https://terramare.vn.ua/menu-dostavki/pizza/").get();


        Elements pizzas = doc.getElementsByClass("product-item");


        for (Element pizza : pizzas){

            String title = pizza.getElementsByClass("woocommerce-loop-product__title").text();

            String price = pizza.getElementsByClass("woocommerce-Price-amount amount").text();
            String symb = pizza.getElementsByClass("woocommerce-Price-currencySymbol").text();

            System.out.print(title + " " + price);
            System.out.println(" ");


        }

    }
}
