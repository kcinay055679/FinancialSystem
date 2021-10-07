package SupermarketPackage;

import org.javatuples.Pair;
import org.javatuples.Triplet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static Map<String, Person> persons = new HashMap<>();

    public static Supermarkt coop = new Supermarkt();
    public static Supermarkt migros = new Supermarkt();
    public static Person selectedUser;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        coop.createSubsidiary("FoodPalace", "Yanick", 555, true,"Thun");
        coop.createSubsidiary("Rudi's Fress Bude", "Marc", 26, true,"Thun");

        Functions.createShelf("FoodPalace");
        Functions.createShelf("Rudi's Fress Bude");
        Functions.createArticle("Steak", 5F, 24, true, "food", "FoodPalace", 1);
        Functions.createArticle("Artikel2", 20F, 6, true, "food", "FoodPalace", 1);
        Functions.createArticle("Artikel3", 30F, 4, false, "food", "FoodPalace", 1);
        Functions.createArticle("Artikel4", 40F, 3, false, "food", "FoodPalace", 1);

        Functions.createArticle("Steak", 5F, 12, true, "food", "Rudi's Fress Bude", 1);

        while (true) {
            login();
        }
    }

    public static void login() throws IOException {
        String input;
        System.out.println("Herzlich wilkommen");
        System.out.println("Um sich als Benutzer anzumelden drücken sie die 1");
        System.out.println("Um sich als Chef einzuloggen drücken sie die 2");
        System.out.println("Um sich als Mitarbeiter einzuloggen drücken sie die 3");


        input = br.readLine();
        switch (input) {
            case "1": {
                System.out.println("Bitte geben sie ihren Namen ein, falls noch kein Benutzerkonto existiert wird automatisch eines erstellt");
                System.out.println("Um zum Menu zurückzukehren bitte \"exit\" eingeben");

                input = br.readLine();
                if (input.equals("exit")) {
                    return;
                }
                if (persons.get(input) == null) {
                    Functions.addPerson(input, 0);
                    selectedUser = persons.get(input);
                    menu();
                } else {
                    selectedUser = persons.get(input);
                    menu();
                }
                return;
            }
            case "2": {
                System.out.println("Um sich als Chef anzumelden, geben sie bitte ihre ID ein");
                while (true) {
                    try {
                        int id = Integer.parseInt(br.readLine());
                        if (coop.chiefs.get(id) == null) {
                            System.out.println("Bitte geben sie eine gültige ID ein");
                            System.out.println("Um zum Menu zurückzukehren bitte \"exit\" eingeben");

                            input = br.readLine();
                            if (input.equals("exit")) {
                                return;
                            }
                        } else {
                            selectedUser = coop.chiefs.get(id).getValue0();
                            chiefMenu(id);
                            return;
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Bitte geben sie eine gültige ID ein");
                    }
                }
            }
            case "3": {
                System.out.println("Um sich als Mitarbeiter anzumelden, geben sie bitte ihren Namen ein");
                while (true) {
                    try {
                        String name = br.readLine();
                        if (coop.employees.get(name) == null) {
                            System.out.println("Bitte geben sie einen korrekten Namen ein");
                            System.out.println("Um zum Menu zurückzukehren bitte \"exit\" eingeben");

                            input = br.readLine();
                            if (input.equals("exit")) {
                                return;
                            }
                        } else {
                            selectedUser = coop.employees.get(name).getValue0();
                            employeeMenu();
                            return;
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Bitte geben sie eine gültige ID ein");
                    }
                }
            }
        }
    }

    public static void menu() throws IOException {
        if (selectedUser.getCurrentShop() != null) {
            return;
        }
        String input;

        while (true) {
            System.out.println("Sie befinden sich im Menu");
            System.out.println("Zurzeit können sie zwischen 5 verschiedenen Optionen wählen");
            System.out.println("Möglichkeit 1:");
            System.out.println("Eine Filiale betreten");
            System.out.println("Möglichkeit 2:");
            System.out.println("Tablet benutzen");
            System.out.println("Möglichkeit 3:");
            System.out.println("Personenbezogene Daten anzeigen");
            System.out.println("Möglichkeit 4:");
            System.out.println("Schüppercard");
            System.out.println("Möglichkeit 5:");
            System.out.println("Auslogen");
            input = br.readLine();
            switch (input) {
                case "1": {
                    System.out.println("Folgende Filialen können sie betreten");
                    coop.subsidiaryList.keySet().forEach(System.out::println);
                    System.out.println("Bitte geben sie den Namen einer Filiale ein um sie zu betreten");
                    while (true) {
                        try {
                            input = br.readLine();
                            selectedUser.setShop(coop.subsidiaryList.get(input));
                            System.out.println("Sie haben die Filiale " + selectedUser.getCurrentShop().getName() + " betreten");
                            break;
                        } catch (NullPointerException e) {
                            System.out.println("Bitte wähle einen vorhandene Filiale ");
                        }
                    }
                    shop();
                    break;
                }
                case "2": {
                    System.out.println("Sie haben das Tablet gestartet");
                    System.out.println("Um nach einem Artikel in allen Filialen gleichzeitig zu suchen, drücken sie bitte die 1");
                    System.out.println("Um nach einem Artikel in einer bestimmten Filialen zu suchen, drücken sie bitte die 2");
                    input = br.readLine();
                    switch (input) {
                        case "1": {
                            searchArticleInSystem();
                            break;
                        }
                        case "2": {
                            searchArticleInShop();
                            break;
                        }
                        case "3": {
                            searchArticleByType();
                        }
                        default: {
                            System.out.println("Bitte gib einen gültigen Befehl ein");
                        }
                    }
                    break;
                }
                case "3": {
                    System.out.println("Sie sind als " + selectedUser.getName() + " angemeldet");
                    System.out.println("Ihr Kontostand beträgt " + selectedUser.getMoney() + "CHF");
                    if (selectedUser.getCard() != null) {
                        System.out.println("Sie haben " + selectedUser.getCard().getPoints() + " Schüpperpunkte");
                    }
                    break;
                }
                case "4": {
                    System.out.println("Um eine Schüppercard zu erhalten drücken sie die 1");
                    System.out.println("Falls sie schon eine Schüppercard besitzen und ihre Punkte umwandeln wollen drücken sie die 2");
                    input = br.readLine();
                    switch (input) {
                        case "1": {
                            System.out.println("Sie besitzen nun eine Schüppercard");
                            selectedUser.addSchüppercard();
                            break;
                        }
                        case "2": {
                            if (selectedUser.getCard() == null) {
                                System.out.println("Sie haben leider noch keine Schüppercard");
                                break;
                            }
                            System.out.println("Ihre Schüpperpunkte wurden in Geld ungewandelt");
                            System.out.println("Ihnen wurden " + selectedUser.getCard().getPoints() / 100 + " CHF gutgeschrieben");
                            selectedUser.convertSchüpperPoints();
                            break;
                        }
                        default: {
                            System.out.println("Bitte geben sie einen gültigen Befehl ein");
                            break;
                        }
                    }
                    break;
                }
                case "5": {
                    System.out.println("Sie haben sich abgemeldet");
                    return;
                }
                default: {
                    System.out.println("Bitte geben sie einen gültigen Befehl ein");
                    break;
                }
            }
        }
    }

    public static void chiefMenu(int id) throws IOException {
        String input;
        Subsidiary shop = coop.chiefs.get(id).getValue1();
        System.out.println("Sie sind nun als Chef der Filiale " + shop.getName() + " angemeldet");

        while (true) {
            System.out.println("Zurzeit haben die folgende Möglichkeiten");
            System.out.println("Möglichkeit 1");
            System.out.println("Alle anwesenden Mitarbeiter der Filiale anzeigen");
            System.out.println("Möglichkeit 2");
            System.out.println("Mitarbeiter einstellen");
            System.out.println("Möglichkeit 3");
            System.out.println("Mitarbeiter kündigen");
            System.out.println("Möglichkeit 4");
            System.out.println("Ausloggen");
            input = br.readLine();
            switch (input) {
                case "1": {
                    System.out.println("Zurzeit sind folgende Mitarbeiter anwesend");
                    shop.presentEmployees.keySet().forEach(System.out::println);
                    break;
                }
                case "2": {
                    List<Person> copyOfPersons = new ArrayList<>(persons.values());
                    List<Person> employees = new ArrayList<>();
                    coop.employees.values().forEach(pair -> employees.add(pair.getValue0()));
                    copyOfPersons.removeAll(employees);

                    System.out.println("Bitte geben sie den Namen der Person ein, die sie einstellen wollen");
                    System.out.println("Folgende Personen haben zurzeit keinen Beruf und können deshalb eingestellt werden");
                    copyOfPersons.forEach(person -> System.out.println(person.getName()));
                    input = br.readLine();

                    String finalInput = input;
                    if (copyOfPersons.stream().filter(element -> element.getName().equals(finalInput)).toArray().length > 0) {
                        Person p = persons.get(input);
                        System.out.println("Wie viel soll " + input + " verdienen");
                        int salary = Integer.parseInt(br.readLine());

                        p.setSalary(salary);
                        Functions.addEmployeeToCompany(p.getName());
                        Functions.hireEmployeeForShop(p.getName(), coop.chiefs.get(id).getValue1().getName());
                        System.out.println(input + " wurde erfolgreich eingestellt" + "und hat einen Lohn von " + salary + " CHF");
                    } else {
                        System.out.println("Bitte gib einen korrekten Namen ein");
                    }
                    break;
                }
                case "3": {
                    int amountOfEmployeesBeforeTermination = shop.getEmployeeList().size();
                    System.out.println("Zurzeit arbeiten " + shop.getEmployeeList().size() + " Personen in der Filiale " + shop.getName());
                    System.out.println("Folgenden Personen können sie kündigen:");
                    shop.getEmployeeList().values().forEach(person -> System.out.println(person.getName()));
                    System.out.println("Geben sie den Namen der Person ein die sie feuern möchten");
                    input = br.readLine();
                    Functions.employeeLeave(input);
                    coop.employees.remove(input);
                    shop.getEmployeeList().remove(input);

                    if (amountOfEmployeesBeforeTermination - 1 == shop.getEmployeeList().size()) {
                        System.out.println(input + " wurde erfolgreich gekündigt");
                    } else {
                        System.out.println("Es ist leider ein Fehler aufgetreten, bitte versuchen sie es später noch einmal");
                    }
                    break;
                }
                case "4": {
                    System.out.println("Sie haben sich ausgeloggt");
                    return;
                }
                default: {
                    System.out.println("Bitte geben sie einen gültigen Befehl ein");
                }
            }
        }

    }

    public static void employeeMenu() throws IOException {
        String input;
        Subsidiary shop = coop.employees.get(selectedUser.getName()).getValue1();
        System.out.println("Sie befinden sich im Mitarbeiter Menu");
        System.out.println("Sie sind Mitarbeiter der Filiale " + shop.getName());
        while (true) {
            System.out.println("Zurzeit haben sie 3 Optionen");
            System.out.println("Möglichkeit 1");
            System.out.println("Filiale betreten, vorausgesetzt sie befinden sich noch nicht in der Filiale");
            System.out.println("Möglichkeit 2");
            System.out.println("Filiale verlassen, vorausgesetzt sie befinden sich in der Filiale");
            System.out.println("Möglichkeit 3");
            System.out.println("Ausloggen");
            input = br.readLine();

            switch (input) {
                case "1": {
                    Functions.employeeEnter(selectedUser.getName());
                    break;
                }
                case "2": {
                    Functions.employeeLeave(selectedUser.getName());
                    selectedUser.receiveSalary();
                    break;
                }
                case "3": {
                    System.out.println("Sie haben sich ausgeloggt");
                    return;
                }
                default: {
                    System.out.println("Bitte geben sie einen korrekten Befehl ein ");
                    break;
                }
            }
        }

    }

    public static void shop() throws IOException {
        String input;
        String shopName = selectedUser.getCurrentShop().getName();


        while (true) {
            System.out.println("Sie haben nun folgende Möglichkeiten");
            System.out.println("Möglichkeit 1:");
            System.out.println("Artikel in den Warenkorb legen");

            System.out.println("Möglichkeit 2:");
            System.out.println("Artikel aus dem Warenkorb entfernen");

            System.out.println("Möglichkeit 3:");
            System.out.println("Artikel im Warenkorb anzeigen");

            System.out.println("Möglichkeit 4:");
            System.out.println("Bezahlen");

            System.out.println("Möglichkeit 5:");
            System.out.println("Shop verlassen (Alle Artikel im Warenkorb werden gelöscht)");
            input = br.readLine();
            switch (input) {
                case "1": {

                    System.out.println("Folgende Artikel können sie kaufen:");
                    coop.subsidiaryList.get(shopName).getAllArticle().forEach(s -> System.out.println(s.getValue0().getName() + "  " + s.getValue1() + "x"));
                    while (true) {
                        int amount;
                        System.out.println("Bitte geben sie den Namen des Artikels ein, welchen sie in den Warenkorb legen wollen (Nur den Namen)");
                        String articelName = br.readLine().toLowerCase().replace(" ", "");
                        System.out.println("Bitte geben sie an wie viele Exemplare dieses Produkts sie kaufen wollen");
                        while (true) {
                            try {
                                amount = Integer.parseInt(br.readLine());
                                break;
                            } catch (NumberFormatException e) {
                                System.out.println("Bitte geben sie einen valide Zahl an ");
                            }
                        }


                        Tablet tablet = new Tablet();
                        int shelfId = tablet.findArticle(articelName, shopName);
                        try {
                            Functions.takeArticle(selectedUser.getName(), articelName, amount, shelfId);
                            break;
                        } catch (NullPointerException e) {
                            System.out.println("Bitte geben sie einen korrekten Namen an");
                        }
                    }
                    break;
                }
                case "2": {
                    System.out.println("Sie haben folgende Artikel in ihrem Warenkorb");
                    selectedUser.getCart().getArticleList().values().forEach(s -> System.out.println(s.getValue0().getName() + "  " + s.getValue1() + "x"));
                    System.out.println("Bitte geben sie den namen eines Artikels an um ihn aus dem Warenkorb zu entfernen");
                    String artikelName = br.readLine();
                    System.out.println("Bitte geben sie an wie viele Exemplare sie entfernen wollen");
                    int articleAmount = Integer.parseInt(br.readLine());
                    selectedUser.getCart().decreaceArticleAmount(artikelName, articleAmount);
                    int shelfId = coop.subsidiaryList.get(shopName).articlePositions.get(artikelName);
                    boolean barcode = coop.articleOfSortiment.get(artikelName).isBarcode();
                    ArticleType articleType = coop.articleOfSortiment.get(artikelName).getArticleType();
                    coop.subsidiaryList.get(shopName).getShelfById(shelfId).increaseArticleAmount(artikelName, articleAmount, barcode, articleType.toString(), shopName);
                    break;
                }
                case "3": {
                    System.out.println("Sie haben folgende Artikel in ihrem Warenkorb");
                    selectedUser.getCart().getArticleList().values().forEach(s -> System.out.println(s.getValue0().getName() + "  " + s.getValue1() + "x"));
                    break;
                }
                case "4": {
                    System.out.println("Sie können entweder an der Kasse oder an einer Self-Checkout Station bezahlen");
                    System.out.println("Um normal an der Kasse zu bezahlen drücken sie die 1");
                    System.out.println("Um an einer Self-Checkout Station zu bezahlen drücken sie die 2");
                    String input2 = br.readLine();
                    switch (input2) {
                        case "1": {
                            Functions.checkOut(selectedUser.getName(), shopName);
                            break;
                        }
                        case "2": {
                            if(selectedUser.getCurrentShop().isSelfCheckout()){
                                Functions.selfCheckOut(selectedUser.getName(), selectedUser.getCurrentShop().getName());
                            }else{
                                System.out.println("Leider verfügt dieser Laden über keine Self-Checkout Station");
                            }
                            break;
                        }
                        default: {
                            System.out.println("Bitte geben sie einen gültigen Befehl ein");
                            break;
                        }
                    }
                    break;
                }
                case "5": {

                    for (Pair<Article, Integer> v : selectedUser.getCart().articleList.values()) {
                        int shelfId = coop.subsidiaryList.get(shopName).articlePositions.get(v.getValue0().getName());
                        boolean barcode = v.getValue0().isBarcode();
                        ArticleType articleType = v.getValue0().getArticleType();
                        coop.subsidiaryList.get(shopName).getShelfById(shelfId).increaseArticleAmount(v.getValue0().getName(), v.getValue1(), barcode, articleType.toString(), shopName);
                    }
                    selectedUser.getCart().setFullPrice(0);
                    selectedUser.getCart().articleList.clear();
                    selectedUser.setShop(null);
                    System.out.println("Sie haben den Laden verlassen");
                    return;
                }
                default: {
                    System.out.println("Bitte geben sie einen gültigen Befehl ein");
                    break;
                }

            }
        }
    }

    public static void searchArticleInShop() throws IOException {
        String shopName;

        System.out.println("In welcher Filiale möchten sie ein Produkt suchen?");
        System.out.println("Es stehen ihnen folgende Filialen zu Auswahl:");
        coop.subsidiaryList.keySet().forEach(System.out::println);
        System.out.println("Bitte geben sie den Namen einer Filiale ein um nach einem Produkt zu suchen");
        while (true) {

            shopName = br.readLine();
            if (coop.subsidiaryList.get(shopName) == null) {
                System.out.println("Bitte suche nach einem existierenden Shop");
            } else {
                break;
            }
        }


        System.out.println("Sie können die Verfügbarkeit der folgenden Produkte überprüfen");
        //coop.subsidiaryList.get(shopName).getAllArticle().forEach(s -> System.out.println(s.getValue0().getName() + "  " + s.getValue1() + "x"));
        coop.subsidiaryList.get(shopName).getAllArticle().forEach(s -> System.out.println(s.getValue0().getName()));
        System.out.println("Bitte wählen sie ein Produkt");
        String articleName;
        Tablet tablet = new Tablet();
        Pair<Article, Integer> articlePair;
        int amount;
        while (true) {
            articleName = br.readLine().toLowerCase().replace(" ", "");
            try {
                articlePair = tablet.getArticlePair(articleName, shopName);
                amount = articlePair.getValue1();
                break;
            } catch (NullPointerException e) {
                System.out.println("Bitte gib einen gültigen Artikelnamen an ");
            }
        }


        System.out.println("In der Filiale " + shopName + " ist das Produkt " + articleName + " " + amount + "x im Regal " + tablet.findArticle(articleName, shopName) + " vorhanden");
    }

    public static void searchArticleInSystem() throws IOException {
        System.out.println("Sie können die Verfügbarkeit der folgenden Produkte überprüfen");
        coop.articleOfSortiment.values().forEach((s -> System.out.println(s.getName())));
        System.out.println("Bitte wählen sie ein Produkt");

        Tablet tablet = new Tablet();
        List<Triplet<Subsidiary, Article, Integer>> articleTripleList;
        String articleName;
        while (true) {
            articleName = br.readLine().toLowerCase().replace(" ", "");
            ;

            articleTripleList = tablet.findArticleInSystem(articleName);
            if (articleTripleList.size() == 0) {
                System.out.println("Bitte gib einen gültigen Artikelnamen an ");
            } else {
                break;
            }
        }

        for (Triplet<Subsidiary, Article, Integer> t : articleTripleList) {
            String shopName = t.getValue0().getName();
            int amount = t.getValue2();
            System.out.println("In der Filiale " + shopName + " ist das Produkt " + articleName + " " + amount + "x im Regal " + tablet.findArticle(articleName, shopName) + " vorhanden");
        }
    }

    public static void searchArticleByType() throws IOException {
        System.out.println("Sie können die Produkte nach den folgenden Typen filtern");
        Arrays.stream(ArticleType.values()).forEach(System.out::println);
        System.out.println("Bitte wählen sie ein Typ");

        Tablet tablet = new Tablet();
        List<Triplet<Subsidiary, Article, Integer>> articleTripleList;
        String articleName;
        while (true) {
            articleName = br.readLine().toUpperCase().replace(" ", "");

            articleTripleList = tablet.findArticleByType(articleName);
            if (articleTripleList.size() == 0) {
                System.out.println("Entweder existiert der eingegebene Type nicht oder es sind keine Produkte dieser Art erfasst");
            } else {
                break;
            }
        }

        for (Triplet<Subsidiary, Article, Integer> t : articleTripleList) {
            String shopName = t.getValue0().getName();
            int amount = t.getValue2();
            System.out.println("In der Filiale " + shopName + " ist das Produkt " + articleName + " " + amount + "x im Regal " + tablet.findArticle(articleName, shopName) + " vorhanden");
        }
    }
}