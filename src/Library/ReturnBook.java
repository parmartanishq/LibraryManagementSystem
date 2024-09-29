package Library;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReturnBook extends JFrame implements ActionListener {

    JLabel label1, label2, label3;
    JButton butt1, butt2;
    JPanel pan1, pan2;
    JTextField textf1, textf2;
    Font fon1, fon2;

    ReturnBook() {

        super(" RETRUN BOOK PAGE");
        setLocation(410, 250);
        setSize(600, 270);
        setResizable(false);

        fon1 = new Font("Palatino Linotype", Font.PLAIN, 18);
        fon2 = new Font("Comic Sans Ms", Font.BOLD, 25);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        label1 = new JLabel(" RETURN BOOK ");
        label2 = new JLabel(" BOOK NO : ");
        label3 = new JLabel(" STUDENT ID :");

        label1.setForeground(Color.WHITE);

        textf1 = new JTextField();
        textf2 = new JTextField();

        label1.setFont(fon2);
        label2.setFont(fon1);
        label3.setFont(fon1);

        textf1.setFont(fon1);
        textf2.setFont(fon1);

        butt1 = new JButton("Return Book");
        butt2 = new JButton("Cancel");
        butt1.setFont(fon1);
        butt2.setFont(fon1);

        butt1.addActionListener(this);
        butt2.addActionListener(this);

        label1.setHorizontalAlignment(JLabel.CENTER);
        label2.setHorizontalAlignment(JLabel.CENTER);
        label3.setHorizontalAlignment(JLabel.CENTER);

        textf1.setHorizontalAlignment(JLabel.CENTER);
        textf2.setHorizontalAlignment(JLabel.CENTER);

        pan1 = new JPanel(new GridLayout(1, 1, 10, 10));
        pan1.add(label1);
        pan1.setBackground(Color.orange);

        pan2 = new JPanel(new GridLayout(3, 2, 10, 10));
        pan2.add(label2);
        pan2.add(textf1);
        pan2.add(label3);
        pan2.add(textf2);
        pan2.add(butt1);
        pan2.add(butt2);

        setLayout(new BorderLayout(10, 10));
        add(pan1, "North");
        add(pan2, "Center");


    }

    public static void main(String[] args) {

        new ReturnBook().setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {


        if (e.getSource() == butt1) {
            String Bookno = textf1.getText();
            int Student_id = Integer.parseInt(textf2.getText());

            try {
                ConnectionClass obj = new ConnectionClass();
                String query1 = "Delete from issuebook where bookno= '" + Bookno + "'and student_id= '" + Student_id + "'";
                int res = obj.stm.executeUpdate(query1);

                if (res == 0) {

                    JOptionPane.showMessageDialog(null, "BOOK IS NOT ISSUED!");
                    this.setVisible(false);
                    new ReturnBook().setVisible(true);
                } else {

                    String query2 = "update addbook set issuebook = issuebook-1 where bookno = '" + Bookno + "'";
                    String query3 = "update addbook set quantity = quantity+1 where bookno ='" + Bookno + "'";
                    int a = obj.stm.executeUpdate(query2);
                    int b = obj.stm.executeUpdate(query3);

                    if (a == 1) {

                        if (b == 1) {

                            JOptionPane.showMessageDialog(null, "DATA SUCCESSFULLY UPDATED");
                            this.setVisible(false);
                            new ReturnBook().setVisible(true);
                        } else {
                            JOptionPane.showMessageDialog(null, "FILL ALL THE BOXES");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "FILL ALL THE BOXES");

                    }

                }


            } catch (Exception ex) {

                ex.printStackTrace();

            }
        }
        if (e.getSource() == butt2) {
            this.setVisible(false);
            new LibrarianSection().setVisible(true);
        }

    }
}
