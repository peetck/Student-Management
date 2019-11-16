package view;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;

public class ScoreGUI {
	private JDesktopPane p1;
	private MyPanel container, bottom, topmenu;
	private JTable table;
	private JButton btn1;
	private JScrollPane table_scroll; 
	private String subject;
	private String subjectID;
	private JLabel l1;
	public ScoreGUI(String payload) {
		String[] temp = payload.split("#");
		this.subject = temp[0];
		this.subjectID = temp[1];
		p1 = new JDesktopPane();
		
		topmenu = Helper.createPanel("");
        topmenu.setLocation(0, 0);
        topmenu.setSize(900, 130);
        topmenu.setLayout(new BorderLayout());

        l1 = Helper.createLabel("<html>" + subject + " (" + subjectID + ")</html>", 30);
        l1.setHorizontalAlignment(JLabel.CENTER);
        topmenu.add(l1);
		
		container = Helper.createPanel("");
		container.setLayout(new BorderLayout());
		container.setSize(900, 460);
		container.setLocation(0, 130);
		
		
		
		
		table_scroll = new JScrollPane(new JTable());
		table_scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); 
		container.add(table_scroll);
		
		bottom = Helper.createPanel("");
		bottom.setLayout(new GridLayout(1, 2));
		bottom.setSize(900, 110);
		bottom.setLocation(0, 590);
    		
		btn1 = Helper.createButton("แก้ไขคะแนน", 23);
		
		
		bottom.add(btn1);

		p1.add(topmenu);
		p1.add(container);
		p1.add(bottom);
	}
	
	public void set(String inp) {
		String[] temp = inp.split("#");
		this.subject = temp[0];
		this.subjectID = temp[1];
		l1.setText("<html>" + subject + " (" + subjectID + ")</html>");
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
		table_scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); 
		container.add(table_scroll);
	}
	public JButton getBtn1() {
		return this.btn1;
	}
	
	public String getSubject() {
		return this.subject;
	}
	public String getSubjectID() {
		return this.subjectID;
	}

}