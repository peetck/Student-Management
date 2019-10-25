package view;
import java.awt.*;
import javax.swing.*;
public class AddGUI {
	private JDesktopPane p1;
	private JLabel l1, l2, l3, l4, l5;
	private JTextField f1, f2, f3, f4, f5;
	private JButton btn1, btn2;
	private MyPanel title, left, right;
	public AddGUI() {
		p1 = new JDesktopPane();

		title = Helper.createPanel("");
		left = Helper.createPanel("");
		right = Helper.createPanel("");
		
		title.setSize(1200, 150);
		title.setLocation(0, 0);
		title.setBackground(Color.BLUE);
		
		left.setSize(600, 550);
		left.setLocation(0, 150);
		left.setLayout(new GridLayout(5, 2));
		
		right.setSize(600, 550);
		right.setLocation(600, 150);
		right.setLayout(new GridLayout(5, 2));
		
		btn1 = Helper.createButton("Back");
		btn2 = Helper.createButton("ADD");
		
		l1 = Helper.createLabel("รหัสนักศึกษา");
		l1.setHorizontalAlignment(JLabel.CENTER);
		l2 = Helper.createLabel("ชื่อ");
		l2.setHorizontalAlignment(JLabel.CENTER);
		l3 = Helper.createLabel("นามสกุล");
		l3.setHorizontalAlignment(JLabel.CENTER);
		l4 = Helper.createLabel("ที่อยู่");
		l4.setHorizontalAlignment(JLabel.CENTER);
		l5 = Helper.createLabel("เบอร์ติดต่อ");
		l5.setHorizontalAlignment(JLabel.CENTER);
		
		f1 = Helper.createTextField(20);
		f2 = Helper.createTextField(20);
		f3 = Helper.createTextField(20);
		f4 = Helper.createTextField(20);
		f5 = Helper.createTextField(20);
		
		
		
		left.add(l1);
		left.add(f1);
		left.add(l2);
		left.add(f2);
		left.add(l3);
		left.add(f3);
		left.add(l4);
		left.add(f4);
		left.add(l5);
		left.add(f5);
		
		right.add(new JButton("ss"));
		right.add(new JButton("ss"));
		right.add(new JButton("ss"));
		right.add(new JButton("ss"));
		right.add(new JButton("ss"));
		right.add(new JButton("ss"));
		right.add(new JButton("ss"));
		right.add(new JButton("ss"));
		right.add(btn1);
		right.add(btn2);
		
		p1.add(title);
		p1.add(left);
		p1.add(right);
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
}
