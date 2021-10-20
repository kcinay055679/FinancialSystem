
import GameHandlerPackage.*;
import SupermarketPackage.*;


import SupermarketPackage.Articles.Article;

import static GameHandlerPackage.SystemHandler.*;


import SupermarketPackage.Articles.Material;
import org.javatuples.Pair;
import org.javatuples.Triplet;
import org.reflections.Reflections;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.List;
import javax.swing.*;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.InternationalFormatter;
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
    private JPanel keineGeldNoch;

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
    private JButton bezahlButtonKasse;
    private JButton TabletMenuTyp;

    private JButton arbeitenGehenButton;
    private JButton kündenButton;
    private JButton regalHinzufügenButton;
    private JButton produktHinzufügenButton;
    private JButton eingebenButton;
    private JButton erstellungAbschliessenButton;

    //ButtonGroups
    ButtonGroup g = new ButtonGroup();


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
    private JButton GetPresentEmployees;
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
    private JButton bezahlenButtonScan;
    private JPanel produkteGescanntList;
    private JButton auswählenButton;
    private JLabel labelFalschRadio;
    private JButton zurückButton2;
    private JButton schüpercardMitPunktenAufladenButton;
    private JTextField textFieldSchüpercard;
    private JLabel labelFalschSchüp;
    private JLabel labelRichtigSchüp;
    private JButton convertSchüpperpointsButton;
    private JPanel SpinnerPanelRegal;
    private JPanel Admin;
    private JButton personHinzufügenButton;
    private JButton shopErstellenButton;
    private JButton supermarktketteErstellenButton;
    private JPanel PersonenHInzufügen;
    private JTextField textFieldBenutzernamen;
    private JTextField textFieldPasswort;
    private JTextField textFieldPasswortRep;
    private JButton benutzerHinzufügenButton;
    private JPanel ShopHinzufügen;
    private JTextField textFieldShopname;
    private JTextField textFieldChief;
    private JTextField selfCheckout;
    private JTextField textFieldPlace;
    private JTextField textFieldEarnings;
    private JButton shopErstellenButton1;
    private JButton zurückButton3;
    private JPanel SupermarktketteHinzufügen;
    private JTextField textFieldSupermarktkettenName;
    private JButton ketteErstellenButton;
    private JButton zurückButton4;
    private JLabel benutzerLabelRichtig;
    private JLabel benutzerLabelFalsch;
    private JButton testTest;
    private JComboBox comboBoxFirmaAdmin;
    private JLabel labelRichtigShop;
    private JLabel labelFalschShop;
    private JButton changePassword;
    private JPanel changePasswordPanel;
    private JButton backToDashboardPw;
    private JLabel passwordOutput;
    private JButton changePasswordSubmit;
    private JButton changePasswordButton;
    private JTextField oldPassword;
    private JTextField newPassword;
    private JTextField repeatPassword;
    private JButton resetButton;
    private JLabel labelKetteRichtig;
    private JLabel labelKetteFalsch;
    private JButton ausloggenButtonAdmin;
    private JPanel PanelRadios;
    private JComboBox comboBoxBarcode;
    private JComboBox comboBoxBarcodeFleisch;
    private JComboBox comboBoxSelfCheckout;
    private JFormattedTextField formattedTextFieldPreisFleisch;
    private JFormattedTextField formattedTextFieldPreisMat;
    private JLabel lohn;
    private JLabel EinkommenLaden;
    private JLabel ShopChief;
    private JButton zurückButton5;
    private JComboBox comboBoxOhneBarcode;
    private JButton manuelHinzufügenButton;
    private JList gescannteProdukteList;

    //Hashmap für die Produkte in einem Laden
    HashMap<String, JSpinner> produkte = new HashMap<>();
    String currentTabletFuntion;
    float greatPrice = 0;

    //Hashmap um Spinner Komponente zu speichern
    HashMap<String, JSpinner> spinnerHashMap = new HashMap<>();

    private int greatValue;
    private final DefaultListModel model = new DefaultListModel();

    public static JFrame frame = new JFrame("Yanick und Marcs Wirtschaftsspass");
    LocalDateTime startWorkTime;

    //Konstruktor indem alle Funktionen verwaltet werden
    public GUI() {

        labelKetteFalsch.setVisible(false);
        labelKetteRichtig.setVisible(false);
        labelFalschShop.setVisible(false);
        labelRichtigShop.setVisible(false);
        benutzerLabelRichtig.setVisible(false);
        benutzerLabelFalsch.setVisible(false);
        labelRichtigSchüp.setVisible(false);
        labelFalschSchüp.setVisible(false);
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


        this.bestätigenButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (SystemHandler.adminCheck(nameLogin.getText(), new String(passwortLogin.getPassword()))) {
                    if (SystemHandler.login(nameLogin.getText(), new String(GUI.this.passwortLogin.getPassword()))) {
                        invisibler();
                        labelFalsch.setVisible(false);
                        Admin.setVisible(true);
                    }
                } else {
                    if (SystemHandler.login(nameLogin.getText(), new String(passwortLogin.getPassword()))) {
                        invisibler();
                        labelFalsch.setVisible(false);
                        Dashboardpanel.setVisible(true);
                        setDashboardInformation();
                        showSpecialButtons();
                    } else {
                        labelFalsch.setVisible(true);
                    }
                }
            }
        });

        //Key listener wenn das Passwort angegeben wurde und Enter gedrückt wird
        passwortLogin.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    if (SystemHandler.adminCheck(nameLogin.getText(), new String(passwortLogin.getPassword()))) {
                        if (SystemHandler.login(nameLogin.getText(), new String(GUI.this.passwortLogin.getPassword()))) {
                            invisibler();
                            Admin.setVisible(true);
                            labelFalsch.setVisible(false);
                        }
                    } else {
                        if (SystemHandler.login(nameLogin.getText(), new String(passwortLogin.getPassword()))) {
                            invisibler();
                            labelFalsch.setVisible(false);
                            Dashboardpanel.setVisible(true);
                            setDashboardInformation();
                            showSpecialButtons();
                        } else {
                            labelFalsch.setVisible(true);
                        }
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
                    if (SystemHandler.adminCheck(nameLogin.getText(), new String(passwortLogin.getPassword()))) {
                        if (SystemHandler.login(nameLogin.getText(), new String(GUI.this.passwortLogin.getPassword()))) {
                            invisibler();
                            Admin.setVisible(true);
                            labelFalsch.setVisible(false);
                        }
                    } else {
                        if (SystemHandler.login(nameLogin.getText(), new String(passwortLogin.getPassword()))) {
                            invisibler();
                            labelFalsch.setVisible(false);
                            Dashboardpanel.setVisible(true);
                            setDashboardInformation();
                            showSpecialButtons();
                        } else {
                            labelFalsch.setVisible(true);
                        }
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
                if (getSelectedUser().getMoney() > 0) {
                    invisibler();
                    PanelRadios.removeAll();
                    for (String key : SystemHandler.getSupermarketChainMap().keySet()) {
                        JRadioButton radioButtonNew = new JRadioButton(key);
                        radioButtonNew.setFont(new Font("Serif", Font.PLAIN, 26));
                        g.add(radioButtonNew);
                        PanelRadios.add(radioButtonNew);
                    }
                    Filialebetreten.setVisible(true);
                } else {
                    invisibler();
                    keineGeldNoch.setVisible(true);
                }
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

        bezahlButtonKasse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                invisibler();
                getSelectedUser().getCart().getArticleList().clear();
                EinkaufAbschluss.setVisible(true);
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getSelectedUser().getCart().getArticleList().clear();
                Cart.removeAll();
                getSelectedUser().decreaseMoney(greatValue);
                getSupermarketChainMap().get(getCurrentCompany()).getShopMap().get(getCurrentShop()).increaseEarnings(greatValue);
                System.out.println(getSupermarketChainMap().get(getCurrentCompany()).getShopMap().get(getCurrentShop()).getEarnings());
                invisibler();
                greatValue = 0;
                labelRichtigSchüp.setVisible(false);
                labelFalschSchüp.setVisible(false);
                schüpercardMitPunktenAufladenButton.setVisible(true);
                Dashboardpanel.setVisible(true);
            }
        });


        //Tablet start
        TabletMenuSupermarkt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentTabletFuntion = "supermarket";
                fillDropdownWithSupermarkets(TabletSupermarktWählen);

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

            }
        });

        TabletMenuTyp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentTabletFuntion = "typ";
                fillDropdownWithArticlesByType(TabletTypWählen);
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


            }
        });

        TabletMenuFiliale.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentTabletFuntion = "shop";
                fillDropdownWithSupermarkets(TabletSupermarktWählen);
                fillDropdownWithShops((String) TabletSupermarktWählen.getSelectedItem(), TabletFilialeWählen);
                fillDropdownWithArticlesFromSupermarketFromShop((String) TabletSupermarktWählen.getSelectedItem(), (String) TabletFilialeWählen.getSelectedItem(), TabletArtikelWählen);

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


            }
        });

        TabletMenuName.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentTabletFuntion = "name";
                fillDropdownWithAllArticles(TabletArtikelWählen);
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


            }
        });

        TabletSupermarktWählen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (TabletSupermarktWählen.getItemCount() > 0) {
                    String supermarket = (String) TabletSupermarktWählen.getSelectedItem();

                    fillDropdownWithArticlesFromSupermarket(supermarket, TabletArtikelWählen);
                }
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

        TabletFilialeWählen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String supermarket = (String) TabletSupermarktWählen.getSelectedItem();
                String shopName = (String) TabletFilialeWählen.getSelectedItem();
                TabletArtikelWählen.removeAllItems();

                if (currentTabletFuntion.equals("shop") && shopName != null) {
                    fillDropdownWithArticlesFromSupermarketFromShop(supermarket, shopName, TabletArtikelWählen);
                }
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

        //Tablet ende

        schüpercardButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(getSelectedUser().getCard() == null){
                    convertSchüpperpointsButton.setVisible(false);
                }else{
                    convertSchüpperpointsButton.setVisible(true);
                }

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
                Shop shop = getSupermarketChainMap().get(getSupermarketChainMap().get(getSelectedUser().getCurrentCompanyWork().getName()).getName()).getShopMap().get(getSelectedUser().getCurrentShopWork().getName());

                for (Pair<Article, Integer> v : getSelectedUser().getCart().getArticleList().values()) {
                    int shelfId = shop.getArticlePositionList().get(v.getValue0().getName());
                    boolean barcode = v.getValue0().isBarcode();
                    String articleType = v.getValue0().getArticleType();
                    if(articleType.equals("Food")){
                        shop.getSupermarketChain().getShopMap().get(shop.getName()).getShelfById(shelfId).increaseArticleAmountFood(v.getValue0().getName(), v.getValue1());
                    }else if (articleType.equals("BuildingMaterial")){
                        shop.getSupermarketChain().getShopMap().get(shop.getName()).getShelfById(shelfId).increaseArticleAmountBuildingMaterial(v.getValue0().getName(), v.getValue1());
                    }
                }

                getSelectedUser().getCart().setFullPrice(0);
                getSelectedUser().getCart().getArticleList().clear();

                invisibler();
                Cart.removeAll();
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
                ArtikelFindenOutput.setText("");
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
                schüpercardErstellenButton.setVisible(false);
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

        arbeitenGehenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                invisibler();
                Mitarbeiter.setVisible(true);
                startWorkTime = DigitalClock.SimpleDigitalClock.realTime;
            }
        });

        regalHinzufügenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                invisibler();
                SpinnerModel sm = new SpinnerNumberModel(1, 1, Integer.MAX_VALUE, 1);
                spinnerAnzRegale = new JSpinner(sm);
                Component mySpinnerEditor = spinnerAnzRegale.getEditor();
                JFormattedTextField jftf = ((JSpinner.DefaultEditor) mySpinnerEditor).getTextField();
                jftf.setColumns(25);
                spinnerAnzRegale.setFont(new Font("Serif", Font.PLAIN, 22));
                SpinnerPanelRegal.add(spinnerAnzRegale);
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
                SpinnerModel sm = new SpinnerNumberModel(1, 1, getSupermarketChainMap().get(getSupermarketChainMap().get(getSelectedUser().getCurrentCompanyWork().getName()).getName()).getShopMap().get(getSelectedUser().getCurrentShopWork().getName()).getShelfList().size(), 1);
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
                fillDropdownsTrueFalsePro();
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
                //Preisfelder formatieren
                NumberFormat format = DecimalFormat.getInstance();
                format.setMinimumFractionDigits(2);
                format.setMaximumFractionDigits(2);
                format.setRoundingMode(RoundingMode.HALF_UP);
                InternationalFormatter formatter = new InternationalFormatter(format);
                formatter.setAllowsInvalid(false);
                formatter.setMinimum(0.0);
                formatter.setMaximum(1000.00);
                DefaultFormatterFactory factory = new DefaultFormatterFactory(formatter);
                formattedTextFieldPreisFleisch.setFormatterFactory(factory);
                formattedTextFieldPreisMat.setFormatterFactory(factory);

                //Spinnermodel mit spinnern
                SpinnerModel sm = new SpinnerNumberModel(1, 1, Integer.MAX_VALUE, 1);
                spinnerMengeFleisch.setModel(sm);
                spinnerMengeMat.setModel(sm);
                spinnerTonnen.setModel(sm);

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

        GetPresentEmployees.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ChiefOutput.setVisible(true);
                ChiefMenuActionPanel.setVisible(false);
                ChiefOutput.setText("<html>");
                Shop shop = getSupermarketChainMap().get(getSupermarketChainMap().get(getSelectedUser().getCurrentCompanyWork().getName()).getName()).getShopMap().get(getSelectedUser().getCurrentShopWork().getName());
                ChiefHireSalaryLabel.setVisible(false);
                ChiefSalaryField.setVisible(false);

                for (String p : shop.getPresentEmployees().keySet()) {
                    ChiefOutput.setText(ChiefOutput.getText() + p + "<br/>");
                }

                ChiefOutput.setText(ChiefOutput.getText() + "</html>");
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
                clearDropdownsTrueFalsePro();
                invisibler();
                ProduktHinzufügen.setVisible(true);
            }
        });

        produktErstellenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (produktnameTextField.getText().equals("") || formattedTextFieldPreisFleisch.getText().equals("")
                        || comboBoxBarcodeFleisch.getSelectedItem().equals("") || DatumTextField.getText().equals("") ||
                        comboBoxFleisch.getSelectedItem() == null) {
                    labelFalschFleisch.setVisible(true);
                } else {
                    try {
                        String produktname = produktnameTextField.getText();
                        float preis = Float.parseFloat(formattedTextFieldPreisFleisch.getText());
                        boolean barcode = Boolean.parseBoolean(comboBoxBarcodeFleisch.getSelectedItem().toString());
                        Fleischsorten fleisch = Fleischsorten.valueOf(comboBoxFleisch.getSelectedItem().toString());
                        String date = DatumTextField.getText();
                        SupermarketHandler.createFood(produktname, preis, (Integer) spinnerMengeFleisch.getValue(), barcode, date,
                                getSelectedUser().getCurrentShopWork().getName(), getSupermarketChainMap().get(getSelectedUser().getCurrentCompanyWork().getName()).getName(), (Integer) spinnerRegal.getValue(), fleisch);
                        invisibler();
                        ProduktErstellt.setVisible(true);
                        clearDropdownsTrueFalsePro();
                        labelFalschFleisch.setVisible(false);
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

                ChiefMenuActionPanelLabel.setText("Bitte wähle eine Person, um sie einzustellen");
                getPersonList().values().stream().filter(p -> p.getRank() == Rank.UNEMPLOYED).forEach(p -> ChiefMenuComboBox.addItem(p.getName()));
            }
        });

        ChiefMenuEnter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Shop shop = getSupermarketChainMap().get(getSupermarketChainMap().get(getSelectedUser().getCurrentCompanyWork().getName()).getName()).getShopMap().get(getSelectedUser().getCurrentShopWork().getName());
                SupermarketChain supermarket = shop.getSupermarketChain();

                if (ChiefMenuActionPanelLabel.getText().equals("Bitte wähle eine Person, um sie einzustellen") && ChiefMenuComboBox.getItemCount() > 0) {
                    hireEmployee((String) ChiefMenuComboBox.getSelectedItem(), supermarket.getName(), shop.getName(), (Integer) ChiefSalaryField.getValue());
                    ChiefMenuActionPanel.setVisible(false);
                    ChiefSalaryField.setVisible(false);
                    ChiefSalaryField.setText(" ");
                    ChiefHireSalaryLabel.setVisible(false);
                    ChiefMenuComboBox.removeAllItems();
                } else if (ChiefMenuActionPanelLabel.getText().equals("Bitte wähle eine Person, um ihr zu kündigen") && ChiefMenuComboBox.getItemCount() > 0) {
                    fireEmployee((String) ChiefMenuComboBox.getSelectedItem());
                    ChiefMenuActionPanel.setVisible(false);
                    ChiefMenuComboBox.removeAllItems();
                } else if (ChiefMenuActionPanelLabel.getText().equals("Bitte wähle eine Person, um sie zum Chef zu befördern") && ChiefMenuComboBox.getItemCount() > 0) {
                    getSupermarketChainMap().get(getSupermarketChainMap().get(getSelectedUser().getCurrentCompanyWork().getName()).getName()).getShopMap().get(getSelectedUser().getCurrentShopWork().getName()).promoteEmployee((String) ChiefMenuComboBox.getSelectedItem());

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
                ChiefSalaryField.setVisible(false);
                ChiefHireSalaryLabel.setVisible(false);
                ChiefOutput.setVisible(false);
                ChiefMenuActionPanel.setVisible(true);
                ChiefMenuComboBox.removeAllItems();
                ChiefMenuActionPanelLabel.setText("Bitte wähle eine Person, um ihr zu kündigen");

                Shop shop = getSupermarketChainMap().get(getSupermarketChainMap().get(getSelectedUser().getCurrentCompanyWork().getName()).getName()).getShopMap().get(getSelectedUser().getCurrentShopWork().getName());
                SupermarketChain supermarket = shop.getSupermarketChain();


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
                ChiefSalaryField.setVisible(false);
                ChiefHireSalaryLabel.setVisible(false);
                ChiefOutput.setVisible(true);
                ChiefMenuActionPanel.setVisible(false);
                ChiefOutput.setText("<html>");
                getSupermarketChainMap().get(getSupermarketChainMap().get(getSelectedUser().getCurrentCompanyWork().getName()).getName()).getShopMap().get(getSelectedUser().getCurrentShopWork().getName()).getEmployeeList().values().forEach(person -> ChiefOutput.setText(ChiefOutput.getText() + person.getName() + "<br/>"));
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
                if (produktnamenBuild.getText().equals("") || formattedTextFieldPreisMat.getText().equals("") || (Integer) spinnerMengeMat.getValue() == 0
                        || comboBoxBarcode.getSelectedItem().equals("") || (Integer) spinnerTonnen.getValue() == 0) {
                    labelInkorrektBuild.setVisible(true);
                } else {
                    try {
                        String produktname = produktnamenBuild.getText();
                        float preis = Float.parseFloat(formattedTextFieldPreisMat.getText());
                        int menge = (Integer) spinnerMengeMat.getValue();
                        boolean barcode = Boolean.parseBoolean(comboBoxBarcode.getSelectedItem().toString());
                        int tonnen = (Integer) spinnerTonnen.getValue();
                        String mat = Objects.requireNonNull(comboBoxMaterial.getSelectedItem()).toString();

                        SupermarketHandler.createBuildingMaterial(produktname, preis, menge, barcode, getSelectedUser().getCurrentShopWork().getName(), tonnen, mat,
                                getSupermarketChainMap().get(getSelectedUser().getCurrentCompanyWork().getName()).getName(), (Integer) spinnerRegal.getValue());

                        invisibler();
                        ProduktErstellt.setVisible(true);
                        clearDropdownsTrueFalsePro();
                        labelFalschBuild.setVisible(false);
                    } catch (Exception a) {
                        labelFalschBuild.setVisible(true);
                    }
                }
            }
        });

        promoteEmployeeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ChiefSalaryField.setVisible(false);
                ChiefHireSalaryLabel.setVisible(false);
                ChiefOutput.setVisible(false);
                ChiefMenuActionPanel.setVisible(true);
                ChiefMenuComboBox.removeAllItems();
                System.out.println(getSelectedUser().getCurrentShopWork() + " promote");
                ChiefMenuActionPanelLabel.setText("Bitte wähle eine Person, um sie zum Chef zu befördern");
                System.out.println(getSelectedUser());

                Shop shop = getSupermarketChainMap().get(getSupermarketChainMap().get(getSelectedUser().getCurrentCompanyWork().getName()).getName()).getShopMap().get(getSelectedUser().getCurrentShopWork().getName());
                SupermarketChain supermarket = getSupermarketChainMap().get(getSupermarketChainMap().get(getSupermarketChainMap().get(getSelectedUser().getCurrentCompanyWork().getName()).getName()).getName());
                shop.getEmployeeList().keySet().forEach(person -> ChiefMenuComboBox.addItem(person));
            }
        });

        kündenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fireEmployee(getSelectedUser().getName());
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
                long hours = ChronoUnit.HOURS.between(startWorkTime, DigitalClock.SimpleDigitalClock.realTime);
                int test = getSelectedUser().receiveSalary(hours);
                getSupermarketChainMap().get(getSupermarketChainMap().get(getSelectedUser().getCurrentCompanyWork().getName()).getName()).getShopMap().get(getSelectedUser().getCurrentShopWork().getName()).decreaseEarnings(test);
                setDashboardInformation();
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
                SpinnerPanelRegal.removeAll();
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
                    if (getSelectedUser().getCart().getArticleList().get(key2).getValue0().getBarcode()) {
                        comboBoxOhneBarcode.addItem(value);
                    } else {
                        ProdukteWarenkorbComb.addItem(value);
                    }
                }
                Selfscanner.setVisible(true);
            }
        });

        manuelHinzufügenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (comboBoxOhneBarcode.getSelectedItem() == null) {
                    ErrorMessageScan.setVisible(true);
                } else {
                    produkteGescanntList.removeAll();
                    model.addElement(comboBoxOhneBarcode.getSelectedItem().toString());
                    JList listNew = new JList(model);
                    listNew.setFont(new Font("Serif", Font.PLAIN, 24));
                    produkteGescanntList.add(listNew);
                    PreisGesamt.removeAll();
                    greatPrice += Float.parseFloat(comboBoxOhneBarcode.getSelectedItem().toString().substring(comboBoxOhneBarcode.getSelectedItem().toString().indexOf(" "), comboBoxOhneBarcode.getSelectedItem().toString().indexOf(",")));
                    comboBoxOhneBarcode.removeItem(comboBoxOhneBarcode.getSelectedItem());
                    JLabel labelNew = new JLabel("Kosten Betragen: " + greatPrice);
                    labelNew.setFont(new Font("Serif", Font.PLAIN, 20));
                    labelNew.setVerticalAlignment(SwingConstants.CENTER);
                    PreisGesamt.add(labelNew);
                    comboBoxOhneBarcode.repaint();
                    comboBoxOhneBarcode.revalidate();
                }
            }
        });

        scanButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (ProdukteWarenkorbComb.getSelectedItem() == null) {
                    ErrorMessageScan.setVisible(true);
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

        bezahlenButtonScan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.clear();
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
                for (Enumeration<AbstractButton> buttons = g.getElements(); buttons.hasMoreElements(); ) {
                    AbstractButton button = buttons.nextElement();

                    if (button.isSelected()) {
                        setCurrentCompany(button.getText());
                    }
                }
                if (getCurrentCompany() == null) {
                    labelFalschRadio.setVisible(true);
                } else {
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
                SpinnerPanelRegal.removeAll();
                invisibler();
                Mitarbeiter.setVisible(true);
            }
        });

        convertSchüpperpointsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getSelectedUser().convertSchüpperPoints();
                setDashboardInformation();
            }
        });

        schüpercardMitPunktenAufladenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (textFieldSchüpercard.getText().equals("")) {
                    labelFalschSchüp.setVisible(true);
                } else {
                    try {
                        if ((Integer.parseInt(textFieldSchüpercard.getText()) > 9999 || Integer.parseInt(textFieldSchüpercard.getText()) < 1000)) {
                            labelFalschSchüp.setVisible(true);
                        } else {
                            if (getSelectedUser().getCard().getCardnumber() == Integer.parseInt(textFieldSchüpercard.getText())) {
                                getSelectedUser().getCard().increasePoints(greatValue);
                                schüpercardMitPunktenAufladenButton.setVisible(false);
                                labelFalschSchüp.setVisible(false);
                                labelRichtigSchüp.setVisible(true);

                            } else {
                                labelFalschSchüp.setVisible(true);
                            }
                        }
                    } catch (Exception a) {
                        labelFalschSchüp.setVisible(true);
                    }
                }
            }
        });

        frame.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(WindowEvent winEvt) {
                safeToFile();
            }
        });

        changePasswordButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                invisibler();
                changePasswordPanel.setVisible(true);
            }
        });

        backToDashboardPw.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                invisibler();
                Dashboardpanel.setVisible(true);
            }
        });

        personHinzufügenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                invisibler();
                PersonenHInzufügen.setVisible(true);
            }
        });

        zurückButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                invisibler();
                benutzerLabelRichtig.setVisible(false);
                benutzerLabelFalsch.setVisible(false);
                Admin.setVisible(true);
            }
        });

        benutzerHinzufügenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (textFieldPasswort.getText().equals(textFieldPasswortRep.getText())) {
                    getPersonList().put(textFieldBenutzernamen.getText(), new Person(textFieldBenutzernamen.getText(),
                            textFieldPasswort.getText(), textFieldPasswortRep.getText()));
                    textFieldPasswort.setText("");
                    textFieldPasswortRep.setText("");
                    textFieldBenutzernamen.setText("");
                    benutzerLabelRichtig.setVisible(true);
                } else {
                    benutzerLabelFalsch.setVisible(true);
                }
            }
        });

        shopErstellenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                invisibler();
                fillDropdownWithSupermarkets(comboBoxFirmaAdmin);
                comboBoxSelfCheckout.addItem(true);
                comboBoxSelfCheckout.addItem(false);
                ShopHinzufügen.setVisible(true);
            }
        });

        supermarktketteErstellenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                invisibler();
                SupermarktketteHinzufügen.setVisible(true);
            }
        });

        zurückButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                comboBoxSelfCheckout.removeAllItems();
                invisibler();
                labelFalschShop.setVisible(false);
                labelRichtigShop.setVisible(false);
                Admin.setVisible(true);
            }
        });

        shopErstellenButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                invisibler();
                try {
                    String shopname = textFieldShopname.getText();
                    boolean selfCheckoutValue = Boolean.parseBoolean(comboBoxSelfCheckout.getSelectedItem().toString());
                    String place = textFieldPlace.getText();
                    int earnings = Integer.parseInt(textFieldEarnings.getText());
                    String chiefname = textFieldChief.getText();
                    Person chief = new Person(chiefname, "123", "123");
                    if (getSupermarketChainMap().get(comboBoxFirmaAdmin.getSelectedItem().toString()).createSubsidiary(shopname, chief, selfCheckoutValue, place, earnings)) {
                        textFieldShopname.setText("");
                        textFieldChief.setText("");
                        textFieldPlace.setText("");
                        textFieldEarnings.setText("");
                        labelRichtigShop.setVisible(true);
                        labelFalschShop.setVisible(false);
                    } else {
                        labelFalschShop.setVisible(false);
                        labelRichtigShop.setVisible(false);
                    }
                } catch (Exception a) {
                    labelRichtigShop.setVisible(false);
                    labelFalschShop.setVisible(true);
                    System.out.println("Ok hello");
                }
                ShopHinzufügen.setVisible(true);
            }
        });

        zurückButton4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                invisibler();
                Admin.setVisible(true);
            }
        });
        ketteErstellenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (createSupermarketChain(textFieldSupermarktkettenName.getText())) {
                    textFieldSupermarktkettenName.setText("");
                    labelKetteRichtig.setVisible(true);
                    labelKetteFalsch.setVisible(false);
                } else {
                    labelKetteFalsch.setVisible(true);
                    labelKetteRichtig.setVisible(false);
                }
            }
        });

        changePasswordSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (getSelectedUser().changePassword(oldPassword.getText(), newPassword.getText(), repeatPassword.getText())) {
                    passwordOutput.setText("Dein Passwort wurde geändert");
                } else {
                    passwordOutput.setText("Ein Fehler ist aufgetreten, bitte versuche es noch einmal");
                }
            }
        });

        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getPersonList().clear();
                getSupermarketChainMap().clear();
                SupermarketHandler.setUp();
                safeToFile();
            }
        });

        ausloggenButtonAdmin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                invisibler();
                nameLogin.setText("");
                passwortLogin.setText("");
                logout();
                Loginpanel.setVisible(true);
            }
        });
        zurückButton5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                invisibler();
                Dashboardpanel.setVisible(true);
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

                JSpinner spinnerNeu = new JSpinner(sm);
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


    public void fillDropdownWithSupermarkets(JComboBox comboBox) {
        if (comboBox.getItemCount() > 0) {
            comboBox.removeAllItems();
        }

        for (String key : SystemHandler.getSupermarketChainMap().keySet()) {
            comboBox.addItem(key);
            addItemIfNotExists(key, comboBox);
        }
    }

    public void fillDropdownWithArticlesFromSupermarket(String supermarketName, JComboBox comboBox) {
        if (comboBox.getItemCount() > 0) {
            comboBox.removeAllItems();
        }

        SupermarketChain supermarketChain = SystemHandler.getSupermarketChainMap().get(supermarketName);
        for (Article article : supermarketChain.getArticleMap().values()) {
            addItemIfNotExists(article.getName(), comboBox);
        }
    }

    public static void addItemIfNotExists(String item, JComboBox comboBox) {
        if (((DefaultComboBoxModel) comboBox.getModel()).getIndexOf(item) == -1) {
            comboBox.addItem(item);
        }
    }

    public void fillDropdownWithArticlesFromSupermarketFromShop(String supermarketname, String shopName, JComboBox
            comboBox) {
        if (comboBox.getItemCount() > 0) {
            comboBox.removeAllItems();
        }

        SupermarketChain supermarketChain = SystemHandler.getSupermarketChainMap().get(supermarketname);
        for (Shelf shelf : supermarketChain.getShopMap().get(shopName).getShelfList().values()) {
            for (Pair<Article, Integer> articlePair : shelf.getArticleList().values()) {
                addItemIfNotExists(articlePair.getValue0().getName(), comboBox);
            }
        }
    }

    /* org.reflections:reflections:0.10.1*/
    public void fillDropdownWithArticlesByType(JComboBox comboBox) {
        if (comboBox.getItemCount() > 0) {
            comboBox.removeAllItems();
        }

        try {
            Reflections reflections = new Reflections("SupermarketPackage.Articles");
            Set<Class<? extends Article>> classes = reflections.getSubTypesOf(Article.class);
            for (Class<? extends Article> subClass : classes) {
                addItemIfNotExists(subClass.getSimpleName(), comboBox);
            }
        } catch (Exception ignored) {

        }
    }

    public void fillDropdownWithAllArticles(JComboBox comboBox) {
        comboBox.removeAllItems();
        for (SupermarketChain supermarket : SystemHandler.getSupermarketChainMap().values()) {
            for (Shop shop : supermarket.getShopMap().values()) {
                for (Shelf shelf : shop.getShelfList().values()) {
                    for (Pair<Article, Integer> pair : shelf.getArticleList().values()) {
                        if (((DefaultComboBoxModel) comboBox.getModel()).getIndexOf(pair.getValue0().getName()) == -1) {
                            addItemIfNotExists(pair.getValue0().getName(), comboBox);
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        if (new File("Data").mkdirs()) {
            System.out.println("Der Ordner \"Data\" wurde erstellt");
        }

        if (new File("Data/persons.ser").exists() && new File("Data/supermarketChains.ser").exists() && new File("Data/time.ser").exists()) {
            try {
                loadFromFile();
            } catch (Exception e) {
                SupermarketHandler.setUp();
            }
        } else {
            SupermarketHandler.setUp();
        }

        frame.setResizable(true);
        frame.setContentPane((new GUI()).panelMain);
        frame.setDefaultCloseOperation(3);
        frame.pack();
        frame.setResizable(false);
        frame.setSize(1000, 800);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        DigitalClock.main();
//        Container glassPane = (Container) frame.getGlassPane();
//        DigitalClock.SimpleDigitalClock simpleDigitalClock = new DigitalClock.SimpleDigitalClock();
//
//        glassPane.add(simpleDigitalClock);
//        glassPane.setVisible(false);
    }

    public void setDashboardInformation() {
        name.setText("Name: " + getSelectedUser().getName());
        guthaben.setText("Guthaben: " + getSelectedUser().getMoney());
        if (getSelectedUser().getRank() == Rank.CHIEF) {
            ShopChief.setText("Shop ihrer Zuständigkeit: " + getSelectedUser().getCurrentShopWork().getName());
            EinkommenLaden.setText("Einkommen ihres Ladens: " + getSupermarketChainMap().get(getSupermarketChainMap().get(getSelectedUser().getCurrentCompanyWork().getName()).getName()).getShopMap().get(getSelectedUser().getCurrentShopWork().getName()).getEarnings());
        }
        lohn.setText("Lohn: " + getSelectedUser().getSalary());
        if (getSelectedUser().getCard() != null) {
            schüpperpunkte.setText("<html>Ihre Schüperkarteennummer ist: " + getSelectedUser().getCard().getCardnumber() + " <br/><br/> Schüpperpunkte: " + getSelectedUser().getCard().getPoints() + "</html>");
        } else {
            schüpperpunkte.setText("Keine Schüperkarte verfügbar");
        }

    }

    public void fillDropdownsTrueFalsePro() {
        comboBoxBarcode.addItem(true);
        comboBoxBarcode.addItem(false);
        comboBoxBarcodeFleisch.addItem(true);
        comboBoxBarcodeFleisch.addItem(false);
    }

    public void clearDropdownsTrueFalsePro() {
        comboBoxBarcode.removeAllItems();

        comboBoxBarcodeFleisch.removeAllItems();
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
        arbeitenGehenButton.setVisible(false);
        RegalHinzufügen.setVisible(false);
        RegaleErstellt.setVisible(false);
        changePasswordPanel.setVisible(false);

        Selfscanner.setVisible(false);
        Admin.setVisible(false);
        PersonenHInzufügen.setVisible(false);
        ShopHinzufügen.setVisible(false);
        SupermarktketteHinzufügen.setVisible(false);
        keineGeldNoch.setVisible(false);

        Entscheidung.setVisible(false);
        if (getSelectedUser() != null) {
            setDashboardInformation();
            showSpecialButtons();
        }
    }

    public void showSpecialButtons() {
        if (getSelectedUser().getRank() == Rank.CHIEF) {
            ChiefMenu.setVisible(true);
        }
        if (getSelectedUser().getRank() == Rank.EMPLOYEE) {
            arbeitenGehenButton.setVisible(true);
        }
    }
}