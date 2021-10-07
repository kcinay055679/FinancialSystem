import GameHandlerPackage.SystemHandler;
import SupermarketPackage.SupermarketHandler;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class GUI {
    private JPanel panelMain;
    private JTextField nameLogin;
    private JLabel nameLabel;
    private JLabel passwortLabel;
    private JPasswordField passwortLogin;
    private JButton bestätigenButton;

    public GUI() {

        bestätigenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StringBuilder out = new StringBuilder();
                for (char word : passwortLogin.getPassword()) {
                    out.append(word).append(" ");
                }

                System.out.println(SystemHandler.login(nameLogin.getText(), out.toString()));
            }
        });
    }

    public static void main(String[] args) {
        SupermarketHandler.setUp();;
        JFrame frame = new JFrame("Login System");
        frame.setResizable(true);
        frame.setContentPane(new GUI().panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(500, 500);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }


}
