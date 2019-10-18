package view;
import java.awt.*;
import javax.swing.*;
public class AddDeleteStudentGUI {
	private MyPanel p1;
	
	public AddDeleteStudentGUI() {
		p1 = Helper.createPanel("");
		p1.setLayout(new GridBagLayout());
		p1.add(Helper.createLabel("เพิ่ม / ลบ ไอสัส"));
	}
	
	public MyPanel getPanel() {
		return this.p1;
	}
}
