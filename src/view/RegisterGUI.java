package view;
import java.awt.*;
import javax.swing.*;
public class RegisterGUI{
    private MyPanel p1;
    private JLabel l1, l2, l3, l4, l5;
    private JTextField f1;
    private JPasswordField f2, f3;
    private JButton btn1, btn2;
    private GridBagConstraints gbc;
    public RegisterGUI(){
        p1 = Helper.createPanel("/images/bg.jpg");
        l1 = Helper.createLabel("Register ", 30);
        l1.setHorizontalAlignment(JLabel.CENTER);
        l2 = Helper.createLabel("Username ");
        l3 = Helper.createLabel("Password ");
        l4 = Helper.createLabel("Confirm password ");
        l5 = Helper.createLabel("");
        l5.setHorizontalAlignment(JLabel.CENTER);
        btn1 = Helper.createButton("Register");
        btn2 = Helper.createButton("Back");
        f1 = Helper.createTextField(30);
        f2 = Helper.createPasswordField(30);
        f3 = Helper.createPasswordField(30);


        gbc = new GridBagConstraints();
        p1.setLayout(new GridBagLayout());
        
        
        gbc.insets = new Insets(240, 0, 20, 0);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridwidth = 2;
        p1.add(l1, gbc);
        gbc.insets = new Insets(5, 0, 5, 0);
        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = 1;
        p1.add(l2, gbc);
        gbc.gridx = 0;
        gbc.gridy = 2;
        p1.add(f1, gbc);
        gbc.gridx = 0;
        gbc.gridy = 3;
        p1.add(l3, gbc);
        gbc.gridx = 0;
        gbc.gridy = 4;
        p1.add(f2, gbc);
        gbc.gridx = 0;
        gbc.gridy = 5;
        p1.add(l4, gbc);
        gbc.gridx = 0;
        gbc.gridy = 6;
        p1.add(f3, gbc);
        gbc.gridx = 0;
        gbc.gridy = 7;
        p1.add(l5, gbc);
        gbc.gridx = 0;
        gbc.gridy = 8;
        p1.add(btn1, gbc);
        gbc.gridx = 0;
        gbc.gridy = 9;
        p1.add(btn2, gbc);
    }
    public RegisterGUI getGUI(){
        return this;
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
    public JPasswordField getF2(){
        return this.f2;
    }
    public JPasswordField getF3(){
        return this.f3;
    }
    public MyPanel getPanel(){
        return this.p1;
    }
    public JLabel getL5() {
    	return this.l5;
    }

}