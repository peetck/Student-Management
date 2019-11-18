package view;
import javax.swing.*;

import controller.Language;
import model.Student;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
public class InformationGUI {
	private JDesktopPane p1;
	private MyPanel left, right, picture, titlep, select;
	private JLabel pictureLabel;
	private JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11, l12, l13, l14, l15, l16;
	private JLabel a1, a2, a3, a4, a5, a6, a8, a9, a10, a11, a12, a13, a14, a15, a16;
	private JLabel title;
	private JScrollPane a7;
	private HashMap<String, String> information;
	private JButton btn1, btn2, btn3;
	private String picturePath;
	private GridBagConstraints gbc;
	private String studentID;

	public InformationGUI() {
		p1 = new JDesktopPane();
		
		/* 900 x 700 */
		left = Helper.createPanel("");
        left.setSize(380, 580);
        left.setLocation(50, 85);
        left.setLayout(new GridLayout(10, 2));
        //left.setBackground(Color.RED);
        
        right = Helper.createPanel("");
        right.setSize(390, 370);
        right.setLocation(490, 165);
        right.setLayout(new GridLayout(6, 2));
        //right.setBackground(Color.RED);
        
        picture = Helper.createPanel("");
        picture.setBorder(BorderFactory.createLineBorder(Color.black));
        picture.setSize(150, 150);
        picture.setLocation(610, 5);
        picture.setLayout(new BorderLayout());
        
        titlep = Helper.createPanel("");
        titlep.setSize(300, 45);
        titlep.setLocation(50, 15);
        titlep.setLayout(new BorderLayout());
        
        title = Helper.createLabel(" ข้อมูลนักเรียน", 35, true);
    	title.setHorizontalAlignment(JLabel.CENTER);
    	title.setIcon(new ImageIcon(Helper.getImage("/images/student.png").getScaledInstance(50, 50, Image.SCALE_DEFAULT)));
    	
    	titlep.add(title);
    	
        select = Helper.createPanel("");
        select.setSize(350, 150);
        select.setLocation(490, 530);
        select.setLayout(new GridBagLayout());

	   	gbc = new GridBagConstraints();
	    gbc.fill = GridBagConstraints.BOTH;
	    gbc.insets = new Insets(5, 0, 5, 0);
        btn1 = Helper.createButton(Language.get("editinformation"), 17);
        btn2 = Helper.createButton(Language.get("seescore"), 17);
        btn3 = Helper.createButton(Language.get("back"), 17);
        
        gbc.weightx = 2;
        select.add(btn1, gbc);
        gbc.gridy = 1;
        select.add(btn2, gbc);
        gbc.gridy = 2;
        select.add(btn3, gbc);
        
        l1 = Helper.createLabel(Language.get("studentid") + " : ", true);
        l2 = Helper.createLabel(Language.get("title") + " : ", true);
		l3 = Helper.createLabel(Language.get("name") + " : ", true);
		l4 = Helper.createLabel(Language.get("surname") + " : ", true);
		l5 = Helper.createLabel(Language.get("born") + " : ", true);
		
		l6 = Helper.createLabel(Language.get("idcard") + " : ", true);
		l7 = Helper.createLabel(Language.get("address") + " : ", true);
		l8 = Helper.createLabel(Language.get("race") + " : ", true);
		l9 = Helper.createLabel(Language.get("religion") + " : ", true);
		l10 = Helper.createLabel(Language.get("bloodtype") + " : ", true);
		l11 = Helper.createLabel(Language.get("tel") + " : ", true);
		l12 = Helper.createLabel(Language.get("email") + " : ", true);
		l13 = Helper.createLabel(Language.get("height") + " : ", true);
		l14 = Helper.createLabel(Language.get("weight") + " : ", true);
		l15 = Helper.createLabel(Language.get("telp") + " : ", true);
		l16 = Helper.createLabel(Language.get("disease") + " : ", true);
		
		
        
		
        p1.add(left);
        p1.add(right);
        p1.add(picture);
        p1.add(titlep);
        p1.add(select);
		
		
	}

	public void set(Student student) {
		
		this.studentID = student.getStudentID();
		
		left.removeAll();
		right.removeAll();
		picture.removeAll();
		
		
		
		information = student.getInformation();
		


    	this.picturePath = student.getPicturePath();

    	
    	pictureLabel = Helper.createLabel("");
    	pictureLabel.setBorder(BorderFactory.createLineBorder(Color.black));

    	if ( ! (student.getPicturePath().equals("default"))) {
    		Image img = Toolkit.getDefaultToolkit().getImage(student.getPicturePath());
	    	img = img.getScaledInstance(150, 150, Image.SCALE_DEFAULT);
		    pictureLabel.setIcon(new ImageIcon(img));
    	}
    	else {
    		Image img = Helper.getImage("/images/blank_profile.png");
    		img = img.getScaledInstance(150, 150, Image.SCALE_DEFAULT);
    		pictureLabel.setIcon(new ImageIcon(img));
    	}
    	
    	
    	
    	a1 = Helper.createLabel(information.get("studentID"));

      	a2 = Helper.createLabel(information.get("title"));   	
    	a3 = Helper.createLabel(information.get("name"));   	
    	a4 = Helper.createLabel(information.get("surname"));  	
    	a5 = Helper.createLabel(information.get("day") + " / " + information.get("month") + " / " + information.get("year"));	
    	a6 = Helper.createLabel(information.get("cardID"));
    	a7 = Helper.createTextArea(information.get("address"));
    	a8 = Helper.createLabel(information.get("race"));
    	a9 = Helper.createLabel(information.get("religion"));
    	a10 = Helper.createLabel(information.get("bloodType"));
    	a11 = Helper.createLabel(information.get("tel"));
    	a12 = Helper.createLabel(information.get("email"));
    	a13 = Helper.createLabel(information.get("height"));
    	a14 = Helper.createLabel(information.get("weight"));
    	a15 = Helper.createLabel(information.get("parentTel"));
    	a16 = Helper.createLabel(information.get("disease"));
    	
    	
    	
 		picture.add(pictureLabel);
 		
 		

    	left.add(l1);
		left.add(a1);
		left.add(l2);
		left.add(a2);
		left.add(l3);
		left.add(a3);
		left.add(l4);
		left.add(a4);
		left.add(l5);
		left.add(a5);
		left.add(l6);
		left.add(a6);
		left.add(l7);
		left.add(a7);
		left.add(l8);
		left.add(a8);
		left.add(l9);
		left.add(a9);
		left.add(l10);
		left.add(a10);
		
		
		

		right.add(l11);
		right.add(a11);
		right.add(l12);
		right.add(a12);
		right.add(l13);
		right.add(a13);
		right.add(l14);
		right.add(a14);
		right.add(l15);
		right.add(a15);
		right.add(l16);
		right.add(a16);
		
	}
	
	
	public JDesktopPane getPanel() {
		return this.p1;
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
	public HashMap<String, String> getInformation() {
		return this.information;
	}
	public String getPicturePath() {
		return this.picturePath;
	}
	
	public String getStudentID() {
		return this.studentID;
	}
}
