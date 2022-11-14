package Util;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JsoupUtil {

    /**
     * Metoda uzima naslove sa interneta i njih stavlja u listu stringova
     * @return listu tih naslova u tipu stringa
     */
    public static List<String> citajNaslove() {
        List<String> list = new ArrayList<>();
        try {
            Document document = Jsoup.connect("https://www.stetoskop.info/aktuelno").get();
            Elements e = document.select("#content > div > div > div.col-lg-9.bottommargin > div");
            int count = 0;
            for (Element el : e) {
                String naslov = el.select("h4").text();
                list.add(naslov);
                count++;
                if (count == 10) {
                    break;
                }


            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        list.remove(0);
        return list;
    }

}
