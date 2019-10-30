package view;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.*;
import javax.swing.border.*;

public class ManagementGUI{
    private JDesktopPane desktop;
    private JPanel menu, program, topmenu, bottommenu;
    private MyPanel menu1, menu2, menu3, menu4;
    private MyStudentGUI mystudent;
    private AddDeleteStudentGUI add_delete;
    private SettingGUI setting;
    private ScoreGUI score;
    public ManagementGUI(){
        desktop = new JDesktopPane();
        menu = new JPanel();
        program = new JPanel();
        program.setLayout(new GridLayout(1, 1));
        mystudent = new MyStudentGUI();
        score = new ScoreGUI();
        add_delete = new AddDeleteStudentGUI();
        setting = new SettingGUI();
        topmenu = Helper.createPanel("");
        bottommenu = Helper.createPanel("");
        

        menu1 = Helper.createPanel("");
        menu1.setLayout(new BorderLayout());
        JLabel msg = Helper.createLabel("รายชื่อนักเรียน", 25);
        msg.setHorizontalAlignment(JLabel.CENTER);
        menu1.add(msg);

        menu2 = Helper.createPanel("");
        menu2.setLayout(new BorderLayout());
        msg = Helper.createLabel("คะแนน", 25);
        msg.setHorizontalAlignment(JLabel.CENTER);
        menu2.add(msg);
        
        menu3 = Helper.createPanel("");
        menu3.setLayout(new BorderLayout());
        msg = Helper.createLabel("เพิ่ม / ลบ นักเรียน", 25);
        msg.setHorizontalAlignment(JLabel.CENTER);
        menu3.add(msg);
        
        menu4 = Helper.createPanel("");
        menu4.setLayout(new BorderLayout());
        msg = Helper.createLabel("ตั้งค่า", 25);
        msg.setHorizontalAlignment(JLabel.CENTER);
        menu4.add(msg);
        
        
        topmenu.setLocation(0, 0);
        topmenu.setSize(300, 130);
        topmenu.setBackground(new Color(0, 99, 178));
        
        bottommenu.setLocation(0, 590);
        bottommenu.setSize(300, 110);
        bottommenu.setBackground(new Color(0, 99, 178));
        
        menu.setLayout(new GridLayout(4, 1));
        menu.setLocation(0, 130);
        menu.setSize(300, 460);
        menu.setVisible(true);
        
        menu.add(menu1);
        menu.add(menu2);
        menu.add(menu3);
        menu.add(menu4);
        
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
    		
    		add_delete.reset();
    		program.add(add_delete.getPanel());
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
    public AddDeleteStudentGUI getAddDeleteStudentGUI() {
    	return this.add_delete;
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
}