package view;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;

public class ScoreGUI {
	private JDesktopPane p1;
	private MyPanel container, bottom;
	private JTable table;
	private JButton btn1;
	private JScrollPane table_scroll; 
	public ScoreGUI() {
		p1 = new JDesktopPane();
		
		
		container = Helper.createPanel("");
		container.setLayout(new BorderLayout());
		container.setSize(900, 590);
		container.setLocation(0, 0);
		
		
		
		
		table_scroll = new JScrollPane(new JTable());
		container.add(table_scroll);
		
		bottom = Helper.createPanel("");
		bottom.setLayout(new GridLayout(1, 2));
		bottom.setSize(900, 110);
		bottom.setLocation(0, 590);
    		
		btn1 = Helper.createButton("แก้ไขคะแนน");
		
		bottom.add(btn1);

		p1.add(container);
		p1.add(bottom);
	}

	public JDesktopPane getPanel() {
		return this.p1;
	}

	public void updateTable(JTable table) {
		this.table = table;
		container.removeAll();
		container.revalidate();
		container.repaint();
		table_scroll = new JScrollPane(table);
		table_scroll.getViewport().setBackground(Color.WHITE);
		container.add(table_scroll);
	}
	public JButton getBtn1() {
		return this.btn1;
	}

}
