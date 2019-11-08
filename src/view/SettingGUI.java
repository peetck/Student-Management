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
		right_menu.setSize(150, 700);
		right_menu.setLocation(750, 0);
		
		right_menu.add(new JButton("General"));
		right_menu.add(new JButton("Account"));
		right_menu.add(new JButton("-------"));
		right_menu.add(new JButton("-------"));

		container = Helper.createPanel("");
		container.setSize(750, 700);
		container.setLocation(0, 0);
		container.setBackground(Color.RED);

		
    		

		p1.add(right_menu);
		p1.add(container);

	}

	public JDesktopPane getPanel() {
		return this.p1;
	}

}
