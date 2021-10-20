package SupermarketPackage;

import GameHandlerPackage.Rank;
import GameHandlerPackage.SystemHandler;
import SupermarketPackage.Articles.Article;
import SupermarketPackage.Articles.BuildingMaterial;
import SupermarketPackage.Articles.Food;
import org.javatuples.Pair;

import java.util.List;
import java.util.stream.Collectors;

import static GameHandlerPackage.SystemHandler.*;

public class SupermarketHandler implements java.io.Serializable{


    public static void setUp() {
        SystemHandler.createSupermarketChain("coop");
        SystemHandler.createSupermarketChain("migros");
        SystemHandler.createSupermarketChain("aldi");

        createShop("coop", "FoodPalace", "Yanick1", "", "", true, "Thun", 5000);
        createShop("coop", "Rudi's Fress Bude", "Yanick2", "", "", true, "Thun", 5000);

        createShop("migros", "Rudi's Fress Bude", "Yanick3", "", "", true, "Thun", 5000);
        createShop("migros", "FoodPalace", "Yanick4", "", "", true, "Thun", 5000);

        createShop("aldi", "Rudi's Fress Bude", "Yanick5", "", "", true, "Thun", 5000);
        createShop("aldi", "FoodPalace", "Yanick6", "", "", true, "Thun", 5000);


        SupermarketHandler.createShelf("FoodPalace", "coop");
        SupermarketHandler.createShelf("FoodPalace", "coop");
        SupermarketHandler.createShelf("Rudi's Fress Bude", "coop");

        SupermarketHandler.createFood("Steak", 5F, 12, true, "20/10/2021", "FoodPalace", "coop", 1, Fleischsorten.FISH);
        SupermarketHandler.createBuildingMaterial("Artikel2", 20F, 6, true, "FoodPalace", 2, "iron", "coop", 1);
        SupermarketHandler.createBuildingMaterial("Artikel3", 30F, 4, false, "FoodPalace", 2, "wood", "coop", 1);
        SupermarketHandler.createBuildingMaterial("Artikel4", 40F, 3, false, "FoodPalace", 2, "wood", "coop", 1);

        SupermarketHandler.createShelf("FoodPalace", "migros");
        SupermarketHandler.createShelf("Rudi's Fress Bude", "migros");
        SupermarketHandler.createShelf("FoodPalace", "migros");
        SupermarketHandler.createFood("Steak", 5F, 12, true, "20/10/2021", "FoodPalace", "migros", 1, Fleischsorten.CHICKEN);

        SupermarketHandler.createFood("Steak", 5F, 12, true, "20/10/2021", "Rudi's Fress Bude", "coop", 1, Fleischsorten.COW);


        SupermarketHandler.addPerson("Yanick", "", "");
        SupermarketHandler.addPerson("unknownUser", "", "");

        SupermarketHandler.addPerson("Rudi", "Traube", "Traube");
        SystemHandler.getPersonList().get("Rudi").setRank(Rank.ADMIN);

        SupermarketHandler.addPerson("Glöschu", "keineGeld", "keineGeld");

        SupermarketHandler.addPerson("Marc", "password", "password");
        hireEmployee("Marc", "coop", "FoodPalace", 4500);
        employeeEnter("Marc");

        SupermarketHandler.addPerson("Mar1", "password", "password");
        hireEmployee("Mar1", "coop", "FoodPalace", 4500);

        System.out.println("Error: All Variables are resettet");
    }


    public static void addPerson(String name, String password, String repeatPassword) {
        if (password.equals(repeatPassword)) {
            getPersonList().put(name, new Person(name, password, repeatPassword));
        }
    }

    public static void takeArticle(String personName, String articleName, int amount, int shelfId) {
        getPersonList().get(personName).takeArticle(articleName, amount, shelfId);
    }

    public static Person getCustomer(String name) {
        return getPersonList().get(name);
    }

    public static void createFood(String articleName, float price, int amount, boolean barcode, String expirationDate, String shopName, String supermarketChainName, int shelfId, Fleischsorten fleisch) {
        SupermarketChain supermarketChain = getSupermarketChainMap().get(supermarketChainName);
        articleName = articleName.toLowerCase().replace(" ", "");
        if (supermarketChain.getShopMap().get(shopName).getShelfById(shelfId).getArticle(articleName) == null) {
            supermarketChain.getShopMap().get(shopName).getShelfById(shelfId).addArticle(new Food(articleName, price, barcode, expirationDate, fleisch), amount);
            supermarketChain.getShopMap().get(shopName).getArticlePositionList().put(articleName, shelfId);
            supermarketChain.getArticleMap().put(articleName, new Food(articleName, price, barcode, expirationDate, fleisch));
        } else {
            supermarketChain.getShopMap().get(shopName).getShelfById(shelfId).increaseArticleAmountFood(articleName, amount);
        }
    }

    public static void createBuildingMaterial(String articleName, float price, int amount, boolean barcode, String shopName, int tons, String material, String supermarketChainName, int shelfId) {
        SupermarketChain supermarketChain = getSupermarketChainMap().get(supermarketChainName);
        articleName = articleName.toLowerCase().replace(" ", "");
        if (supermarketChain.getShopMap().get(shopName).getShelfById(shelfId).getArticle(articleName) == null) {
            supermarketChain.getShopMap().get(shopName).getShelfById(shelfId).addArticle(new BuildingMaterial(articleName, price, barcode, tons, material), amount);
            supermarketChain.getShopMap().get(shopName).getArticlePositionList().put(articleName, shelfId);
            supermarketChain.getArticleMap().put(articleName, new BuildingMaterial(articleName, price, barcode, tons, material));
        } else {
            supermarketChain.getShopMap().get(shopName).getShelfById(shelfId).increaseArticleAmountBuildingMaterial(articleName, amount);
        }
    }

    public static void createShelf(String shopName, String supermarketChainName) {
        SupermarketChain supermarket = getSupermarketChainMap().get(supermarketChainName);
        Shop shop = supermarket.getShopMap().get(shopName);
        shop.createShelf();
    }

    public static void checkOut(String customerName, String shopName) {
        getPersonList().get(customerName).getCurrentShopWork().getSupermarketChain().getShopMap().get(shopName).checkOut(getPersonList().get(customerName));
    }


    public static void employeeEnter(String personName) {
        Shop shop = getPersonList().get(personName).getCurrentShopWork();
        shop.employeeJoined(getPersonList().get(personName));
    }

    public static void employeeLeave(String personName) {
        Shop shop = getPersonList().get(personName).getCurrentShopWork().getSupermarketChain().getEmployeeMap().get(personName).getValue1();
        shop.employeeLeft(personName);
    }

    public static Person[] getEmployeesOfShop(String shopName, String supermarketChainName) {
        return getSupermarketChainMap().get(supermarketChainName).getShopMap().get(shopName).getEmployeeList().values().toArray(Person[]::new);
    }

    public static void createShop(String supermarketChain, String shopName, String name, String password, String repeatPassword, boolean selfCheckout, String place, int earnings) {
        addPerson(name, password, repeatPassword);
        getPersonList().get(name).setSalary(7000);
        getPersonList().get(name).setRank(Rank.CHIEF);
        SystemHandler.getSupermarketChainMap().get(supermarketChain).createSubsidiary(shopName, getPersonList().get(name), selfCheckout, place, earnings);
        Shop shop = SystemHandler.getSupermarketChainMap().get(supermarketChain).getShopMap().get(shopName);
        getPersonList().get(name).setCurrentShopWork(shop);
        getPersonList().get(name).setCurrentCompanyWork(SystemHandler.getSupermarketChainMap().get(supermarketChain));
    }
}
