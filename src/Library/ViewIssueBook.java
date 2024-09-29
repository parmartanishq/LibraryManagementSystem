package Library;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class ViewIssueBook extends JFrame implements ActionListener {


    /* x */ String[] tablevalues = {"ID", "BOOK NO", "BOOK NAME", "STUDENT-ID", "STUDENT NAME", "STUDENT CONTACT", "DATE"};
    JButton butt1;
    /* y */ String[][] tablex = new String[100][7];
    int i = 0;
    int j = 0;
    JTable table;
    Font fon1, fon2, fon3;
    JPanel pan1, pan2;
    JLabel label1;
    DefaultTableCellRenderer cellRenderer;

    ViewIssueBook() {

        super("VIEW ISSUE BOOK PAGE");
        setLocation(200, 200);
        setSize(1000, 400);
        setResizable(false);

        fon1 = new Font("Palatino Linotype", Font.BOLD, 15);
        fon2 = new Font("Comic Sans Ms", Font.BOLD, 25);
        fon3 = new Font("Arial", Font.PLAIN, 15);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        try {
            ConnectionClass obj = new ConnectionClass();
            String query = "Select * from issuebook";
            ResultSet result = obj.stm.executeQuery(query);

            while (result.next()) {

                tablex[i][j++] = result.getString("book_id");
                tablex[i][j++] = result.getString("bookno");
                tablex[i][j++] = result.getString("bookname");
                tablex[i][j++] = result.getString("student_id");
                tablex[i][j++] = result.getString("student_name");
                tablex[i][j++] = result.getString("student_contact");
                tablex[i][j++] = result.getString("date");
                i++;
                j = 0;
            }

            table = new JTable(tablex, tablevalues);
            table.setAlignmentX(JTable.CENTER_ALIGNMENT);
            cellRenderer = new DefaultTableCellRenderer();
            cellRenderer.setHorizontalAlignment(JLabel.CENTER);
            table.getColumnModel().getColumn(0).setPreferredWidth(1);
            table.getColumnModel().getColumn(2).setPreferredWidth(200);
            for (i = 0; i < 7; i++) {
                table.getColumnModel().getColumn(i).setCellRenderer(cellRenderer);
                table.setFont(fon3);
            }
        } catch (Exception ex) {

            ex.printStackTrace();
        }

        JScrollPane sp = new JScrollPane(table);
        add(sp);

        label1 = new JLabel("VIEW ISSUE-BOOK");
        label1.setFont(fon2);
        label1.setHorizontalAlignment(JLabel.CENTER);

        pan1 = new JPanel();
        pan1.setLayout(new GridLayout(1, 0, 10, 10));
        pan1.add(label1);
        pan1.setBackground(Color.orange);

        butt1 = new JButton("CLOSE");
        butt1.setFont(fon1);
        butt1.setSize(10, 10);
        butt1.setHorizontalAlignment(JButton.CENTER);

        butt1.addActionListener(this);
        pan2 = new JPanel(new GridLayout(1, 0, 10, 10));
        add(pan1, "North");
        add(butt1, "South");


    }

    public static void main(String[] args) {
        new ViewIssueBook().setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == butt1) {
            this.setVisible(false);
            new LibrarianSection().setVisible(true);
        }

    }

}
