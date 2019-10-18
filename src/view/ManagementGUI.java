package view;
import java.awt.*;
import javax.swing.*;
public class ManagementGUI{
    private JDesktopPane desktop;
    private JPanel menu, program;
    private JButton btn1, btn5;
    private MyStudentGUI list;
    private AddDeleteStudentGUI add_delete;
    public ManagementGUI(){
        desktop = new JDesktopPane();
        menu = new JPanel();
        program = new JPanel();
        list = new MyStudentGUI();
        add_delete = new AddDeleteStudentGUI();
        btn1 = Helper.createButton("รายชื่อ");
        btn5 = Helper.createButton("เพิ่ม / ลบ");
   
        
        menu.setLayout(new GridLayout(5, 1));
        menu.setLocation(0, 0);
        menu.setSize(300, 700);
        menu.setVisible(true);
        menu.add(btn1);
        menu.add(Helper.createButton("-------"));
        menu.add(Helper.createButton("-------"));
        menu.add(Helper.createButton("-------"));
        menu.add(btn5);

        program.setSize(900, 700);
        program.setLocation(300, 0);
        program.setVisible(true);
        program.add(list.getPanel());
        
        desktop.setVisible(true);
        desktop.add(menu);
        desktop.add(program);
        
    }
    public void set(String select) {
    	if (select.equals("add/delete")) {
    		program.removeAll();
    		
    		program.revalidate();
    		program.repaint();
    		program.add(add_delete.getPanel());
    	}
    	else if (select.equals("list")) {
    		program.removeAll();
    		
    		program.revalidate();
    		program.repaint();
    		program.add(list.getPanel());
    	}
    }
    public JDesktopPane getPanel(){
        return this.desktop;
    }
    public JButton getBtn1() {
    	return this.btn1;
    }
    public JButton getBtn5() {
    	return this.btn5;
    }
}