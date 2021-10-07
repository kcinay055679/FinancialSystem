package SupermarketPackage;

import GameHandlerPackage.SystemHandler;
import org.javatuples.Pair;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;


import static GameHandlerPackage.SystemHandler.*;

public class SupermarketHandler {
    
    public static void setUp() {
        SystemHandler.createSupermarketChain("coop");

        SystemHandler.getSupermarketChainMap().get("coop").createSubsidiary("FoodPalace", "Yanick", 555, true, "Thun");
        SystemHandler.getSupermarketChainMap().get("coop").createSubsidiary("Rudi's Fress Bude", "Marc", 26, true, "Thun");

        SupermarketHandler.createShelf("FoodPalace", "coop");
        SupermarketHandler.createShelf("Rudi's Fress Bude", "coop");
        SupermarketHandler.createArticle("Steak", 5F, 24, true, "food", "FoodPalace", "coop",1);
        SupermarketHandler.createArticle("Artikel2", 20F, 6, true, "food", "FoodPalace","coop", 1);
        SupermarketHandler.createArticle("Artikel3", 30F, 4, false, "food", "FoodPalace", "coop",1);
        SupermarketHandler.createArticle("Artikel4", 40F, 3, false, "food", "FoodPalace", "coop",1);

        SupermarketHandler.createArticle("Steak", 5F, 12, true, "food", "Rudi's Fress Bude", "coop",1);

        SupermarketHandler.addPerson("Yanick", "password", "password", 0);

    }

    public static void customerJoinSubsidary(String personName, String shop) {
        SupermarketChain supermarketChain = getPersonList().get(personName).getCurrentShop().getSupermarketChain();
        getPersonList().get(personName).setShop(supermarketChain.shopList.get(shop));
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

    public static void createArticle(String articleName, float price, int amount, boolean barcode, String articleType, String shopName, String supermarketChainName,int shelfId) {
        SupermarketChain supermarketChain =  getSupermarketChainMap().get(supermarketChainName);
        articleName = articleName.toLowerCase().replace(" ", "");
        if (supermarketChain.shopList.get(shopName).getShelfById(shelfId).getArticle(articleName) == null) {
            supermarketChain.shopList.get(shopName).getShelfById(shelfId).addArticle(new Article(articleName, price, barcode, articleType), amount);
            supermarketChain.shopList.get(shopName).getArticlePositionList().put(articleName, shelfId);
            supermarketChain.articleOfSortiment.put(articleName, new Article(articleName, price, barcode, articleType));
        } else {
            supermarketChain.shopList.get(shopName).getShelfById(shelfId).increaseArticleAmount(articleName, amount, barcode, articleType, shopName);
        }
    }

    public static void createShelf(String shopName, String supermarketChainName) {
        Shop test = getSupermarketChainMap().get(supermarketChainName).shopList.get(shopName);
        test.createShelf();
    }

    public static void checkOut(String customerName, String shopName, String supermarketChainName ) {
        getPersonList().get(customerName).getCurrentShop().getSupermarketChain().shopList.get(shopName).checkOut(getPersonList().get(customerName));
    }

    public static void selfCheckOut(String customerName, String shopName) throws IOException {
        int scannedArticles = 0;
        String input;
        int fullPrice = 0;
        input = "2";
        while (true) {
            switch (input) {
                case "1": {
                    getPersonList().get(customerName).getCurrentShop().getSupermarketChain().shopList.get(getSelectedUser().getCurrentShop().getName()).selfCheckOut(getSelectedUser(), fullPrice);
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
                default: {
                    System.out.println("Bitte geben sie einen gültigen Befehl ein");
                    break;
                }
            }
        }
    }

    public static int scan() throws IOException {

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
        Shop shop = getPersonList().get(personName).getCurrentShop().getSupermarketChain().employees.get(personName).getValue1();
        shop.employeeJoined(getPersonList().get(personName));
    }

    public static void employeeLeave(String personName) {
        Shop shop = getPersonList().get(personName).getCurrentShop().getSupermarketChain().employees.get(personName).getValue1();
        shop.employeeLeaved(personName);
    }

    public static Person[] getEmployeesOfShop(String shopName, String supermarketChainName) {
        return getSupermarketChainMap().get(supermarketChainName).shopList.get(shopName).getEmployeeList().values().toArray(Person[]::new);
    }

    public static void hireEmployeeForShop(String name, String shopName) {
        SupermarketChain supermarketChain =  getPersonList().get(name).getCurrentShop().getSupermarketChain();
        Person p = supermarketChain.employees.get(name).getValue0();
        Shop shop = supermarketChain.shopList.get(shopName);
        supermarketChain.employees.put(p.getName(), new Pair<>(p, supermarketChain.shopList.get(shopName)));
        shop.getEmployeeList().put(p.getName(), p);
    }


}
