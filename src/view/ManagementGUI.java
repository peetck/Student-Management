package view;
import java.awt.*;
import javax.swing.*;
public class ManagementGUI{
    private JDesktopPane desktop;
    private JPanel menu, program;
    public ManagementGUI(){
        desktop = new JDesktopPane();
        menu = new JPanel();
        program = new JPanel();

        menu.setLayout(new GridLayout(5, 1));
        menu.setLocation(0, 0);
        menu.setSize(300, 700);
        menu.setVisible(true);
        menu.add(Helper.createButton("รายชื่อนักเรียนที่ดูแลอยู่"));
        menu.add(Helper.createButton("-------"));
        menu.add(Helper.createButton("-------"));
        menu.add(Helper.createButton("-------"));
        menu.add(Helper.createButton("เพิ่ม / ลบ นักเรียน"));

        program.setSize(900, 700);
        program.setLocation(300, 0);
        program.setVisible(true);
        //program.add(new MyStudentGUI().getPanel());

        desktop.setVisible(true);
        desktop.add(menu);
        desktop.add(program);
    }
    public JDesktopPane getPanel(){
        return this.desktop;
    }
}