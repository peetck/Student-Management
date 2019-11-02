package view;
import java.awt.*;

import javax.swing.*;
public class MainGUI{
    private JFrame fr;
    private LoginGUI login;
    private RegisterGUI register;
    private ManagementGUI management;
    private Image programIcon;
    public MainGUI(){
        fr = new JFrame("Student Management");
        login = new LoginGUI();
        register = new RegisterGUI();
        management = new ManagementGUI();
        fr.setSize(1200, 730); // 1200 * 700 (730 because title bar)
        fr.setResizable(false);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        programIcon = Helper.createImage("/images/icon.png");
        fr.setIconImage(programIcon);
        fr.setVisible(true);
        fr.setLocationRelativeTo(null);
    }
    public void set(String select){
        if (select.equals("LoginGUI")){
            login.getF1().setText("");
            login.getF2().setText("");
            login.getL3().setText("");
            fr.setContentPane(login.getPanel());
            fr.revalidate();
            fr.repaint();
        }
        else if (select.equals("RegisterGUI")){
        	register.getF1().setText("");
            register.getF2().setText("");
            register.getF3().setText("");
            register.getL5().setText("");
            fr.setContentPane(register.getPanel());
            fr.revalidate();
            fr.repaint();
        }
        else if (select.equals("ManagementGUI")){
            fr.setContentPane(management.getPanel());
            fr.revalidate();
            fr.repaint();
        }
    }
    public LoginGUI getLoginGUI(){
        return this.login;
    }
    public RegisterGUI getRegisterGUI(){
        return this.register;
    }
    public ManagementGUI getManagementGUI() {
    	return this.management;
    }
    public JFrame getFrame() {
    	return this.fr;
    }


}