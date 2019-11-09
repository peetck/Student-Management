package view;
import java.awt.*;

import javax.swing.*;

public class LoginGUI{
    private JButton btn1;
    private JDesktopPane desktop, linkPanel;
    private MyPanel link, p1, href;
    private JLabel l1, l2, l3, l4, title, github;
    private JTextField f1;
    private JPasswordField f2;
    private GridBagConstraints gbc;
    public LoginGUI(){

    	desktop = new JDesktopPane();
    	
        p1 =  Helper.createPanel("/images/bg.jpg");
        p1.setSize(1200, 630);
        p1.setLocation(0, 0);
        
        link = Helper.createPanel("");
        link.setLayout(new BorderLayout());
        link.setSize(1200, 70);
        link.setLocation(0, 630);
        
        linkPanel = new JDesktopPane();
        linkPanel.setBackground(Color.white);
        
        href = Helper.createPanel("");
        href.setBackground(Color.white);
        href.setSize(60, 60);
        href.setLocation(1110, 0);

        
        github = Helper.createLabel("", "/images/github.png", 50, 50);
        
        
        href.add(github);
        
        linkPanel.add(href);
        
        link.add(linkPanel);
        
        
        btn1 = Helper.createButton("Login");
        
        title = Helper.createLabel("Student Management", 30, true);
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

        gbc.insets = new Insets(280, 0, 30, 0);
        gbc.gridx = 0;
        gbc.gridy = 0;
        p1.add(title, gbc);
       
        gbc.insets = new Insets(25, 0, 5, 0);
        gbc.gridx = 0;
        gbc.gridy = 1;
        p1.add(l1, gbc);
        gbc.insets = new Insets(5, 0, 5, 0);
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
        

        
        desktop.add(p1);
        desktop.add(link);

    }
    public LoginGUI getGUI(){
        return this;
    }
    public JDesktopPane getPanel(){
        return this.desktop;
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
    public JLabel getGithub() {
    	return this.github;
    }
}