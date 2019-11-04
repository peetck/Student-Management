package view;
import java.awt.*;
import javax.swing.*;

public class LoginGUI{
    private JButton btn1;
    private MyPanel p1;
    private JLabel l1, l2, l3, l4, title;
    private JTextField f1;
    private JPasswordField f2;
    private GridBagConstraints gbc;
    public LoginGUI(){

        p1 =  Helper.createPanel("/images/bg.jpg");
        btn1 = Helper.createButton("Login");
        
        title = Helper.createLabel("Student Management", 20);
        title.setHorizontalAlignment(JLabel.CENTER);
        
        l1 = Helper.createLabel("Username ");
        l2 = Helper.createLabel("Password ");
        
        l3 = Helper.createLabel("");
        l3.setForeground(Color.red);
        l3.setHorizontalAlignment(JLabel.CENTER);
        
        l4 = Helper.createLabel("Create an account.");
        l4.setHorizontalAlignment(JLabel.CENTER);
        
        f1 = Helper.createTextField(30);
        f2 = Helper.createPasswordField(30);

        gbc = new GridBagConstraints();
        p1.setLayout(new GridBagLayout());
        gbc.fill = GridBagConstraints.BOTH;

        gbc.insets = new Insets(150, 0, 30, 0);
        gbc.gridx = 0;
        gbc.gridy = 0;
        p1.add(title, gbc);
       
        gbc.insets = new Insets(5, 0, 5, 0);
        gbc.gridx = 0;
        gbc.gridy = 1;
        p1.add(l1, gbc);
        gbc.gridx = 0;
        gbc.gridy = 2;
        p1.add(f1, gbc);
        gbc.gridx = 0;
        gbc.gridy = 3;
        p1.add(l2, gbc);
        gbc.gridx = 0;
        gbc.gridy = 4;

        p1.add(f2, gbc);
        gbc.gridwidth = 2;
        gbc.gridx = 0;
        gbc.gridy = 5;
        p1.add(l3, gbc);
        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = 6;
        p1.add(btn1, gbc);
        gbc.gridx = 0;
        gbc.gridy = 7;
        p1.add(l4, gbc);

    }
    public LoginGUI getGUI(){
        return this;
    }
    public MyPanel getPanel(){
        return this.p1;
    }
    public JButton getBtn1(){
        return this.btn1;
    }
    public JTextField getF1(){
        return this.f1;
    }
    public JTextField getF2(){
        return this.f2;
    }
    public JLabel getL3(){
        return this.l3;
    }
    public JLabel getL4() {
    	return this.l4;
    }
}