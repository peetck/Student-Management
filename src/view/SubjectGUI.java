package view;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;

public class SubjectGUI {
	private JDesktopPane p1;
	private MyPanel container, topcontainer;
	private JButton btn1, btn2, btn3;
	private ScoreGUI subject1, subject2, subject3;
	private ImageIcon alreadyIcon = new ImageIcon(Helper.getImage("/images/already_have_subject.png").getScaledInstance(60, 60, Image.SCALE_DEFAULT));
	public SubjectGUI() {
		p1 = new JDesktopPane();
		
		// 900 * 700
	    
	    topcontainer = Helper.createPanel("");
	    topcontainer.setLayout(new GridLayout(1, 1));
	    topcontainer.setSize(900, 226);
	    topcontainer.setLocation(0, 0);
	    
		container = Helper.createPanel("");
		container.setLayout(new GridLayout(2, 1));
		container.setSize(900, 378);
		container.setLocation(0, 322);

		
		btn1 = Helper.createButton("ยังไม่ได้เพิ่มวิชาเหรอ? เพิ่มเลย", 30, "/images/add_subject.png", 60, 60);
		btn2 = Helper.createButton("ยังไม่ได้เพิ่มวิชาเหรอ? เพิ่มเลย", 30, "/images/add_subject.png", 60, 60);
		btn3 = Helper.createButton("ยังไม่ได้เพิ่มวิชาเหรอ? เพิ่มเลย", 30, "/images/add_subject.png", 60, 60);


		
		topcontainer.add(btn1);
		
		container.add(btn2);
		container.add(btn3);


		p1.add(topcontainer);
		p1.add(container);

		
	}

	public JDesktopPane getPanel() {
		return this.p1;
	}
	
	public void setSubject(String s1, String s2, String s3) {
		if (s1.equals("")) {
			subject1 = null;
		}
		else {
			subject1 = new ScoreGUI(s1);
			btn1.setText("<html> วิชา" + subject1.getSubject() + " (" + subject1.getSubjectID() + ")</html>");
			btn1.setIcon(alreadyIcon);
		}
		
		if (s2.equals("")) {
			subject2 = null;
		}
		else {
			subject2 = new ScoreGUI(s2);
			btn2.setText("<html>วิชา" + subject2.getSubject() + " (" + subject2.getSubjectID() + ")</html>");
			btn2.setIcon(alreadyIcon);
		}
		
		if (s3.equals("")) {
			subject3 = null;
		}
		else {
			subject3 = new ScoreGUI(s3);
			btn3.setText("<html>วิชา" + subject3.getSubject() + " (" + subject3.getSubjectID() + ")</html>");
			btn3.setIcon(alreadyIcon);
		}

	}
	
	public ScoreGUI getSubject1() {
		return this.subject1;
	}
	
	public ScoreGUI getSubject2() {
		return this.subject2;
	}
	
	public ScoreGUI getSubject3() {
		return this.subject3;
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

}
