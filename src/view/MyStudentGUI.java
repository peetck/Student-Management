package view;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;

public class MyStudentGUI {
	private JDesktopPane p1;
	private MyPanel container, title;
	private JTable table;
	private JScrollPane table_scroll; 
	public MyStudentGUI() {
		p1 = new JDesktopPane();
		
		
		title = Helper.createPanel("images/MyStudentGUI_bg.png", "title");
		title.setSize(900, 150);
		title.setLocation(0, 0);
		
		container = Helper.createPanel("");
		container.setLayout(new BorderLayout());
		container.setSize(900, 550);
		container.setLocation(0, 150);
		
		String[][] data = new String[30][4];
		for (int i = 0; i < 30; i++) {
			data[i][0] = "" + (i + 1);
			data[i][1] = "-----";
			data[i][2] = "-----";
			data[i][3] = "19/ต.ค/2562";
		}
		String[] header = {"รหัสนักศึกษา", "ชื่อ", "นามสกุล", "เพิ่มเข้ามาในวันที่"};
		table = new JTable(data, header);
		table.getTableHeader().setReorderingAllowed(false);
		table.setDefaultEditor(Object.class, null);
		table.setFillsViewportHeight(true);
		 
		for (int i = 0; i < table.getColumnCount(); i++) {
			table.getColumnModel().getColumn(i).setCellRenderer(new CellRenderer());
		}
		

		table_scroll = new JScrollPane(table);
		
		container.add(table_scroll);
    		
		p1.add(title);
		p1.add(container);
	}
	
	public JDesktopPane getPanel() {
		return this.p1;
	}
}
