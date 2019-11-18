package view;
import java.awt.*;
import javax.swing.*;

import org.jfree.chart.ChartPanel;
public class OverallScoreGraphGUI {
	
	private JDesktopPane p;
	private MyPanel top, bottom, middle;
	private JLabel max, min, mean, sd;
	private JButton btn1;
	private int subject;
	public OverallScoreGraphGUI() {
		p = new JDesktopPane();
		
		// 900 * 700
		top = Helper.createPanel("");
		top.setLayout(new BorderLayout());
		top.setSize(880, 410);
		top.setLocation(0, 0);
		
		middle = Helper.createPanel("");
		middle.setLayout(new GridLayout(1, 4));
		middle.setSize(900, 200);
		middle.setLocation(0, 410);
		
		max = Helper.createLabel("Max : ", 20);
		max.setHorizontalAlignment(JLabel.CENTER);
		min = Helper.createLabel("Min : ", 20);
		min.setHorizontalAlignment(JLabel.CENTER);
		mean = Helper.createLabel("Mean : ", 20);
		mean.setHorizontalAlignment(JLabel.CENTER);
		sd = Helper.createLabel("SD : ", 20);
		sd.setHorizontalAlignment(JLabel.CENTER);
		
		middle.add(max);
		middle.add(min);
		middle.add(mean);
		middle.add(sd);
		
		bottom = Helper.createPanel("");
		bottom.setLayout(new GridLayout(1, 2));
		bottom.setSize(900, 90);
		bottom.setLocation(0, 610);
		
		btn1 = Helper.createButton("ย้อนกลับ", 25);
		
		bottom.add(btn1);
		
		p.add(middle);
		p.add(top);
		p.add(bottom);
	}
	
	public JDesktopPane getPanel() {
		return this.p;
	}
	
	public JButton getBtn1() {
		return this.btn1;
	}
	public int getSubject() {
		return subject;
	}
	
	public void set(double[] inp) {
		max.setText("<html><b>คะแนนสูงสุด : </b>" + String.format("%.2f", inp[0]) + "</html>");
		min.setText("<html><b>คะแนนตํ่าสุด : </b>" + String.format("%.2f", inp[1]) + "</html>");
		mean.setText("<html><b>ค่าเฉลี่ย : </b>" + String.format("%.2f", inp[2]) + "</html>");
		sd.setText("<html><b>ค่า SD : </b>" + String.format("%.2f", inp[3]) + "</html>");
		
	}
	public void updateGraph(ChartPanel n, int select) {

		top.removeAll();

		top.add(n);
		top.revalidate();
		top.repaint();
		
		subject = select;

	}
}
