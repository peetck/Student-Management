package view;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;

public class ScoreGUI {
	private JDesktopPane p1;
	private MyPanel container, title;
	public ScoreGUI() {
		p1 = new JDesktopPane();
		
		
		title = Helper.createPanel("", "title");
		title.setSize(900, 150);
		title.setLocation(0, 0);
		title.setBackground(Color.CYAN);
		
		container = Helper.createPanel("");
		container.setLayout(new BorderLayout());
		container.setSize(900, 550);
		container.setLocation(0, 150);
		
		
		container.add(new JButton("click"));
    		
		p1.add(title);
		p1.add(container);
	}

	public JDesktopPane getPanel() {
		return this.p1;
	}

}
