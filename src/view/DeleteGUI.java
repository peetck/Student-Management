package view;
import java.awt.*;
import javax.swing.*;
public class DeleteGUI {
	private JDesktopPane p1;
	private JButton btn1, btn2, btn3;
	private MyPanel title, select, container, left;
	private GridBagConstraints gbc;
	private JLabel l1;
	private JTextField f1;
	public DeleteGUI() {
		p1 = new JDesktopPane();
		btn1 = Helper.createButton("Back");
		btn2 = Helper.createButton("View");
		btn3 = Helper.createButton("Delete");
		
		l1 = Helper.createLabel("StudentID : ");
		f1 = Helper.createTextField(20);
		
		
		title = Helper.createPanel("");
		title.setSize(1200, 150);
		title.setLocation(0, 0);
		title.setBackground(Color.BLUE);
		

		
		gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
		gbc.insets = new Insets(5, 0, 5, 0);
		
		select = Helper.createPanel("");
		select.setLayout(new GridLayout(1, 2));
		select.add(l1);
		select.add(f1);

		
		container = Helper.createPanel("");
		container.setSize(900, 550);
		container.setLocation(300, 150);

		left = Helper.createPanel("");
		left.setLayout(new GridLayout(4, 1));
		left.setSize(300, 550);
		left.setLocation(0, 150);
		
		left.add(select);
		left.add(btn2);
		left.add(btn3);
		left.add(btn1);
		
		p1.add(title);
		p1.add(left);
		p1.add(container);


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

}
