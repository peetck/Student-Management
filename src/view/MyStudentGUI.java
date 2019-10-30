package view;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.*;
import java.awt.*;

public class MyStudentGUI {
	private JDesktopPane p1;
	private MyPanel container;
	private JScrollPane table_scroll; 
	public MyStudentGUI() {
		p1 = new JDesktopPane();

		
		container = Helper.createPanel("");
		container.setLayout(new BorderLayout());
		container.setSize(885, 700);
		container.setLocation(0, 0);

		

		table_scroll = new JScrollPane(new JTable());
		table_scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); 
		
		container.add(table_scroll);

		p1.add(container);
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

}
