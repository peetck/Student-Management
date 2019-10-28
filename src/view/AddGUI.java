package view;
import java.awt.*;
import javax.swing.*;
public class AddGUI {
	private JDesktopPane p1;
	private JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11, l12, l13, l14, l15;
	private JTextField f1, f2, f3, f4, f5, f6, f7, f8, f9, f10, f11, f12, f13, f14, f15;
	private JButton btn1, btn2;
	private MyPanel title, left, right, rightbot;
	private GridBagConstraints gbc;
	public AddGUI() {
		p1 = new JDesktopPane();
		gbc = new GridBagConstraints();
		gbc.insets = new Insets(2, 0, 2, 0);
        gbc.fill = GridBagConstraints.BOTH;
		
		title = Helper.createPanel("");
		left = Helper.createPanel("");
		right = Helper.createPanel("");
		rightbot = Helper.createPanel("");
		
		title.setSize(1200, 150);
		title.setLocation(0, 0);
		title.setBackground(Color.BLUE);
		
		left.setSize(600, 550);
		left.setLocation(0, 150);
		left.setLayout(new GridBagLayout());
		
		right.setSize(600, 400);
		right.setLocation(600, 150);
		right.setLayout(new GridBagLayout());
		
		rightbot.setSize(600, 100);
		rightbot.setLocation(600, 550);
		rightbot.setLayout(new GridLayout(1, 2));
		//rightbot.setBackground(Color.RED);
		
		btn1 = Helper.createButton("ย้อนกลับ");
		btn2 = Helper.createButton("เพิ่ม");
		
		l1 = Helper.createLabel("รหัสนักศึกษา");
		l2 = Helper.createLabel("คํานําหน้า");
		l3 = Helper.createLabel("ชื่อ");
		l4 = Helper.createLabel("นามสกุล");
		l5 = Helper.createLabel("หมายเลขบัตรประชาชน");
		l6 = Helper.createLabel("ที่อยู่");
		l7 = Helper.createLabel("เชื้อชาติ");
		l8 = Helper.createLabel("ศาสนา");
		l9 = Helper.createLabel("หมู่เลือด");
		l10 = Helper.createLabel("เบอร์ติดต่อ");
		l11 = Helper.createLabel("อีเมล์");
		l12 = Helper.createLabel("ส่วนสูง");
		l13 = Helper.createLabel("นํ้าหนัก");
		l14 = Helper.createLabel("เบอร์ติดต่อผู้ปกครอง");
		l15 = Helper.createLabel("โรคประจําตัว");
		
		f1 = Helper.createTextField(20);
		f2 = Helper.createTextField(20);
		f3 = Helper.createTextField(20);
		f4 = Helper.createTextField(20);
		f5 = Helper.createTextField(20);
		f6 = Helper.createTextField(20);
		f7 = Helper.createTextField(20);
		f8 = Helper.createTextField(20);
		f9 = Helper.createTextField(20);
		f10 = Helper.createTextField(20);
		f11 = Helper.createTextField(20);
		f12 = Helper.createTextField(20);
		f13 = Helper.createTextField(20);
		f14 = Helper.createTextField(20);
		f15 = Helper.createTextField(20);
		
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
		gbc.gridy = 0;
		right.add(l10, gbc);
		gbc.gridx = 0;
		gbc.gridy = 1;
		right.add(f10, gbc);
		gbc.gridx = 0;
		gbc.gridy = 2;
		right.add(l11, gbc);
		gbc.gridx = 0;
		gbc.gridy = 3;
		right.add(f11, gbc);
		gbc.gridx = 0;
		gbc.gridy = 4;
		right.add(l12, gbc);
		gbc.gridx = 0;
		gbc.gridy = 5;
		right.add(f12, gbc);
		gbc.gridx = 0;
		gbc.gridy = 6;
		right.add(l13, gbc);
		gbc.gridx = 0;
		gbc.gridy = 7;
		right.add(f13, gbc);
		gbc.gridx = 0;
		gbc.gridy = 8;
		right.add(l14, gbc);
		gbc.gridx = 0;
		gbc.gridy = 9;
		right.add(f14, gbc);
		gbc.gridx = 0;
		gbc.gridy = 10;
		right.add(l15, gbc);
		gbc.gridx = 0;
		gbc.gridy = 11;
		right.add(f15, gbc);
		
		rightbot.add(btn2);
		rightbot.add(btn1);
		
		p1.add(title);
		p1.add(left);
		p1.add(right);
		p1.add(rightbot);
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
	public JTextField getF1() {
		return this.f1;
	}
	public JTextField getF2() {
		return this.f2;
	}
	public JTextField getF3() {
		return this.f3;
	}
	public JTextField getF4() {
		return this.f4;
	}
	public JTextField getF5() {
		return this.f5;
	}
	public JTextField getF6() {
		return this.f6;
	}
	public JTextField getF7() {
		return this.f7;
	}
	public JTextField getF8() {
		return this.f8;
	}
	public JTextField getF9() {
		return this.f9;
	}
	public JTextField getF10() {
		return this.f10;
	}
	public JTextField getF11() {
		return this.f11;
	}
	public JTextField getF12() {
		return this.f12;
	}
	public JTextField getF13() {
		return this.f13;
	}
	public JTextField getF14() {
		return this.f14;
	}
	public JTextField getF15() {
		return this.f15;
	}
}
