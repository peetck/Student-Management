package view;
import java.awt.*;


import javax.swing.*;


public class ManagementGUI{
    private JDesktopPane desktop;
    private JPanel menu, program, topmenu, bottommenu;
    private MyPanel menu1, menu2, menu3, menu4, menu5;
    private JLabel menuMsg1, menuMsg2, menuMsg3, menuMsg4, menuMsg5, icon1, icon2, icon3, icon4, icon5;
    private MyStudentGUI mystudent;
    private AddStudentGUI add;
    private SettingGUI setting;
    private ScoreGUI score;
    public ManagementGUI(){
        desktop = new JDesktopPane();
        menu = new JPanel();
        program = new JPanel();
        program.setLayout(new GridLayout(1, 1));
        mystudent = new MyStudentGUI();
        score = new ScoreGUI();
        add = new AddStudentGUI();
        setting = new SettingGUI();
        topmenu = Helper.createPanel("");
        bottommenu = Helper.createPanel("");
        

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
        
        
        topmenu.setLocation(0, 0);
        topmenu.setSize(300, 130);
        topmenu.setBackground(new Color(0, 99, 178));
        
        bottommenu.setLocation(0, 590);
        bottommenu.setSize(300, 110);
        bottommenu.setBackground(new Color(0, 99, 178));
        
        menu.setLayout(new GridLayout(5, 1));
        menu.setLocation(0, 130);
        menu.setSize(300, 460);
        menu.setVisible(true);
        
        menu.add(menu1);
        menu.add(menu2);
        menu.add(menu3);
        menu.add(menu4);
        menu.add(menu5);
        
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
}