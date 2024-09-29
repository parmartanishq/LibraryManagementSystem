package Library;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Index extends JFrame implements ActionListener {

    JLabel label1, label2, label3, label4;
    JButton butt1, butt2;
    JPanel pan1, pan2, pan3, pan4, pan5;
    Font fon1, fon2;

    Index() {


        super("LOGIN PAGE");
        setLocation(430, 250);
        setSize(500, 200);
        setResizable(false);

        fon1 = new Font("Palatino Linotype", Font.PLAIN, 18);
        fon2 = new Font("Comic Sans Ms", Font.BOLD, 25);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        label1 = new JLabel(" ADMIN ");
        label1.setFont(fon1);

        label2 = new JLabel(" LIBRARIAN ");
        label2.setFont(fon1);

        label3 = new JLabel("T.O.D.A LIBRARY");
        label3.setFont(fon2);


        butt1 = new JButton("Log in");
        butt1.setFont(fon1);
        butt2 = new JButton("Log in");
        butt2.setFont(fon1);

        butt1.addActionListener(this);
        butt2.addActionListener(this);

        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("Library/icon/LOCK.png"));
        Image i = img.getImage().getScaledInstance(130, 120, Image.SCALE_DEFAULT);
        ImageIcon img2 = new ImageIcon(i);
        label4 = new JLabel(img2);

        label3.setHorizontalAlignment(JLabel.CENTER);
        label1.setHorizontalAlignment(JLabel.CENTER);
        label2.setHorizontalAlignment(JLabel.CENTER);

        pan1 = new JPanel();
        pan1.setLayout(new GridLayout(2, 2, 10, 10));
        pan1.add(label1);
        pan1.add(butt1);
        pan1.add(label2);
        pan1.add(butt2);
        pan1.setBackground(Color.WHITE);

        pan2 = new JPanel();
        pan2.setLayout(new GridLayout(1, 1, 10, 10));
        pan2.add(label4);
        pan2.setBackground(Color.WHITE);

        pan3 = new JPanel();
        pan3.setLayout(new GridLayout(1, 1, 10, 10));
        pan3.add(label3);
        pan3.setBackground(Color.CYAN);

        setLayout(new BorderLayout(1, 1));
        add(pan3, "North");
        add(pan2, "West");
        add(pan1, "Center");

    }

    public static void main(String[] args) {

        new Index().setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == butt1) {

            //  System.out.println("ADMIN LOGIN ");
            new Admin().setVisible(true);
            this.setVisible(false);
        }
        if (e.getSource() == butt2) {

            this.setVisible(false);
            new Librarian().setVisible(true);
        }
    }
}
