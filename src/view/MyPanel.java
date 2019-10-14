package view;
import java.awt.*;
import javax.swing.*;
public class MyPanel extends JPanel{
    private Image bgImage;
    public MyPanel(Image bg){
        bgImage = bg;

    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        repaint();
        g.drawImage(bgImage, 0, 0, null);

    }
}