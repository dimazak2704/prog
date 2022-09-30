import org.jsoup.*;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {


        HashMap<String, String > map = new HashMap<>();
        LinkedHashMap<String, String> sortedMap = new LinkedHashMap<>();
        ArrayList<String> list = new ArrayList<>();


        System.out.println("ПЕРШИЙ САЙТ");
        Document doc = Jsoup.connect("https://la.ua/vinnytsya/").get();
        Elements pizzas = doc.getElementsByClass("col-md-6 col-lg-4");
        for (Element pizza : pizzas){
          //String title = pizza.getElementsByClass("productTitle h5").text();
          String desc = pizza.getElementsByClass("productDescription ").text();
          String price = pizza.getElementsByClass("productPrice").text();
          System.out.println(price + "\t" + desc);

        }


        System.out.println("\n" + "\n" + "ДРУГИЙ САЙТ" + "\n" + "\n");
        Document doc1 = Jsoup.connect("https://express-pizza.vn.ua/catalog/pitstsa/").get();
        Elements pizzas1 = doc1.getElementsByClass("col-lg-3 col-xl-3 col-sm-6 product-ajax-cont ");
        for (Element pizza1 : pizzas1){
            String title1 = pizza1.getElementsByAttributeValue("itemprop", "name").text();
            String price1 = pizza1.getElementsByAttributeValue("itemprop", "price").text();
            String desc1 = pizza1.getElementsByAttributeValue("itemprop", "description").text();
            map.put(title1, price1);
            //System.out.println(title1 + "   " + "\t" + price1 + " грн" + "\t" + desc1);
        }


        System.out.println("\n" + "\n" + "ТРЕТІЙ САЙТ" + "\n" + "\n");
        Document doc2 = Jsoup.connect("https://paparoni.com.ua/").get();
        Elements pizzas2 = doc2.getElementsByClass("isotope-item align-left tm-has-options product type-product post-192 status-publish first instock product_cat-20 has-post-thumbnail shipping-taxable purchasable product-type-simple");
        for (Element pizza2 : pizzas2){
            String title2 = doc2.getElementsByClass("desc").text();
            System.out.println(title2);
        }
        //int a =




        //sorting
        for (Map.Entry<String, String> entry : map.entrySet()) {
            list.add(entry.getValue());
        }
        Collections.sort(list, new Comparator<String>() {
            public int compare(String str, String str1) {
                return (str).compareTo(str1);
            }
        });
        for (String str : list) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (entry.getValue().equals(str)) {
                    sortedMap.put(entry.getKey(), str);
                }
            }
        }

        for (String s : sortedMap.keySet()){
            System.out.println(s + " = " + map.get(s));
        }
    }
}
