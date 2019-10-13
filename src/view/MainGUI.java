package view;
import java.awt.*;
import javax.swing.*;
import java.net.URL;
public class MainGUI{
    private JFrame fr;
    private LoginGUI login;
    private RegisterGUI register;
    private ManagementGUI management;
    public MainGUI(){
        fr = new JFrame("Student Management");
        login = new LoginGUI();
        register = new RegisterGUI();
        management = new ManagementGUI();
        fr.setSize(800, 500);
        fr.setVisible(true);
        //fr.setResizable(false);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void set(String select){
        if (select.equals("LoginGUI")){
            login.getF1().setText("");
            login.getF2().setText("");
            login.getL3().setText("");


            /* URL imageURL = MainGUI.class.getResource("bg.png");
            ImageIcon image = new ImageIcon(imageURL);
            JLabel bg = new JLabel(image);
            fr.getContentPane().add(bg, BorderLayout.WEST);
            fr.getContentPane().add(login.getPanel()); */

            fr.setContentPane(login.getPanel());
            fr.repaint();
            fr.revalidate();
        }
        else if (select.equals("RegisterGUI")){
            fr.setContentPane(register.getPanel());
            fr.repaint();
            fr.revalidate();
        }
        else if (select.equals("ManagementGUI")){
            fr.setContentPane(management.getPanel());
            fr.repaint();
            fr.revalidate();
        }
    }
    public LoginGUI getLoginGUI(){
        return this.login;
    }
    public RegisterGUI getRegisterGUI(){
        return this.register;
    }
}