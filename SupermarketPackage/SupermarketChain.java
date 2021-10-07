package SupermarketPackage;

import GameHandlerPackage.Company;
import GameHandlerPackage.Place;
import org.javatuples.Pair;

import java.util.HashMap;
import java.util.Map;

public class SupermarketChain extends Company {
    private final String name;
    private final Map<String, Shop> shopMap = new HashMap<>();
    private final Map<String, Article> articleMap = new HashMap<>();
    private final Map<Integer, Pair<Person, Shop>> chiefMap = new HashMap<>();
    private final Map<String, Pair<Person, Shop>> employeeMap = new HashMap<>();


    public Map<String, Shop> getShopMap() {
        return shopMap;
    }

    public Map<String, Article> getArticleMap() {
        return articleMap;
    }

    public Map<Integer, Pair<Person, Shop>> getChiefMap() {
        return chiefMap;
    }

    public Map<String, Pair<Person, Shop>> getEmployeeMap() {
        return employeeMap;
    }

    public String getName() {
        return name;
    }

    public SupermarketChain(String name) {
        this.name = name;
    }

    public void createSubsidiary(String shopName, String chiefName, int chiefId, boolean selfCheckout, String place) {
        if (shopMap.get(shopName) == null) {
            if (chiefMap.get(chiefId) == null) {
                chiefMap.put(chiefId, new Pair<>(new Person(chiefName, "", "", Integer.MAX_VALUE), null));
                shopMap.put(shopName, new Shop(shopName, selfCheckout, this, Place.valueOf(place.toUpperCase()), chiefMap.get(chiefId).getValue0()));
                chiefMap.put(chiefId, new Pair<>(new Person(chiefName, "", "", Integer.MAX_VALUE), shopMap.get(shopName)));
            }
        } else {
            System.out.println("Shop konnte nicht erstellt werden, bitte wenden sie sich an ihren Systemadministrator");
        }
    }
}
