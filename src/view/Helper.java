package view;


import mdlaf.animation.*;


import javax.swing.*;
import java.awt.*;
public class Helper{
	public static JComboBox<String> createComboBox() {
		JComboBox<String> c = new JComboBox<String>();
		c.setFont(new Font("Kanit ExtraLight", Font.PLAIN, 16));
		return c;
	}
	// return MyPanel with image if want
    public static MyPanel createPanel(String url){
    	Image img = getImage(url);
        return new MyPanel(img);
    }
    public static MyPanel createPanel(String url, String select){
    	Image img = getImage(url);
        return new MyPanel(img, select);
    }
    // return JLabel with font 
    public static JLabel createLabel(String msg){
        JLabel l = new JLabel(msg);
        l.setFont(new Font("Kanit ExtraLight", Font.PLAIN, 16));
        l.setOpaque(false);
        return l;
    }
    public static JLabel createLabel(String msg, Color color){
        JLabel l = new JLabel(msg);
        l.setFont(new Font("Kanit ExtraLight", Font.PLAIN, 16));
        l.setForeground(color);
        l.setOpaque(false);
        return l;
    }
    public static JLabel createLabel(String msg, int size){
        JLabel l = new JLabel(msg);
        l.setFont(new Font("Kanit ExtraLight", Font.PLAIN, size));
        l.setOpaque(false);
        return l;
    }
    public static JLabel createLabel(String msg, int size, Color color){
        JLabel l = new JLabel(msg);
        l.setFont(new Font("Kanit ExtraLight", Font.PLAIN, size));
        l.setForeground(color);
        l.setOpaque(false);
        return l;
    }
    // menu JLable icon only !!
    public static JLabel createLabel(String msg, String path) {
    	Image img = getImage(path);
	    img = img.getScaledInstance(70, 70, Image.SCALE_DEFAULT);
	    ImageIcon icon = new ImageIcon(img);
	    JLabel l = new JLabel(msg + "   ");
        l.setFont(new Font("Kanit ExtraLight", Font.PLAIN, 16));
        l.setIcon(icon);
        l.setOpaque(false);
        return l;
    }
    public static JLabel createLabel(String msg, String path, int width, int height) {
    	Image img = getImage(path);
	    img = img.getScaledInstance(width, height, Image.SCALE_DEFAULT);
	    ImageIcon icon = new ImageIcon(img);
	    JLabel l = new JLabel(msg);
        l.setFont(new Font("Kanit ExtraLight", Font.PLAIN, 16));
        l.setIcon(icon);
        l.setOpaque(false);
        //l.setHorizontalTextPosition(JLabel.LEFT);
        return l;
    }

    // return JTextField with font and selected size
    public static JTextField createTextField(int size){
        JTextField f = new JTextField(size);
        f.setFont(new Font("Kanit ExtraLight", Font.PLAIN, 16));
        f.setOpaque(false);
        return f;
    }
    // return JPasswordField with font and selected size
    public static JPasswordField createPasswordField(int size){
        JPasswordField pf = new JPasswordField(size);
        pf.setFont(new Font("Kanit ExtraLight", Font.PLAIN, 16));
        pf.setOpaque(false);
        return pf;
    }
    // return JButton with font and message
    public static JButton createButton(String msg){
        JButton btn = new JButton(msg);
        btn.setFont(new Font("Kanit ExtraLight", Font.PLAIN, 16));
        MaterialUIMovement.add (btn, new Color(156, 195, 213), 5, 1000 / 60);
        btn.setOpaque(false);
        return btn;
    }
    public static JButton createButton(String msg, Color color){
        JButton btn = new JButton(msg);
        btn.setFont(new Font("Kanit ExtraLight", Font.PLAIN, 16));
        btn.setForeground(color);
        btn.setOpaque(false);
        return btn;
    }
    public static Image getImage(String url) {
    	Image img = Toolkit.getDefaultToolkit().getImage(Helper.class.getResource(url));
    	return img;
    }

}
