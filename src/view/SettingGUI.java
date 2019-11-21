package view;
import javax.swing.*;
import java.awt.*;

public class SettingGUI {
	private JDesktopPane p1;
	private JPanel container, container_bot;
	private JButton btn1, btn2, btn3;
	public SettingGUI() {
		p1 = new JDesktopPane();
		



		container = Helper.createPanel(""); // 900 * 700
		container.setSize(900, 419);
		container.setLocation(0, 0);
		container.setLayout(new GridLayout(2, 1));
		container.setBackground(Color.WHITE);

		container_bot = Helper.createPanel("");
		container_bot.setSize(900, 185);
		container_bot.setLocation(0, 514);
		container_bot.setLayout(new GridLayout(1, 1));
		container_bot.setBackground(Color.WHITE);
		
		
		btn1 = Helper.createButton("เปลี่ยนรหัสผ่าน", 40, "/images/password_change.png", 60, 60);

		btn2 = Helper.createButton("ล็อกเอ้าท์", 40, "/images/logout.png", 60, 60);

		btn3 = Helper.createButton("ลบบัญชี", 40, "/images/delete_account.png", 60, 60);

		
		

		container.add(btn1);
		container.add(btn2);
		
		container_bot.add(btn3);
		
		p1.add(container);
		p1.add(container_bot);

	}

	public JDesktopPane getPanel() {
		return this.p1;
	}
	
	public JButton getBtn1() {
		return this.btn1;
	}
	public JButton getBtn2() {
		return this.btn2;
	}
	public JButton getBtn3() {
		return this.btn3;
	}

}
