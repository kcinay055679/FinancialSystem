import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class GUI {
    private JLabel loginLabel;
    private JPanel panelMain;

    public GUI() {

    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("GUI");
        frame.setResizable(true);
        frame.setContentPane(new GUI().panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();

        frame.setSize(500, 500);
        frame.setVisible(true);

    }
}
