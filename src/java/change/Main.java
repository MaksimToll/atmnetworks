package change;

import change.entity.AtmNetwork;
import change.simple_factory.AtmNetwokFactory;

import java.util.ArrayList;

/**
 * Created by maks on 05.11.2014.
 */
public class Main {
    public static void main(String[] args) {
        ArrayList<AtmNetwork> atmNetworks = new ArrayList<AtmNetwork>(5);
        AtmNetwokFactory atmNetwokFactory=new AtmNetwokFactory();
        atmNetworks.add(atmNetwokFactory.createAtmNetwork("ПриватБанк"));
        atmNetworks.add(atmNetwokFactory.createAtmNetwork("АТМоСфера"));
        atmNetworks.add(atmNetwokFactory.createAtmNetwork("Euronet"));
        atmNetworks.add(atmNetwokFactory.createAtmNetwork("Радіус"));
        atmNetworks.add(atmNetwokFactory.createAtmNetwork("УкрКард"));

    }
}
