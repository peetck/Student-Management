package view;
import java.awt.*;
import javax.swing.*;
public class AddDeleteStudentGUI {
	private JDesktopPane p1;
	private MyPanel title, left, right;
	private AddGUI add_gui;
	private GridBagConstraints gbc;
	public AddDeleteStudentGUI() {
		add_gui = new AddGUI();
		p1 = new JDesktopPane();
		gbc = new GridBagConstraints();
		
		title = Helper.createPanel("images/011.jpg", "title");
		title.setSize(900, 150);
		title.setLocation(0, 0);
		
		left = Helper.createPanel("images/AddDelete_left.jpg", "adddelete");
		left.setSize(450, 550);
		left.setLocation(0, 150);
		
		right = Helper.createPanel("images/AddDelete_right.jpg", "adddelete");
		right.setSize(450, 550);
		right.setLocation(450, 150);


		
		
		
		
		p1.add(title);
		p1.add(left);
		p1.add(right);
	}
	

	public JDesktopPane getPanel() {
		return this.p1;
	}
	public MyPanel getLeft() {
		return this.left;
	}
	public MyPanel getRight() {
		return this.right;
	}
	public AddGUI getAddGUI() {
		return add_gui;
	}
}
