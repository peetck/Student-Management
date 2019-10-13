package view;
import java.awt.*;
import javax.swing.*;
public class ManagementGUI{
    private JPanel p1, left, right;
    public ManagementGUI(){
        p1 = new JPanel();
        left = new JPanel();
        right = new JPanel();
        p1.setLayout(new BorderLayout());
        left.setLayout(new GridLayout(5, 1));
        for (int i = 0; i < 5; i++){
            left.add(new JButton("" + i));
        }
        right.add(new JButton("ss"));
        p1.add(right, BorderLayout.CENTER);
        p1.add(left, BorderLayout.WEST);
    }
    public JPanel getPanel(){
        return this.p1;
    }
}