package Library;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Librarian extends JFrame implements ActionListener {


    JLabel label1, label2, label3, label4;
    JPanel pan1, pan2, pan3;
    JButton butt1, butt2;
    Font fon1, fon2;
    JTextField textf1;
    JPasswordField passf;

    Librarian() {

        super("Librarian Login Page");
        setLocation(430, 250);
        setSize(500, 200);
        setResizable(false);

        fon1 = new Font("Palatino Linotype", Font.PLAIN, 18);
        fon2 = new Font("Comic Sans Ms", Font.BOLD, 25);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        label1 = new JLabel(" NAME : ");
        label1.setFont(fon1);

        label2 = new JLabel(" PASSWORD : ");
        label2.setFont(fon1);

        label3 = new JLabel("LIBRARIAN LOGIN");
        label3.setFont(fon2);

        butt1 = new JButton("Login");
        butt1.setFont(fon1);
        butt2 = new JButton("Cancel");
        butt2.setFont(fon1);

        butt1.addActionListener(this);
        butt2.addActionListener(this);

        textf1 = new JTextField();
        textf1.setFont(fon1);
        passf = new JPasswordField();
        passf.setFont(fon1);

        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("Library/icon/liblogin.jpg"));
        Image i = img.getImage().getScaledInstance(110, 110, Image.SCALE_DEFAULT);
        ImageIcon img2 = new ImageIcon(i);
        label4 = new JLabel(img2);


        pan3 = new JPanel();
        pan3.setLayout(new GridLayout(1, 1, 10, 10));
        pan3.add(label3);
        pan3.setBackground(Color.yellow);

        pan1 = new JPanel();
        pan1.setLayout(new GridLayout(3, 2, 10, 10));
        pan1.add(label1);
        pan1.add(textf1);
        pan1.add(label2);
        pan1.add(passf);
        pan1.add(butt1);
        pan1.add(butt2);
        pan1.setBackground(Color.WHITE);

        pan2 = new JPanel();
        pan2.setLayout(new GridLayout(1, 1, 10, 10));
        pan2.add(label4);
        pan2.setBackground(Color.WHITE);

        label3.setHorizontalAlignment(JLabel.CENTER);
        label1.setHorizontalAlignment(JLabel.CENTER);
        label2.setHorizontalAlignment(JLabel.CENTER);

        textf1.setHorizontalAlignment(JLabel.CENTER);
        passf.setHorizontalAlignment(JLabel.CENTER);

        setLayout(new BorderLayout(1, 1));
        add(pan3, "North");
        add(pan2, "West");
        add(pan1, "Center");
    }

    public static void main(String[] args) {

        new Librarian().setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String librarian_login_name = textf1.getText();
        char[] temp = passf.getPassword();
        String librarian_login_pass = String.valueOf(temp);

        if (e.getSource() == butt1) {
            try {

                ConnectionClass obj = new ConnectionClass();
                String query = "Select name,password from librarian where name = '" + librarian_login_name + "' and password = '" + librarian_login_pass + "'";
                ResultSet resset = obj.stm.executeQuery(query);

                if (resset.next()) {
                    this.setVisible(false);
                    new LibrarianSection().setVisible(true);
                } else {

                    JOptionPane.showMessageDialog(null, "USERNAME OR PASSWORD IS WRONG!");
                    this.setVisible(false);
                    new Librarian().setVisible(true);
                }
            } catch (Exception ex) {

                ex.printStackTrace();
            }
        }
        if (e.getSource() == butt2) {
            new Index().setVisible(true);
            this.setVisible(false);
        }
    }
}
