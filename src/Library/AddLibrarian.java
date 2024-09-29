package Library;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddLibrarian extends JFrame implements ActionListener {

    JLabel label1, label2, label3, label4, label5, label6, label7;
    JButton butt1, butt2;
    JPanel pan1, pan2;
    JTextField textf1, textf2, textf3, textf4, textf5;
    JPasswordField passf;
    Font fon1, fon2;

    AddLibrarian() {

        super("ADD LIBRARIAN PAGE");
        setLocation(400, 200);
        setSize(600, 400);
        setResizable(false);

        fon1 = new Font("Palatino Linotype", Font.PLAIN, 18);
        fon2 = new Font("Comic Sans Ms", Font.BOLD, 25);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        label1 = new JLabel(" ADD LIBRARIAN ");
        label2 = new JLabel(" NAME ");
        label3 = new JLabel(" PASSWORD ");
        label4 = new JLabel(" EMAIL ");
        label5 = new JLabel(" CONTACT ");
        label6 = new JLabel(" ADDRESS ");
        label7 = new JLabel(" BRANCH ");

        label1.setForeground(Color.WHITE);

        textf1 = new JTextField();
        textf2 = new JTextField();
        textf3 = new JTextField();
        textf4 = new JTextField();
        textf5 = new JTextField();

        textf1.setFont(fon1);
        textf2.setFont(fon1);
        textf3.setFont(fon1);
        textf4.setFont(fon1);
        textf5.setFont(fon1);

        passf = new JPasswordField();
        passf.setFont(fon1);

        label1.setFont(fon2);
        label2.setFont(fon1);
        label3.setFont(fon1);
        label4.setFont(fon1);
        label5.setFont(fon1);
        label6.setFont(fon1);
        label7.setFont(fon1);

        butt1 = new JButton("Add Librarian");
        butt2 = new JButton("Cancel");
        butt1.setFont(fon1);
        butt2.setFont(fon1);

        butt1.addActionListener(this);
        butt2.addActionListener(this);

        pan1 = new JPanel();
        pan1.setLayout(new GridLayout(1, 1, 10, 10));
        pan1.add(label1);
        pan1.setBackground(Color.orange);

        pan2 = new JPanel();
        pan2.setLayout(new GridLayout(7, 2, 10, 10));
        pan2.add(label2);
        pan2.add(textf1);

        pan2.add(label3);
        pan2.add(passf);

        pan2.add(label4);
        pan2.add(textf2);

        pan2.add(label5);
        pan2.add(textf3);

        pan2.add(label6);
        pan2.add(textf4);

        pan2.add(label7);
        pan2.add(textf5);

        pan2.add(butt1);
        pan2.add(butt2);

        label1.setHorizontalAlignment(JLabel.CENTER);
        label2.setHorizontalAlignment(JLabel.CENTER);
        label3.setHorizontalAlignment(JLabel.CENTER);
        label4.setHorizontalAlignment(JLabel.CENTER);
        label5.setHorizontalAlignment(JLabel.CENTER);
        label6.setHorizontalAlignment(JLabel.CENTER);
        label7.setHorizontalAlignment(JLabel.CENTER);

        textf1.setHorizontalAlignment(JLabel.CENTER);
        textf2.setHorizontalAlignment(JLabel.CENTER);
        textf3.setHorizontalAlignment(JLabel.CENTER);
        textf4.setHorizontalAlignment(JLabel.CENTER);
        textf5.setHorizontalAlignment(JLabel.CENTER);
        passf.setHorizontalAlignment(JLabel.CENTER);

        setLayout(new BorderLayout(1, 1));
        add(pan1, "North");
        add(pan2, "Center");

    }

    public static void main(String[] args) {
        new AddLibrarian().setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String Name = textf1.getText();
        char[] temp = passf.getPassword();
        String Password = String.valueOf(temp);
        String Email = textf2.getText();
        String Contact = textf3.getText();
        String Address = textf4.getText();
        String Branch = textf5.getText();

        if (e.getSource() == butt1) {

            try {

                ConnectionClass obj = new ConnectionClass();

                String query = "insert into librarian(name,password,email,contact,address,branch) values('" + Name + "','" + Password + "','" + Email + "','" + Contact + "','" + Address + "','" + Branch + "')";
                int check = obj.stm.executeUpdate(query);

                if (check == 1) {

                    JOptionPane.showMessageDialog(null, "DATA SUCCESFULLY ADDED!");
                    this.setVisible(false);
                    new AdminSection().setVisible(true);
                } else {

                    JOptionPane.showMessageDialog(null, "FILL ALL THE BOXES CAREFULLY!");
                    this.setVisible(true);
                }

            } catch (Exception ex) {
                ex.printStackTrace();
            }

        }
        if (e.getSource() == butt2) {

            this.setVisible(false);
            new AdminSection().setVisible(true);
        }
    }
}
