import controller.*;
import javax.swing.*;


import mdlaf.*;


import java.awt.*;
import java.io.*;


public class Main {
	public static void main(String[] args) {
		try {
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();

			InputStream font = Main.class.getResourceAsStream("fonts/Kanit-ExtraLight.ttf");
			ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, font));
			font.close();

			UIManager.setLookAndFeel(new MaterialLookAndFeel());
			JDialog.setDefaultLookAndFeelDecorated(false);
			UIManager.put("Button.mouseHoverEnable", true);
			UIManager.put("TableHeader.font", new Font("Kanit ExtraLight", Font.BOLD, 16));

			UIManager.put("OptionPane.messageFont", new Font("Kanit ExtraLight", Font.PLAIN, 16));
			UIManager.put("OptionPane.buttonFont", new Font("Kanit ExtraLight", Font.PLAIN, 16));
			UIManager.put("ToolTip.font", new Font("Kanit ExtraLight", Font.PLAIN, 16));

		}
		catch (Exception e) {
			e.printStackTrace();
		}
		new StudentManagement("localhost", 27017);

	}

}
