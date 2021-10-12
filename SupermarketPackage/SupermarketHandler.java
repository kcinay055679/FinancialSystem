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

public class SupermarketHandler {



    public static void setUp() {
        SystemHandler.createSupermarketChain("coop");
        SystemHandler.createSupermarketChain("migros");
        SystemHandler.createSupermarketChain("aldi");

        createShop("coop","FoodPalace","Yanick1", "", "",true,"Thun");
        createShop("coop","Rudi's Fress Bude","Yanick2", "", "",true,"Thun");

        createShop("migros","Rudi's Fress Bude","Yanick3", "", "",true,"Thun");
        createShop("migros","FoodPalace","Yanick4", "", "",true,"Thun");

        createShop("aldi","Rudi's Fress Bude","Yanick5", "", "",true,"Thun");
        createShop("aldi","FoodPalace","Yanick6", "", "",true,"Thun");



        SupermarketHandler.createShelf("FoodPalace", "coop");
        SupermarketHandler.createShelf("FoodPalace", "coop");
        SupermarketHandler.createShelf("Rudi's Fress Bude", "coop");

        SupermarketHandler.createFood("Steak", 5F, 12, true, "20/10/2021","FoodPalace", "coop", 1, Fleischsorten.FISH);
        SupermarketHandler.createBuildingMaterial("Artikel2", 20F, 6, true , "FoodPalace", 2,"iron","coop", 1);
        SupermarketHandler.createBuildingMaterial("Artikel3", 30F, 4, false , "FoodPalace", 2, "wood","coop", 1);
        SupermarketHandler.createBuildingMaterial("Artikel4", 40F, 3, false, "FoodPalace",2, "wood", "coop", 1);

        SupermarketHandler.createShelf("FoodPalace", "migros");
        SupermarketHandler.createShelf("Rudi's Fress Bude", "migros");
        SupermarketHandler.createShelf("FoodPalace", "migros");
        SupermarketHandler.createFood("Steak", 5F, 12, true, "20/10/2021", "FoodPalace", "migros", 1, Fleischsorten.CHICKEN);

        SupermarketHandler.createFood("Steak", 5F, 12, true, "20/10/2021","Rudi's Fress Bude", "coop", 1, Fleischsorten.COW);


        SupermarketHandler.addPerson("Yanick", "", "", 0);
        SupermarketHandler.addPerson("", "", "", 0);

        SupermarketHandler.addPerson("Marc", "password", "password", 0);
        addEmployeeToCompany("Marc", "coop");
        hireEmployeeForShop("Marc", "FoodPalace");
        employeeEnter("Marc");

        SupermarketHandler.addPerson("Mar1", "password", "password", 0);
        addEmployeeToCompany("Mar1", "coop");
        hireEmployeeForShop("Mar1", "FoodPalace");
        employeeEnter("Mar1");



    }

    public static void customerJoinShop(String personName, String shop) {
        SupermarketChain supermarketChain = getPersonList().get(personName).getCurrentShopWork().getSupermarketChain();
        getPersonList().get(personName).setShop(supermarketChain.getShopMap().get(shop));
    }

    public static void addPerson(String name, String password, String repeatPassword, int salary) {
        if (password.equals(repeatPassword)) {
            getPersonList().put(name, new Person(name, password, repeatPassword, salary));
        }
    }

    public static boolean checkPassword(String personName, String password) {
        return getPersonList().get(personName).checkPassword(password);
    }

    public static void changePassword(String personName, String oldPassword, String newPassword, String repeatNewPassword) {
        getPersonList().get(personName).changePassword(oldPassword, newPassword, repeatNewPassword);
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

    public static void selfCheckOut(String customerName, String shopName) {
        int scannedArticles = 0;
        String input;
        int fullPrice = 0;
        input = "2";
        while (true) {
            switch (input) {
                case "1": {
                    getPersonList().get(customerName).getCurrentShopWork().getSupermarketChain().getShopMap().get(getSelectedUser().getCurrentShopWork().getName()).selfCheckOut(getSelectedUser(), fullPrice);
                    System.out.println("Sie haben für " + fullPrice + " CHF bei uns eingekauft");
                    System.out.println("Falls sie eine Schüpperkarte besitzen wurden ihnen diese Punkte gutgeschrieben");
                    return;
                }
                case "2": {
                    fullPrice += scan();
                    scannedArticles++;
                    System.out.println("sie haben " + scannedArticles + " Artikel gescannt");
                    System.out.println("Um zu bezahlen drücken sie die 1");
                    System.out.println("Um weiter zu scannen drücken sie die 2");
                    break;
                }
                default:{
                    System.out.println("Bitte geben sie einen gültigen Befehl ein");

                }
            }
        }
    }

    public static int scan() {

        String input;
        int fullPrice = 0;
        System.out.println("Sie haben folgende Artikel in ihrem Warenkorb");
        getSelectedUser().getCart().getArticleList().values().forEach(s -> System.out.println(s.getValue0().getName() + "  " + s.getValue1() + "x"));

        List<Pair<Article, Integer>> articlesWithBarcode = getSelectedUser().getCart().getArticleList().values().stream().filter(s -> s.getValue0().isBarcode()).collect(Collectors.toList());
        if (articlesWithBarcode.size() > 0) {
            System.out.println("Zuerst werden die Artikel mit Barcode gescannt");
            System.out.println("Bitte drücken sie Enter damit alle Artikel mit Barcode automatisch gescannt werden");

            fullPrice = articlesWithBarcode.stream().mapToInt(pair -> (int) (pair.getValue0().getPrice() * pair.getValue1())).sum();
            articlesWithBarcode.forEach(pair -> getSelectedUser().getCart().articleList.remove(pair.getValue0().getName()));
            return fullPrice;
        }

        System.out.println("Jetzt werden die Artikel ohne Barcode gescannt");
        System.out.println("Um einen Artikel zu scannen, bitte den Artikel Namen eingeben");
        System.out.println("Um den Scanvorgang abzubrechen bitte \"exit\" eingeben");


        Pair<Article, Integer> articlePair = getSelectedUser().getCart().getArticleList().get("Artikel2");
        //add Article

        fullPrice += articlePair.getValue0().getPrice() * articlePair.getValue1();
        getSelectedUser().getCart().articleList.remove("Artikel2");

        return fullPrice;
    }

    public static void employeeEnter(String personName) {
        Shop shop = getPersonList().get(personName).getCurrentShopWork().getSupermarketChain().getEmployeeMap().get(personName).getValue1();
        shop.employeeJoined(getPersonList().get(personName));
    }

    public static void employeeLeave(String personName) {
        Shop shop = getPersonList().get(personName).getCurrentShopWork().getSupermarketChain().getEmployeeMap().get(personName).getValue1();
        shop.employeeLeaved(personName);
    }

    public static Person[] getEmployeesOfShop(String shopName, String supermarketChainName) {
        return getSupermarketChainMap().get(supermarketChainName).getShopMap().get(shopName).getEmployeeList().values().toArray(Person[]::new);
    }

    public static void hireEmployeeForShop(String personName, String shopName) {
        SupermarketChain supermarketChain = (SupermarketChain) getPersonList().get(personName).getWorkPlace();
        Person p = supermarketChain.getEmployeeMap().get(personName).getValue0();
        Shop shop = supermarketChain.getShopMap().get(shopName);
        p.setCurrentShopWork(shop);
        p.setRank(Rank.EMPLOYEE);
        supermarketChain.getEmployeeMap().put(p.getName(), new Pair<>(p, supermarketChain.getShopMap().get(shopName)));
        shop.getEmployeeList().put(p.getName(), p);
    }

    public static void createShop(String supermarketChain, String shopName, String name,String password, String repeatPassword, boolean selfCheckout, String place){
        addPerson(name, password, repeatPassword, Integer.MAX_VALUE);
        getPersonList().get(name).setRank(Rank.CHIEF);
        SystemHandler.getSupermarketChainMap().get(supermarketChain).createSubsidiary(shopName, getPersonList().get(name),  selfCheckout, place);
    }
}
