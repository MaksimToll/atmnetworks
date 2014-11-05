package change.creators;


import change.entity.BankEntry;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by maks on 05.11.2014.
 */
public class AtmosferaBankListCreator extends BankListCreatable {

    public static final String NETWORK_URL = "http://www.atmosphere.net.ua/ru/members_atmoshera_rus.htm?print&showAll=1";
    @Override
    public List<BankEntry> createBankList() {
        List<BankEntry> atmosferaBanks = new ArrayList<BankEntry>();

        try {
            Document doc = Jsoup.connect(NETWORK_URL).get();
            Elements names = doc.select("td.tab_line_mini");  // Array of names of banks

            for (Element name : names) {
                Element  tmp = name.nextElementSibling();
                String   bankName = name.text();
                String   bankUrl = tmp.child(0).attr("href");
                atmosferaBanks.add(new BankEntry(bankName,bankUrl));    //Add elements to list
                tmp = tmp.nextElementSibling();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return atmosferaBanks; // List!
    }

}
