import java.awt.*;
import javax.swing.*;

public class Login {
    private JFrame fr;
    private JLabel login, user, password;
    private JPanel txt_login, user_inp, pass_inp, btn, sup;
    private JTextField us, pa;
    private JButton bt, create, remember;
    public void init(){
        fr = new JFrame("Login");
        txt_login = new JPanel();
        user_inp = new JPanel();
        pass_inp = new JPanel();
        btn = new JPanel();
        sup = new JPanel();
        
        login = new JLabel("Login");
        user = new JLabel("User");
        password = new JLabel("Password");
        
        bt = new JButton("Submit");
        create = new JButton("Create Account");
        remember = new JButton("Remember");
        
        us = new JTextField();
        pa = new JTextField();
        
        
        txt_login.setLayout(new BorderLayout());
        txt_login.add(login, BorderLayout.CENTER);
        
        user_inp.setLayout(new GridLayout(2, 1));
        user_inp.add(user);
        user_inp.add(us);
        
        pass_inp.setLayout(new GridLayout(2, 1));
        pass_inp.add(password);
        pass_inp.add(pa);
        
        btn.setLayout(new BorderLayout());
        btn.add(bt, BorderLayout.CENTER);
        
        sup.setLayout(new FlowLayout());
        sup.add(create);
        sup.add(new JLabel("    "));
        sup.add(remember);
        
        
        
        
        
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setLayout(new GridLayout(5, 1));
        
        
        
        
        fr.add(txt_login);
        fr.add(user_inp);
        fr.add(pass_inp);
        fr.add(btn);
        fr.add(sup);
        
        
        fr.setSize(600, 600);
        fr.setVisible(true);
    }
    public static void main(String[] args){
        new Login().init();
    }
    
}