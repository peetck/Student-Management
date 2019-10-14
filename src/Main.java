import controller.*;
import javax.swing.*;
import mdlaf.*;
import mdlaf.animation.*;
public class Main{
    public static void main(String[] args) {
        try {
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
