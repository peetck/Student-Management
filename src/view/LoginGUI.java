package view;
import java.awt.*;
import javax.swing.*;
public class LoginGUI{
    private JButton btn1, btn2;
    private JPanel p1;
    private JLabel l1, l2;
    private JTextField f1;
    private JPasswordField f2;
    private GridBagConstraints gbc;
    public LoginGUI(){
        btn1 = new JButton("Login");
        btn2 = new JButton("Register");
        l1 = new JLabel("User name : ");
        l2 = new JLabel("Password : ");
        f1 = new JTextField(20);
        f2 = new JPasswordField(20);
        p1 = new JPanel();
        gbc = new GridBagConstraints();
        p1.setLayout(new GridBagLayout());
        gbc.insets = new Insets(5, 5, 5, 5);
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
    public JButton getBtn2(){
        return this.btn2;
    }
    public JTextField getF1(){
        return this.f1;
    }
    public JTextField getF2(){
        return this.f2;
    }
}