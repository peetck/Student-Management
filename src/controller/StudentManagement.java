package controller;
import java.awt.event.*;
import com.mongodb.*;
import java.util.*;
import model.*;
import view.*;
public class StudentManagement{
    private MainGUI gui;
    private Teacher teacher;
    private Mongo connect;
    private DB db;
    private DBCollection user;
    public StudentManagement(){
        try{
            System.out.println("Connecting to mongoDB...");
            connect = new Mongo("localhost", 27017);
            db = connect.getDB("StudentManagement");
            user = db.getCollection("user");
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
                String username = gui.getLoginGUI().getF1().getText();
                String password = gui.getLoginGUI().getF2().getText();
                DBCursor curs = user.find();
                while (curs.hasNext()){
                    DBObject t = curs.next();
                    System.out.println((String)t.get("username"));
                    System.out.println((String)t.get("password"));
                    System.out.println("--------------------------");
                    if (((String)t.get("username")).equals(username) && ((String)t.get("password")).equals(password)){
                        System.out.println("Login success!!");
                        gui.set("ManagementGUI");
                        return;
                    }
                }
                gui.getLoginGUI().getL3().setText("Wrong Username or Password");
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
        gui.getRegisterGUI().getBtn1().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                System.out.println("RegisterGUI : Register btn clicked!!");
                BasicDBObject n = new BasicDBObject();
                String username = gui.getRegisterGUI().getF1().getText();
                String password = gui.getRegisterGUI().getF2().getText();
                String cpassword = gui.getRegisterGUI().getF3().getText();
                DBCursor curs = user.find();
                while (curs.hasNext()){
                    DBObject t = curs.next();
                    if (((String)t.get("username")).equals(username)){
                        System.out.println("this username already taken!!");
                        return;
                    }
                }
                if (password.equals(cpassword)){
                    n.put("username", username);
                    n.put("password", password);
                    user.insert(n);
                }
            }
        });
    }
}