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
        username = new JTextField("");
        password = new JTextField("");
        p1 = new JPanel();
        p2 = new JPanel();
        p3 = new JPanel();
        p4 = new JPanel();
        p1.setLayout(new GridLayout(3, 1));
        p2.setLayout(new GridLayout(1, 2));
        p3.setLayout(new GridLayout(1, 2));

        p2.add(l1);
        p2.add(username);
        p3.add(l2);
        p3.add(password);

        p1.add(p2);
        p1.add(p3);

        p4.add(loginButton);
        p4.add(registerButton);
        p1.add(p4);

        fr.add(p1, BorderLayout.CENTER);
        fr.add(new JPanel(), BorderLayout.EAST);
        fr.add(new JPanel(), BorderLayout.SOUTH);
        fr.add(new JPanel(), BorderLayout.WEST);
        fr.add(new JPanel(), BorderLayout.NORTH);
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