package view;
import java.awt.Color;
import java.awt.Font;
import java.util.Calendar;

import javax.swing.*;
public class TimeLabel extends JLabel implements Runnable{
	private Calendar c;
	private int hr, min, sec;
	
	public TimeLabel() {
		this.setText("");
		this.setForeground(Color.WHITE);
		this.setBackground(new Color(0, 99, 178));
		this.setFont(new Font("Kanit ExtraLight", Font.PLAIN, 16));
		this.setHorizontalAlignment(JLabel.CENTER);
	}
	
	public void run() {
		while(true) {
			try {
				c = Calendar.getInstance();
				hr = c.get(Calendar.HOUR_OF_DAY);
				min = c.get(Calendar.MINUTE);
				sec = c.get(Calendar.SECOND);
				this.setText(String.format("%02d:%02d:%02d", hr, min, sec));
				Thread.sleep(1000);
			}
			catch(InterruptedException e) {
				
			}
		}
	}
}
