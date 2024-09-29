package Library;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class ViewLibrarian extends JFrame implements ActionListener {

    /* x */ String[] tablevalues = {"ID", "NAME", "PASSWORD", "EMAIL", "CONTACT", "ADDRESS", "BRANCH"};
    JButton butt1;
    /* y */ String[][] tablex = new String[100][7];
    int i = 0;
    int j = 0;
    JTable table;
    Font fon1, fon2, fon3;
    JPanel pan1, pan2;
    JLabel label1;
    DefaultTableCellRenderer cellRenderer;

    ViewLibrarian() {

        super("VIEW LIBRARIAN PAGE");
        setLocation(200, 200);
        setSize(1000, 400);
        setResizable(false);

        fon1 = new Font("Palatino Linotype", Font.BOLD, 15);
        fon2 = new Font("Comic Sans Ms", Font.BOLD, 25);
        fon3 = new Font("Arial", Font.PLAIN, 15);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        try {
            ConnectionClass obj = new ConnectionClass();
            String query = "Select * from librarian";
            ResultSet result = obj.stm.executeQuery(query);

            while (result.next()) {

                tablex[i][j++] = result.getString("librarian_id");
                tablex[i][j++] = result.getString("name");
                tablex[i][j++] = result.getString("password");
                tablex[i][j++] = result.getString("email");
                tablex[i][j++] = result.getString("contact");
                tablex[i][j++] = result.getString("address");
                tablex[i][j++] = result.getString("branch");
                i++;
                j = 0;
            }

            table = new JTable(tablex, tablevalues);
            table.setAlignmentX(JTable.CENTER_ALIGNMENT);
            cellRenderer = new DefaultTableCellRenderer();
            cellRenderer.setHorizontalAlignment(JLabel.CENTER);
            for (i = 0; i < 7; i++) {
                table.getColumnModel().getColumn(i).setCellRenderer(cellRenderer);
                table.setFont(fon3);
            }
        } catch (Exception ex) {

            ex.printStackTrace();
        }

        JScrollPane sp = new JScrollPane(table);
        add(sp);

        label1 = new JLabel("VIEW LIBRARIAN");
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
        new ViewLibrarian().setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == butt1) {
            this.setVisible(false);
            new AdminSection().setVisible(true);
        }
    }

}
