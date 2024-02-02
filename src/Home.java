
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Home extends JFrame implements ActionListener {

    private JPanel panel;
    private JButton b1, b2, b3, b4, b5, b6, b7, b8;

    public static void main(String[] args) {
        new Home().setVisible(true);
    }

    public Home() {

        setBackground(new Color(169, 169, 169));
        setBounds(600, 300, 600, 400);

        panel = new JPanel();
        panel.setBackground(new Color(176, 224, 230));
        setContentPane(panel);
        panel.setLayout(null);

        b1 = new JButton("Create New Account");
        b1.addActionListener(this);

        b1.setForeground(new Color(205, 92, 92));
        b1.setBackground(new Color(253, 245, 230));
        b1.setBounds(209, 10, 179, 39);
        panel.add(b1);

        b2 = new JButton("Display All Acount");
        b2.addActionListener(this);

        b2.setForeground(new Color(205, 92, 92));
        b2.setBackground(new Color(253, 245, 230));
        b2.setBounds(209, 55, 179, 39);
        panel.add(b2);

        b3 = new JButton("Update Acount");
        b3.addActionListener(this);

        b3.setForeground(new Color(205, 92, 92));
        b3.setBackground(new Color(253, 245, 230));
        b3.setBounds(209, 100, 179, 39);
        panel.add(b3);

        b4 = new JButton("Delete Acount");
        b4.addActionListener(this);

        b4.setForeground(new Color(205, 92, 92));
        b4.setBackground(new Color(253, 245, 230));
        b4.setBounds(209, 145, 179, 39);
        panel.add(b4);

        b5 = new JButton("Deposit");
        b5.addActionListener(this);

        b5.setForeground(new Color(205, 92, 92));
        b5.setBackground(new Color(253, 245, 230));
        b5.setBounds(209, 190, 179, 39);
        panel.add(b5);

        b6 = new JButton("Withdraw");
        b6.addActionListener(this);

        b6.setForeground(new Color(205, 92, 92));
        b6.setBackground(new Color(253, 245, 230));
        b6.setBounds(209, 235, 179, 39);
        panel.add(b6);

        b7 = new JButton("Search Account");
        b7.addActionListener(this);

        b7.setForeground(new Color(205, 92, 92));
        b7.setBackground(new Color(253, 245, 230));
        b7.setBounds(209, 280, 179, 39);
        panel.add(b7);

        b8 = new JButton("Exit");
        b8.addActionListener(this);

        b8.setForeground(new Color(205, 92, 92));
        b8.setBackground(new Color(253, 245, 230));
        b8.setBounds(209, 325, 179, 39);
        panel.add(b8);

        JPanel panel2 = new JPanel();
        panel2.setBackground(new Color(176, 224, 230));
        panel2.setBounds(24, 40, 434, 263);
        panel.add(panel2);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b1) {
            setVisible(false);
            CreateAccount ca = new CreateAccount();
            ca.setVisible(true);
        }
        if (ae.getSource() == b2) {
            setVisible(false);
            DisplayAccount ca = new DisplayAccount();
            ca.setVisible(true);
        }
        if (ae.getSource() == b3) {
            setVisible(false);
            UpdateAccount ca = new UpdateAccount();
            ca.setVisible(true);
        }
        if (ae.getSource() == b4) {
            setVisible(false);
            delete ca = new delete();
            ca.setVisible(true);
        }
        if (ae.getSource() == b5) {
            setVisible(false);
            Deposite ca = new Deposite();
            ca.setVisible(true);
        }
        if (ae.getSource() == b6) {
            setVisible(false);
            Withdraw ca = new Withdraw();
            ca.setVisible(true);
        }
        if (ae.getSource() == b7) {
            setVisible(false);
            SearchAccount ca = new SearchAccount();
            ca.setVisible(true);
        }
        if (ae.getSource() == b8) {
            System.exit(0);
        }
    }
}
