package view;
import java.awt.*;
import javax.swing.*;
public class Helper{
	public static JComboBox<String> createComboBox() {
		JComboBox<String> c = new JComboBox<String>();
		c.setFont(new Font("itim", Font.PLAIN, 16));
		return c;
	}
	// return MyPanel with image if want
    public static MyPanel createPanel(String url){
        Image img = Toolkit.getDefaultToolkit().createImage(url);
        return new MyPanel(img);
    }
    public static MyPanel createPanel(String url, String select){
        Image img = Toolkit.getDefaultToolkit().createImage(url);
        return new MyPanel(img, select);
    }
    // return JLabel with font 
    public static JLabel createLabel(String msg){
        JLabel l = new JLabel(msg);
        l.setFont(new Font("itim", Font.PLAIN, 16));
        l.setOpaque(false);
        return l;
    }
    public static JLabel createLabel(String msg, int size){
        JLabel l = new JLabel(msg);
        l.setFont(new Font("itim", Font.PLAIN, size));
        l.setOpaque(false);
        return l;
    }
    // return JTextField with font and selected size
    public static JTextField createTextField(int size){
        JTextField f = new JTextField(size);
        f.setFont(new Font("itim", Font.PLAIN, 16));
        f.setOpaque(false);
        return f;
    }
    // return JPasswordField with font and selected size
    public static JPasswordField createPasswordField(int size){
        JPasswordField pf = new JPasswordField(size);
        pf.setFont(new Font("itim", Font.PLAIN, 16));
        pf.setOpaque(false);
        return pf;
    }
    // return JButton with font and message
    public static JButton createButton(String msg){
        JButton btn = new JButton(msg);
        btn.setFont(new Font("itim", Font.PLAIN, 16));
        btn.setOpaque(false);
        return btn;
    }
}
