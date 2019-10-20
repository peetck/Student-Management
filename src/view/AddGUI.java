package view;
import java.awt.*;
import javax.swing.*;
public class AddGUI {
	private JDesktopPane p1;
	private JLabel l1, l2, l3, l4;
	private JTextField f1, f2;
	private JButton btn1;
	private MyPanel title, container;
	//private GridBagConstraints gbc;
	public AddGUI() {
		p1 = new JDesktopPane();
		//p1.setLayout(new GridBagLayout());
		title = Helper.createPanel("");
		container = Helper.createPanel("");
		
		title.setSize(1200, 150);
		title.setLocation(0, 0);
		title.setBackground(Color.BLUE);
		
		container.setSize(1200, 550);
		container.setLocation(0, 150);
		
		
		btn1 = Helper.createButton("Back");
		
		l1 = Helper.createLabel("รหัสนักศึกษา");
		l2 = Helper.createLabel("ชื่อ");
		l3 = Helper.createLabel("นามสกุล");
		l4 = Helper.createLabel("ที่อยู่");
		
		f1 = Helper.createTextField(20);
		f2 = Helper.createTextField(20);
		
		
		//gbc = new GridBagConstraints();
		
		
		
		container.add(l1);

		container.add(f1);

		container.add(l2);

		container.add(f2);

		container.add(btn1);
		
		
		p1.add(title);
		p1.add(container);
	}
	public JDesktopPane getPanel() {
		return this.p1;
	}
	public JButton getBtn1() {
		return this.btn1;
	}
}
