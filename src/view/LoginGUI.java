package view;
import java.awt.*;
import javax.swing.*;
public class LoginGUI{
    private JButton btn1, btn2;
    private MyPanel p1;
    private JLabel l1, l2, l3;
    private JTextField f1;
    private JPasswordField f2;
    private GridBagConstraints gbc;
    public LoginGUI(){

        p1 =  Helper.createPanel("images/bg.png");
        btn1 = Helper.createButton("Login");
        btn2 = Helper.createButton("Register");
        l1 = Helper.createLabel("Username ");
        l2 = Helper.createLabel("Password ");
        l3 = Helper.createLabel("");
        l3.setForeground(Color.red);
        f1 = Helper.createTextField(20);
        f2 = Helper.createPasswordField(29);


        gbc = new GridBagConstraints();
        p1.setLayout(new GridBagLayout());
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 0;
        gbc.gridy = 0;
        p1.add(l1, gbc);
        gbc.gridx = 1;
        gbc.gridy = 0;
        p1.add(f1, gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        p1.add(l2, gbc);
        gbc.gridx = 1;
        gbc.gridy = 1;
        p1.add(f2, gbc);
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        p1.add(l3, gbc);
        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = 3;
        p1.add(btn1, gbc);
        gbc.gridx = 1;
        gbc.gridy = 3;
        p1.add(btn2, gbc);

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
    public JButton getBtn2(){
        return this.btn2;
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
}