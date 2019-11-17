package view;


import mdlaf.animation.*;


import javax.swing.*;
import javax.swing.border.LineBorder;

import java.awt.*;
public class Helper{
	public static JComboBox<String> createComboBox() {
		JComboBox<String> c = new JComboBox<String>();
		c.setFont(new Font("Kanit ExtraLight", Font.PLAIN, 16));
		return c;
	}
	public static JComboBox<String> createComboBox(int size) {
		JComboBox<String> c = new JComboBox<String>();
		c.setFont(new Font("Kanit ExtraLight", Font.PLAIN, size));
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
    public static JLabel createLabel(String msg, boolean b){
        JLabel l = new JLabel(msg);
        if (b) {
            l.setFont(new Font("Kanit ExtraLight", Font.BOLD, 16));
        }
        else {
            l.setFont(new Font("Kanit ExtraLight", Font.PLAIN, 16));
        }
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
    public static JLabel createLabel(String msg, int size, boolean b){
        JLabel l = new JLabel(msg);
        if (b) {
            l.setFont(new Font("Kanit ExtraLight", Font.BOLD, size));
        }
        else {
            l.setFont(new Font("Kanit ExtraLight", Font.PLAIN, size));
        }
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
    public static JScrollPane createTextArea(String msg) {
    	JTextArea ta = new JTextArea(msg);
        ta.setFont(new Font("Kanit ExtraLight", Font.PLAIN, 16));
        ta.setOpaque(false);
        ta.setLineWrap(true);
        ta.setWrapStyleWord(true);
        ta.setEditable(false);
        JScrollPane scroll = new JScrollPane(ta);
        scroll.getViewport().setOpaque(false);
        scroll.setOpaque(false);

        //scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); 
        return scroll;
    }
    // return JTextField with font and selected size
    public static JTextField createTextField(int size){
        JTextField f = new JTextField(size);
        f.setFont(new Font("Kanit ExtraLight", Font.PLAIN, 16));
        f.setOpaque(false);
        return f;
    }
    public static JTextField createTextField(int size, int fsize){
        JTextField f = new JTextField(size);
        f.setFont(new Font("Kanit ExtraLight", Font.PLAIN, fsize));
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
        btn.setBackground(new Color(156, 195, 213, 85));
        MaterialUIMovement.add (btn, new Color(156, 195, 213), 5, 1000 / 60);
        btn.setOpaque(false);
        return btn;
    }
    public static JButton createButton(String msg, int size){
        JButton btn = new JButton(msg);
        btn.setFont(new Font("Kanit ExtraLight", Font.PLAIN, size));
        btn.setBackground(new Color(156, 195, 213, 85));
        MaterialUIMovement.add (btn, new Color(156, 195, 213), 5, 1000 / 60);
        btn.setOpaque(false);
        return btn;
    }

    
    public static JButton createButton(String msg, int size, String path, int width, int height) {
    	JButton btn = new JButton(msg);
        btn.setFont(new Font("Kanit ExtraLight", Font.PLAIN, size));
        btn.setOpaque(false);
        btn.setBackground(new Color(156, 195, 213, 85));
        Image img = Helper.getImage(path);
	    img = img.getScaledInstance(width, height, Image.SCALE_DEFAULT);
	    ImageIcon icon = new ImageIcon(img);
		btn.setIcon(icon);
		btn.setIconTextGap(20);
		btn.setBackground(Color.WHITE);
		MaterialUIMovement.add (btn, new Color(156, 195, 213), 5, 1000 / 60);
        return btn;
    	
    }
    public static Image getImage(String url) {
    	Image img = Toolkit.getDefaultToolkit().getImage(Helper.class.getResource(url));
    	return img;
    }

}
