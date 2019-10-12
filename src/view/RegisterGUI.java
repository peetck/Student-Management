package view;
import java.awt.*;
import javax.swing.*;
public class RegisterGUI{
    private JPanel p1;
    private JLabel l1, l2, l3, l4;
    private JTextField f1, f2, f3;
    private JButton btn1;
    private GridBagConstraints gbc;
    public RegisterGUI(){
        p1 = new JPanel();
        l1 = new JLabel("Register");
        l2 = new JLabel("Username : ");
        l3 = new JLabel("Password : ");
        l4 = new JLabel("Confirm password : ");
        btn1 = new JButton("Register");
        f1 = new JTextField(20);
        f2 = new JTextField(20);
        f3 = new JTextField(20);
        gbc = new GridBagConstraints();

        p1.setLayout(new GridBagLayout());
        p1.add(l1, gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        p1.add(l2, gbc);
        gbc.gridx = 1;
        gbc.gridy = 1;
        p1.add(f1, gbc);
        gbc.gridx = 0;
        gbc.gridy = 2;
        p1.add(l3, gbc);
        gbc.gridx = 1;
        gbc.gridy = 2;
        p1.add(f2, gbc);
        gbc.gridx = 0;
        gbc.gridy = 3;
        p1.add(l4, gbc);
        gbc.gridx = 1;
        gbc.gridy = 3;
        p1.add(f3, gbc);
        gbc.gridx = 0;
        gbc.gridy = 4;
        p1.add(btn1, gbc);
    }
    public RegisterGUI getGUI(){
        return this;
    }
    public JPanel getPanel(){
        return this.p1;
    }
}