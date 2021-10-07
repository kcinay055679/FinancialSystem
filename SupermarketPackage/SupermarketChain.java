package SupermarketPackage;

import GameHandlerPackage.Company;
import GameHandlerPackage.Place;
import org.javatuples.Pair;

import java.util.HashMap;
import java.util.Map;

public class SupermarketChain extends Company {
    public Map<String, Shop> shopList = new HashMap<>();
    public Map<String, Article> articleOfSortiment = new HashMap<>();
    private final Map<Integer, Pair<Person, Shop>> chiefs = new HashMap<>();
    public Map<String, Pair<Person, Shop>> employees = new HashMap<>();
    private final String name;

    public String getName() {
        return name;
    }

    public SupermarketChain(String name) {
        this.name = name;
    }

    public void createSubsidiary(String shopName, String chiefName, int chiefId, boolean selfCheckout, String place) {
        if (shopList.get(shopName) == null) {
            if (chiefs.get(chiefId) == null) {
                chiefs.put(chiefId, new Pair<>(new Person(chiefName, "", "", Integer.MAX_VALUE), null));
                shopList.put(shopName, new Shop(shopName, selfCheckout, this, Place.valueOf(place.toUpperCase()), chiefs.get(chiefId).getValue0()));
                chiefs.put(chiefId, new Pair<>(new Person(chiefName, "", "", Integer.MAX_VALUE), shopList.get(shopName)));
            }
        } else {
            System.out.println("Shop konnte nicht erstellt werden, bitte wenden sie sich an ihren Systemadministrator");
        }
    }
}
