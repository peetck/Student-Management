package view;
import javax.swing.*;
import java.awt.*;
public class MyStudentGUI {
	private JDesktopPane p1;
	private MyPanel container, title;
	
	public MyStudentGUI() {
		p1 = new JDesktopPane();
		
		title = Helper.createPanel("images/MyStudentGUI_bg.png", "title");
		title.setSize(900, 150);
		title.setLocation(0, 0);
		
		container = Helper.createPanel("");
		
		p1.add(title);
		p1.add(container);
	}
	
	public JDesktopPane getPanel() {
		return this.p1;
	}
}
