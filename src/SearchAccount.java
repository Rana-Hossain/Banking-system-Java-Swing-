import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.util.List;

public class SearchAccount extends JFrame implements ActionListener{

    private JPanel panel;
    private JTextField idField;
    private JTextField nameField;
    private JTextField passField;
    private JTextField emailField;
    private JTextField numberField;
    private JTextField accountTypeField;
    private JTextField balanceField;
    private JButton b1, b2;
    private static List<UserData> userList;
    

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new SearchAccount().setVisible(true));
    }

    public SearchAccount(){
        setBackground(new Color(169, 169, 169));
        setBounds(600, 300, 600, 400);

        panel = new JPanel();
        panel.setBackground(new Color(176, 224, 230));
        setContentPane(panel);
        panel.setLayout(null);

        JLabel l0 = new JLabel("Enter Account ID : ");
        l0.setBounds(124, 54, 200, 24);
        panel.add(l0);

        JLabel l1 = new JLabel("Name : ");
        l1.setBounds(124, 89, 200, 24);
        panel.add(l1);

        JLabel l2 = new JLabel("Password : ");
        l2.setBounds(124, 124, 200, 24);
        panel.add(l2);

        JLabel l3 = new JLabel("Email : ");
        l3.setBounds(124, 159, 200, 24);
        panel.add(l3);

        JLabel l4 = new JLabel("Number : ");
        l4.setBounds(124, 194, 200, 24);
        panel.add(l4);

        JLabel l5 = new JLabel("Account Type : ");
        l5.setBounds(124, 229, 200, 24);
        panel.add(l5);

        JLabel l6 = new JLabel("Balance : ");
        l6.setBounds(124, 264, 200, 24);
        panel.add(l6);

        idField = new JTextField();
        idField.setBounds(270, 55, 157, 20);
        panel.add(idField);

        nameField = new JTextField();
        nameField.setBounds(270, 90, 157, 20);
        nameField.setEditable(false);
        panel.add(nameField);

        passField = new JTextField();
        passField.setBounds(270, 125, 157, 20);
        passField.setEditable(false);
        panel.add(passField);

        emailField = new JTextField();
        emailField.setBounds(270, 160, 157, 20);
        emailField.setEditable(false);
        panel.add(emailField);

        numberField = new JTextField();
        numberField.setBounds(270, 195, 157, 20);
        numberField.setEditable(false);
        panel.add(numberField);

        accountTypeField = new JTextField();
        accountTypeField.setBounds(270, 230, 157, 20);
        accountTypeField.setEditable(false);
        panel.add(accountTypeField);

        balanceField = new JTextField();
        balanceField.setBounds(270, 265, 157, 20);
        balanceField.setEditable(false);
        panel.add(balanceField);

        b1 = new JButton("Search");
        b1.addActionListener(this);
        b1.setForeground(new Color(205, 92, 92));
        b1.setBackground(new Color(253, 245, 230));
        b1.setBounds(109, 300, 179, 39);
        panel.add(b1);

        b2 = new JButton("Back");
        b2.addActionListener(this);

        b2.setForeground(new Color(205, 92, 92));
        b2.setBackground(new Color(253, 245, 230));
        b2.setBounds(309, 300, 179, 39);
        panel.add(b2);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            String accountId = idField.getText();
            search(accountId);
        }
        if (e.getSource() == b2) {
            setVisible(false);
            Home ca = new Home();
            ca.setVisible(true);
        }
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }

    public void search(String accountId){
        userList = UserDataManager.getUserList();
        for(UserData user:userList)
        {
            if (user.getID().equals(accountId)){
                nameField.setText(user.getName());
                passField.setText("********");
                emailField.setText(user.getEmail());
                numberField.setText(user.getNumber());
                accountTypeField.setText(user.getAccountType());
                balanceField.setText(user.getInitialBalance());
                break;
            }
        }
    }
    
}
