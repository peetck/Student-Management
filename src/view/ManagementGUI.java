package view;
import java.awt.*;
import javax.swing.*;
public class ManagementGUI{
    private JPanel p1;
    public ManagementGUI(){
        p1 = new JPanel();
        p1.setLayout(new BorderLayout());
        p1.add(new JButton("test"), BorderLayout.EAST);
        p1.add(new JButton("test"), BorderLayout.WEST);
    }
    public JPanel getPanel(){
        return this.p1;
    }
}