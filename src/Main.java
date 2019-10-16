import controller.*;
import javax.swing.*;
import mdlaf.*;
import mdlaf.animation.*;
import java.awt.*;
import java.io.*;
public class Main{
    public static void main(String[] args) {
        try {
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("../font/itim.ttf")));
            UIManager.setLookAndFeel(new MaterialLookAndFeel());
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        SwingUtilities.invokeLater(() -> {
            StudentManagement n = new StudentManagement();
        });
    }
}
