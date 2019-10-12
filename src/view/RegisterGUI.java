package view;
import java.awt.*;
import javax.swing.*;
public class RegisterGUI{
    private JPanel p1;
    private JLabel l1, l2, l3, l4;
    private JTextField f1;
    private JPasswordField f2, f3;
    private JButton btn1, btn2;
    private GridBagConstraints gbc;
    public RegisterGUI(){
        p1 = new JPanel();
        l1 = new JLabel("Register");
        l2 = new JLabel("Username : ");
        l3 = new JLabel("Password : ");
        l4 = new JLabel("Confirm password : ");
        btn1 = new JButton("Register");
        btn2 = new JButton("Back");
        f1 = new JTextField(20);
        f2 = new JPasswordField(20);
        f3 = new JPasswordField(20);
        gbc = new GridBagConstraints();

        p1.setLayout(new GridBagLayout());
        p1.add(l1, gbc);
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
    public JPanel getPanel(){
        return this.p1;
    }

}