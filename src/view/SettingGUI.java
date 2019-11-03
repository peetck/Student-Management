package view;
import javax.swing.*;

import java.awt.*;

public class SettingGUI {
	private JDesktopPane p1;
	private MyPanel container, top;
	private MyPanel right_menu;
 
	public SettingGUI() {
		p1 = new JDesktopPane();
		

		right_menu = Helper.createPanel("");
		right_menu.setLayout(new GridLayout(4, 1));
		right_menu.setSize(150, 400);
		right_menu.setLocation(750, 150);
		
		right_menu.add(new JButton("General"));
		right_menu.add(new JButton("Account"));
		right_menu.add(new JButton("-------"));
		right_menu.add(new JButton("-------"));

		

		
    		

		p1.add(right_menu);

	}

	public JDesktopPane getPanel() {
		return this.p1;
	}

}
