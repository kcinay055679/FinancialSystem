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

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;
import java.util.List;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.HashMap;
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

    //Komponente des zweiten Panels
    private JLabel welcomeText;
    private JButton filialeBetretenButton;
    private JButton tabletBenutzenButton;
    private JButton personalienAnzeigenButton;
    private JButton schüpercardButton;
    private JButton ausloggenButton;
    private JRadioButton migrosRadioButton;
    private JRadioButton coopRadioButton;
    private JRadioButton aldiRadioButton;
    //private JPanel Filiale;
    private JComboBox comboBox1;
    private JButton TabletMenuArtikelFIliale;
    private JPanel Tablet;
    private JPanel TabletÜbersicht;
    private JPanel TabletArtikelSupermarkt;
    private JComboBox TabletArtikelSupermarktSupermarktWählen;
    private JButton BUttonArtikelSuchen;
    private JComboBox TabletArtikelSupermarktArtikelWählen;
    private JButton TabletMenuArtikelSupermarkt;
    private JLabel ArtikelFindenOutput;
    private JButton artikelInDenWarenkorbButton;
    private JButton bestätigenButton1;
    private JComboBox TabletArtikelTypWählen;
    private JButton TabletMenuArtikelName;
    private JScrollBar scrollBar1;
    private JComboBox TabletFilialeWählen;
    private JButton TabletMenuArtikelTyp;

    //Hashmapp für die Produkte in einem Laden
    HashMap<String, JSpinner> produkte = new HashMap<>();

    //Globale Variabeln
    private String currentCompany;
    private String currentShop;

    //Komponente des Panels 3
    public static JFrame frame = new JFrame("Yanick und Marcs Wirtschaftsspass");

    //Konstruktor indem alle Funktionen verwaltet werden
    public GUI() {
        invisibler();
        this.Loginpanel.setVisible(true);

        this.bestätigenButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                if (SystemHandler.login(GUI.this.nameLogin.getText(), new String(GUI.this.passwortLogin.getPassword()))) {
                    System.out.println("Hey hou let's go");
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
                currentCompany = "migros";
                invisibler();
                Filiale.setVisible(true);
                fillDropdownWithShops(currentCompany, comboBox1);
            }
        });

        coopRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Hier gehts ins Coop
                currentCompany = "coop";
                invisibler();
                Filiale.setVisible(true);
                fillDropdownWithShops(currentCompany, comboBox1);
            }


        });

        aldiRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Hier gehts in den Aldi
                currentCompany = "aldi";
                invisibler();
                Filiale.setVisible(true);
                fillDropdownWithShops(currentCompany, comboBox1);
            }
        });


        tabletBenutzenButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                //Hier gehts in den Aldi
                invisibler();
                Tablet.setVisible(true);
                TabletArtikelSupermarkt.setVisible(false);

            }
        });

        TabletMenuArtikelSupermarkt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TabletÜbersicht.setVisible(false);
                TabletArtikelSupermarkt.setVisible(true);
                fillDropdownWithSupermarkets(TabletArtikelSupermarktSupermarktWählen);
                //fillDropdownWithShops(currentCompany, );
            }
        });

        //Dieser Button bestätigt die ausgewählte Filiale
        bestätigenButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               // System.out.println(comboBox1.getSelectedItem().toString());
                currentShop = comboBox1.getSelectedItem().toString();
                generateProducts(comboBox1.getSelectedItem().toString());

                invisibler();
                Warenkorb.setVisible(true);
            }
        });

        //Mit diesem Button fügt der Benutzer die Artikel in den Warenkorb ein
        artikelInDenWarenkorbButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i : SystemHandler.getSupermarketChainMap().get(currentCompany).getShopMap().get(currentShop).getShelfList().keySet()) {
                    for (String j : SystemHandler.getSupermarketChainMap().get(currentCompany).getShopMap().get(currentShop).getShelfList().get(i).getArticleList().keySet()) {
                        for (String key : produkte.keySet()) {
                            SystemHandler.getSupermarketChainMap().get(currentCompany).getShopMap().get(currentShop).getShelfList().get(i).takeArticle(key, (Integer) produkte.get(key).getValue());
                        }
                    }
                }
            }
        });

        TabletArtikelSupermarktSupermarktWählen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e){
                String supermarket = (String) TabletArtikelSupermarktSupermarktWählen.getSelectedItem();
                TabletArtikelSupermarktArtikelWählen.removeAllItems();
                fillDropdownWithArticlesFromSupermarket(supermarket, TabletArtikelSupermarktArtikelWählen);
            }
        });

        BUttonArtikelSuchen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SupermarketPackage.Tablet Tablet1 = new Tablet();
                String supermarketName = (String) TabletArtikelSupermarktSupermarktWählen.getSelectedItem();
                String articleName = (String) TabletArtikelSupermarktArtikelWählen.getSelectedItem();
                List<Triplet<Shop, Article, Integer>> articleInSystemList = Tablet1.findArticleInSystem(articleName, supermarketName);
                StringBuilder output = new StringBuilder();
                for (Triplet<Shop, Article, Integer> t : articleInSystemList) {
                    String shopName = t.getValue0().getName();
                    int amount = t.getValue2();
                    int shelfId = Tablet1.findArticle(articleName, shopName, supermarketName);
                    output.append("In der Filiale ").append(shopName).append(" ist das Produkt ").append(articleName).append(" ").append(amount).append("x im Regal ").append(shelfId).append(" vorhanden \n");
                }
                ArtikelFindenOutput.setText(output.toString());
            }
        });

        //Dieser Button bestätigt die ausgewählte Filiale
        bestätigenButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(comboBox1.getSelectedItem().toString());
                generateProducts(comboBox1.getSelectedItem().toString());
                invisibler();
                Warenkorb.setVisible(true);
            }
        });

        //Mit diesem Button fügt der Benutzer die Artikel in den Warenkorb ein
        artikelInDenWarenkorbButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
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
        for (int key : SystemHandler.getSupermarketChainMap().get(currentCompany).getShopMap().get(shopname).getShelfList().keySet()) {
            for (Pair<Article, Integer> key2Pair : SystemHandler.getSupermarketChainMap().get(currentCompany).getShopMap().get(shopname).getShelfList().get(key).getArticleList().values()) {
                String key2 = key2Pair.getValue0().getName();
                //Neues Panel wird erstellt
                JPanel panelNew = new JPanel();

                //Danach gleichzeitig neue Labels welche in das erstellte Panel eingefügt werden
                JLabel labelNew = new JLabel(key2 + " ("+key2Pair.getValue1()+"x)");
                labelNew.setFont(new Font("Serif", Font.PLAIN, 20));
                panelNew.add(labelNew);

                //Das Gleiche geschieht mit dem Spinner
                JSpinner spinnerNeu = new JSpinner();
                spinnerNeu.setFont(new Font("Serif", Font.PLAIN, 20));
                panelNew.add(spinnerNeu);


                produkte.put(key2, spinnerNeu);

                //Schlussendlich wird das erstellte Panel in das Artikelpanel gelegt
                ArtikelPanel.add(panelNew);
            }
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
    }


}
