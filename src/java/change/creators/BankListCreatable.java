package change.creators;




import change.entity.AtmNetwork;
import change.entity.BankEntry;

import java.util.List;

/**
 * Created by maks on 05.11.2014.
 */
public abstract class BankListCreatable {
    AtmNetwork atmNetwork = null;

    public abstract List<BankEntry> createBankList();

    public AtmNetwork createAtmNetwork(String nameAtmNetwork) {
        atmNetwork = new AtmNetwork(nameAtmNetwork, createBankList());
        return atmNetwork;
    }
}
