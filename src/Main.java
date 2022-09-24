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
            String desc = pizza.getElementsByAttributeValue("itemprop", "description").text();


            System.out.print(title + " " + price + "   |   " + desc);
            System.out.println(" ");


        }
        
        /*Document doc1 = Jsoup.connect("https://express-pizza.vn.ua/catalog/pitstsa/").get();
        Elements pizzas1 = doc1.getElementsByClass("col-lg-3 col-xl-3 col-sm-6 product-ajax-cont ");

        for (Element pizza1 : pizzas1){
            String desc = pizza1.getElementsByAttributeValue("itemprop", "name").text();
            String pizzaaaa = pizza1.getElementsByAttributeValue("itemprop", "price").text();
            String opus = pizza1.getElementsByAttributeValue("itemprop", "description").text();

            System.out.println(desc + "   " + "\t" + pizzaaaa + " грн" + "\t" + opus);
        }*/

    }
}
