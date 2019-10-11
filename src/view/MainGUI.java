package view;
import java.awt.*;
import javax.swing.*;
public class MainGUI{
    private JFrame fr;
    private JPanel p1;
    private JButton btn1;
    public MainGUI(){
        fr = new JFrame("Student Management");
        btn1 = new JButton("Welcom to Student ManageMent System");
        p1 = new JPanel();
        fr.add(btn1);
        fr.setSize(1200, 800);
        fr.setVisible(true);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    public JButton getBtn1(){
        return this.btn1;
    }
}