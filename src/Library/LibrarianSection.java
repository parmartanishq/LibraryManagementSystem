package Library;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LibrarianSection extends JFrame implements ActionListener {
    JLabel label1;
    Font fon1, fon2;

    LibrarianSection() {

        super("Librarian Page");
        setLocation(190, 50);
        setSize(1000, 700);
        setResizable(false);

        fon1 = new Font("Palatino Linotype", Font.PLAIN, 18);
        fon2 = new Font("Comic Sans Ms", Font.BOLD, 22);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ImageIcon ic = new ImageIcon(ClassLoader.getSystemResource("Library/icon/libsectionbg.png"));
        Image img = ic.getImage().getScaledInstance(1000, 700, Image.SCALE_DEFAULT);
        ImageIcon ic1 = new ImageIcon(img);
        label1 = new JLabel(ic1);

        JMenuBar menuBar = new JMenuBar();
        menuBar.setBackground(Color.lightGray);


        JMenu menu1 = new JMenu("Add Info");
        menuBar.add(menu1);
        menu1.setFont(fon2);
        JMenuItem menuItem1 = new JMenuItem("Add Book");
        menu1.add(menuItem1);
        menuItem1.setFont(fon1);

        JMenu menu2 = new JMenu("View Info");
        menuBar.add(menu2);
        menu2.setFont(fon2);
        JMenuItem menuItem2 = new JMenuItem("View Book");
        menu2.add(menuItem2);
        menuItem2.setFont(fon1);
        JMenuItem menuItem_2 = new JMenuItem("View Issue-Book");
        menu2.add(menuItem_2);
        menuItem_2.setFont(fon1);

        JMenu menu3 = new JMenu("Issues");
        menuBar.add(menu3);
        menu3.setFont(fon2);
        JMenuItem menuItem3 = new JMenuItem("Issue-Book");
        menu3.add(menuItem3);
        menuItem3.setFont(fon1);

        JMenu menu4 = new JMenu("Returns");
        menuBar.add(menu4);
        menu4.setFont(fon2);
        JMenuItem menuItem4 = new JMenuItem("Return-Book");
        menu4.add(menuItem4);
        menuItem4.setFont(fon1);

        JMenu menu5 = new JMenu("Options");
        menuBar.add(menu5);
        menu5.setFont(fon2);
        JMenuItem menuItem5 = new JMenuItem("Log-Out");
        menu5.add(menuItem5);
        menuItem5.setFont(fon1);
        menuItem5.setForeground(Color.RED);

        menuItem1.addActionListener(this);
        menuItem2.addActionListener(this);
        menuItem_2.addActionListener(this);
        menuItem3.addActionListener(this);
        menuItem4.addActionListener(this);
        menuItem5.addActionListener(this);

        setJMenuBar(menuBar);
        add(label1);
    }

    public static void main(String[] args) {
        new LibrarianSection().setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String command = e.getActionCommand();
        if (command.equals("Add Book")) {
            this.setVisible(false);
            new AddBook().setVisible(true);

        } else if (command.equals("View Book")) {
            this.setVisible(false);
            new ViewBook().setVisible(true);

        } else if (command.equals("View Issue-Book")) {
            this.setVisible(false);
            new ViewIssueBook().setVisible(true);
        } else if (command.equals("Issue-Book")) {
            this.setVisible(false);
            new IssueBook().setVisible(true);

        } else if (command.equals("Return-Book")) {
            this.setVisible(false);
            new ReturnBook().setVisible(true);

        } else if (command.equals("Log-Out")) {
            this.setVisible(false);
            new Index().setVisible(true);
        }
    }

}