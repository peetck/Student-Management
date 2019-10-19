package view;
import java.awt.*;
import javax.swing.*;
public class AddDeleteStudentGUI {
	private JDesktopPane p1;
	private MyPanel container, title;
	private JButton btn1, btn2;
	public AddDeleteStudentGUI() {
		p1 = new JDesktopPane();
		container = Helper.createPanel("");
		container.setLayout(new GridBagLayout());
		container.setSize(900, 550);
		container.setLocation(0, 150);
		title = Helper.createPanel("images/AddDeleteStudentGUI_bg.png", "title");
		title.setSize(900, 150);
		title.setLocation(0, 0);
		
		
		btn1 = Helper.createButton("ADD");
		btn2 = Helper.createButton("Delete");


		
		container.add(btn1);
		container.add(btn2);
		
		p1.add(title);
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
