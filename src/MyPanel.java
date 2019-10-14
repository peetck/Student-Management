import java.awt.*;
import javax.swing.*;
public class MyPanel extends JPanel{
    private Image bgImage;
    public MyPanel(){
        bgImage = Toolkit.getDefaultToolkit().createImage("../images/bg.png");
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(bgImage, 0, 0, null);
    }
}