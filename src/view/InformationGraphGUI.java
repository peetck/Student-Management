package view;
import java.awt.*;
import javax.swing.*;

import org.jfree.chart.ChartPanel;
public class InformationGraphGUI {
	private JDesktopPane p;
	private MyPanel bottom, container;
	private JButton btn1, btn2;
	public InformationGraphGUI() {
		p = new JDesktopPane();
		
		// 900 * 700
		btn1 = Helper.createButton("แก้ไขคะแนน", 25);
		btn2 = Helper.createButton("ย้อนกลับ", 25);
		
		container = Helper.createPanel("");
		container.setLayout(new BorderLayout());
		container.setSize(900, 610);
		container.setLocation(0, 0);
		
		bottom = Helper.createPanel("");
		bottom.setLayout(new GridLayout(1, 2));
		bottom.setSize(900, 90);
		bottom.setLocation(0, 610);
		
		bottom.add(btn1);
		bottom.add(btn2);
		
		p.add(container);
		p.add(bottom);
	}
	
	public JDesktopPane getPanel() {
		return p;
	}
	
	public JButton getBtn1() {
		return this.btn1;
	}
	
	public JButton getBtn2() {
		return this.btn2;
	}
	
	public void updateGraph(ChartPanel n) {
		
		container.removeAll();
		
		container.add(n);
		container.revalidate();
		container.repaint();
		
	}
}
