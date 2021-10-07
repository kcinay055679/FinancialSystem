package SupermarketPackage;

import org.javatuples.Pair;

import java.util.HashMap;
import java.util.Map;

public class Supermarkt {
    public Map<String, Subsidiary> subsidiaryList = new HashMap<>();
    public Map<String, Article> articleOfSortiment = new HashMap<>();
    public Map<Integer, Pair<Person,Subsidiary>>chiefs = new HashMap<>();
    public Map<String, Pair<Person,Subsidiary>> employees = new HashMap<>();

    static Person CEO = new Person("Yanick Nils Minder", Integer.MAX_VALUE);

    public void createSubsidiary(String shopName, String chiefName, int chiefId,boolean selfCheckout,String place) {
        if (subsidiaryList.get(shopName) == null) {
            if(chiefs.get(chiefId) == null){
                chiefs.put(chiefId, new Pair<>(new Person(chiefName, Integer.MAX_VALUE), null));
                subsidiaryList.put(shopName, new Subsidiary(shopName, selfCheckout,  Place.valueOf(place.toUpperCase())));
                chiefs.put(chiefId, new Pair<>(new Person(chiefName, Integer.MAX_VALUE), subsidiaryList.get(shopName)));
            }
        }else{
            System.out.println("Shop konnte nicht erstellt werden, bitte wenden sie sich an ihren Systemadministrator");
        }
    }
}
