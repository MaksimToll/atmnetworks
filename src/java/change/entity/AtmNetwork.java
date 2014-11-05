package change.entity;

import java.util.List;

/**
 * Created by Olavin on 20.10.2014.
 */
public class AtmNetwork {
    private String name;
    private List<BankEntry> banksList = null;

    public AtmNetwork(String name, List<BankEntry> banks){
        this.name = name;
        banksList = banks;
    }



    public String getName(){
        return name;
    }

    public List<BankEntry> getBanks(){
        return banksList;
    }

}
