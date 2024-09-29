package Library;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class DeleteLibrarian extends JFrame implements ActionListener {
    /* x */ String[] tablevalues = {"ID", "NAME", "PASSWORD", "EMAIL", "CONTACT", "ADDRESS", "BRANCH"};
    JButton butt1, butt2;
    /* y */ String[][] tablex = new String[100][7];
    int i = 0;
    int j = 0;
    JTable table;
    Font fon1, fon2, fon3;
    JTextField textf;
    JPanel pan1, pan2, pan3;
    JLabel label1, label2;
    DefaultTableCellRenderer cellRenderer;

    DeleteLibrarian() {

        super("DELETE LIBRARIAN PAGE");
        setLocation(200, 200);
        setSize(1000, 400);
        setResizable(false);

        fon1 = new Font("Palatino Linotype", Font.BOLD, 18);
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


        label1 = new JLabel("DELETE LIBRARIAN");
        label1.setFont(fon2);
        label1.setHorizontalAlignment(JLabel.CENTER);

        textf = new JTextField();
        textf.setFont(fon1);
        textf.setHorizontalAlignment(JLabel.CENTER);
        butt1 = new JButton("DELETE");
        butt1.setFont(fon1);
        butt2 = new JButton("CANCEL");
        butt2.setFont(fon1);

        butt1.setHorizontalAlignment(JButton.CENTER);

        butt1.addActionListener(this);
        butt2.addActionListener(this);

        pan1 = new JPanel();
        pan1.setLayout(new GridLayout(1, 1, 10, 10));
        pan1.add(label1);

        label2 = new JLabel("LIBRARIAN ID :");
        label2.setFont(fon1);
        label2.setHorizontalAlignment(JLabel.RIGHT);
        pan2 = new JPanel(new GridLayout(1, 4, 10, 10));
        pan2.add(label2);
        pan2.add(textf);
        pan2.add(butt1);
        pan2.add(butt2);


        pan1.setBackground(Color.orange);

        setLayout(new BorderLayout(10, 10));
        add(sp, "Center");
        add(pan1, "North");
        add(pan2, "South");
    }

    public static void main(String[] args) {

        new DeleteLibrarian().setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == butt1) {
            int librarian_id = Integer.parseInt(textf.getText());
            try {
                ConnectionClass obj = new ConnectionClass();
                String query = "delete from librarian where librarian_id='" + librarian_id + "'";
                int result = obj.stm.executeUpdate(query);

                if (result == 1) {

                    JOptionPane.showMessageDialog(null, "DATA DELETED SUCCESSFULLY");
                    this.setVisible(false);
                    new DeleteLibrarian().setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "ID NOT FOUND");
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
