import controller.*;
import javax.swing.*;
import mdlaf.*;
import java.awt.*;
import java.io.*;
public class Main{
    public static void main(String[] args) {
        try {
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("font/itim.ttf")));
            //ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("font/kanit.ttf")));
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
