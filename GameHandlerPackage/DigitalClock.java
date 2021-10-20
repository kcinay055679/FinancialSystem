package GameHandlerPackage;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

public class DigitalClock {
    public static void main() {
        JFrame frm = new JFrame();
        frm.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        SimpleDigitalClock clock1 = new SimpleDigitalClock();
        frm.add(clock1);
        frm.pack();
        frm.setVisible(true);
    }

    public static class SimpleDigitalClock extends JPanel {
        Thread t = new Thread();
        String timeString = "";
        public static LocalDateTime realTime = LocalDateTime.from(LocalDateTime.of(1, 1, 1, 0, 0,0, 0));

        public void setStringTime(String abc) {
            this.timeString = abc;
        }

        public int Number(int a, int b) {
            return (a <= b) ? a : b;
        }

        public SimpleDigitalClock() {
            Timer t = new Timer(0, new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    repaint();
                }
            });
            t.start();
        }

        @Override
        public void paintComponent(Graphics v) {
            super.paintComponent(v);

            realTime = realTime.plusSeconds(1);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
            timeString = formatter.format(realTime);

            setStringTime(timeString);
            v.setColor(Color.BLACK);
            int length = Number(this.getWidth(), this.getHeight());
            Font Font1 = new Font("SansSerif", Font.PLAIN, length / 6);
            v.setFont(Font1);
            v.drawString(timeString, (int) length / 6, length / 2);
            this.setBackground(null);
            try {
                t.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }
    }


}

