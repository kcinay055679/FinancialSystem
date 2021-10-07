//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import GameHandlerPackage.SystemHandler;
import SupermarketPackage.SupermarketHandler;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    private JPanel Filiale;
    private JComboBox comboBox1;

    //Komponente des Panels 3
    public static JFrame frame = new JFrame("Login System");


    public GUI() {
        invisibler();
        this.Loginpanel.setVisible(true);
        this.bestätigenButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println(GUI.this.passwortLogin.getText());
                if (SystemHandler.login(GUI.this.nameLogin.getText(), GUI.this.passwortLogin.getText())) {
                    System.out.println("Hey hou let's go");
                    invisibler();
                    Dashboardpanel.setVisible(true);
                }

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
                String company = "Migros";
            }
        });

        coopRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Hier gehts ins Coop
                String company = "Coop";
            }


        });

        aldiRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Hier gehts in den Aldi
                String company = "Aldi";
            }
        });
    }

    public void invisibler() {
        Dashboardpanel.setVisible(false);
        Filialebetreten.setVisible(false);
        Loginpanel.setVisible(false);
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
        for(String key : SystemHandler.getCompanyMap().keySet()) {

        }
    }
}
