package view;

import java.awt.*;
import java.util.Locale;

import javax.swing.*;

import com.github.lgooddatepicker.components.DatePicker;
import com.github.lgooddatepicker.components.DatePickerSettings;

import controller.Language;

public class AddStudentGUI {
	private JDesktopPane p1;
	private MyPanel left, right, picture;
	private JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11, l12, l13, l14, l15, l16, pictureLabel;
	private JTextField f1, f3, f4, f6, f7, f8, f9, f10, f11, f12, f13, f14, f15, f16;
	private JComboBox<String> f2;
	private DatePicker f5;
	private JButton btn1, btn2;
	private GridBagConstraints gbc;
	private Image defaultImg;
	private String picturePath;
	private DatePickerSettings settings;
	private JLabel title;
	private MyPanel titlep;
	public AddStudentGUI() {
		

		p1 = new JDesktopPane();
		gbc = new GridBagConstraints();
		gbc.insets = new Insets(2, 0, 0, 0);
        gbc.fill = GridBagConstraints.BOTH;
        btn1 = Helper.createButton(Language.get("ok"));
        btn2 = Helper.createButton(Language.get("editimg"));
        
        
        left = Helper.createPanel("");
        left.setSize(450, 630);
        left.setLocation(0, 70);
        left.setLayout(new GridBagLayout());
        
        right = Helper.createPanel("");
        right.setSize(450, 525);
        right.setLocation(450, 175);
        right.setLayout(new GridBagLayout());
        
        picture = Helper.createPanel("");
        picture.setBorder(BorderFactory.createLineBorder(Color.black));
        picture.setSize(150, 170);
        picture.setLocation(610, 5);
        picture.setLayout(new BorderLayout());
        
        titlep = Helper.createPanel("");
        titlep.setSize(300, 50);
        titlep.setLocation(50, 15);
        titlep.setLayout(new BorderLayout());
        
        title = Helper.createLabel(Language.get("addstudent"), 35, true);
    	title.setHorizontalAlignment(JLabel.CENTER);
    	title.setIcon(new ImageIcon(Helper.getImage("/images/menu_icon/Add.png").getScaledInstance(50, 50, Image.SCALE_DEFAULT)));
    	
    	titlep.add(title);
        
        l1 = Helper.createLabel(Language.get("studentid") + " : ", 15, true);
        l2 = Helper.createLabel(Language.get("title") + " : ", 15, true);
		l3 = Helper.createLabel(Language.get("name") + " : ", 15, true);
		l4 = Helper.createLabel(Language.get("surname") + " : ", 15, true);
		l5 = Helper.createLabel(Language.get("born") + " : ", 15, true);
		
		l6 = Helper.createLabel(Language.get("idcard") + " : ", 15, true);
		l7 = Helper.createLabel(Language.get("address") + " : ", 15, true);
		l8 = Helper.createLabel(Language.get("race") + " : ", 15, true);
		l9 = Helper.createLabel(Language.get("religion") + " : ", 15, true);
		l10 = Helper.createLabel(Language.get("bloodtype") + " : ", 15, true);
		l11 = Helper.createLabel(Language.get("tel") + " : ", 15, true);
		l12 = Helper.createLabel(Language.get("email") + " : ", 15, true);
		l13 = Helper.createLabel(Language.get("height") + " : ", 15, true);
		l14 = Helper.createLabel(Language.get("weight") + " : ", 15, true);
		l15 = Helper.createLabel(Language.get("telp") + " : ", 15, true);
		l16 = Helper.createLabel(Language.get("disease") + " : ", 15, true);
		
		f1 = Helper.createTextField(20, 15);


		f2 = Helper.createComboBox(15);
		f2.addItem(Language.get("male"));
		f2.addItem(Language.get("female"));
		f3 = Helper.createTextField(20, 15);
		f4 = Helper.createTextField(20, 15);
		

		settings = new DatePickerSettings();
        settings.setAllowKeyboardEditing(false);
        settings.setLocale(Locale.US);
        
        f5 = new DatePicker(settings);
		
		f6 = Helper.createTextField(20, 15);
		f7 = Helper.createTextField(20, 15);
		f8 = Helper.createTextField(20, 15);
		f9 = Helper.createTextField(20, 15);
		f10 = Helper.createTextField(20, 15);
		f11 = Helper.createTextField(20, 15);
		f12 = Helper.createTextField(20, 15);
		f13 = Helper.createTextField(20, 15);
		f14 = Helper.createTextField(20, 15);
		f15 = Helper.createTextField(20, 15);
		f16 = Helper.createTextField(20, 15);
		
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
		gbc.insets = new Insets(3, 0, 0, 0);
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
		gbc.insets = new Insets(18, 0, 0, 0);
		right.add(btn1, gbc);

		

        pictureLabel = Helper.createLabel("");
        pictureLabel.setBackground(Color.RED);
		picture.add(pictureLabel);
		picture.add(btn2, BorderLayout.SOUTH);
		

		defaultImg = Helper.getImage("/images/blank_profile.png");
		defaultImg = defaultImg.getScaledInstance(150, 150, Image.SCALE_DEFAULT);
	    pictureLabel.setIcon(new ImageIcon(defaultImg));
		
	    picturePath = "default";
	
		
		p1.add(left);
		p1.add(right);
		p1.add(picture);
		p1.add(titlep);

	}
	

	public JTextField getF4() {
		return f4;
	}


	public void setF4(JTextField f4) {
		this.f4 = f4;
	}

	public JComboBox<String> getF2(){
		return this.f2;
	}

	public JTextField getF6() {
		return f6;
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







	public void setF2(JComboBox<String> f2) {
		this.f2 = f2;
	}


	public JTextField getF3() {
		return this.f3;
	}





	public DatePicker getF5() {
		return this.f5;
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
		f3.setText("");
		f4.setText("");
		f5.setDate(null);
		f6.setText("");
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
		defaultImg = Helper.getImage("/images/blank_profile.png");
		defaultImg = defaultImg.getScaledInstance(150, 150, Image.SCALE_DEFAULT);
	    pictureLabel.setIcon(new ImageIcon(defaultImg));
	    picturePath = "default";
	}
	
	public JTextField getF1() {
		return f1;
	}
}
