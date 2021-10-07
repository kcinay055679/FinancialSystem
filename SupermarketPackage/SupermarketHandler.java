package SupermarketPackage;

import static SupermarketPackage.Main.*;

import org.javatuples.Pair;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;



public class SupermarketHandler {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void customerJoinSubsidary(String customer, String subsidiary) {
        Main.persons.get(customer).setShop(Main.coop.subsidiaryList.get(subsidiary));
    }

    public static void addPerson(String name,String password, String repeatPassword,int salary) {
        if (password.equals(repeatPassword)) {
            Main.persons.put(name, new Person(name,password, repeatPassword,salary));
        }
    }
    public static boolean checkPassword(String personName, String password){
        return persons.get(personName).checkPassword(password);
    }
    public static void changePassword(String personName, String oldPassword, String newPassword, String repeatNewPassword){
        persons.get(personName).changePassword(oldPassword, newPassword, repeatNewPassword);
    }


    public static void takeArticle(String personName, String articleName, int amount, int shelfId) {
        Main.persons.get(personName).takeArticle(articleName, amount, shelfId);
    }

    public static Person getCustomer(String name) {
        return Main.persons.get(name);
    }

    public static void createArticle(String articleName, float price, int amount, boolean barcode, String articleType, String shopName, int shelfId) {
        articleName = articleName.toLowerCase().replace(" ", "");
        if (Main.coop.subsidiaryList.get(shopName).getShelfById(shelfId).getArticle(articleName) == null) {
            Main.coop.subsidiaryList.get(shopName).getShelfById(shelfId).addArticle(new Article(articleName, price, barcode, articleType), amount);
            Main.coop.subsidiaryList.get(shopName).articlePositions.put(articleName, shelfId);
            Main.coop.articleOfSortiment.put(articleName, new Article(articleName, price, barcode, articleType));
        } else {
            Main.coop.subsidiaryList.get(shopName).getShelfById(shelfId).increaseArticleAmount(articleName, amount, barcode, articleType, shopName);
        }
    }

    public static void createShelf(String shopName) {
        Subsidiary test = Main.coop.subsidiaryList.get(shopName);
        test.createShelf();
    }

    public static void checkOut(String customerName, String shopName) {
        Main.coop.subsidiaryList.get(shopName).checkOut(Main.persons.get(customerName));
    }

    public static void selfCheckOut(String customerName, String shopName) throws IOException {
        int scannedArticles = 0;
        String input;
        int fullPrice = 0;
        input = "2";
        while (true) {
            switch (input) {
                case "1": {
                    Main.coop.subsidiaryList.get(Main.selectedUser.getCurrentShop().getName()).selfCheckOut(Main.selectedUser, fullPrice);
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
                    input = br.readLine();
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
        Main.selectedUser.getCart().getArticleList().values().forEach(s -> System.out.println(s.getValue0().getName() + "  " + s.getValue1() + "x"));

        List<Pair<Article, Integer>> articlesWithBarcode = selectedUser.getCart().getArticleList().values().stream().filter(s -> s.getValue0().isBarcode()).collect(Collectors.toList());
        if (articlesWithBarcode.size() > 0) {
            System.out.println("Zuerst werden die Artikel mit Barcode gescannt");
            System.out.println("Bitte drücken sie Enter damit alle Artikel mit Barcode automatisch gescannt werden");

            fullPrice = articlesWithBarcode.stream().mapToInt(pair -> (int) (pair.getValue0().getPrice() * pair.getValue1())).sum();
            articlesWithBarcode.forEach(pair -> Main.selectedUser.getCart().articleList.remove(pair.getValue0().getName()));
            return fullPrice;
        }

        System.out.println("Jetzt werden die Artikel ohne Barcode gescannt");
        System.out.println("Um einen Artikel zu scannen, bitte den Artikel Namen eingeben");
        System.out.println("Um den Scanvorgang abzubrechen bitte \"exit\" eingeben");

        input = br.readLine();
        if (input.equals("exit")) {
            return 0;
        }
        Pair<Article, Integer> articlePair = Main.selectedUser.getCart().getArticleList().get(input);
        //add Article

        fullPrice += articlePair.getValue0().getPrice() * articlePair.getValue1();
        Main.selectedUser.getCart().articleList.remove(input);

        return fullPrice;
    }

    public static void employeeEnter(String personName) {
        Subsidiary shop = coop.employees.get(personName).getValue1();
        shop.employeeJoined(persons.get(personName));
    }

    public static void employeeLeave(String personName) {
        Subsidiary shop = coop.employees.get(personName).getValue1();
        shop.employeeLeaved(personName);
    }

    public static Person[] getEmployeesOfShop(String shopName) {
        return Main.coop.subsidiaryList.get(shopName).getEmployeeList().values().toArray(Person[]::new);
    }

    public static void addEmployeeToCompany(String name) {
        Person p = persons.get(name);
        coop.employees.put(p.getName(), new Pair<>(p, coop.subsidiaryList.get(null)));
    }

    public static void hireEmployeeForShop(String name, String shopName) {
        Person p = coop.employees.get(name).getValue0();
        Subsidiary shop = coop.subsidiaryList.get(shopName);
        coop.employees.put(p.getName(), new Pair<>(p, coop.subsidiaryList.get(shopName)));
        shop.employeeList.put(p.getName(), p);
    }
}
