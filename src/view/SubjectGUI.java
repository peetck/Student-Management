package view;
import javax.swing.*;
import java.awt.*;

public class SubjectGUI {
	private JDesktopPane p1;
	private JPanel container, topcontainer;
	private JButton btn1, btn2, btn3;
	private ScoreGUI subject1, subject2, subject3;
	private ImageIcon alreadyIcon = new ImageIcon(Helper.getImage("/images/already_have_subject.png").getScaledInstance(60, 60, Image.SCALE_DEFAULT));
	private ImageIcon addIcon = new ImageIcon(Helper.getImage("/images/add_subject.png").getScaledInstance(60, 60, Image.SCALE_DEFAULT));
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

		subject1 = new ScoreGUI("empty#0");
		subject2 = new ScoreGUI("empty#0");
		subject3 = new ScoreGUI("empty#0");
		
	}

	public JDesktopPane getPanel() {
		btn1.setBackground(Color.WHITE);
		btn2.setBackground(Color.WHITE);
		btn3.setBackground(Color.WHITE);
		return this.p1;
	}
	
	public void setSubject(String s1, String s2, String s3) {
		if (!s1.equals("")) {
			subject1.set(s1);
			btn1.setText("<html>" + subject1.getSubject() + " (" + subject1.getSubjectID() + ")</html>");
			btn1.setIcon(alreadyIcon);
		}
		else {
			subject1.set("empty#0");
			btn1.setText("ยังไม่ได้เพิ่มวิชาเหรอ? เพิ่มเลย");
			btn1.setIcon(addIcon);
		}
		if (!s2.equals("")) {
			subject2.set(s2);
			btn2.setText("<html>" + subject2.getSubject() + " (" + subject2.getSubjectID() + ")</html>");
			btn2.setIcon(alreadyIcon);
		}
		else {
			subject2.set("empty#0");
			btn2.setText("ยังไม่ได้เพิ่มวิชาเหรอ? เพิ่มเลย");
			btn2.setIcon(addIcon);
		}
		if (!s3.equals("")) {
			subject3.set(s3);
			btn3.setText("<html>" + subject3.getSubject() + " (" + subject3.getSubjectID() + ")</html>");
			btn3.setIcon(alreadyIcon);
		}
		else {
			subject3.set("empty#0");
			btn3.setText("ยังไม่ได้เพิ่มวิชาเหรอ? เพิ่มเลย");
			btn3.setIcon(addIcon);
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
