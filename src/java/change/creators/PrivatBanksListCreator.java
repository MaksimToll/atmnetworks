package change.creators;



import change.entity.BankEntry;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Olavin on 20.10.2014.
 */
public class PrivatBanksListCreator extends BankListCreatable {

    public static final String NETWORK_URL ="https://privatbank.ua/";


    public List<BankEntry> createBankList(){
        List<BankEntry> privatBank = new ArrayList<BankEntry>(1);
        privatBank.add(new BankEntry("ПриватБанк",NETWORK_URL)); // only for PrivatBank networkUrl == bankUrl
        return privatBank;
    }


}
