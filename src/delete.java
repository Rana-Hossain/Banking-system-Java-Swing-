import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.List;

public class delete extends JFrame implements ActionListener {

    private JPanel panel;
    private JTextField idField;
    private JButton b1,b2;
    private static List<UserData> userList;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new delete().setVisible(true));
    }

    public delete() {
        setBackground(new Color(169, 169, 169));
        setBounds(600, 300, 600, 400);

        panel = new JPanel();
        panel.setBackground(new Color(176, 224, 230));
        setContentPane(panel);
        panel.setLayout(null);

        JLabel l0 = new JLabel("Enter Account ID to Delete: ");
        l0.setBounds(124, 54, 200, 24);
        panel.add(l0);

        idField = new JTextField();
        idField.setBounds(330, 55, 157, 20);
        panel.add(idField);

        b1 = new JButton("Delete Account");
        b1.addActionListener(this);
        b1.setForeground(new Color(205, 92, 92));
        b1.setBackground(new Color(253, 245, 230));
        b1.setBounds(109, 150, 179, 39);
        panel.add(b1);

        b2 = new JButton("Back");
        b2.addActionListener(this);

        b2.setForeground(new Color(205, 92, 92));
        b2.setBackground(new Color(253, 245, 230));
        b2.setBounds(309, 150, 179, 39);
        panel.add(b2);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == b1) {
            String accountId = idField.getText();
            deleteUserData(accountId);
        }
        if (e.getSource() == b2) {
            setVisible(false);
            Home ca = new Home();
            ca.setVisible(true);
        }

        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }

    public void deleteUserData(String accountId) {
        // Retrieve the user list
        userList = UserDataManager.getUserList();

        // Iterate through the list to find the user with the specified account ID
        for (UserData user : userList) {
            if (user.getID().equals(accountId)) {
                int confirmation = JOptionPane.showConfirmDialog(null,
                        "Are you sure you want to delete this account?", "Confirmation", JOptionPane.YES_NO_OPTION);

                if (confirmation == JOptionPane.YES_OPTION) {

                    user.setID("");
                    user.setName("");
                    user.setPassword("");
                    user.setEmail("");
                    user.setNumber("");
                    user.setBalance("");

                    JOptionPane.showMessageDialog(null, "User account deleted successfully", "Success",
                        JOptionPane.INFORMATION_MESSAGE);
                    UserDataManager.updateUser(userList);
                    break;
                }
            }
        }
    }
    
}
