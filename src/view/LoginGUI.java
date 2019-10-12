package view;
import java.awt.*;
import javax.swing.*;
public class LoginGUI{
    private JButton btn1, btn2;
    private JPanel p1;
    private JLabel l1, l2;
    private JTextField f1, f2;
    private GridBagConstraints gbc;
    public LoginGUI(){
        btn1 = new JButton("Login");
        btn2 = new JButton("Register");
        l1 = new JLabel("User name : ");
        l2 = new JLabel("Password : ");
        f1 = new JTextField(20);
        f2 = new JTextField(20);
        p1 = new JPanel();
        gbc = new GridBagConstraints();
        p1.setLayout(new GridBagLayout());
        gbc.gridx = 0;
        gbc.gridy = 0;
        p1.add(l1, gbc);
        gbc.gridx = 1;
        gbc.gridy = 0;
        p1.add(f1, gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        p1.add(l2, gbc);
        gbc.gridx = 1;
        gbc.gridy = 1;
        p1.add(f2, gbc);
        gbc.gridx = 0;
        gbc.gridy = 2;
        p1.add(btn1, gbc);
        gbc.gridx = 1;
        gbc.gridy = 2;
        p1.add(btn2, gbc);
    }
    public LoginGUI getGUI(){
        return this;
    }
    public JPanel getPanel(){
        return this.p1;
    }
    public JButton getBtn1(){
        return this.btn1;
    }
}