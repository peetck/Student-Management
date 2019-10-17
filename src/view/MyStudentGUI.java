package view;
import javax.swing.*;
import java.awt.*;
public class MyStudentGUI {
	private MyPanel p1;
	
	public MyStudentGUI() {
		p1 = Helper.createPanel("");
		p1.setLayout(new GridBagLayout());
		p1.add(Helper.createButton("sss"));
	}
	
	public MyPanel getPanel() {
		return this.p1;
	}
}
