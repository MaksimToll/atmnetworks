package change.simple_factory;

import change.creators.*;

/**
 * Created by maks on 05.11.2014.
 */
public class AtmNetwokFactory {
    private BankListCreatable bankList = null;
    private change.entity.AtmNetwork atmNetwork =null;
    public change.entity.AtmNetwork createAtmNetwork(String atmNetworkName){
        if(atmNetworkName=="ПриватБанк"){
            atmNetwork = new PrivatBanksListCreator().createAtmNetwork("ПриватБанк");
        }else if(atmNetworkName=="АТМоСфера"){
            atmNetwork = new AtmosferaBankListCreator().createAtmNetwork("АТМоСфера");
        }else if(atmNetworkName=="Euronet"){
            atmNetwork = new EuronetBankListCreator().createAtmNetwork("Euronet");
        }else if(atmNetworkName=="Радіус"){
            atmNetwork = new RediusBankListCreator().createAtmNetwork("Радіус");
        }else if(atmNetworkName=="УкрКард"){
            atmNetwork = new UkrCardBankListCreator().createAtmNetwork("УкрКард");
        }
        return  atmNetwork;
    }
}
