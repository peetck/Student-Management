import controller.*;
import javax.swing.*;
import mdlaf.*;
import java.awt.*;
import java.io.*;
public class Main{
    public static void main(String[] args) {
        try {
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("font/kanit.ttf")));
            UIManager.setLookAndFeel(new MaterialLookAndFeel());
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        SwingUtilities.invokeLater(() -> {
            new StudentManagement();
        });
    }
}
