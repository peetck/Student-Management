package view;
import java.awt.*;
import javax.swing.*;
public class MainGUI{
    private JFrame fr;
    private LoginGUI login;
    private RegisterGUI register;
    public MainGUI(){
        fr = new JFrame("Student Management");
        login = new LoginGUI();
        register = new RegisterGUI();
        fr.setSize(800, 500);
        fr.setVisible(true);
        fr.setResizable(false);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void set(String select){
        if (select.equals("LoginGUI")){
            fr.setContentPane(login.getPanel());
        }
        else if (select.equals("RegisterGUI")){
            fr.setContentPane(register.getPanel());
        }
    }
    public LoginGUI getLoginGUI(){
        return this.login;
    }
    public RegisterGUI getRegisterGUI(){
        return this.register;
    }
}