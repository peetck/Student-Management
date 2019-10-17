package view;
import java.awt.*;
import javax.swing.*;
public class RegisterGUI{
    private MyPanel p1;
    private JLabel l1, l2, l3, l4;
    private JTextField f1;
    private JPasswordField f2, f3;
    private JButton btn1, btn2;
    private GridBagConstraints gbc;
    public RegisterGUI(){
        p1 = Helper.createPanel("images/bg.png");
        l1 = Helper.createLabel("Register");
        l2 = Helper.createLabel("Username : ");
        l3 = Helper.createLabel("Password : ");
        l4 = Helper.createLabel("Confirm password : ");
        btn1 = Helper.createButton("Register");
        btn2 = Helper.createButton("Back");
        f1 = Helper.createTextField(20);
        f2 = Helper.createPasswordField(20);
        f3 = Helper.createPasswordField(20);


        gbc = new GridBagConstraints();
        p1.setLayout(new GridBagLayout());
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.gridwidth = 2;
        p1.add(l1, gbc);
        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = 1;
        p1.add(l2, gbc);
        gbc.gridx = 1;
        gbc.gridy = 1;
        p1.add(f1, gbc);
        gbc.gridx = 0;
        gbc.gridy = 2;
        p1.add(l3, gbc);
        gbc.gridx = 1;
        gbc.gridy = 2;
        p1.add(f2, gbc);
        gbc.gridx = 0;
        gbc.gridy = 3;
        p1.add(l4, gbc);
        gbc.gridx = 1;
        gbc.gridy = 3;
        p1.add(f3, gbc);
        gbc.gridx = 0;
        gbc.gridy = 4;
        p1.add(btn1, gbc);
        gbc.gridx = 1;
        gbc.gridy = 4;
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

}