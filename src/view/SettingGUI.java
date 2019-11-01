package view;
import javax.swing.*;

import java.awt.*;

public class SettingGUI {
	private JDesktopPane p1;
	private MyPanel container;
	public SettingGUI() {
		p1 = new JDesktopPane();
		

		
		container = Helper.createPanel("");
		container.setLayout(new BorderLayout());
		container.setSize(900, 700);
		container.setLocation(0, 0);
		
		
		container.add(new JButton("click"));
    		

		p1.add(container);
	}

	public JDesktopPane getPanel() {
		return this.p1;
	}

}
