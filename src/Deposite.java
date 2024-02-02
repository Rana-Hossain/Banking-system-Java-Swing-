import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.util.List;

public class Deposite extends JFrame implements ActionListener{

    private JPanel panel;
    private JTextField idField;
    private JTextField depositField;
    private JButton b1,b2;
    private static List<UserData> userList;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Deposite().setVisible(true));
    }

    public Deposite(){

        setBackground(new Color(169, 169, 169));
        setBounds(600, 300, 600, 400);

        panel = new JPanel();
        panel.setBackground(new Color(176, 224, 230));
        setContentPane(panel);
        panel.setLayout(null);

        JLabel l0 = new JLabel("Enter Account ID : ");
        l0.setBounds(124, 54, 200, 24);
        panel.add(l0);

        JLabel l1 = new JLabel("Enter Deposite Amount : ");
        l1.setBounds(124, 90, 200, 24);
        panel.add(l1);

        idField = new JTextField();
        idField.setBounds(270, 55, 157, 20);
        panel.add(idField);

        depositField = new JTextField();
        depositField.setBounds(270, 91, 157, 20);
        panel.add(depositField);

        b1 = new JButton("Deposite");
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
            String balance = depositField.getText();
            deposit(accountId,balance);
        }
        if (e.getSource() == b2) {
            setVisible(false);
            Home ca = new Home();
            ca.setVisible(true);
        }
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }

    public void deposit(String accountId,String balance){

        userList = UserDataManager.getUserList();
        for (UserData user : userList) {
            if (user.getID().equals(accountId)) {
                int confirmation = JOptionPane.showConfirmDialog(null,
                        "Are you sure you want to deposite this amount?", "Confirmation", JOptionPane.YES_NO_OPTION);

                if (confirmation == JOptionPane.YES_OPTION) {
                    int bal = Integer.parseInt(balance)+Integer.parseInt(user.getInitialBalance());
                    String str = String.valueOf(bal);
                    System.out.println(str);
                    user.setBalance(str);

                    JOptionPane.showMessageDialog(null, "Deposite Amount Successfully", "Success",
                            JOptionPane.INFORMATION_MESSAGE);
                    UserDataManager.updateUser(userList);
                    break;
                }
            }
        }
    }
}
