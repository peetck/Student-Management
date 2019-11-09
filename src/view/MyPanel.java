package view;
import java.awt.*;
import javax.swing.*;
public class MyPanel extends JPanel{
    private Image bgImage;
    public MyPanel(Image bg){
        bgImage = bg.getScaledInstance(1200, 700, Image.SCALE_DEFAULT);
    }
    public MyPanel(Image bg, String select) {
    	if (select.equals("menu")) {
    		bgImage = bg.getScaledInstance(300, 115, Image.SCALE_DEFAULT);
    	}
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        repaint();
        g.drawImage(bgImage, 0, 0, null);
    }
}