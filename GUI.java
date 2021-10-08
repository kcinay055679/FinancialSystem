//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import GameHandlerPackage.SystemHandler;
import SupermarketPackage.Article;
import SupermarketPackage.SupermarketHandler;
import org.javatuples.Pair;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
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
    private JComboBox comboBox1;
    private JButton artikelInDenWarenkorbButton;
    private JPanel ArtikelPanel;
    private JButton bestätigenButton1;

    //Globale Variabeln
    private String currentCompany;

    //Komponente des Panels 3
    public static JFrame frame = new JFrame("Yanick und Marcs Wirtschaftspass");

    //Konstruktor indem alle Funktionen verwaltet werden
    public GUI() {
        invisibler();
        this.Loginpanel.setVisible(true);

        this.bestätigenButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println(GUI.this.passwortLogin.getText());
                if(SystemHandler.login(GUI.this.nameLogin.getText(), GUI.this.passwortLogin.getText())) {
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
                if(e.getKeyCode() == KeyEvent.VK_ENTER && SystemHandler.login(GUI.this.nameLogin.getText(), GUI.this.passwortLogin.getText())) {
                    System.out.println("Hey hou let's go");
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
                if(e.getKeyCode() == KeyEvent.VK_ENTER && SystemHandler.login(GUI.this.nameLogin.getText(), GUI.this.passwortLogin.getText())) {
                    System.out.println("Hey hou let's go");
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
                fillDropdown(currentCompany);
            }
        });

        coopRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Hier gehts ins Coop
                currentCompany = "coop";
                invisibler();
                Filiale.setVisible(true);
                fillDropdown(currentCompany);
            }


        });

        aldiRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Hier gehts in den Aldi
                currentCompany = "aldi";
                invisibler();
                Filiale.setVisible(true);
                fillDropdown(currentCompany);
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
    }

    public void invisibler() {
        Dashboardpanel.setVisible(false);
        Filialebetreten.setVisible(false);
        Loginpanel.setVisible(false);
        Filiale.setVisible(false);
        Warenkorb.setVisible(false);
    }

    public static void main(String[] args) {
        SupermarketHandler.setUp();
        frame.setResizable(true);
        frame.setContentPane((new GUI()).panelMain);
        frame.setDefaultCloseOperation(3);
        frame.pack();
        frame.setSize(600, 500);
        frame.setLocationRelativeTo((Component)null);
        frame.setVisible(true);
    }

    public void fillDropdown(String companyName) {
        for(String key : SystemHandler.getSupermarketChainMap().keySet()) {
            if(key.equals(companyName)) {
                for(String key2 :  SystemHandler.getSupermarketChainMap().get(key).getShopMap().keySet()) {
                    comboBox1.addItem(key2);
                }
            } else {
                System.out.println("Nicht diese Filiale");
            }
        }
    }

    //Hier befüllen wir die Labels mit den Artikeln welche wir verkaufen
    public void generateProducts(String shopname) {
        for(int key : SystemHandler.getSupermarketChainMap().get(currentCompany).getShopMap().get(shopname).getShelfList().keySet()) {
            for(String key2 : SystemHandler.getSupermarketChainMap().get(currentCompany).getShopMap().get(shopname).getShelfList().get(key).getArticleList().keySet()) {
                JLabel labelNew = new JLabel(key2);
                labelNew.setFont(new Font("Serif", Font.PLAIN, 20));
                labelNew.setHorizontalAlignment(JLabel.LEFT);
                Warenkorb.add(labelNew);
            }
        }
    }
}
