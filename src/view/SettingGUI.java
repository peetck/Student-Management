package view;
import javax.swing.*;

import java.awt.*;

public class SettingGUI {
	private JDesktopPane p1;
	private MyPanel container, top;
 
	public SettingGUI() {
		p1 = new JDesktopPane();
		

		
		
		top = Helper.createPanel("");
		top.setLayout(new GridLayout(1, 4));
		top.setSize(900, 130);
		top.setLocation(0, 0);
		top.setBackground(Color.RED);
		
		
		container = Helper.createPanel("");
		container.setLayout(new BorderLayout());
		container.setSize(900, 570);
		container.setLocation(0, 130);
		container.setBackground(Color.BLUE);
		

		
    		

		p1.add(container);
		p1.add(top);
	}

	public JDesktopPane getPanel() {
		return this.p1;
	}

}
