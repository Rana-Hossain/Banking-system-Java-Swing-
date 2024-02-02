import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.List;
import java.util.Random;

public class CreateAccount extends JFrame implements ActionListener {

    private JPanel panel;
    private JTextField textField;
    private JPasswordField passwordField;
    private JButton b1, b2;
    private JComboBox<String> comboBox;
    private JTextField emailTextField;
    private JTextField numberTextField;
    private JTextField balanceTextField;

    private List<UserData> userList;

    public static void main(String[] args) {
        new CreateAccount().setVisible(true);
    }

    public CreateAccount() {
        setBackground(new Color(169, 169, 169));
        setBounds(600, 300, 600, 400);

        panel = new JPanel();
        panel.setBackground(new Color(176, 224, 230));
        setContentPane(panel);
        panel.setLayout(null);

        JLabel l1 = new JLabel("Name : ");
        l1.setBounds(124, 89, 95, 24);
        panel.add(l1);

        JLabel l2 = new JLabel("Password : ");
        l2.setBounds(124, 124, 95, 24);
        panel.add(l2);

        JLabel l3 = new JLabel("Email : ");
        l3.setBounds(124, 159, 95, 24);
        panel.add(l3);

        JLabel l4 = new JLabel("Number : ");
        l4.setBounds(124, 194, 95, 24);
        panel.add(l4);

        JLabel l5 = new JLabel("Account Type : ");
        l5.setBounds(124, 229, 95, 24);
        panel.add(l5);

        JLabel l6 = new JLabel("Initial Balance : ");
        l6.setBounds(124, 264, 95, 24);
        panel.add(l6);

        b1 = new JButton("Create Account");
        b1.addActionListener(this);

        b1.setForeground(new Color(205, 92, 92));
        b1.setBackground(new Color(253, 245, 230));
        b1.setBounds(109, 299, 179, 39);
        panel.add(b1);

        b2 = new JButton("Back");
        b2.addActionListener(this);

        b2.setForeground(new Color(205, 92, 92));
        b2.setBackground(new Color(253, 245, 230));
        b2.setBounds(309, 299, 179, 39);
        panel.add(b2);

        textField = new JTextField();
        textField.setBounds(210, 93, 157, 20);
        panel.add(textField);

        passwordField = new JPasswordField();
        passwordField.setBounds(210, 128, 157, 20);
        panel.add(passwordField);

        emailTextField = new JTextField();
        emailTextField.setBounds(210, 163, 157, 20);
        panel.add(emailTextField);

        numberTextField = new JTextField();
        numberTextField.setBounds(210, 198, 157, 20);
        panel.add(numberTextField);

        String[] accountTypes = { "Current", "Saving", "Salary" };
        comboBox = new JComboBox<>(accountTypes);
        comboBox.setBounds(210, 233, 157, 20);
        panel.add(comboBox);

        balanceTextField = new JTextField();
        balanceTextField.setBounds(210, 268, 157, 20);
        panel.add(balanceTextField);

        userList = UserDataManager.getUserList();

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == b1) {
            // Handle button click
            String accountType = (String) comboBox.getSelectedItem();
            String initialBalance = balanceTextField.getText();
            if (accountType == "Current") {
                if (Integer.parseInt(initialBalance) < 10000) {
                    JOptionPane.showMessageDialog(this, "You Have TO Deposite Minimum 10000 For Current Account",
                            "Check",
                            JOptionPane.INFORMATION_MESSAGE);
                } else {
                    insertUserData();
                    JOptionPane.showMessageDialog(this, "Account created successfully!", "Success",
                            JOptionPane.INFORMATION_MESSAGE);
                    setVisible(false);
                    Home su = new Home();
                    su.setVisible(true);
                }
            } else if (accountType == "Saving") {
                if (Integer.parseInt(initialBalance) < 20000) {
                    JOptionPane.showMessageDialog(this, "You Have TO Deposite Minimum 20000 For Saving Account",
                            "Check",
                            JOptionPane.INFORMATION_MESSAGE);
                } else {
                    insertUserData();
                    JOptionPane.showMessageDialog(this, "Account created successfully!", "Success",
                            JOptionPane.INFORMATION_MESSAGE);
                    setVisible(false);
                    Home su = new Home();
                    su.setVisible(true);
                }
            } else if (accountType == "Salary") {
                if (Integer.parseInt(initialBalance) < 15000) {
                    JOptionPane.showMessageDialog(this, "You Have TO Deposite Minimum 15000 For Salary Account",
                            "Check",
                            JOptionPane.INFORMATION_MESSAGE);
                } else {
                    insertUserData();
                    JOptionPane.showMessageDialog(this, "Account created successfully!", "Success",
                            JOptionPane.INFORMATION_MESSAGE);
                    setVisible(false);
                    Home su = new Home();
                    su.setVisible(true);
                }
            }
        }
        if (e.getSource() == b2) {
            setVisible(false);
            Home su = new Home();
            su.setVisible(true);
        }
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }

    private void insertUserData() {
        // Retrieve input data
        String accountId = generateRandomDigits(8);
        String name = textField.getText();
        String password = new String(passwordField.getPassword());
        String email = emailTextField.getText();
        String number = numberTextField.getText();
        String accountType = (String) comboBox.getSelectedItem();
        String initialBalance = balanceTextField.getText();

        // Create UserData object
        UserData userData = new UserData(accountId, name, password, email, number, accountType, initialBalance);

        // Add user data to the list
        userList.add(userData);
        UserDataManager.addUser(userData);
    }

    private String generateRandomDigits(int length) {
        Random random = new Random();
        StringBuilder sb = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            sb.append(random.nextInt(10)); // Append a random digit (0-9)
        }

        return sb.toString();
    }
}
