package main;
import controller.*;
import javax.swing.*;


import mdlaf.*;


import java.awt.*;
import java.io.*;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Locale;
import java.util.ResourceBundle;


public class Main {
	public static StudentManagement rootprogram;
	public static void main(String[] args) {
		try {
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();

			InputStream font = Main.class.getResourceAsStream("/fonts/Kanit-ExtraLight.ttf");
			ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, font));
			font.close();

			UIManager.setLookAndFeel(new MaterialLookAndFeel());
			JDialog.setDefaultLookAndFeelDecorated(false);
			UIManager.put("Button.mouseHoverEnable", true);
			UIManager.put("TableHeader.font", new Font("Kanit ExtraLight", Font.BOLD, 16));

			UIManager.put("OptionPane.messageFont", new Font("Kanit ExtraLight", Font.PLAIN, 16));
			UIManager.put("OptionPane.buttonFont", new Font("Kanit ExtraLight", Font.PLAIN, 16));
			UIManager.put("ToolTip.font", new Font("Kanit ExtraLight", Font.PLAIN, 16));
			
			Language.init("en", "US");
			rootprogram = new StudentManagement("localhost", 27017);
			
		}
		catch (Exception e) {
			System.out.println(e);
		}
		  
		

	}
	public static void reload(String host, int port) {
		rootprogram.getGUI().getFrame().setVisible(false);
		rootprogram.getGUI().getFrame().dispose();
		rootprogram = new StudentManagement(host, port);
	}

}
