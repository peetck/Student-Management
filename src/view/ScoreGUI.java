package view;
import javax.swing.*;
import java.awt.*;

public class ScoreGUI {
	private JDesktopPane p1;
	private JPanel container, bottom, topmenu;
	private JButton btn1, btn2, btn3, btn4, btn5;
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
        topmenu.setLocation(50, 0);
        topmenu.setSize(800, 130);
        topmenu.setLayout(new BorderLayout());

        l1 = Helper.createLabel("  " + subject + " (" + subjectID + ")", "/images/already_have_subject.png", 60, 60);
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
		bottom.setLayout(new GridLayout(1, 5));
		bottom.setSize(900, 90);
		bottom.setLocation(0, 610);
		
    		
		btn1 = Helper.createButton("แก้ไขคะแนน", 21);
		btn2 = Helper.createButton("ลบวิชา", 21);
		btn3 = Helper.createButton("ดูกราฟ", 21);
		btn4 = Helper.createButton("อัพโหลดคะแนน", 21);
		btn5 = Helper.createButton("ดาวน์โหลดคะแนน", 21);
		
		
		bottom.add(btn1);
		bottom.add(btn2);
		bottom.add(btn3);
		bottom.add(btn4);
		bottom.add(btn5);

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
	public JButton getBtn5() {
		return this.btn5;
	}
	public String getSubject() {
		return this.subject;
	}
	public String getSubjectID() {
		return this.subjectID;
	}

}