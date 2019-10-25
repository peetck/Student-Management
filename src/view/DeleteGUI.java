package view;
import java.awt.*;
import javax.swing.*;
public class DeleteGUI {
	private JDesktopPane p1;
	private JButton btn1;
	private MyPanel title, container;

	public DeleteGUI() {
		p1 = new JDesktopPane();

		
		title = Helper.createPanel("");
		title.setSize(1200, 150);
		title.setLocation(0, 0);
		title.setBackground(Color.BLUE);
		
		container = Helper.createPanel("");
		container.setSize(1200, 550);
		container.setLocation(0, 150);

		btn1 = Helper.createButton("Back");
		
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
