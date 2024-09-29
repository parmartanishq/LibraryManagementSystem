package Library;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;

public class IssueBook extends JFrame implements ActionListener {


    JLabel label1, label2, label3, label4, label5, label6, label7, label8;
    JButton butt1, butt2;
    JPanel pan1, pan2;
    JTextField textf1, textf2, textf3, textf4, textf5, textf6;
    Font fon1, fon2;
    Choice choice;

    IssueBook() {

        super("ISSUE BOOK PAGE");
        setLocation(400, 200);
        setSize(600, 400);
        setResizable(false);

        fon1 = new Font("Palatino Linotype", Font.PLAIN, 18);
        fon2 = new Font("Comic Sans Ms", Font.BOLD, 25);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        label1 = new JLabel(" ISSUE BOOK");
        label2 = new JLabel(" BOOK ID ");
        label3 = new JLabel(" BOOK NO ");
        label4 = new JLabel(" BOOK NAME ");
        label5 = new JLabel(" STUDENT ID  ");
        label6 = new JLabel(" STUDENT NAME ");
        label7 = new JLabel(" STUDENT CONTACT ");
        label8 = new JLabel(" BOOK QUANTITY ");

        label1.setForeground(Color.WHITE);

        textf1 = new JTextField();
        textf2 = new JTextField();
        textf3 = new JTextField();
        textf4 = new JTextField();
        textf5 = new JTextField();
        textf6 = new JTextField();

        label1.setFont(fon2);
        label2.setFont(fon1);
        label3.setFont(fon1);
        label4.setFont(fon1);
        label5.setFont(fon1);
        label6.setFont(fon1);
        label7.setFont(fon1);
        label8.setFont(fon1);


        textf1.setFont(fon1);
        textf2.setFont(fon1);
        textf3.setFont(fon1);
        textf4.setFont(fon1);
        textf5.setFont(fon1);
        textf6.setFont(fon1);

        butt1 = new JButton("Issue Book");
        butt2 = new JButton("Cancel");
        butt1.setFont(fon1);
        butt2.setFont(fon1);

        butt1.addActionListener(this);
        butt2.addActionListener(this);

        label1.setHorizontalAlignment(JLabel.CENTER);
        label2.setHorizontalAlignment(JLabel.CENTER);
        label3.setHorizontalAlignment(JLabel.CENTER);
        label4.setHorizontalAlignment(JLabel.CENTER);
        label5.setHorizontalAlignment(JLabel.CENTER);
        label6.setHorizontalAlignment(JLabel.CENTER);
        label7.setHorizontalAlignment(JLabel.CENTER);
        label8.setHorizontalAlignment(JLabel.CENTER);

        textf1.setHorizontalAlignment(JLabel.CENTER);
        textf2.setHorizontalAlignment(JLabel.CENTER);
        textf3.setHorizontalAlignment(JLabel.CENTER);
        textf4.setHorizontalAlignment(JLabel.CENTER);
        textf5.setHorizontalAlignment(JLabel.CENTER);
        textf6.setHorizontalAlignment(JLabel.CENTER);

        textf6.setEditable(false);

        choice = new Choice();

        try {

            ConnectionClass obj = new ConnectionClass();
            String query = " select book_id from addbook";
            ResultSet result = obj.stm.executeQuery(query);
            while (result.next()) {

                choice.add(result.getString("book_id"));

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        choice.setFont(fon1);

        pan1 = new JPanel(new GridLayout(1, 1, 10, 10));
        pan1.add(label1);
        pan1.setBackground(Color.orange);

        pan2 = new JPanel(new GridLayout(8, 2, 10, 10));
        pan2.add(label2);
        pan2.add(choice);
        pan2.add(label3);
        pan2.add(textf1);
        pan2.add(label4);
        pan2.add(textf2);
        pan2.add(label5);
        pan2.add(textf3);
        pan2.add(label6);
        pan2.add(textf4);
        pan2.add(label7);
        pan2.add(textf5);
        pan2.add(label8);
        pan2.add(textf6);
        pan2.add(butt1);
        pan2.add(butt2);

        setLayout(new BorderLayout(10, 10));
        add(pan1, "North");
        add(pan2, "Center");

        choice.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                try {

                    ConnectionClass obj = new ConnectionClass();
                    int book_id = Integer.parseInt(choice.getSelectedItem());
                    String query = "Select * from addbook where book_id ='" + book_id + "'";
                    ResultSet result = obj.stm.executeQuery(query);
                    while (result.next()) {

                        textf1.setText(result.getString("bookno"));
                        textf2.setText(result.getString("bookname"));
                        textf6.setText(result.getString("quantity"));

                    }

                } catch (Exception ex) {

                    ex.printStackTrace();
                }


            }
        });
    }

    public static void main(String[] args) {
        new IssueBook().setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == butt1) {

            int quantity = 0;
            int Bookid = Integer.parseInt(choice.getSelectedItem());
            String Bookno = textf1.getText();
            String Bookname = textf2.getText();
            int Student_id = Integer.parseInt(textf3.getText());
            String Studentname = textf4.getText();
            String StudentContact = textf5.getText();
            String date = new java.util.Date().toString();

            try {
                ConnectionClass obj = new ConnectionClass();
                String query = "Select quantity from addbook where book_id='" + Bookid + "'";
                ResultSet result = obj.stm.executeQuery(query);

                while (result.next()) {

                    quantity = Integer.parseInt(result.getString("quantity"));
                }
                if (quantity <= 0) {

                    JOptionPane.showMessageDialog(null, "BOOK OUT OF STOCK.");
                    this.setVisible(false);
                    this.setVisible(true);
                } else {

                    String query1 = "insert into issuebook(book_id,bookno,bookname,student_id,student_name,student_contact,date) values('" + Bookid + "','" + Bookno + "','" + Bookname + "','" + Student_id + "','" + Studentname + "','" + StudentContact + "','" + date + "')";
                    String query2 = "update addbook set issuebook = issuebook+1 where book_id = '" + Bookid + "'";
                    String query3 = "update addbook set quantity = quantity-1 where book_id ='" + Bookid + "'";

                    int a = obj.stm.executeUpdate(query1);
                    int b = obj.stm.executeUpdate(query2);
                    int c = obj.stm.executeUpdate(query3);

                    if (a == 1) {

                        if (b == 1) {
                            if (c == 1) {

                                JOptionPane.showMessageDialog(null, "DATA SUCCESSFULY UPDATED");
                                this.setVisible(false);
                                new IssueBook().setVisible(true);
                            } else {
                                JOptionPane.showMessageDialog(null, "FILL ALL BOXES");
                            }

                        } else {
                            JOptionPane.showMessageDialog(null, "FILL ALL BOXES");
                        }

                    } else {
                        JOptionPane.showMessageDialog(null, "FILL ALL BOXES");
                    }

                }

            } catch (Exception ex) {
                ex.printStackTrace();
            }


        } else if (e.getSource() == butt2) {

            this.setVisible(false);
            new LibrarianSection().setVisible(true);

        }

    }
}
