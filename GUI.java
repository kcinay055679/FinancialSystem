//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import GameHandlerPackage.SystemHandler;
import SupermarketPackage.SupermarketHandler;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

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

    //Komponente des Panels 3
    private JRadioButton migrosRadioButton1;
    private JRadioButton migrosRadioButton2;
    private JRadioButton migrosRadioButton3;
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
        filialeBetretenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                invisibler();
                Filialebetreten.setVisible(true);
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
}
