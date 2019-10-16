package view;
import java.awt.*;
import javax.swing.*;
public class Helper{
    public static MyPanel createPanel(String url){
        Image img = Toolkit.getDefaultToolkit().createImage(url);
        return new MyPanel(img);
    }
    public static JLabel createLabel(String msg){
        JLabel l = new JLabel(msg);
        l.setFont(new Font("itim", Font.PLAIN, 16));
        l.setOpaque(false);
        return l;
    }
    public static JTextField createTextField(int size){
        JTextField f = new JTextField(size);
        f.setFont(new Font("itim", Font.PLAIN, 16));
        f.setOpaque(false);
        return f;
    }
    public static JPasswordField createPasswordField(int size){
        JPasswordField pf = new JPasswordField(size);
        pf.setFont(new Font("itim", Font.PLAIN, 16));
        pf.setOpaque(false);
        return pf;
    }
    public static JButton createButton(String msg){
        JButton btn = new JButton(msg);
        btn.setFont(new Font("itim", Font.PLAIN, 16));
        btn.setOpaque(false);
        return btn;
    }
}
