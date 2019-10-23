package view;
import java.awt.*;
import javax.swing.*;
public class ManagementGUI{
    private JDesktopPane desktop;
    private JPanel menu, program;
    private MyPanel menu1, menu2, menu3, menu4;
    private MyStudentGUI mystudent;
    private AddDeleteStudentGUI add_delete;
    public ManagementGUI(){
        desktop = new JDesktopPane();
        menu = new JPanel();
        program = new JPanel();
        program.setLayout(new GridLayout(1, 1));
        mystudent = new MyStudentGUI();

        add_delete = new AddDeleteStudentGUI();
        menu1 = Helper.createPanel("images/menu/List.jpg", "menu");
        menu2 = Helper.createPanel("images/menu/Score.jpg", "menu");
        menu3 = Helper.createPanel("images/menu/AddDelete.jpg", "menu");
        menu4 = Helper.createPanel("images/menu/Setting.jpg", "menu");
        
        

        
        menu.setLayout(new GridLayout(4, 1));
        menu.setLocation(0, 0);
        menu.setSize(300, 700);
        menu.setVisible(true);
        
        menu.add(menu1);
        menu.add(menu2);
        menu.add(menu3);
        menu.add(menu4);
        
        program.setSize(900, 700);
        program.setLocation(300, 0);
        program.setVisible(true);
        program.add(mystudent.getPanel());
        
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
    	else if (select.equals("mystudent")) {
    		program.removeAll();
    		
    		program.revalidate();
    		program.repaint();
    		program.add(mystudent.getPanel());
    	}
    }
    public JDesktopPane getPanel(){
        return this.desktop;
    }
    public AddDeleteStudentGUI getAddDeleteStudentGUI() {
    	return this.add_delete;
    }
    public MyStudentGUI getMyStudentGUI() {
    	return this.mystudent;
    }

    public MyPanel getMenu1() {
    	return this.menu1;
    }
    public MyPanel getMenu2() {
    	return this.menu2;
    }
    public MyPanel getMenu3() {
    	return this.menu3;
    }
    public MyPanel getMenu4() {
    	return this.menu4;
    }
}