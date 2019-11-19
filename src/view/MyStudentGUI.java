package view;
import javax.swing.*;

import java.awt.*;

public class MyStudentGUI {
	private JDesktopPane p1;
	private MyPanel container, bottom;
	private JScrollPane table_scroll;
	private JButton btn1;
	public MyStudentGUI() {
		p1 = new JDesktopPane();

		
		container = Helper.createPanel("");
		container.setLayout(new BorderLayout());
		container.setSize(885, 610);
		container.setLocation(0, 0);

		
		bottom = Helper.createPanel("");
		bottom.setLayout(new GridLayout(1, 1));
		bottom.setSize(900, 90);
		bottom.setLocation(0, 610);
		
		btn1 = Helper.createButton("ดาวน์โหลดข้อมูลนักเรียน", 25);
		
		bottom.add(btn1);
		
		table_scroll = new JScrollPane(new JTable());
		table_scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); 
		
		container.add(table_scroll);

		p1.add(container);
		p1.add(bottom);
	}
	public void updateTable(JTable table) {
		
		
		container.removeAll();
		container.revalidate();
		container.repaint();
		table_scroll = new JScrollPane(table);
		table_scroll.getViewport().setBackground(Color.WHITE);
		
		table_scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); 
		

		container.add(table_scroll);

		
	}
	public JDesktopPane getPanel() {
		return this.p1;
	}
	public JButton getBtn1() {
		return this.btn1;
	}
}
