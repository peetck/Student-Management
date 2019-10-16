package view;
import java.awt.*;
import javax.swing.*;
public class ManagementGUI{
    private JDesktopPane desktop;
    private JInternalFrame menu, program;
    public ManagementGUI(){
        desktop = new JDesktopPane();
        menu = new JInternalFrame("menu", true, true, true, true);
        program = new JInternalFrame("program", true, true, true, true);


        menu.setLocation(0, 0);
        menu.setSize(300, 700);
        menu.setVisible(true);


        program.setSize(900, 700);
        program.setLocation(300, 0);
        program.setVisible(true);

        desktop.setVisible(true);
        desktop.add(menu);
        desktop.add(program);
    }
    public JDesktopPane getPanel(){
        return this.desktop;
    }
}