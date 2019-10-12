package controller;
import view.MainGUI;
import java.awt.event.*;
import com.mongodb.*;
public class StudentManagement{
    private MainGUI gui;
    private Mongo connect;
    private DB db;
    private DBCollection user;
    public StudentManagement(){
        try{
            System.out.println("Connecting to mongoDB...");
            connect = new Mongo("localhost", 27017);
            db = connect.getDB("StudentManagement");

            /* if (user.findOne() == null){

            } */
            /* BasicDBObject newProduct = new BasicDBObject();
            newProduct.put("productID", "productID");
            newProduct.put("productName", "productName");
            test.insert(newProduct); */
            System.out.println("Connected!!");
        }
        catch (Exception e){
            System.out.println("Can't Connect to Database!");
            System.exit(0);
        }
        gui = new MainGUI();
        gui.set("LoginGUI");
        gui.getLoginGUI().getBtn1().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                System.out.println("LoginGUI : Login btn clicked!!!");
                System.out.println("Username : " + gui.getLoginGUI().getF1().getText());
                System.out.println("Password : " + gui.getLoginGUI().getF2().getText());
            }
        });
        gui.getLoginGUI().getBtn2().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                System.out.println("LoginGUI : Register btn clicked!!!");
                gui.set("RegisterGUI");
            }
        });
        gui.getRegisterGUI().getBtn2().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                System.out.println("RegisterGUI : Back btn clicked!!");
                gui.set("LoginGUI");
            }
        });
    }
}