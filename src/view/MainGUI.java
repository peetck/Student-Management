package view;
import java.awt.*;
import javax.swing.*;
public class MainGUI{
    private JFrame fr;
    private JButton loginButton, registerButton;
    private JPanel p1, p2, p3, p4;
    private JLabel l1, l2;
    private JTextField username, password;
    public MainGUI(){
        fr = new JFrame("Student Management");
        loginButton = new JButton("Login");
        registerButton = new JButton("Register");
        l1 = new JLabel("User name : ");
        l2 = new JLabel("Password : ");
        username = new JTextField(20);
        password = new JTextField(20);
        p1 = new JPanel();
        p1.setLayout(new GridBagLayout());

        p1.add(l1);
        p1.add(username);
        p1.add(l2);
        p1.add(password);
        p1.add(loginButton);
        p1.add(registerButton);

        fr.add(p1);
        fr.setSize(800, 500);
        fr.setVisible(true);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public JButton getLoginButton(){
        return this.loginButton;
    }
    public JButton getRegisterButton(){
        return this.registerButton;
    }
}