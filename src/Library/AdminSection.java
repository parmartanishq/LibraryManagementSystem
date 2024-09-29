package Library;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminSection extends JFrame implements ActionListener {
    JLabel label1;
    Font fon1, fon2;

    AdminSection() {

        super("Admin Page");
        setLocation(190, 50);
        setSize(1000, 700);
        setResizable(false);

        fon1 = new Font("Palatino Linotype", Font.PLAIN, 18);
        fon2 = new Font("Comic Sans Ms", Font.BOLD, 22);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ImageIcon ic = new ImageIcon(ClassLoader.getSystemResource("Library/icon/Adminsecbg.jpg"));
        Image img = ic.getImage().getScaledInstance(1000, 700, Image.SCALE_DEFAULT);
        ImageIcon ic1 = new ImageIcon(img);
        label1 = new JLabel(ic1);

        JMenuBar menuBar = new JMenuBar();
        menuBar.setBackground(Color.lightGray);


        JMenu menu1 = new JMenu("Add Info");
        menuBar.add(menu1);
        menu1.setFont(fon2);
        JMenuItem menuItem1 = new JMenuItem("Add Librarian");
        menu1.add(menuItem1);
        menuItem1.setFont(fon1);

        JMenu menu2 = new JMenu("View Info");
        menuBar.add(menu2);
        menu2.setFont(fon2);
        menu2.setBackground(Color.LIGHT_GRAY);

        JMenuItem menuItem2 = new JMenuItem("View Librarian");
        menu2.add(menuItem2);
        menuItem2.setFont(fon1);

        JMenu menu3 = new JMenu("Delete Info");
        menuBar.add(menu3);
        menu3.setFont(fon2);
        JMenuItem menuItem3 = new JMenuItem("Delete Librarian");
        menu3.add(menuItem3);
        menuItem3.setFont(fon1);

        JMenu menu4 = new JMenu("Options");
        menuBar.add(menu4);
        menu4.setFont(fon2);
        JMenuItem menuItem4 = new JMenuItem("Log-Out");
        menu4.add(menuItem4);
        menuItem4.setFont(fon1);
        menuItem4.setForeground(Color.RED);

        menuItem1.addActionListener(this);
        menuItem2.addActionListener(this);
        menuItem3.addActionListener(this);
        menuItem4.addActionListener(this);

        setJMenuBar(menuBar);
        add(label1);

    }

    public static void main(String[] args) {
        new AdminSection().setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String command = e.getActionCommand();
        if (command.equals("Add Librarian")) {
            this.setVisible(false);
            new AddLibrarian().setVisible(true);

        } else if (command.equals("View Librarian")) {
            this.setVisible(false);
            new ViewLibrarian().setVisible(true);


        } else if (command.equals("Delete Librarian")) {
            this.setVisible(false);
            new DeleteLibrarian().setVisible(true);
            System.out.println("del lib");

        } else if (command.equals("Log-Out")) {
            this.setVisible(false);
            new Index().setVisible(true);
        }
    }
}
