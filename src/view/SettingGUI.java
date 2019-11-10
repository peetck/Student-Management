package view;
import javax.swing.*;

import java.awt.*;

public class SettingGUI {
	private JDesktopPane p1;
	private MyPanel container;
	private JButton m1, m2, m3, m4;
 
	public SettingGUI() {
		p1 = new JDesktopPane();
		



		container = Helper.createPanel("");
		container.setSize(900, 700);
		container.setLocation(0, 0);
		container.setBackground(Color.RED);


		p1.add(container);

	}

	public JDesktopPane getPanel() {
		return this.p1;
	}

}
