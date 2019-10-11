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
        gui.getLoginButton().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                System.out.println("Login clicked!");
                user = db.getCollection("user");
                if (user.findOne() == null){
                    System.out.println("Wrong username or password");
                }
            }
        });
        gui.getRegisterButton().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){

            }
        });
    }
}