import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.util.List;

public class Withdraw extends JFrame implements ActionListener {

    private JPanel panel;
    private JTextField idField;
    private JTextField withdrawField;
    private JButton b1, b2;
    private static List<UserData> userList;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Withdraw().setVisible(true));
    }

    public Withdraw() {
        setBackground(new Color(169, 169, 169));
        setBounds(600, 300, 600, 400);

        panel = new JPanel();
        panel.setBackground(new Color(176, 224, 230));
        setContentPane(panel);
        panel.setLayout(null);

        JLabel l0 = new JLabel("Enter Account ID : ");
        l0.setBounds(124, 54, 200, 24);
        panel.add(l0);

        JLabel l1 = new JLabel("Enter withdraw Amount : ");
        l1.setBounds(124, 90, 200, 24);
        panel.add(l1);

        idField = new JTextField();
        idField.setBounds(270, 55, 157, 20);
        panel.add(idField);

        withdrawField = new JTextField();
        withdrawField.setBounds(270, 91, 157, 20);
        panel.add(withdrawField);

        b1 = new JButton("withdraw");
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
            String balance = withdrawField.getText();
            withdraw(accountId, balance);
        }
        if (e.getSource() == b2) {
            setVisible(false);
            Home ca = new Home();
            ca.setVisible(true);
        }
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }

    public void withdraw(String accountId, String balance) {

        userList = UserDataManager.getUserList();
        for (UserData user : userList) {
            if (user.getID().equals(accountId)) {

                String type = user.getAccountType();
                int b = Integer.parseInt(user.getInitialBalance());
                if (type == "Current" && b < 10000) {

                    JOptionPane.showMessageDialog(this,
                            "You Have TO Minimum 10000 Account Balance to Withdraw In Current Account",
                            "Check",
                            JOptionPane.INFORMATION_MESSAGE);

                } else if (type == "Saving" && b < 20000) {

                    JOptionPane.showMessageDialog(this,
                            "You Have TO Minimum 10000 Account Balance to Withdraw In Saving Account",
                            "Check",
                            JOptionPane.INFORMATION_MESSAGE);

                } else if (type == "Salary" && b < 15000) {

                    JOptionPane.showMessageDialog(this,
                            "You Have TO Minimum 10000 Account Balance to Withdraw In Saving Account",
                            "Check",
                            JOptionPane.INFORMATION_MESSAGE);

                } else {
                    if (b < Integer.parseInt(balance)) {
                        JOptionPane.showMessageDialog(this,
                                "Insufficient Balance",
                                "Check",
                                JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        int confirmation = JOptionPane.showConfirmDialog(null,
                                "Are you sure you want to Withdraw this amount?", "Confirmation",
                                JOptionPane.YES_NO_OPTION);

                        if (confirmation == JOptionPane.YES_OPTION) {
                            int newBalance = Integer.parseInt(user.getInitialBalance()) - Integer.parseInt(balance);
                            String str = String.valueOf(newBalance);
                            System.out.println(str);
                            user.setBalance(str);
                            
                            JOptionPane.showMessageDialog(null, "Withdraw Amount Successfully", "Success",
                                    JOptionPane.INFORMATION_MESSAGE);
                            UserDataManager.updateUser(userList);
                            break;
                        }
                    }
                }
            }
        }
    }

}
