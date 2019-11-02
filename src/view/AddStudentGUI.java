package view;
import java.awt.*;



import javax.swing.*;
import javax.swing.border.EmptyBorder;
public class AddStudentGUI {
	private JDesktopPane p1;
	private MyPanel left, right, picture, f6;
	private JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11, l12, l13, l14, l15, l16, l17, pictureLabel;
	private JTextField f1,f4, f5, f7, f8, f9, f10, f11, f12, f13, f14, f15, f16, f17;
	private JComboBox<String> f2, f3, f6_1, f6_2, f6_3;
	private JButton btn1, btn2;
	private GridBagConstraints gbc;
	private Image defaultImg;
	private String picturePath;
	public AddStudentGUI() {
		

		p1 = new JDesktopPane();
		gbc = new GridBagConstraints();
		gbc.insets = new Insets(5, 0, 0, 0);
        gbc.fill = GridBagConstraints.BOTH;
        btn1 = Helper.createButton("เพิ่มนักศึกษา");
        btn2 = Helper.createButton("เพิ่มรูป");
        
        left = Helper.createPanel("");
        left.setSize(450, 700);
        left.setLocation(0, 0);
        left.setLayout(new GridBagLayout());
        
        right = Helper.createPanel("");
        right.setSize(450, 545);
        right.setLocation(450, 155);
        right.setLayout(new GridBagLayout());
        
        picture = Helper.createPanel("");
        picture.setBorder(BorderFactory.createLineBorder(Color.black));
        picture.setSize(150, 150);
        picture.setLocation(610, 5);
        picture.setLayout(new BorderLayout());
        

        
        l1 = Helper.createLabel("รหัสนักศึกษา");
		l2 = Helper.createLabel("คณะ");
        l3 = Helper.createLabel("คํานําหน้า");
		l4 = Helper.createLabel("ชื่อ");
		l5 = Helper.createLabel("นามสกุล");
		l6 = Helper.createLabel("วันเดือนปีเกิด");
		
		l7 = Helper.createLabel("หมายเลขบัตรประชาชน");
		l8 = Helper.createLabel("ที่อยู่");
		l9 = Helper.createLabel("เชื้อชาติ");
		l10 = Helper.createLabel("ศาสนา");
		l11 = Helper.createLabel("หมู่เลือด");
		l12 = Helper.createLabel("เบอร์ติดต่อ");
		l13 = Helper.createLabel("อีเมล์");
		l14 = Helper.createLabel("ส่วนสูง");
		l15 = Helper.createLabel("นํ้าหนัก");
		l16 = Helper.createLabel("เบอร์ติดต่อผู้ปกครอง");
		l17 = Helper.createLabel("โรคประจําตัว");

		
		f1 = Helper.createTextField(20);
		f2 = Helper.createComboBox();
		f2.addItem("วิศวกรรมศาสตร์");
		f2.addItem("สถาปัตยกรรมศาสตร์");
		f2.addItem("ครุศาสตร์อุตสาหกรรม");
		f2.addItem("เทคโนโลยีการเกษตร");
		f2.addItem("วิทยาศาสตร์");
		f2.addItem("อุตสาหกรรมเกษตร");
		f2.addItem("เทคโนโลยีสารสนเทศ");
		f2.addItem("วิทยาลัยนานาชาติ");
		f2.addItem("วิทยาลัยนาโนเทคโนโลยี ฯ");
		f2.addItem("วิทยาลัยนวัตกรรมการจัดการข้อมูล");
		f2.addItem("วิทยาลัยการบริหารและจัดการ");
		f2.addItem("ศิลปศาสตร์");
		f2.addItem("วิศกรรมการบินและนักบินพาณิชย์");

		f3 = Helper.createComboBox();
		f3.addItem("นาย");
		f3.addItem("นางสาว");
		f4 = Helper.createTextField(20);
		f5 = Helper.createTextField(20);
		
		
		f6 = Helper.createPanel("");
		f6.setLayout(new GridLayout(1, 3));
		
		f6_1 = Helper.createComboBox();
		for (int i = 1; i <= 31; i++) {
			f6_1.addItem("" + i);
		}
		f6_2 = Helper.createComboBox();
		for (int i = 1; i <= 12; i++) {
			f6_2.addItem("" + i);
		}
		f6_3 = Helper.createComboBox();
		for (int i = 1950; i <= 2019; i++) {
			f6_3.addItem("" + i);
		}
		
		
		f6.add(f6_1);
		f6.add(f6_2);
		f6.add(f6_3);
		
		f7 = Helper.createTextField(20);
		f8 = Helper.createTextField(20);
		f9 = Helper.createTextField(20);
		f10 = Helper.createTextField(20);
		f11 = Helper.createTextField(20);
		f12 = Helper.createTextField(20);
		f13 = Helper.createTextField(20);
		f14 = Helper.createTextField(20);
		f15 = Helper.createTextField(20);
		f16 = Helper.createTextField(20);
		f17 = Helper.createTextField(20);
		
		left.add(l1, gbc);
		gbc.gridx = 0;
		gbc.gridy = 1;
		left.add(f1, gbc);
		gbc.gridx = 0;
		gbc.gridy = 2;
		left.add(l2, gbc);
		gbc.gridx = 0;
		gbc.gridy = 3;
		left.add(f2, gbc);
		gbc.gridx = 0;
		gbc.gridy = 4;
		left.add(l3, gbc);
		gbc.gridx = 0;
		gbc.gridy = 5;
		left.add(f3, gbc);
		gbc.gridx = 0;
		gbc.gridy = 6;
		left.add(l4, gbc);
		gbc.gridx = 0;
		gbc.gridy = 7;
		left.add(f4, gbc);
		gbc.gridx = 0;
		gbc.gridy = 8;
		left.add(l5, gbc);
		gbc.gridx = 0;
		gbc.gridy = 9;
		left.add(f5, gbc);
		gbc.gridx = 0;
		gbc.gridy = 10;
		left.add(l6, gbc);
		gbc.gridx = 0;
		gbc.gridy = 11;
		left.add(f6, gbc);
		gbc.gridx = 0;
		gbc.gridy = 12;
		left.add(l7, gbc);
		gbc.gridx = 0;
		gbc.gridy = 13;
		left.add(f7, gbc);
		gbc.gridx = 0;
		gbc.gridy = 14;
		left.add(l8, gbc);
		gbc.gridx = 0;
		gbc.gridy = 15;
		left.add(f8, gbc);
		gbc.gridx = 0;
		gbc.gridy = 16;
		left.add(l9, gbc);
		gbc.gridx = 0;
		gbc.gridy = 17;
		left.add(f9, gbc);
		gbc.gridx = 0;
		gbc.gridy = 18;
		left.add(l10, gbc);
		gbc.gridx = 0;
		gbc.gridy = 19;
		left.add(f10, gbc);
		
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.insets = new Insets(5, 0, 0, 0);
		right.add(l11, gbc);
		gbc.gridx = 0;
		gbc.gridy = 1;
		right.add(f11, gbc);
		gbc.gridx = 0;
		gbc.gridy = 2;
		right.add(l12, gbc);
		gbc.gridx = 0;
		gbc.gridy = 3;
		right.add(f12, gbc);
		gbc.gridx = 0;
		gbc.gridy = 4;
		right.add(l13, gbc);
		gbc.gridx = 0;
		gbc.gridy = 5;
		right.add(f13, gbc);
		gbc.gridx = 0;
		gbc.gridy = 6;
		right.add(l14, gbc);
		gbc.gridx = 0;
		gbc.gridy = 7;
		right.add(f14, gbc);
		gbc.gridx = 0;
		gbc.gridy = 8;
		right.add(l15, gbc);
		gbc.gridx = 0;
		gbc.gridy = 9;
		right.add(f15, gbc);
		gbc.gridx = 0;
		gbc.gridy = 10;
		right.add(l16, gbc);
		gbc.gridx = 0;
		gbc.gridy = 11;
		right.add(f16, gbc);
		gbc.gridx = 0;
		gbc.gridy = 12;
		right.add(l17, gbc);
		gbc.gridx = 0;
		gbc.gridy = 13;
		right.add(f17, gbc);
		gbc.gridx = 0;
		gbc.gridy = 14;
		right.add(btn2, gbc);
		gbc.gridx = 0;
		gbc.gridy = 15;
		right.add(btn1, gbc);
		

        pictureLabel = Helper.createLabel("");
        pictureLabel.setBackground(Color.RED);
		picture.add(pictureLabel);
		

		defaultImg = Helper.createImage("/images/blank_profile.png");
		defaultImg = defaultImg.getScaledInstance(150, 150, Image.SCALE_DEFAULT);
	    pictureLabel.setIcon(new ImageIcon(defaultImg));
		
	    picturePath = "/images/blank_profile.png";
		
		p1.add(left);
		p1.add(right);
		p1.add(picture);

	}
	

	public JTextField getF4() {
		return f4;
	}


	public void setF4(JTextField f4) {
		this.f4 = f4;
	}


	public JTextField getF5() {
		return f5;
	}


	public void setF5(JTextField f5) {
		this.f5 = f5;
	}


	public JTextField getF7() {
		return f7;
	}


	public void setF7(JTextField f7) {
		this.f7 = f7;
	}


	public JTextField getF8() {
		return f8;
	}


	public void setF8(JTextField f8) {
		this.f8 = f8;
	}


	public JTextField getF9() {
		return f9;
	}


	public void setF9(JTextField f9) {
		this.f9 = f9;
	}


	public JTextField getF10() {
		return f10;
	}


	public void setF10(JTextField f10) {
		this.f10 = f10;
	}


	public JTextField getF11() {
		return f11;
	}


	public void setF11(JTextField f11) {
		this.f11 = f11;
	}


	public JTextField getF12() {
		return f12;
	}


	public void setF12(JTextField f12) {
		this.f12 = f12;
	}


	public JTextField getF13() {
		return f13;
	}


	public void setF13(JTextField f13) {
		this.f13 = f13;
	}


	public JTextField getF14() {
		return f14;
	}


	public void setF14(JTextField f14) {
		this.f14 = f14;
	}


	public JTextField getF15() {
		return f15;
	}


	public void setF15(JTextField f15) {
		this.f15 = f15;
	}


	public JTextField getF16() {
		return f16;
	}


	public void setF16(JTextField f16) {
		this.f16 = f16;
	}


	public JTextField getF17() {
		return f17;
	}


	public void setF17(JTextField f17) {
		this.f17 = f17;
	}


	public JComboBox<String> getF2() {
		return f2;
	}


	public void setF2(JComboBox<String> f2) {
		this.f2 = f2;
	}


	public JComboBox<String> getF3() {
		return f3;
	}


	public void setF3(JComboBox<String> f3) {
		this.f3 = f3;
	}


	public JComboBox<String> getF6_1() {
		return f6_1;
	}


	public void setF6_1(JComboBox<String> f6_1) {
		this.f6_1 = f6_1;
	}


	public JComboBox<String> getF6_2() {
		return f6_2;
	}


	public void setF6_2(JComboBox<String> f6_2) {
		this.f6_2 = f6_2;
	}


	public JComboBox<String> getF6_3() {
		return f6_3;
	}


	public void setF6_3(JComboBox<String> f6_3) {
		this.f6_3 = f6_3;
	}


	public void setF1(JTextField f1) {
		this.f1 = f1;
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
	
	public JLabel getPictureLabel() {
		return this.pictureLabel;
	}
	
	public String getPicturePath() {
		return picturePath;
	}
	
	public void setPicturePath(String path) {
		this.picturePath = path;
	}
	

	public void reset() {
		f1.setText("");
		f2.setSelectedIndex(0);
		f3.setSelectedIndex(0);
		f4.setText("");
		f5.setText("");
		f6_1.setSelectedIndex(0);
		f6_2.setSelectedIndex(0);
		f6_3.setSelectedIndex(0);
		f7.setText("");
		f8.setText("");
		f9.setText("");
		f10.setText("");
		f11.setText("");
		f12.setText("");
		f13.setText("");
		f14.setText("");
		f15.setText("");
		f16.setText("");
		f17.setText("");
	}
	
	public JTextField getF1() {
		return f1;
	}
}
