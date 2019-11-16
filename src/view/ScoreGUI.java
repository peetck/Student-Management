package view;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;

public class ScoreGUI {
	private JDesktopPane p1;
	private MyPanel container, bottom, topmenu;
	private JTable table;
	private JButton btn1, btn2, btn3, btn4;
	private JScrollPane table_scroll; 
	private String subject;
	private String subjectID;
	private JLabel l1;
	public ScoreGUI(String payload) {
		String[] temp = payload.split("#");
		this.subject = temp[0];
		this.subjectID = temp[1];
		p1 = new JDesktopPane();
		
		topmenu = Helper.createPanel("");
        topmenu.setLocation(0, 0);
        topmenu.setSize(900, 130);
        topmenu.setLayout(new BorderLayout());

        l1 = Helper.createLabel("<html>&nbsp;&nbsp;" + subject + " (" + subjectID + ")</html>", "/images/already_have_subject.png", 60, 60);
        l1.setFont(new Font("Kanit ExtraLight", Font.PLAIN, 35));
        l1.setHorizontalAlignment(JLabel.CENTER);
        topmenu.add(l1);
		
		container = Helper.createPanel("");
		container.setLayout(new BorderLayout());
		container.setSize(885, 480);
		container.setLocation(0, 130);
		
		
		
		
		table_scroll = new JScrollPane(new JTable());
		table_scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); 
		container.add(table_scroll);
		
		bottom = Helper.createPanel("");
		bottom.setLayout(new GridLayout(1, 4));
		bottom.setSize(900, 90);
		bottom.setLocation(0, 610);
		
    		
		btn1 = Helper.createButton("แก้ไขคะแนน", 25);
		btn2 = Helper.createButton("ลบวิชา", 25);
		btn3 = Helper.createButton("อัพโหลด CSV", 25);
		btn4 = Helper.createButton("ดาวน์โหลด CSV", 25);
		
		
		bottom.add(btn1);
		bottom.add(btn2);
		bottom.add(btn3);
		bottom.add(btn4);

		p1.add(topmenu);
		p1.add(container);
		p1.add(bottom);
	}
	
	public void set(String inp) {
		String[] temp = inp.split("#");
		this.subject = temp[0];
		this.subjectID = temp[1];
		l1.setText("<html>&nbsp;&nbsp;<b>วิชา " + subject + " (" + subjectID + ")</b></html>");
	}
	
	public JDesktopPane getPanel() {
		return this.p1;
	}

	public void updateTable(JTable table) {
		this.table = table;
		container.removeAll();
		container.revalidate();
		container.repaint();
		table_scroll = new JScrollPane(table);
		table_scroll.getViewport().setBackground(Color.WHITE);
		table_scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); 
		container.add(table_scroll);
	}
	public JButton getBtn1() {
		return this.btn1;
	}
	public JButton getBtn2() {
		return this.btn2;
	}
	public JButton getBtn3() {
		return this.btn3;
	}
	public JButton getBtn4() {
		return this.btn4;
	}
	public String getSubject() {
		return this.subject;
	}
	public String getSubjectID() {
		return this.subjectID;
	}

}