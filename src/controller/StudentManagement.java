package controller;
import view.MainGUI;
import java.awt.event.*;
public class StudentManagement{
    private MainGUI gui;
    public StudentManagement(){
        gui = new MainGUI();
        gui.getBtn1().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                System.out.println("click");
            }
        });
    }
}