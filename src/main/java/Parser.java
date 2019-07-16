import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.URL;

public class Parser {

    private static Document getPage() throws IOException {
        String url = "https://pogoda.mail.ru/prognoz/donetsk/extended/";
        Document page = Jsoup.parse(new URL(url), 5000);
        return page;
    }

    private static void printMint(Elements elements) {
        for (int i = 1; i < 9; i++) {
            for (Element elRow : elements) {
                Elements eltsStr = elRow.select("div");
                System.out.print(String.format("  %30s    ", eltsStr.get(i).text()));
            }
            System.out.println();
        }
    }


    public static void main(String[] args) throws IOException {

        Document page = getPage();
        Element table = page.select("div[class=cols__column__item cols__column__item_2-1 cols__column__item_2-1_ie8]").first();
        Elements dayPeriods = table.select("div[class=day day_period]");

        printMint(dayPeriods);


    }
}
