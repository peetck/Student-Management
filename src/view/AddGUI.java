package view;
import java.awt.*;
import javax.swing.*;
public class AddGUI {
	private MyPanel p1;
	private JLabel l1, l2, l3, l4;
	private JTextField f1, f2;
	private JButton btn1;
	//private GridBagConstraints gbc;
	public AddGUI() {
		p1 = Helper.createPanel("");
		//p1.setLayout(new GridBagLayout());
		btn1 = Helper.createButton("Back");
		
		l1 = Helper.createLabel("รหัสนักศึกษา");
		l2 = Helper.createLabel("ชื่อ");
		l3 = Helper.createLabel("นามสกุล");
		l4 = Helper.createLabel("ที่อยู่");
		
		f1 = Helper.createTextField(20);
		f2 = Helper.createTextField(20);
		
		
		//gbc = new GridBagConstraints();
		
		
		
		p1.add(l1);

		p1.add(f1);

		p1.add(l2);

		p1.add(f2);

		p1.add(btn1);
	}
	public MyPanel getPanel() {
		return this.p1;
	}
	public JButton getBtn1() {
		return this.btn1;
	}
}
