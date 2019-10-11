package view;
import java.awt.*;
import javax.swing.*;
public class MainGUI{
    private JFrame fr;
    private JButton loginButton, registerButton;
    private JPanel p1, p2, p3, p4;
    private JLabel l1, l2;
    private JTextField username, password;
    private GridBagConstraints gbc;
    public MainGUI(){
        fr = new JFrame("Student Management");
        loginButton = new JButton("Login");
        registerButton = new JButton("Register");
        l1 = new JLabel("User name : ");
        l2 = new JLabel("Password : ");
        username = new JTextField(20);
        password = new JTextField(20);
        p1 = new JPanel();
        gbc = new GridBagConstraints();

        p1.setLayout(new GridBagLayout());
        gbc.gridx = 0;
        gbc.gridy = 0;
        p1.add(l1);
        gbc.gridx = 1;
        gbc.gridy = 0;
        p1.add(username);
        gbc.gridx = 0;
        gbc.gridy = 1;
        p1.add(l2);
        gbc.gridx = 1;
        gbc.gridy = 1;
        p1.add(password);
        gbc.gridx = 0;
        gbc.gridy = 2;
        p1.add(loginButton);
        gbc.gridx = 1;
        gbc.gridy = 2;
        p1.add(registerButton);

        fr.add(p1);
        fr.setSize(800, 500);
        fr.setVisible(true);
        fr.setResizable(false);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public JButton getLoginButton(){
        return this.loginButton;
    }
    public JButton getRegisterButton(){
        return this.registerButton;
    }
}