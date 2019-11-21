package view;
import java.awt.*;

import javax.swing.*;

public class LoginGUI{
    private JButton btn1, btn2;
    private JDesktopPane desktop, linkPanel;
    private JPanel link, p1, href, connectp;
    private JLabel l1, l2, l3, l4, title, github, connect, unconnect;
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
        
        connectp = Helper.createPanel("");
        connectp.setBackground(Color.white);
        connectp.setSize(60, 60);
        connectp.setLocation(0, 0);

        connect = Helper.createLabel("", "/images/connected.png", 50, 50);
        connect.setVisible(false);
        unconnect = Helper.createLabel("", "/images/unconnected.png", 50, 50);
        unconnect.setVisible(false);
        
        github = Helper.createLabel("", "/images/github.png", 50, 50);
        
        
        href.add(github);
        
        connectp.add(connect);
        connectp.add(unconnect);
        
        
        linkPanel.add(href);
        linkPanel.add(connectp);
        
        link.add(linkPanel);
        
        
        
        btn1 = Helper.createButton("ล็อกอิน");
        btn2 = Helper.createButton("ตั้งค่าฐานข้อมูล");
        
        title = Helper.createLabel("Student Management", 30, true);
        title.setHorizontalAlignment(JLabel.CENTER);
        
        l1 = Helper.createLabel("ชื่อผู้ใช้ ");
        l2 = Helper.createLabel("รหัสผ่าน ");
        
        l3 = Helper.createLabel("");
        l3.setForeground(Color.red);
        l3.setHorizontalAlignment(JLabel.CENTER);
        
        l4 = Helper.createLabel("ยังไม่มีบัญชีเหรอ? สมัครเลย.");
        l4.setHorizontalAlignment(JLabel.CENTER);
        
        f1 = Helper.createTextField(30);
        f2 = Helper.createPasswordField(30);
        
        

        gbc = new GridBagConstraints();
        p1.setLayout(new GridBagLayout());
        gbc.fill = GridBagConstraints.BOTH;

        gbc.insets = new Insets(220, 0, 30, 0);
        gbc.gridx = 0;
        gbc.gridy = 0;
        p1.add(title, gbc);
       
        gbc.insets = new Insets(30, 0, 5, 0);
        gbc.gridx = 0;
        gbc.gridy = 1;
        p1.add(l1, gbc);
        gbc.insets = new Insets(3, 0, 3, 0);
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
        p1.add(btn2, gbc);
        gbc.gridx = 0;
        gbc.gridy = 8;
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
    public JButton getBtn2() {
    	return this.btn2;
    }
    public void connected(boolean check) {
		/*desktop.revalidate();
		desktop.repaint();*/
		if (check) {
			connect.setVisible(true);
	    	unconnect.setVisible(false);
		}
		else {
			connect.setVisible(false);
	    	unconnect.setVisible(true);
		}
    }
}