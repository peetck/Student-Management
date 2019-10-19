package view;
import java.awt.*;
import javax.swing.*;
public class ManagementGUI{
    private JDesktopPane desktop;
    private JPanel menu, program;
    private MyPanel menu1;
    private JButton btn5, btn6;
    private MyStudentGUI list;
    private AddDeleteStudentGUI add_delete;
    public ManagementGUI(){
        desktop = new JDesktopPane();
        menu = new JPanel();
        program = new JPanel();
        program.setLayout(new GridLayout(1, 1));
        list = new MyStudentGUI();
        add_delete = new AddDeleteStudentGUI();
        menu1 = Helper.createPanel("images/Menu_bg1.jpg", "menu");
        
        
        btn5 = Helper.createButton("เพิ่ม / ลบ");
        btn6 = Helper.createButton("ตั้งค่า");
        
        menu.setLayout(new GridLayout(6, 1));
        menu.setLocation(0, 0);
        menu.setSize(300, 700);
        menu.setVisible(true);
        menu.add(menu1);
        menu.add(Helper.createButton("-------"));
        menu.add(Helper.createButton("-------"));
        menu.add(Helper.createButton("-------"));
        menu.add(btn5);
        menu.add(btn6);
        
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
    public AddDeleteStudentGUI getAddDeleteStudentGUI() {
    	return this.add_delete;
    }

    public JButton getBtn5() {
    	return this.btn5;
    }
    public MyPanel getMenu1() {
    	return this.menu1;
    }
}