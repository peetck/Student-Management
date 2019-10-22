package controller;
import java.awt.event.*;
import com.mongodb.*;
import java.util.*;

import javax.swing.JTable;

import model.*;
import view.*;
public class StudentManagement{
    private MainGUI gui;
    private Teacher teacher;
    private Mongo connect;
    private DB db;
    private DBCollection users;
    private String myUsername;
    public StudentManagement(){
        try{
            System.out.println("Connecting to mongoDB...");
            connect = new Mongo("localhost", 27017);
            db = connect.getDB("StudentManagement");
            users = db.getCollection("users");
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
        
        
        
        // ********* below here is event of all application *********
        gui.getLoginGUI().getBtn1().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                System.out.println("LoginGUI : Login btn clicked!!!");
                String username = gui.getLoginGUI().getF1().getText();
                String password = gui.getLoginGUI().getF2().getText();
                DBCursor curs = users.find();
                while (curs.hasNext()){
                    DBObject t = curs.next();
                    if (((String)t.get("username")).equals(username) && ((String)t.get("password")).equals(password)){
                        gui.set("ManagementGUI");
                        myUsername = username;
                        login_success();
                        return;
                    }
                }
                gui.getLoginGUI().getL3().setText("Wrong Username or Password");
            }
        });
        gui.getLoginGUI().getL4().addMouseListener (new MouseListener (){
            public void mouseClicked (MouseEvent e){
                gui.set("RegisterGUI");
            }
            public void mouseEntered(MouseEvent e) {}        	
			public void mousePressed(MouseEvent e) {}
			public void mouseReleased(MouseEvent e) {}
			public void mouseExited(MouseEvent e) {}
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
                DBCursor curs = users.find();
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
                    users.insert(n);
                }
            }
        });
        // LoginGui enter event
        KeyListener loginListener = new KeyListener() {
        	@Override
        	public void keyPressed(KeyEvent e) {
        		int keycode = e.getKeyCode();
        		if (keycode == 10) {
        			gui.getLoginGUI().getBtn1().doClick();
        		}
        	}
        	 
        	@Override
        	public void keyReleased(KeyEvent event) {
        	}
        	 
        	@Override
        	public void keyTyped(KeyEvent event) {       
        	}
        };
        gui.getLoginGUI().getF1().addKeyListener(loginListener);
        gui.getLoginGUI().getF2().addKeyListener(loginListener);
        
        gui.getManagementGUI().getMenu2().addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				gui.getManagementGUI().set("add/delete");
			}

			@Override
			public void mousePressed(MouseEvent e) {}

			@Override
			public void mouseReleased(MouseEvent e) {}

			@Override
			public void mouseEntered(MouseEvent e) {}

			@Override
			public void mouseExited(MouseEvent e) {}
        });
        
        gui.getManagementGUI().getMenu1().addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				gui.getManagementGUI().set("mystudent");
			}

			@Override
			public void mousePressed(MouseEvent e) {}

			@Override
			public void mouseReleased(MouseEvent e) {}

			@Override
			public void mouseEntered(MouseEvent e) {}

			@Override
			public void mouseExited(MouseEvent e) {}
        });
        
        
        gui.getManagementGUI().getAddDeleteStudentGUI().getLeft().addMouseListener(new MouseListener() {
        	@Override
			public void mouseClicked(MouseEvent e) {
				gui.set("AddGUI");
			}

			@Override
			public void mousePressed(MouseEvent e) {}

			@Override
			public void mouseReleased(MouseEvent e) {}

			@Override
			public void mouseEntered(MouseEvent e) {}

			@Override
			public void mouseExited(MouseEvent e) {}
        });
        gui.getManagementGUI().getAddDeleteStudentGUI().getAddGUI().getBtn1().addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		gui.set("ManagementGUI");
        		
        	}
        });
        gui.getManagementGUI().getAddDeleteStudentGUI().getAddGUI().getBtn2().addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		addStudent();
        	}
    	});
    }
    
    // below here is method in all application
    
    public void addStudent() {
    	String name, surname, studentID, address, enrollAt;
    	studentID = gui.getManagementGUI().getAddDeleteStudentGUI().getAddGUI().getF1().getText();
    	name = gui.getManagementGUI().getAddDeleteStudentGUI().getAddGUI().getF2().getText();
    	surname = gui.getManagementGUI().getAddDeleteStudentGUI().getAddGUI().getF3().getText();
    	address = gui.getManagementGUI().getAddDeleteStudentGUI().getAddGUI().getF4().getText();
    	enrollAt = "" + java.time.LocalDate.now();
    	BasicDBObject n = new BasicDBObject();
    	n.put("name", name);
    	n.put("surname", surname);
    	n.put("address", address);
    	n.put("studentID", studentID);
    	n.put("enrollAt", enrollAt);
    	
    	DBCollection myStudent = db.getCollection(myUsername);
    	myStudent.insert(n);
    	
    	teacher.addStudent(new Student(name, surname, address, studentID, enrollAt));
    	// add success
    	
    	// update table
    	updateTable();
    	
    }
    public void login_success() {
        System.out.println("Login success!!");
    	teacher = new Teacher();
    	DBCollection myStudent = db.getCollection(myUsername);
    	DBCursor curs = myStudent.find();
        while (curs.hasNext()){
            DBObject t = curs.next();
            teacher.addStudent(new Student((String)t.get("name"), (String)t.get("surname"), (String)t.get("address"), (String)t.get("studentID"), (String)t.get("enrollAt")));
        }
        // update Table
        updateTable();
    }
    public void updateTable() {
    	ArrayList<Student> students = teacher.getStudents();
    	JTable table = new JTable();
    	String[][] data = new String[students.size()][5];
		for (int i = 0; i < students.size(); i++) {
			data[i] = students.get(i).getInfo();
		}
		String[] header = {"รหัสนักศึกษา", "ชื่อ", "นามสกุล", "ที่อยู่", "เพิ่มเข้ามาในวันที่"};
		table = new JTable(data, header);
		table.getTableHeader().setReorderingAllowed(false);
		table.setDefaultEditor(Object.class, null);
		table.setFillsViewportHeight(true);
		 
		for (int i = 0; i < table.getColumnCount(); i++) {
			table.getColumnModel().getColumn(i).setCellRenderer(new CellRenderer());
		}
		gui.getManagementGUI().getMyStudentGUI().updateTable(table);

    }
}



















