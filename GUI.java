
import GameHandlerPackage.*;
import SupermarketPackage.*;


import SupermarketPackage.Articles.Article;

import static GameHandlerPackage.SystemHandler.*;

import SupermarketPackage.Articles.Material;
import org.javatuples.Pair;
import org.javatuples.Triplet;
import org.reflections.Reflections;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.*;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;


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
    private JPanel EinkaufAbschluss;
    private JPanel Gesamtwert;
    private JPanel Schüpercard;
    private JPanel ProduktHinzufügen;
    private JPanel Employeepanel;
    private JPanel Mitarbeiter;

    //Alle normalen Buttons
    private JLabel welcomeText;
    private JButton filialeBetretenButton;
    private JButton tabletBenutzenButton;
    private JButton schüpercardButton;
    private JButton ausloggenButton;
    private JButton TabletMenuName;
    private JButton artikelInDenWarenkorbButton;
    private JButton bestätigenButton1;
    private JButton anDieKasseGehenButton;
    private JButton ButtonArtikelSuchen;
    private JButton TabletMenuSupermarkt;
    private JButton TabletMenuArtikelSupermarkt;
    private JButton backButton;
    private JButton TabletMenuFiliale;
    private JButton schüpercardErstellenButton;
    private JButton zurückButton;
    private JButton zurückButtonFiliale1;
    private JButton zurückButtonWarenkorb;
    private JButton zurückButtonKasse;
    private JButton zurückButtonSchüpercard;
    private JButton Zurück;
    private JButton buttonZurückTablet;
    private JButton zurückButtonSchüpperkarteErstellt;
    private JButton bezahlButton;
    private JButton TabletMenuTyp;

    private JButton arbeitenGehenButton;
    private JButton kündenButton;
    private JButton regalHinzufügenButton;
    private JButton produktHinzufügenButton;
    private JButton eingebenButton;
    private JButton erstellungAbschliessenButton;


    //Radiobuttons für die Supermarktketten-Auswahl
    private JRadioButton migrosRadioButton;
    private JRadioButton coopRadioButton;
    private JRadioButton aldiRadioButton;

    //Dropdownmenü um die Artikel auszuwählen(Tablet)
    private JComboBox comboBox1;
    private JComboBox TabletSupermarktWählen;
    private JComboBox TabletArtikelWählen;
    private JComboBox TabletTypWählen;
    private JComboBox TabletFilialeWählen;

    //Label / Texte
    private JLabel TabletSupermarktWählenLabel;
    private JLabel TabletArtikelWählenLabel;
    private JLabel TabletFilialeWählenLabel;
    private JLabel TabletTypWählenLabel;
    private JPanel SchüperkarteErstellt;
    private JPanel SchüpercardNummer;

    private JLabel name;
    private JLabel schüpperpunkte;
    private JLabel guthaben;
    private JLabel ArtikelFindenOutput;
    private JButton ChiefMenu;
    private JPanel ChiefPanel;
    private JButton HireEmployee;
    private JButton mitarbeiterKündigenButton;

    private JLabel labelFalsch;

    public JSpinner spinnerRegal;
    private JTextField chipsÄpfelUswTextField;
    private JTextField a500CHFTextField;
    private JTextField trueFalseTextField;
    private JLabel labelFalschProdukt;
    private JSpinner spinnerMenge;
    private JTextField produktnameTextField;
    private JComboBox comboBoxProduktart;
    private JButton zurückZumMenuButton;
    private JButton GetAllEmployeesOfShop;
    private JButton promoteEmployeeButton;
    private JLabel ChiefOutput;
    private JButton employeeMenuButton;
    private JButton zurückButtonHinzufügen;
    private JPanel SpinnerPanelProdukte;
    private JPanel FoodPanel;
    private JTextField PreisTextField;
    private JTextField DatumTextField;
    private JComboBox comboBoxFleisch;
    private JButton produktErstellenButton;
    private JButton zurückButtonFleisch;
    private JButton zurückButton1;
    private JLabel labelFalschFleisch;
    private JComboBox ChiefMenuComboBox;
    private JButton ChiefMenuEnter;
    private JPanel ChiefMenuActionPanel;
    private JLabel ChiefMenuActionPanelLabel;
    private JButton ChiefMenuALLEmployees;
    private JSpinner spinnerMengeFleisch;
    private JPanel BuildingMatPanel;
    private JTextField produktnamenBuild;
    private JTextField PreisFeld;
    private JSpinner spinnerMengeMat;
    private JTextField trueFalseTextBuild;
    private JSpinner spinnerTonnen;
    private JComboBox comboBoxMaterial;
    private JButton zurückButtonMaterial;
    private JButton produktErstellenBuildingMat;
    private JPanel ProduktErstellt;
    private JButton zurückZumMenüButton;
    private JLabel labelUnkorrektFleisch;
    private JLabel labelFalschBuild;
    private JLabel labelInkorrektBuild;
    private JPanel Arbeiten;
    private JButton arbeitVerlassenButton;
    private JPanel RegalHinzufügen;
    private JSpinner spinnerAnzRegale;
    private JButton gewählteAnzahlHinzufügenButton;
    private JPanel RegaleErstellt;
    private JButton zurückZumMenüButton1;
    private JPanel Selfscanner;
    private JPanel Entscheidung;
    private JButton selfscannerButton;
    private JButton normaleKasseButton;
    private JPanel PreisGesamt;
    private JPanel ProdukteWarenkorb;
    private JPanel ProdukteGescannt;
    private JButton scanButton;
    private JComboBox ProdukteWarenkorbComb;
    private JFormattedTextField ChiefSalaryField;
    private JLabel ChiefHireSalaryLabel;
    private JLabel ErrorMessageScan;
    private JButton bezahlenButton;
    private JPanel produkteGescanntList;
    private JButton auswählenButton;
    private JLabel labelFalschRadio;
    private JButton zurückButton2;
    private JList gescannteProdukteList;

    //Hashmap für die Produkte in einem Laden
    HashMap<String, JSpinner> produkte = new HashMap<>();
    String currentTabletFuntion;
    float greatPrice = 0;

    //Hashmap um Spinner Komponente zu speichern
    HashMap<String, JSpinner> spinnerHashMap = new HashMap<>();

    private int greatValue;
    private DefaultListModel model = new DefaultListModel();

    public static JFrame frame = new JFrame("Yanick und Marcs Wirtschaftsspass");

    //Konstruktor indem alle Funktionen verwaltet werden
    public GUI() {

        labelFalschRadio.setVisible(false);
        ErrorMessageScan.setVisible(false);
        labelFalsch.setVisible(false);
        labelUnkorrektFleisch.setVisible(false);
        labelFalschBuild.setVisible(false);
        labelInkorrektBuild.setVisible(false);

        labelFalschFleisch.setVisible(false);
        invisibler();

        Loginpanel.setVisible(true);
        ChiefMenu.setVisible(false);
        employeeMenuButton.setVisible(false);


        this.bestätigenButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                if (SystemHandler.login(nameLogin.getText(), new String(passwortLogin.getPassword()))) {
                    //SystemHandler.setSelectedUser(SystemHandler.getPersonList().get(nameLogin.getText()));
                    invisibler();
                    labelFalsch.setVisible(false);
                    Dashboardpanel.setVisible(true);
                    setDashboardInformation();
                    showSpecialButtons();
                } else {
                    labelFalsch.setVisible(true);
                }
            }
        });

        //Key listener wenn das Passwort angegeben wurde und Enter gedrückt wird
        passwortLogin.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    if (SystemHandler.login(GUI.this.nameLogin.getText(), GUI.this.passwortLogin.getText())) {
                        invisibler();
                        showSpecialButtons();
                        Dashboardpanel.setVisible(true);
                        setDashboardInformation();
                    } else {
                        labelFalsch.setVisible(true);
                    }
                }
                super.keyPressed(e);

            }
        });

        //Falls der Benutzer schon beim Benutzernamen Enter drückt, oder diesen noch ändern muss
        nameLogin.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    if (SystemHandler.login(GUI.this.nameLogin.getText(), GUI.this.passwortLogin.getText())) {
                        invisibler();
                        Dashboardpanel.setVisible(true);
                        setDashboardInformation();
                        showSpecialButtons();
                    } else {
                        labelFalsch.setVisible(true);
                    }
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

        tabletBenutzenButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                //Hier gehts in den Aldi
                invisibler();
                Tablet.setVisible(true);
                TabletÜbersicht.setVisible(true);

            }
        });

        //Mit diesem Button fügt der Benutzer die Artikel in den Warenkorb ein
        artikelInDenWarenkorbButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (String key : spinnerHashMap.keySet()) {
                    if ((Integer) spinnerHashMap.get(key).getValue() != 0) {
                        for (int key2 : SystemHandler.getSupermarketChainMap().get(getCurrentCompany()).getShopMap().get(getCurrentShop()).getShelfList().keySet()) {
                            for (Pair<Article, Integer> key3Pair : SystemHandler.getSupermarketChainMap().get(getCurrentCompany()).getShopMap().get(getCurrentShop()).getShelfList().get(key2).getArticleList().values()) {
                                Article key3 = key3Pair.getValue0();
                                if (key3.getName().equals(key)) {
                                    getSelectedUser().getCart().addArticle(new Pair<>(SystemHandler.getSupermarketChainMap().get(getCurrentCompany()).getShopMap().get(getCurrentShop()).getShelfList().get(key2).getArticleList().get(key3.getName()).getValue0(), (Integer) spinnerHashMap.get(key).getValue()));
                                    SystemHandler.getSupermarketChainMap().get(getCurrentCompany()).getShopMap().get(getCurrentShop()).getShelfList().get(key2).takeArticle(key, (Integer) spinnerHashMap.get(key).getValue());
                                    greatValue += SystemHandler.getSupermarketChainMap().get(getCurrentCompany()).getShopMap().get(getCurrentShop()).getShelfList().get(key2).getArticleList().get(key3.getName()).getValue0().getPrice() * (Integer) spinnerHashMap.get(key).getValue();
                                }
                            }
                        }
                    }
                }
                generateProducts(getCurrentShop());
                Gesamtwert.removeAll();
                Gesamtwert.repaint();
                Gesamtwert.revalidate();
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
                Entscheidung.setVisible(true);
            }
        });

        //Dieser Button bestätigt die ausgewählte Filiale
        bestätigenButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
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

                //Einkaufswert auf Null zurücksetzen
                greatValue = 0;

                //Abschluss wird sichtbar
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

        TabletSupermarktWählen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String supermarket = (String) TabletSupermarktWählen.getSelectedItem();
                TabletArtikelWählen.removeAllItems();
                if (TabletFilialeWählen.getItemCount() > 0) {
                    TabletFilialeWählen.removeAllItems();
                }

                fillDropdownWithShops(supermarket, TabletFilialeWählen);

                fillDropdownWithArticlesFromSupermarket(supermarket, TabletArtikelWählen);

            }
        });

        TabletFilialeWählen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String supermarket = (String) TabletSupermarktWählen.getSelectedItem();
                String shopName = (String) TabletFilialeWählen.getSelectedItem();
                System.out.println("tsets " + shopName);
                TabletArtikelWählen.removeAllItems();

                if (currentTabletFuntion.equals("shop") && shopName != null) {
                    fillDropdownWithArticlesFromSupermarketFromShop(supermarket, shopName, TabletArtikelWählen);
                }
            }
        });

        TabletMenuSupermarkt.addActionListener(new ActionListener() {
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

        TabletMenuTyp.addActionListener(new ActionListener() {
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

                fillDropdownWithArticlesByType(TabletTypWählen);
            }
        });

        TabletMenuFiliale.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentTabletFuntion = "shop";
                TabletÜbersicht.setVisible(false);
                TabletSelect.setVisible(true);

                TabletSupermarktWählen.setVisible(true);
                TabletSupermarktWählenLabel.setVisible(true);

                TabletArtikelWählen.setVisible(true);
                TabletArtikelWählenLabel.setVisible(true);

                TabletFilialeWählen.setVisible(true);
                TabletFilialeWählenLabel.setVisible(true);

                TabletTypWählen.setVisible(false);
                TabletTypWählenLabel.setVisible(false);
                fillDropdownWithSupermarkets(TabletSupermarktWählen);
            }
        });

        TabletTypWählen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentTabletFuntion = "typ";
                TabletÜbersicht.setVisible(false);
                TabletSelect.setVisible(true);

                TabletSupermarktWählen.setVisible(false);
                TabletSupermarktWählenLabel.setVisible(false);

                TabletArtikelWählen.setVisible(false);
                TabletArtikelWählenLabel.setVisible(false);

                TabletFilialeWählen.setVisible(false);
                TabletFilialeWählenLabel.setVisible(false);

                TabletTypWählen.setVisible(true);
                TabletTypWählenLabel.setVisible(true);

                fillDropdownWithArticlesByType(TabletTypWählen);
            }
        });

        TabletMenuName.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentTabletFuntion = "name";
                TabletÜbersicht.setVisible(false);
                TabletSelect.setVisible(true);

                TabletSupermarktWählen.setVisible(false);
                TabletSupermarktWählenLabel.setVisible(false);

                TabletArtikelWählen.setVisible(true);
                TabletArtikelWählenLabel.setVisible(true);

                TabletFilialeWählen.setVisible(false);
                TabletFilialeWählenLabel.setVisible(false);

                TabletTypWählen.setVisible(false);
                TabletTypWählenLabel.setVisible(false);

                fillDropdownWithAllArticles(TabletArtikelWählen);
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
                        break;
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
                        break;
                    }
                    case "shop": {
                        String supermarketName = (String) TabletSupermarktWählen.getSelectedItem();
                        String shopName = (String) TabletFilialeWählen.getSelectedItem();
                        String articleName = (String) TabletArtikelWählen.getSelectedItem();
                        List<Triplet<Shop, Article, Integer>> articleInSystemList = Tablet1.findArticleInShop(articleName, shopName, supermarketName);
                        StringBuilder output = new StringBuilder();
                        output.append("<html>");
                        for (Triplet<Shop, Article, Integer> t : articleInSystemList) {

                            int amount = t.getValue2();
                            int shelfId = Tablet1.findArticle(articleName, shopName, supermarketName);
                            output.append("In der Filiale ").append(shopName).append(" ist das Produkt ").append(articleName).append(" ").append(amount).append("x im Regal ").append(shelfId).append(" vorhanden <br/>");
                        }

                        ArtikelFindenOutput.setText(output.append("</html>").toString());
                        break;
                    }
                    case "name": {
                        String articleName = (String) TabletArtikelWählen.getSelectedItem();
                        StringBuilder output = new StringBuilder();
                        output.append("<html>");
                        for (SupermarketChain supermarket : SystemHandler.getSupermarketChainMap().values()) {
                            for (Shop shop : supermarket.getShopMap().values()) {
                                for (Shelf shelf : shop.getShelfList().values()) {
                                    for (Pair<Article, Integer> pair : shelf.getArticleList().values()) {
                                        assert articleName != null;
                                        if (articleName.equals(pair.getValue0().getName())) {
                                            output.append("Im Supermarkt ").append(supermarket.getName()).append(" hat es in der Filiale ").append(shop.getName()).append(" das Produkt ").append(pair.getValue0().getName()).append(" ").append(pair.getValue1()).append("x im Regal ").append(shelf.getID()).append("<br/>");
                                        }
                                    }
                                }
                            }
                        }
                        ArtikelFindenOutput.setText(output.append("</html>").toString());
                        break;
                    }
                }
            }
        });

        schüpercardButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                invisibler();
                Schüpercard.setVisible(true);
            }
        });
        ausloggenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                invisibler();
                Loginpanel.setVisible(true);
                labelFalsch.setVisible(false);
                nameLogin.setText("");
                passwortLogin.setText("");
                SystemHandler.logout();
            }
        });

        //Alle Zurückbuttons welche wir brauchen um das Programm dynamisch zu gestalten
        zurückButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                invisibler();
                Dashboardpanel.setVisible(true);
            }
        });

        zurückButtonFiliale1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                invisibler();
                Filialebetreten.setVisible(true);
            }
        });

        zurückButtonKasse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                invisibler();
                Warenkorb.setVisible(true);
            }
        });

        zurückButtonWarenkorb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                invisibler();
                Filiale.setVisible(true);
            }
        });

        zurückButtonSchüpercard.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                invisibler();
                Dashboardpanel.setVisible(true);
            }
        });

        Zurück.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                invisibler();
                Dashboardpanel.setVisible(true);
            }
        });

        buttonZurückTablet.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                invisibler();
                Tablet.setVisible(true);
                TabletÜbersicht.setVisible(true);
            }
        });

        schüpercardErstellenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SchüpercardNummer.removeAll();
                getSelectedUser().addSchüppercard();

                JLabel labelNew = new JLabel("Ihre Schüpercardnummer: " + getSelectedUser().getCard().getCardnumber());
                labelNew.setFont(new Font("Serif", Font.PLAIN, 26));
                labelNew.setHorizontalAlignment(SwingConstants.CENTER);

                SchüpercardNummer.repaint();
                SchüpercardNummer.revalidate();

                invisibler();
                SchüpercardNummer.add(labelNew);
                SchüperkarteErstellt.setVisible(true);
                showSpecialButtons();
            }
        });

        zurückButtonSchüpperkarteErstellt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                invisibler();
                Dashboardpanel.setVisible(true);
            }
        });

        kündenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getSelectedUser().setRank(Rank.UNEMPLOYED);
                for (String key : SystemHandler.getSupermarketChainMap().keySet()) {
                    for (String key2 : SystemHandler.getSupermarketChainMap().get(key).getShopMap().keySet()) {
                        for (String key3 : SystemHandler.getSupermarketChainMap().get(key).getShopMap().get(key2).getEmployeeList().keySet()) {
                            if (getSelectedUser().getName().equals(SystemHandler.getSupermarketChainMap().get(key).getShopMap().get(key2).getEmployeeList().get(key3))) {
                                SystemHandler.getSupermarketChainMap().get(key).getShopMap().get(key2).getEmployeeList().remove(key3);
                            }
                        }
                    }
                }
            }
        });
        regalHinzufügenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                invisibler();
                RegalHinzufügen.setVisible(true);
            }
        });

        produktHinzufügenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                comboBoxProduktart.removeAllItems();
                invisibler();
                fillDropdownWithArticlesByType(comboBoxProduktart);

                System.out.println(getSelectedUser().getCurrentShopWork().getShelfList().size());
                SpinnerModel sm = new SpinnerNumberModel(1, 1, getSelectedUser().getCurrentShopWork().getShelfList().size(), 1);
                spinnerRegal = new JSpinner(sm);
                spinnerRegal.setFont(new Font("Serif", Font.PLAIN, 22));
                Dimension dimension = new Dimension(800, 35);
                SpinnerPanelProdukte.removeAll();
                spinnerRegal.setPreferredSize(dimension);
                SpinnerPanelProdukte.add(spinnerRegal);
                ProduktHinzufügen.setVisible(true);
                ProduktHinzufügen.repaint();
                ProduktHinzufügen.revalidate();
            }
        });

        eingebenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (comboBoxProduktart.getSelectedItem().equals("Food")) {
                    Arrays.asList(Fleischsorten.values())
                            .forEach(fleisch -> comboBoxFleisch.addItem(fleisch));
                    invisibler();
                    FoodPanel.setVisible(true);

                } else if (comboBoxProduktart.getSelectedItem().equals("BuildingMaterial")) {
                    Arrays.asList(Material.values())
                            .forEach(material -> comboBoxMaterial.addItem(material));
                    invisibler();
                    BuildingMatPanel.setVisible(true);
                } else {
                    System.out.println("Siuuur");
                }
            }
        });

        ChiefMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                invisibler();
                ChiefPanel.setVisible(true);
                ChiefMenuActionPanel.setVisible(false);
                ChiefSalaryField.setVisible(false);
                ChiefHireSalaryLabel.setVisible(false);
            }
        });

        GetAllEmployeesOfShop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ChiefOutput.setVisible(true);
                ChiefMenuActionPanel.setVisible(false);
                ChiefOutput.setText("<html>");
                for (SupermarketChain supermarket : getSupermarketChainMap().values()) {
                    for (Pair<Person, Shop> pair : supermarket.getChiefMap().values()) {
                        if (pair.getValue0() == getSelectedUser()) {
                            for (String p : pair.getValue1().getPresentEmployees().keySet()) {
                                ChiefOutput.setText(ChiefOutput.getText() + p + "<br/>");
                            }
                        }
                    }
                }
                ChiefOutput.setText(ChiefOutput.getText() + "</html>");

            }
        });

        employeeMenuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                invisibler();
                Mitarbeiter.setVisible(true);
            }
        });

        zurückButtonHinzufügen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                invisibler();
                Mitarbeiter.setVisible(true);
            }
        });
        zurückButtonFleisch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                invisibler();
                ProduktHinzufügen.setVisible(true);
            }
        });

        produktErstellenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (produktnameTextField.getText().equals("") || PreisTextField.getText().equals("")
                        || trueFalseTextField.getText().equals("") || DatumTextField.getText().equals("") ||
                        comboBoxFleisch.getSelectedItem() == null) {
                    labelFalschFleisch.setVisible(true);
                } else {
                    try {
                        String produktname = produktnameTextField.getText();
                        float preis = Float.parseFloat(PreisTextField.getText());
                        boolean barcode = Boolean.parseBoolean(trueFalseTextField.getText());
                        Fleischsorten fleisch = Fleischsorten.valueOf(comboBoxFleisch.getSelectedItem().toString());
                        String date = DatumTextField.getText();
                        SupermarketHandler.createFood(produktname, preis, (Integer) spinnerMengeFleisch.getValue(), barcode, date,
                                getSelectedUser().getCurrentShopWork().getName(), getSelectedUser().getCurrentCompanyWork().getName(), (Integer) spinnerRegal.getValue(), fleisch);
                        invisibler();
                        ProduktErstellt.setVisible(true);
                    } catch (Exception a) {
                        labelUnkorrektFleisch.setVisible(true);
                    }
                }
            }
        });

        HireEmployee.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ChiefOutput.setVisible(false);
                ChiefHireSalaryLabel.setVisible(true);
                ChiefMenuActionPanel.setVisible(true);
                ChiefMenuComboBox.removeAllItems();
                ChiefSalaryField.setVisible(true);
                NumberFormat format = NumberFormat.getIntegerInstance();
                NumberFormatter formatter = new NumberFormatter(format);
                formatter.setValueClass(Integer.class);
                formatter.setMinimum(0);
                formatter.setMaximum(Integer.MAX_VALUE);
                formatter.setAllowsInvalid(false);
                DefaultFormatterFactory factory = new DefaultFormatterFactory(formatter);
                ChiefSalaryField.setFormatterFactory(factory);

                ChiefMenuActionPanelLabel.setText("Bitte wähle eine Person um sie einzustellen");
                getPersonList().values().stream().filter(p -> p.getRank() == Rank.UNEMPLOYED).forEach(p -> ChiefMenuComboBox.addItem(p.getName()));
            }
        });

        ChiefMenuEnter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Company company = null;
                Shop shop = null;
                for (SupermarketChain supermarket : getSupermarketChainMap().values()) {
                    for (Pair<Person, Shop> pair : supermarket.getChiefMap().values()) {
                        if (pair.getValue0() == getSelectedUser()) {
                            shop = pair.getValue1();
                            company = shop.getSupermarketChain();
                        }
                    }
                }

                if (ChiefMenuActionPanelLabel.getText().equals("Bitte wähle eine Person um sie einzustellen") && ChiefMenuComboBox.getItemCount() > 0) {
                    System.out.println(ChiefSalaryField.getHorizontalVisibility().getValue());
                    hireEmployee((String) ChiefMenuComboBox.getSelectedItem(), company.getName(), shop.getName(), (Integer) ChiefSalaryField.getValue());
                    ChiefMenuActionPanel.setVisible(false);
                    ChiefSalaryField.setVisible(false);
                    ChiefHireSalaryLabel.setVisible(false);
                    ChiefMenuComboBox.removeAllItems();
                } else if (ChiefMenuActionPanelLabel.getText().equals("Bitte wähle eine Person um ihr zu kündigen") && ChiefMenuComboBox.getItemCount() > 0) {
                    fireEmployee((String) ChiefMenuComboBox.getSelectedItem(), shop);
                    ChiefMenuActionPanel.setVisible(false);
                    ChiefMenuComboBox.removeAllItems();
                } else if (ChiefMenuActionPanelLabel.getText().equals("Bitte wähle eine Person um sie zum Chef zu befördern") && ChiefMenuComboBox.getItemCount() > 0) {
                    getSelectedUser().getCurrentShopWork().promoteEmployee((String) ChiefMenuComboBox.getSelectedItem());

                    ChiefOutput.setVisible(false);
                    ChiefMenuActionPanel.setVisible(false);
                    ChiefMenuComboBox.removeAllItems();
                    invisibler();
                    Dashboardpanel.setVisible(true);
                    showSpecialButtons();
                }
            }
        });

        mitarbeiterKündigenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ChiefOutput.setVisible(false);
                ChiefMenuActionPanel.setVisible(true);
                ChiefMenuComboBox.removeAllItems();
                ChiefMenuActionPanelLabel.setText("Bitte wähle eine Person um ihr zu kündigen");
                Company company = null;
                Shop shop = null;
                for (SupermarketChain supermarket : getSupermarketChainMap().values()) {
                    for (Pair<Person, Shop> pair : supermarket.getChiefMap().values()) {
                        if (pair.getValue0() == getSelectedUser()) {
                            shop = pair.getValue1();
                            company = shop.getSupermarketChain();
                        }
                    }
                }
                shop.getEmployeeList().values().forEach(person -> ChiefMenuComboBox.addItem(person.getName()));
            }
        });

        zurückButtonMaterial.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                invisibler();
                ProduktHinzufügen.setVisible(true);
            }
        });

        zurückZumMenuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ChiefOutput.setVisible(false);
                ChiefMenuActionPanel.setVisible(false);
                ChiefMenuComboBox.removeAllItems();
                invisibler();
                Dashboardpanel.setVisible(true);
            }
        });

        ChiefMenuALLEmployees.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ChiefOutput.setVisible(true);
                ChiefMenuActionPanel.setVisible(false);
                ChiefOutput.setText("<html>");
                getSelectedUser().getCurrentShopWork().getEmployeeList().values().forEach(person -> ChiefOutput.setText(ChiefOutput.getText() + person.getName() + "<br/>"));
                ChiefOutput.setText(ChiefOutput.getText() + "</html>");
            }
        });

        zurückZumMenüButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                invisibler();
                Mitarbeiter.setVisible(true);
            }
        });

        produktErstellenBuildingMat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (produktnamenBuild.getText().equals("") || PreisFeld.getText().equals("") || (Integer) spinnerMengeMat.getValue() == 0
                        || trueFalseTextBuild.getText().equals("") || (Integer) spinnerTonnen.getValue() == 0) {
                    labelInkorrektBuild.setVisible(true);
                } else {
                    try {
                        String produktname = produktnamenBuild.getText();
                        float preis = Float.parseFloat(PreisFeld.getText());
                        int menge = (Integer) spinnerMengeMat.getValue();
                        boolean barcode = Boolean.parseBoolean(trueFalseTextBuild.getText());
                        int tonnen = (Integer) spinnerTonnen.getValue();
                        String mat = comboBoxMaterial.getSelectedItem().toString();

                        SupermarketHandler.createBuildingMaterial(produktname, preis, menge, barcode, getSelectedUser().getCurrentShopWork().getName(), tonnen, mat,
                                getSelectedUser().getCurrentCompanyWork().getName(), (Integer) spinnerRegal.getValue());
                        invisibler();
                        ProduktErstellt.setVisible(true);
                    } catch (Exception a) {
                        labelFalschBuild.setVisible(true);
                    }
                }
            }
        });

        promoteEmployeeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ChiefOutput.setVisible(false);
                ChiefMenuActionPanel.setVisible(true);
                ChiefMenuComboBox.removeAllItems();
                ChiefMenuActionPanelLabel.setText("Bitte wähle eine Person um sie zum Chef zu befördern");
                getSelectedUser().getCurrentShopWork().getEmployeeList().values().forEach(person -> ChiefMenuComboBox.addItem(person.getName()));

            }
        });
        kündenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fireEmployee(getSelectedUser().getName(), getSelectedUser().getCurrentShopWork());
                invisibler();
                showSpecialButtons();
                Dashboardpanel.setVisible(true);
            }
        });
        arbeitVerlassenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                invisibler();
               Dashboardpanel.setVisible(true);
            }
        });
        gewählteAnzahlHinzufügenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (String key : SystemHandler.getSupermarketChainMap().keySet()) {
                    for (String key2 : SystemHandler.getSupermarketChainMap().get(key).getShopMap().keySet()) {
                        for (String key3 : SystemHandler.getSupermarketChainMap().get(key).getShopMap().get(key2).getEmployeeList().keySet()) {
                            if (SystemHandler.getSupermarketChainMap().get(key).getShopMap().get(key2).getEmployeeList().get(key3).getName().equals(getSelectedUser().getName())) {
                                for (int i = 0; i < (Integer) spinnerAnzRegale.getValue(); i++) {
                                    SystemHandler.getSupermarketChainMap().get(key).getShopMap().get(key2).createShelf();
                                    System.out.println("Regal erstellt");
                                }
                            }
                        }
                    }
                }
                invisibler();
                RegaleErstellt.setVisible(true);
            }
        });
        zurückZumMenüButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                invisibler();
                Mitarbeiter.setVisible(true);
            }
        });
        normaleKasseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                invisibler();
                Kassen.setVisible(true);
            }
        });
        selfscannerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                invisibler();
                for (String key2 : getSelectedUser().getCart().getArticleList().keySet()) {
                    float price = getSelectedUser().getCart().getArticleList().get(key2).getValue0().getPrice() * getSelectedUser().getCart().getArticleList().get(key2).getValue1();
                    JLabel labeNew = new JLabel(getSelectedUser().getCart().getArticleList().get(key2).getValue0().getName() + "(" + getSelectedUser().getCart().getArticleList().get(key2).getValue1() + "x) "
                            + price + ", ");

                   String value = getSelectedUser().getCart().getArticleList().get(key2).getValue0().getName() + "(" + getSelectedUser().getCart().getArticleList().get(key2).getValue1() + "x) "
                           + price + ", ";
                    ProdukteWarenkorbComb.addItem(value);
                }
                Selfscanner.setVisible(true);
            }
        });
        scanButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(ProdukteWarenkorbComb.getSelectedItem() == null) {
                    ErrorMessageScan.setVisible(true);
                    model.clear();
                } else {
                    produkteGescanntList.removeAll();
                    model.addElement(ProdukteWarenkorbComb.getSelectedItem().toString());
                    JList listNew = new JList(model);
                    listNew.setFont(new Font("Serif", Font.PLAIN, 24));
                    produkteGescanntList.add(listNew);

                    PreisGesamt.removeAll();
                    greatPrice += getSelectedUser().getCart().getArticleList().get(ProdukteWarenkorbComb.getSelectedItem().toString().substring(0,
                            ProdukteWarenkorbComb.getSelectedItem().toString().indexOf("("))).getValue0().getPrice() * getSelectedUser().getCart().getArticleList().get(ProdukteWarenkorbComb.getSelectedItem().toString().substring(0,
                            ProdukteWarenkorbComb.getSelectedItem().toString().indexOf("("))).getValue1();

                    ProdukteWarenkorbComb.removeItem(ProdukteWarenkorbComb.getSelectedItem());
                    JLabel labelNew = new JLabel("Kosten Betragen: " + greatPrice);
                    labelNew.setFont(new Font("Serif", Font.PLAIN, 20));
                    labelNew.setVerticalAlignment(SwingConstants.CENTER);
                    PreisGesamt.add(labelNew);
                    ProdukteWarenkorbComb.repaint();
                    ProdukteWarenkorbComb.revalidate();
                }
            }
        });
        bezahlenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                produkteGescanntList.removeAll();
                ProdukteWarenkorbComb.removeAllItems();
                model.clear();
                getSelectedUser().getCart().getArticleList().clear();
                invisibler();
                EinkaufAbschluss.setVisible(true);
            }
        });

        auswählenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(aldiRadioButton.isSelected()) {
                    setCurrentCompany("aldi");
                }else if(migrosRadioButton.isSelected()) {
                    setCurrentCompany("migros");
                }else if(coopRadioButton.isSelected()) {
                    setCurrentCompany("coop");
                }
                if(getCurrentCompany() == null) {
                    labelFalschRadio.setVisible(true);
                }else {
                    invisibler();
                    Filiale.setVisible(true);
                    fillDropdownWithShops(getCurrentCompany(), comboBox1);
                    labelFalschRadio.setVisible(false);
                }
            }
        });
        zurückButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                invisibler();
                Mitarbeiter.setVisible(true);
            }
        });
    }

    public void fillDropdownWithShops(String supermarketname, JComboBox comboBox) {
        comboBox.removeAllItems();
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
        ArtikelPanel.removeAll();
        ArtikelPanel.repaint();
        ArtikelPanel.revalidate();
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
                SpinnerModel sm = new SpinnerNumberModel(0, 0, (int) key2Pair.getValue1(), 1); //default value,lower bound,upper bound,increment by

                JSpinner spinnerNeu = new JSpinner();
                Component mySpinnerEditor = spinnerNeu.getEditor();
                JFormattedTextField jftf = ((JSpinner.DefaultEditor) mySpinnerEditor).getTextField();
                jftf.setColumns(3);
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
            float price = getSelectedUser().getCart().getArticleList().get(key2).getValue0().getPrice() * getSelectedUser().getCart().getArticleList().get(key2).getValue1();
            JPanel panelNew = new JPanel();
            JLabel labeNew = new JLabel(getSelectedUser().getCart().getArticleList().get(key2).getValue0().getName() + "(" + getSelectedUser().getCart().getArticleList().get(key2).getValue1() + "x) "
                    + price);

            labeNew.setFont(new Font("Serif", Font.PLAIN, 20));
            labeNew.setVerticalAlignment(SwingConstants.CENTER);
            panelNew.add(labeNew);
            Cart.add(panelNew);
        }
    }

    public void showPriceSelfScanner() {
        for (String key2 : getSelectedUser().getCart().getArticleList().keySet()) {
            float price = getSelectedUser().getCart().getArticleList().get(key2).getValue0().getPrice() * getSelectedUser().getCart().getArticleList().get(key2).getValue1();
            JPanel panelNew = new JPanel();
            JLabel labeNew = new JLabel(getSelectedUser().getCart().getArticleList().get(key2).getValue0().getName() + "(" + getSelectedUser().getCart().getArticleList().get(key2).getValue1() + "x) "
                    + price);

            labeNew.setFont(new Font("Serif", Font.PLAIN, 20));
            labeNew.setVerticalAlignment(SwingConstants.CENTER);
            panelNew.add(labeNew);
            PreisGesamt.add(panelNew);
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

    public void fillDropdownWithArticlesFromSupermarketFromShop(String supermarketname, String shopName, JComboBox comboBox) {
        SupermarketChain supermarketChain = SystemHandler.getSupermarketChainMap().get(supermarketname);
        System.out.println(supermarketname + " " + shopName);
        for (Shelf shelf : supermarketChain.getShopMap().get(shopName).getShelfList().values()) {
            for (Pair<Article, Integer> articlePair : shelf.getArticleList().values()) {
                comboBox.addItem(articlePair.getValue0().getName());
            }
        }
    }

    /* org.reflections:reflections:0.10.1*/
    public void fillDropdownWithArticlesByType(JComboBox comboBox) {
        try {
            Reflections reflections = new Reflections("SupermarketPackage.Articles");
            Set<Class<? extends Article>> classes = reflections.getSubTypesOf(Article.class);
            for (Class<? extends Article> subClass : classes) {
                comboBox.addItem(subClass.getSimpleName());
                System.out.println(subClass.getSimpleName());
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void fillDropdownWithAllArticles(JComboBox comboBox) {
        for (SupermarketChain supermarket : SystemHandler.getSupermarketChainMap().values()) {
            for (Shop shop : supermarket.getShopMap().values()) {
                for (Shelf shelf : shop.getShelfList().values()) {
                    for (Pair<Article, Integer> pair : shelf.getArticleList().values()) {
                        if (((DefaultComboBoxModel) comboBox.getModel()).getIndexOf(pair.getValue0().getName()) == -1) {
                            comboBox.addItem(pair.getValue0().getName());
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        SupermarketHandler.setUp();
        frame.setResizable(true);
        frame.setContentPane((new GUI()).panelMain);
        frame.setDefaultCloseOperation(3);
        frame.pack();
        frame.setSize(1000, 600);
        frame.setLocationRelativeTo((Component) null);
        frame.setVisible(true);
        DigitalClock.main();

        Container glassPane = (Container) frame.getGlassPane();
        DigitalClock.SimpleDigitalClock simpleDigitalClock = new DigitalClock.SimpleDigitalClock();

        glassPane.add(simpleDigitalClock);
        glassPane.setVisible(false);


    }

    public void setDashboardInformation() {
        name.setText("Name: " + getSelectedUser().getName());
        guthaben.setText("Guthaben: " + getSelectedUser().getMoney());

        if (getSelectedUser().getCard() != null) {
            schüpperpunkte.setText("<html>Ihre Schüperkarteennummer ist: " + getSelectedUser().getCard().getCardnumber() + " <br/><br/> Schüpperpunkte: " + getSelectedUser().getCard().getPoints() + "</html>");
        } else {
            schüpperpunkte.setText("Keine Schüperkarte verfügbar");
        }

    }

    public void invisibler() {
        Dashboardpanel.setVisible(false);
        Filialebetreten.setVisible(false);
        Loginpanel.setVisible(false);
        Filiale.setVisible(false);
        Tablet.setVisible(false);
        TabletÜbersicht.setVisible(false);
        TabletSelect.setVisible(false);
        Warenkorb.setVisible(false);
        Kassen.setVisible(false);
        EinkaufAbschluss.setVisible(false);
        Schüpercard.setVisible(false);
        ChiefPanel.setVisible(false);
        SchüperkarteErstellt.setVisible(false);
        Mitarbeiter.setVisible(false);
        ProduktHinzufügen.setVisible(false);
        FoodPanel.setVisible(false);
        BuildingMatPanel.setVisible(false);
        ChiefMenu.setVisible(false);
        ProduktErstellt.setVisible(false);
        employeeMenuButton.setVisible(false);

        RegalHinzufügen.setVisible(false);
        RegaleErstellt.setVisible(false);

        Selfscanner.setVisible(false);

        Entscheidung.setVisible(false);
        if(getSelectedUser() !=null){
            setDashboardInformation();
            showSpecialButtons();
        }

    }

    public void showSpecialButtons() {
        if (getSelectedUser().getRank() == Rank.CHIEF) {
            ChiefMenu.setVisible(true);
        }
        if (getSelectedUser().getRank() == Rank.EMPLOYEE) {
            employeeMenuButton.setVisible(true);
        }
        if (getSelectedUser().getCard() != null) {
            schüpercardButton.setVisible(false);
        }
    }
}
