import controller.*;
import javax.swing.*;
import javax.swing.plaf.ColorUIResource;

import mdlaf.*;
import java.awt.*;
import java.io.*;


public class Main{
    public static void main(String[] args) {
        try {
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            
            InputStream font = Main.class.getResourceAsStream("fonts/itim.ttf");
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, font));
            font.close();
            UIManager.setLookAndFeel(new MaterialLookAndFeel());
            JDialog.setDefaultLookAndFeelDecorated(false);
            UIManager.put("Button.mouseHoverEnable", true);
            UIManager.put("TableHeader.font", new Font("itim", Font.PLAIN, 16));

        }
        catch (Exception e) {
            e.printStackTrace();
        }
           new StudentManagement("localhost", 27017);

    }
    

	
}
