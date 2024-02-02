import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.List;

public class UpdateAccount extends JFrame implements ActionListener {

    private JPanel panel;
    private JTextField idField;
    private JTextField textField;
    private JPasswordField prev_passwordField;
    private JPasswordField new_passwordField;
    private JTextField emailTextField;
    private JTextField numberTextField;
    private static List<UserData> userList;

    private JButton b1, b2;

    public static void main(String[] args) {
        new UpdateAccount().setVisible(true);
    }

    public UpdateAccount() {
        setBackground(new Color(169, 169, 169));
        setBounds(600, 300, 600, 400);

        panel = new JPanel();
        panel.setBackground(new Color(176, 224, 230));
        setContentPane(panel);
        panel.setLayout(null);

        JLabel l0 = new JLabel("Enter Account ID : ");
        l0.setBounds(124, 54, 120, 24);
        panel.add(l0);

        JLabel l1 = new JLabel("Previous Password : ");
        l1.setBounds(124, 89, 125, 24);
        panel.add(l1);

        JLabel l2 = new JLabel("New Password : ");
        l2.setBounds(124, 124, 110, 24);
        panel.add(l2);

        JLabel l3 = new JLabel("Update Name : ");
        l3.setBounds(124, 159, 95, 24);
        panel.add(l3);

        JLabel l4 = new JLabel("Update Email : ");
        l4.setBounds(124, 194, 100, 24);
        panel.add(l4);

        JLabel l5 = new JLabel("Update Number : ");
        l5.setBounds(124, 229, 100, 24);
        panel.add(l5);

        idField = new JTextField();
        idField.setBounds(250, 55, 157, 20);
        panel.add(idField);

    
        prev_passwordField = new JPasswordField();
        prev_passwordField.setBounds(250, 93, 157, 20);
        panel.add(prev_passwordField);

        new_passwordField = new JPasswordField();
        new_passwordField.setBounds(250, 128, 157, 20);
        panel.add(new_passwordField);

        textField = new JTextField();
        textField.setBounds(250, 163, 157, 20);
        panel.add(textField);

        emailTextField = new JTextField();
        emailTextField.setBounds(250, 198, 157, 20);
        panel.add(emailTextField);

        numberTextField = new JTextField();
        numberTextField.setBounds(250, 233, 157, 20);
        panel.add(numberTextField);

        b1 = new JButton("Update Account");
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
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            String accountId = idField.getText();
            String name = textField.getText();
            String prev_password = new String(prev_passwordField.getPassword());
            String new_password = new String(new_passwordField.getPassword());
            String email = emailTextField.getText();
            String number = numberTextField.getText();

            updateUserData(accountId, name, prev_password, new_password, email, number);
        }
        if (e.getSource() == b2) {
            setVisible(false);
            Home su = new Home();
            su.setVisible(true);
        }

        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }

    public static void updateUserData(String accountId, String newName, String prevPassword, String newPassword,
            String newEmail,
            String newNumber) {
        // Retrieve the user list
        userList = UserDataManager.getUserList();

        // Iterate through the list to find the user with the specified account ID
        int flag=0;
        for (UserData user : userList) {
            if (user.getID().equals(accountId)) {
                // Update the user data
                
                if (user.getPassword().equals(prevPassword)) {
                    if (!newName.isEmpty())
                        user.setName(newName);
                    if(!newPassword.isEmpty())
                        user.setPassword(newPassword);
                    if (!newEmail.isEmpty())
                        user.setEmail(newEmail);
                    if (!newNumber.isEmpty())
                        user.setNumber(newNumber);
                    JOptionPane.showMessageDialog(null, "Account Update Successfully", "Succes",
                        JOptionPane.INFORMATION_MESSAGE);
                    UserDataManager.updateUser(userList);
                }
                else{
                    JOptionPane.showMessageDialog(null, "Invalid Password", "Error",
                            JOptionPane.INFORMATION_MESSAGE);
                }

                // Optionally, you may notify UserDataManager to save changes
    

                // Break the loop since the user has been found and updated
                flag=1;
                break;
            }
        }
        if(flag==0){
            JOptionPane.showMessageDialog(null, "Invalid Account ID", "Error",
                            JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
