package SupermarketPackage;

import GameHandlerPackage.Company;
import GameHandlerPackage.Place;
import SupermarketPackage.Articles.Article;
import org.javatuples.Pair;

import java.util.HashMap;
import java.util.Map;

public class SupermarketChain extends Company implements java.io.Serializable{
    private final Map<String, Shop> shopMap = new HashMap<>();
    private final Map<String, Article> articleMap = new HashMap<>();
    private final Map<String, Pair<Person, Shop>> chiefMap = new HashMap<>();
    private final Map<String, Pair<Person, Shop>> employeeMap = new HashMap<>();


    public Map<String, Shop> getShopMap() {
        return shopMap;
    }

    public Map<String, Article> getArticleMap() {
        return articleMap;
    }

    public Map<String, Pair<Person, Shop>> getChiefMap() {
        return chiefMap;
    }

    public Map<String, Pair<Person, Shop>> getEmployeeMap() {
        return employeeMap;
    }



    public SupermarketChain(String name) {
        super(name);

    }

    public void createSubsidiary(String shopName, Person chief, boolean selfCheckout, String place) {
        if (shopMap.get(shopName) == null && chief != null && chiefMap.get(chief.getName()) == null) {
                chiefMap.put(chief.getName(), new Pair<>(chief, null));
                shopMap.put(shopName, new Shop(shopName, selfCheckout, this, Place.valueOf(place.toUpperCase()), chiefMap.get(chief.getName()).getValue0()));
                chiefMap.put(chief.getName(), new Pair<>(chief, shopMap.get(shopName)));

        } else {
            System.out.println("Shop konnte nicht erstellt werden, bitte wenden sie sich an ihren Systemadministrator "+shopName+" "+getName());
        }
    }
}

