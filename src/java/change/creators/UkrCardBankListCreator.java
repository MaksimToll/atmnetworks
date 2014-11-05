package change.creators;

import change.entity.BankEntry;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by maks on 05.11.2014.
 */
public class UkrCardBankListCreator extends  BankListCreatable {
    public static final String NETWORK_URL = "http://ubanks.com.ua/atmnet/ukrcard.php";

    @Override
    public List<BankEntry> createBankList() {
        List<BankEntry> banksList = new ArrayList<BankEntry>();
        String bankName;
        String bankUrl;
        try {
            Document doc = Jsoup.connect(NETWORK_URL).get();
            //int i = 0;
            Elements banks = doc.select("#zmist li");
            for (Element element : banks) {

                // lookup for Bank's site URL on separate page
                bankUrl = searchBankSite(element.child(0).attr("href"));
                bankName = element.child(0).text();

                banksList.add(new BankEntry(bankName, bankUrl));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return banksList;
    }

    private String searchBankSite(String pageUrl) throws IOException {
        String bankAddr = null;
        URL baseUrl = new URL(NETWORK_URL);
        URL url = new URL(baseUrl, pageUrl);
        Document doc = Jsoup.connect(url.toString()).get();
        Elements elements = doc.select("div.url>span.value-title"); // '>' means "sub" select
        bankAddr = elements.get(0).child(0).attr("href");
        return bankAddr;
    }
}
