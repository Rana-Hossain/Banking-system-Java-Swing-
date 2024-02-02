import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class DisplayAccount extends JFrame implements ActionListener {

    private JPanel panel;
    private JTable table;
    private DefaultTableModel tableModel;
    private JButton b1;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new DisplayAccount().setVisible(true));
    }

    public DisplayAccount() {
        setBackground(new Color(169, 169, 169));
        setBounds(600, 300, 600, 400);

        panel = new JPanel();
        panel.setBackground(new Color(176, 224, 230));
        setContentPane(panel);
        panel.setLayout(new BorderLayout());

        // Create columns for the table
        String[] columnNames = {"Account Id", "Name", "Password", "Email", "Number", "Account Type", "Balance" };

        // Create a table model with columns
        tableModel = new DefaultTableModel(columnNames, 0);

        // Create a JTable with the model
        table = new JTable(tableModel);

        // Add the table to a scroll pane
        JScrollPane scrollPane = new JScrollPane(table);
        panel.add(scrollPane, BorderLayout.CENTER);

        // Populate the table with user data
        populateTable();

        b1 = new JButton("Back");
        b1.addActionListener(this);

        b1.setForeground(new Color(205, 92, 92));
        b1.setBackground(new Color(253, 245, 230));
        panel.add(b1, BorderLayout.SOUTH);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            setVisible(false);
            // Replace 'login' with the appropriate class
            Home ca = new Home();
            ca.setVisible(true);
        }

        // Avoid throwing an exception here; you can remove this line
        // throw new UnsupportedOperationException("Unimplemented method
        // 'actionPerformed'");
    }

    private void populateTable() {
        // Assuming UserDataManager.getUserList() returns a valid list
        List<UserData> userList = UserDataManager.getUserList();

        int i = 1;
        for (UserData user : userList) {
            String tem = user.getID();
            if (i % 2 != 0&&!tem.isEmpty()) {
                Object[] rowData = {user.getID(), user.getName(), user.getPassword(), user.getEmail(),
                        user.getNumber(), user.getAccountType(), user.getInitialBalance() };
                tableModel.addRow(rowData);
            }
            i++;
        }
    }
}
