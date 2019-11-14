package view;
import javax.swing.*;

import model.Student;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
public class InformationGUI {
	private JDesktopPane p1;
	private MyPanel left, right, picture, titlep, select;
	private JLabel pictureLabel;
	private JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11, l12, l13, l14, l15, l16, l17;
	private JLabel a1, a2, a3, a4, a5, a6, a7, a9, a10, a11, a12, a13, a14, a15, a16, a17;
	private JLabel title;
	private JScrollPane a8;
	private HashMap<String, String> information;
	private JButton btn1;
	private String picturePath;
	public InformationGUI() {
		p1 = new JDesktopPane();
		
		/* 900 x 700 */
		left = Helper.createPanel("");
        left.setSize(380, 645);
        left.setLocation(50, 85);
        left.setLayout(new GridLayout(10, 2));
        //left.setBackground(Color.RED);
        
        right = Helper.createPanel("");
        right.setSize(390, 450);
        right.setLocation(490, 165);
        right.setLayout(new GridLayout(7, 2));
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
        select.setSize(350, 50);
        select.setLocation(490, 615);
        select.setLayout(new BorderLayout());

        
        btn1 = Helper.createButton("แก้ไขข้อมูล", 20);
        
        select.add(btn1);
        
        l1 = Helper.createLabel("รหัสนักเรียน : ", true);
        l2 = Helper.createLabel("คณะ : ", true);
        l3 = Helper.createLabel("คํานําหน้า : ", true);
		l4 = Helper.createLabel("ชื่อ : ", true);
		l5 = Helper.createLabel("นามสกุล : ", true);
		l6 = Helper.createLabel("วันเดือนปีเกิด : ", true);
		
		l7 = Helper.createLabel("หมายเลขบัตรประชาชน : ", true);
		l8 = Helper.createLabel("ที่อยู่ : ", true);
		l9 = Helper.createLabel("เชื้อชาติ : ", true);
		l10 = Helper.createLabel("ศาสนา : ", true);
		l11 = Helper.createLabel("หมู่เลือด : ", true);
		l12 = Helper.createLabel("เบอร์ติดต่อ : ", true);
		l13 = Helper.createLabel("อีเมล์ : ", true);
		l14 = Helper.createLabel("ส่วนสูง : ", true);
		l15 = Helper.createLabel("นํ้าหนัก : ", true);
		l16 = Helper.createLabel("เบอร์ติดต่อผู้ปกครอง : ", true);
		l17 = Helper.createLabel("โรคประจําตัว : ", true);
		
		
        
		
        p1.add(left);
        p1.add(right);
        p1.add(picture);
        p1.add(titlep);
        p1.add(select);
		
		
	}

	public void set(Student student) {
		
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
    	a2 = Helper.createLabel(information.get("faculty"));
      	a3 = Helper.createLabel(information.get("title"));   	
    	a4 = Helper.createLabel(information.get("name"));   	
    	a5 = Helper.createLabel(information.get("surname"));  	
    	a6 = Helper.createLabel(information.get("day") + " / " + information.get("month") + " / " + information.get("year"));	
    	a7 = Helper.createLabel(information.get("cardID"));
    	a8 = Helper.createTextArea(information.get("address"));
    	a9 = Helper.createLabel(information.get("race"));
    	a10 = Helper.createLabel(information.get("religion"));
    	a11 = Helper.createLabel(information.get("bloodType"));
    	a12 = Helper.createLabel(information.get("tel"));
    	a13 = Helper.createLabel(information.get("email"));
    	a14 = Helper.createLabel(information.get("height"));
    	a15 = Helper.createLabel(information.get("weight"));
    	a16 = Helper.createLabel(information.get("parentTel"));
    	a17 = Helper.createLabel(information.get("disease"));
    	
    	
    	
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
		right.add(l17);
		right.add(a17);
		
	}
	
	
	public JDesktopPane getPanel() {
		return this.p1;
	}
	public JButton getBtn1() {
		return this.btn1;
	}
	public HashMap<String, String> getInformation() {
		return this.information;
	}
	public String getPicturePath() {
		return this.picturePath;
	}
}
