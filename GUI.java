//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import GameHandlerPackage.*;
import SupermarketPackage.*;

import SupermarketPackage.Articles.Article;
import static GameHandlerPackage.SystemHandler.*;

import org.javatuples.Pair;
import org.javatuples.Triplet;
import org.reflections.Reflections;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;
import java.util.List;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Set;
import javax.swing.*;

public class GUI {

    //Erstes Panel Komponente
    private JPanel panelMain;
    private JTextField nameLogin;
    private JLabel nameLabel;
    private JLabel passwortLabel;
    private JPasswordField passwortLogin;
    private JButton bestätigenButton;

    //Alle Panels
    private JPanel Loginpanel;
    private JPanel Dashboardpanel;
    private JPanel Filialebetreten;
    private JPanel Filiale;
    private JPanel Warenkorb;
    private JPanel ArtikelPanel;
    private JPanel Tablet;
    private JPanel TabletÜbersicht;
    private JPanel TabletSelect;
    private JPanel Kassen;
    private JPanel Cart;

    //Alle normalen Buttons
    private JLabel welcomeText;
    private JButton filialeBetretenButton;
    private JButton tabletBenutzenButton;
    private JButton personalienAnzeigenButton;
    private JButton schüpercardButton;
    private JButton ausloggenButton;
    private JButton TabletArtikelFIliale;
    private JButton artikelInDenWarenkorbButton;
    private JButton bestätigenButton1;
    private JButton anDieKasseGehenButton;
    private JButton ButtonArtikelSuchen;
    private JButton TabletMenuArtikelSupermarkt;

    //Radiobuttons für die Supermarktketten-Auswahl
    private JRadioButton migrosRadioButton;
    private JRadioButton coopRadioButton;
    private JRadioButton aldiRadioButton;

    //Dropdownmenü um die Artikel auszuwählen(Tablet)
    private JComboBox comboBox1;
    private JButton TabletMenuArtikelFIliale;
    private JComboBox TabletSupermarktWählen;
    private JComboBox TabletArtikelWählen;
    private JLabel ArtikelFindenOutput;
    private JComboBox TabletTypWählen;
    private JButton TabletMenuArtikelName;
    private JComboBox TabletFilialeWählen;
    private JButton TabletMenuArtikelTyp;
    private JLabel TabletSupermarktWählenLabel;
    private JLabel TabletArtikelWählenLabel;
    private JLabel TabletFilialeWählenLabel;
    private JLabel TabletTypWählenLabel;
    private JButton bezahlButton;
    private JPanel Gesamtwert;

    //Hashmap für die Produkte in einem Laden
    HashMap<String, JSpinner> produkte = new HashMap<>();
    String currentTabletFuntion;

    //Hashmap um Spinner Komponente zu speichern
    HashMap<String, JSpinner> spinnerHashMap = new HashMap<>();

    //Globale Variabeln


    private int greatValue;

    public static JFrame frame = new JFrame("Yanick und Marcs Wirtschaftsspass");

    //Konstruktor indem alle Funktionen verwaltet werden
    public GUI() {
        invisibler();
        this.Loginpanel.setVisible(true);

        this.bestätigenButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                if (SystemHandler.login(nameLogin.getText(), new String(passwortLogin.getPassword()))) {
                    //SystemHandler.setSelectedUser(SystemHandler.getPersonList().get(nameLogin.getText()));
                    invisibler();
                    Dashboardpanel.setVisible(true);
                }

            }
        });

        //Key listener wenn das Passwort angegeben wurde und Enter gedrückt wird
        passwortLogin.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER && SystemHandler.login(GUI.this.nameLogin.getText(), GUI.this.passwortLogin.getText())) {
                    if (SystemHandler.login(nameLogin.getText(), new String(passwortLogin.getPassword()))) {
                        //SystemHandler.setSelectedUser(SystemHandler.getPersonList().get(nameLogin.getText()));
                        invisibler();
                        Dashboardpanel.setVisible(true);
                    }
                    invisibler();
                    Dashboardpanel.setVisible(true);
                }
                super.keyPressed(e);
            }
        });

        //Falls der Benutzer schon beim Benutzernamen Enter drückt, oder diesen noch ändern muss
        nameLogin.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER && SystemHandler.login(GUI.this.nameLogin.getText(), GUI.this.passwortLogin.getText())) {
                    invisibler();
                    Dashboardpanel.setVisible(true);
                }
                super.keyPressed(e);
            }
        });


        //Der Kunde betritt die Filiale
        //Nun hat der Kunde die Wahl in welcher Filiale er einkaufen gehen will
        filialeBetretenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                invisibler();
                Filialebetreten.setVisible(true);
            }
        });

        //Mit diesen Buttons bestimmt man den die gewollte Filiale
        migrosRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Hier gehts ins Migros
                setCurrentCompany("migros");
                invisibler();
                Filiale.setVisible(true);
                fillDropdownWithShops(getCurrentCompany(), comboBox1);
            }
        });

        coopRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Hier gehts ins Coop
                setCurrentCompany("coop");
                invisibler();
                Filiale.setVisible(true);
                fillDropdownWithShops(getCurrentCompany(), comboBox1);
            }


        });

        aldiRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Hier gehts in den Aldi
                setCurrentCompany("aldi");
                invisibler();
                Filiale.setVisible(true);
                fillDropdownWithShops(getCurrentCompany(), comboBox1);
            }
        });


        tabletBenutzenButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                //Hier gehts in den Aldi
                invisibler();
                Tablet.setVisible(true);
                TabletSelect.setVisible(false);

            }
        });

        //Dieser Button bestätigt die ausgewählte Filiale


        //Mit diesem Button fügt der Benutzer die Artikel in den Warenkorb ein
        artikelInDenWarenkorbButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for(String key : spinnerHashMap.keySet()) {
                    if((Integer) spinnerHashMap.get(key).getValue() != 0) {
                        for(int key2 : SystemHandler.getSupermarketChainMap().get(getCurrentCompany()).getShopMap().get(getCurrentShop()).getShelfList().keySet()) {
                            for(String key3 : SystemHandler.getSupermarketChainMap().get(getCurrentCompany()).getShopMap().get(getCurrentShop()).getShelfList().get(key2).getArticleList().keySet()) {
                                if(key3.equals(key)) {
                                    getSelectedUser().getCart().addArticle(new Pair<>(SystemHandler.getSupermarketChainMap().get(getCurrentCompany()).getShopMap().get(getCurrentShop()).getShelfList().get(key2).getArticleList().get(key3).getValue0(), (Integer) spinnerHashMap.get(key).getValue()));
                                    SystemHandler.getSupermarketChainMap().get(getCurrentCompany()).getShopMap().get(getCurrentShop()).getShelfList().get(key2).takeArticle(key, (Integer) spinnerHashMap.get(key).getValue());
                                    greatValue += SystemHandler.getSupermarketChainMap().get(getCurrentCompany()).getShopMap().get(getCurrentShop()).getShelfList().get(key2).getArticleList().get(key3).getValue0().getPrice() * (Integer) spinnerHashMap.get(key).getValue();
                                }
                            }
                        }
                    }
                }
                JLabel labelNew = new JLabel("Insgesamt: " + greatValue + "CHF");
                labelNew.setFont(new Font("Serif", Font.PLAIN, 30));
                Gesamtwert.add(labelNew);
            }
        });


        /*Der anDieKasseGehenButton ist ein äusserst komplizierter Button. Er ist kaum nachvollziehbar
         * der Kunde wird gezwungen zu zahlen bar. Zahlt er mit Karte, landet er im Garte*/
        anDieKasseGehenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                invisibler();
                showPrice();
                Kassen.setVisible(true);
            }
        });

        //Dieser Button bestätigt die ausgewählte Filiale

        bestätigenButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // System.out.println(comboBox1.getSelectedItem().toString());
                setCurrentShop(comboBox1.getSelectedItem().toString());
                generateProducts(comboBox1.getSelectedItem().toString());

                invisibler();
                Warenkorb.setVisible(true);
            }
        });

        bezahlButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                invisibler();
                EinkaufAbschluss.setVisible(true);
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                invisibler();
                Dashboardpanel.setVisible(true);
            }
        });
    }

        TabletSupermarktWählen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String supermarket = (String) TabletSupermarktWählen.getSelectedItem();
                TabletArtikelWählen.removeAllItems();
                fillDropdownWithArticlesFromSupermarket(supermarket, TabletArtikelWählen);
            }
        });

        TabletMenuArtikelTyp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentTabletFuntion = "typ";
                TabletÜbersicht.setVisible(false);
                TabletSelect.setVisible(true);

                TabletTypWählen.setVisible(true);
                TabletTypWählenLabel.setVisible(true);

                TabletSupermarktWählen.setVisible(false);
                TabletSupermarktWählenLabel.setVisible(false);

                TabletFilialeWählen.setVisible(false);
                TabletFilialeWählenLabel.setVisible(false);

                TabletArtikelWählen.setVisible(false);
                TabletArtikelWählenLabel.setVisible(false);

                fillDropdownWithArticlesFromType(TabletTypWählen);


            }
        });

        TabletMenuArtikelSupermarkt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentTabletFuntion = "supermarket";
                TabletÜbersicht.setVisible(false);
                TabletSelect.setVisible(true);

                TabletSupermarktWählen.setVisible(true);
                TabletSupermarktWählenLabel.setVisible(true);

                TabletArtikelWählen.setVisible(true);
                TabletArtikelWählenLabel.setVisible(true);


                TabletFilialeWählen.setVisible(false);
                TabletFilialeWählenLabel.setVisible(false);

                TabletTypWählen.setVisible(false);
                TabletTypWählenLabel.setVisible(false);
                fillDropdownWithSupermarkets(TabletSupermarktWählen);
            }
        });

        ButtonArtikelSuchen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SupermarketPackage.Tablet Tablet1 = new Tablet();
                switch (currentTabletFuntion) {
                    case "supermarket": {

                        String supermarketName = (String) TabletSupermarktWählen.getSelectedItem();
                        String articleName = (String) TabletArtikelWählen.getSelectedItem();
                        List<Triplet<Shop, Article, Integer>> articleInSystemList = Tablet1.findArticleInSystem(articleName, supermarketName);
                        StringBuilder output = new StringBuilder();
                        output.append("<html>");
                        for (Triplet<Shop, Article, Integer> t : articleInSystemList) {
                            String shopName = t.getValue0().getName();
                            int amount = t.getValue2();
                            int shelfId = Tablet1.findArticle(articleName, shopName, supermarketName);
                            output.append("In der Filiale ").append(shopName).append(" ist das Produkt ").append(articleName).append(" ").append(amount).append("x im Regal ").append(shelfId).append(" vorhanden <br/>");
                        }
                        ArtikelFindenOutput.setText(output.append("</html>").toString());
                    }
                    case "typ": {
                        String typ = (String) TabletTypWählen.getSelectedItem();
                        StringBuilder output = new StringBuilder();
                        output.append("<html>");
                        for (SupermarketChain supermarket : SystemHandler.getSupermarketChainMap().values()) {
                            for (Shop shop : supermarket.getShopMap().values()) {
                                for (Shelf shelf : shop.getShelfList().values())
                                    for (Pair<Article, Integer> articlePair : shelf.getArticleList().values()) {
                                        if (articlePair.getValue0().getClass().getSimpleName().equals(typ)) {

                                            output.append("Im Supermarkt ").append(supermarket.getName()).append(" hat es in der Filiale ").append(shop.getName()).append(" das Produkt ").append(articlePair.getValue0().getName()).append(" ").append(articlePair.getValue1()).append("x im Regal ").append(shelf.getID()).append("<br/>");
                                        }
                                    }
                            }
                        }
                        ArtikelFindenOutput.setText(output.append("</html>").toString());
                    }
                }
            }
        });
    }


    public void fillDropdownWithShops(String supermarketname, JComboBox comboBox) {
        for (String key : SystemHandler.getSupermarketChainMap().keySet()) {
            if (key.equals(supermarketname)) {
                for (String key2 : SystemHandler.getSupermarketChainMap().get(key).getShopMap().keySet()) {
                    comboBox.addItem(key2);
                }
            } else {
                System.out.println("Nicht diese Filiale");
            }
        }
    }

    //Hier befüllen wir die Labels mit den Artikeln welche wir verkaufen
    public void generateProducts(String shopname) {
        for (int key : SystemHandler.getSupermarketChainMap().get(getCurrentCompany()).getShopMap().get(shopname).getShelfList().keySet()) {
            for (Pair<Article, Integer> key2Pair : SystemHandler.getSupermarketChainMap().get(getCurrentCompany()).getShopMap().get(shopname).getShelfList().get(key).getArticleList().values()) {
                String key2 = key2Pair.getValue0().getName();
                //Neues Panel wird erstellt
                JPanel panelNew = new JPanel();

                //Danach gleichzeitig neue Labels welche in das erstellte Panel eingefügt werden
                JLabel labelNew = new JLabel(key2 + " (" + key2Pair.getValue1() + "x)");
                labelNew.setFont(new Font("Serif", Font.PLAIN, 20));
                panelNew.add(labelNew);

                //Das Gleiche geschieht mit dem Spinner
                JSpinner spinnerNeu = new JSpinner();
                spinnerNeu.setFont(new Font("Serif", Font.PLAIN, 20));
                spinnerHashMap.put(key2, spinnerNeu);

                panelNew.add(spinnerNeu);

                produkte.put(key2, spinnerNeu);

                //Schlussendlich wird das erstellte Panel in das Artikelpanel gelegt
                ArtikelPanel.add(panelNew);
            }
        }
    }

    //Mit der showPrice Methode sorgen wir für die Darstellung des Preises an der Kasse
    public void showPrice() {
        for (String key2 : getSelectedUser().getCart().getArticleList().keySet()) {
            JPanel panelNew = new JPanel();
            JLabel labeNew = new JLabel(getSelectedUser().getCart().getArticleList().get(key2).getValue0().getName() + " " + getSelectedUser().getCart().getArticleList().get(key2).getValue0().getPrice());
            labeNew.setFont(new Font("Serif", Font.PLAIN, 20));
            labeNew.setVerticalAlignment(SwingConstants.CENTER);
            panelNew.add(labeNew);
            Cart.add(panelNew);
        }
    }

    public void fillDropdownWithSupermarkets(JComboBox comboBox) {
        for (String key : SystemHandler.getSupermarketChainMap().keySet()) {
            comboBox.addItem(key);
        }
    }

    public void fillDropdownWithArticlesFromSupermarket(String supermarketname, JComboBox comboBox) {
        SupermarketChain supermarketChain = SystemHandler.getSupermarketChainMap().get(supermarketname);
        for (Article article : supermarketChain.getArticleMap().values()) {
            comboBox.addItem(article.getName());
        }
    }
/* org.reflections:reflections:0.10.1*/
    public void fillDropdownWithArticlesFromType(JComboBox comboBox) {
        Reflections reflections = new Reflections("SupermarketPackage.Articles");

        Set<Class<? extends Article>> classes = reflections.getSubTypesOf(Article.class);

        for (Class<? extends Article> subClass : classes) {
            comboBox.addItem(subClass.getSimpleName());
            System.out.println(subClass.getSimpleName());
        }
    }


    public static void main(String[] args) {
        SupermarketHandler.setUp();


        frame.setResizable(true);
        frame.setContentPane((new GUI()).panelMain);
        frame.setDefaultCloseOperation(3);
        frame.pack();
        frame.setSize(600, 500);
        frame.setLocationRelativeTo((Component) null);
        frame.setVisible(true);
    }

    public void invisibler() {
        Dashboardpanel.setVisible(false);
        Filialebetreten.setVisible(false);
        Loginpanel.setVisible(false);
        Filiale.setVisible(false);
        Tablet.setVisible(false);
        Warenkorb.setVisible(false);
        Kassen.setVisible(false);
        EinkaufAbschluss.setVisible(false);
    }


}
