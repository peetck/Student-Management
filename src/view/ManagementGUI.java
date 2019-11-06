package view;
import java.awt.*;


import javax.swing.*;


public class ManagementGUI{
    private JDesktopPane desktop;
    private MyPanel menu, program, topmenu, bottommenu, menu1, menu2, menu3, menu4, menu5, menu6, version, time;
    private JDesktopPane bottommenu_desktopPane;
    private JLabel menuMsg1, menuMsg2, menuMsg3, menuMsg4, menuMsg5, menuMsg6, icon1, icon2, icon3, icon4, icon5, icon6, bottoml1;
    private MyStudentGUI mystudent;
    private AddStudentGUI add;
    private SettingGUI setting;
    private ScoreGUI score;
    private TimeLabel currentTime;
    private Thread t1;
    public ManagementGUI(){
        desktop = new JDesktopPane();
        
        menu = Helper.createPanel("");
        menu.setLayout(new GridLayout(6, 1));
        menu.setLocation(0, 130);
        menu.setSize(300, 480);
        menu.setVisible(true);
        
        program = Helper.createPanel("");
        program.setLayout(new GridLayout(1, 1));
        mystudent = new MyStudentGUI();
        score = new ScoreGUI();
        add = new AddStudentGUI();
        setting = new SettingGUI();
        
        topmenu = Helper.createPanel("");
        topmenu.setLocation(0, 0);
        topmenu.setSize(300, 130);
        topmenu.setBackground(new Color(0, 99, 178));
        
        bottommenu = Helper.createPanel("");
        bottommenu.setLayout(new BorderLayout());
        bottommenu.setLocation(0, 610);
        bottommenu.setSize(300, 90);
        
        
        bottommenu_desktopPane = new JDesktopPane();
        bottommenu_desktopPane.setBackground(new Color(0, 99, 178));
        
        version = Helper.createPanel("");
        version.setSize(100, 30);
        version.setLocation(205, 50);
        version.setBackground(new Color(0, 99, 178));
        bottoml1 = Helper.createLabel("Version 1.0", Color.WHITE);
        version.add(bottoml1);
        
        time = Helper.createPanel("");
        time.setSize(100, 30);
        time.setLocation(205, 20);
        time.setBackground(new Color(0, 99, 178));
        
        currentTime = new TimeLabel();
        t1 = new Thread(currentTime);
        t1.start();
        
        time.add(currentTime);
        
        
        bottommenu_desktopPane.add(version);
        bottommenu_desktopPane.add(time);
        
        bottommenu.add(bottommenu_desktopPane);

        
        

        menu1 = Helper.createPanel("");
        menu1.setLayout(new BorderLayout());
        menuMsg1 = Helper.createLabel("รายชื่อนักเรียน    ", 25);
        menuMsg1.setHorizontalAlignment(JLabel.CENTER);
        icon1 = Helper.createLabel("", "/images/menu_icon/List.png");
        menu1.add(menuMsg1);
        menu1.add(icon1, BorderLayout.EAST);

        menu2 = Helper.createPanel("");
        menu2.setLayout(new BorderLayout());
        menuMsg2 = Helper.createLabel("คะแนน    ",  25);
        icon2 = Helper.createLabel("", "/images/menu_icon/Score.png");
        menuMsg2.setHorizontalAlignment(JLabel.CENTER);
        menu2.add(menuMsg2);
        menu2.add(icon2, BorderLayout.EAST);
        
        menu3 = Helper.createPanel("");
        menu3.setLayout(new BorderLayout());
        menuMsg3 = Helper.createLabel("เพิ่มนักเรียน    ",  25);
        icon3 = Helper.createLabel("", "/images/menu_icon/Add.png");
        menuMsg3.setHorizontalAlignment(JLabel.CENTER);
        menu3.add(menuMsg3);
        menu3.add(icon3, BorderLayout.EAST);
        
        menu4 = Helper.createPanel("");
        menu4.setLayout(new BorderLayout());
        menuMsg4 = Helper.createLabel("ลบนักเรียน    ",  25);
        icon4 = Helper.createLabel("", "/images/menu_icon/Delete.png");
        menuMsg4.setHorizontalAlignment(JLabel.CENTER);
        menu4.add(menuMsg4);
        menu4.add(icon4, BorderLayout.EAST);
        
        menu5 = Helper.createPanel("");
        menu5.setLayout(new BorderLayout());
        menuMsg5 = Helper.createLabel("ตั้งค่า    ",  25);
        icon5 = Helper.createLabel("", "/images/menu_icon/Setting.png");
        menuMsg5.setHorizontalAlignment(JLabel.CENTER);
        menu5.add(menuMsg5);
        menu5.add(icon5, BorderLayout.EAST);
        
        menu6 = Helper.createPanel("");
        menu6.setLayout(new BorderLayout());
        menuMsg6 = Helper.createLabel("ออกจากโปรแกรม   ",  25);
        icon6 = Helper.createLabel("", "/images/menu_icon/Exit.png");
        menuMsg6.setHorizontalAlignment(JLabel.CENTER);
        menu6.add(menuMsg6);
        menu6.add(icon6, BorderLayout.EAST);
        
        
       
        
        menu.add(menu1);
        menu.add(menu2);
        menu.add(menu3);
        menu.add(menu4);
        menu.add(menu5);
        menu.add(menu6);
        
        program.setSize(900, 700);
        program.setLocation(300, 0);
        program.setVisible(true);
        program.add(mystudent.getPanel());
        
        desktop.setVisible(true);
        desktop.add(topmenu);
        desktop.add(menu);
        desktop.add(bottommenu);
        desktop.add(program);
        
    }
    public void set(String select) {
    	if (select.equals("add/delete")) {
    		program.removeAll();
    		
    		program.revalidate();
    		program.repaint();
    		
    		add.reset();
    		program.add(add.getPanel());
    	}
    	else if (select.equals("mystudent")) {
    		program.removeAll();
    		
    		program.revalidate();
    		program.repaint();
    		program.add(mystudent.getPanel());
    	}
    	else if (select.equals("setting")) {
    		program.removeAll();
    		
    		program.revalidate();
    		program.repaint();
    		program.add(setting.getPanel());
    	}
    	else if (select.equals("score")) {
    		program.removeAll();
    		
    		program.revalidate();
    		program.repaint();
    		program.add(score.getPanel());
    	}
    }
    public JDesktopPane getPanel(){
        return this.desktop;
    }
    public AddStudentGUI getAddStudentGUI() {
    	return this.add;
    }
    public MyStudentGUI getMyStudentGUI() {
    	return this.mystudent;
    }
    public ScoreGUI getScoreGUI() {
    	return this.score;
    }
    public MyPanel getMenu1() {
    	return this.menu1;
    }
    public MyPanel getMenu2() {
    	return this.menu2;
    }
    public MyPanel getMenu3() {
    	return this.menu3;
    }
    public MyPanel getMenu4() {
    	return this.menu4;
    }
    public MyPanel getMenu5() {
    	return this.menu5;
    }
    public MyPanel getMenu6() {
    	return this.menu6;
    }
}