package view;
import javax.swing.*;
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
        fr.setSize(1200, 700);
        fr.setVisible(true);
        fr.setResizable(false);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setIconImage(new ImageIcon("images/icon.png").getImage());
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