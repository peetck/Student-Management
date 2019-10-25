package controller;
import java.awt.*;
import java.awt.event.*;
import com.mongodb.*;
import java.util.*;
import javax.swing.*;
import model.*;
import view.*;
public class StudentManagement{
    private MainGUI gui;
    private Teacher teacher;
    private Mongo connect;
    private DB db;
    private DBCollection users;
    private String myUsername;
    public StudentManagement(String hostname, int port){
        try{
            System.out.println("Connecting to mongoDB...");
            connect = new Mongo(hostname, port);
            db = connect.getDB("StudentManagement");
            users = db.getCollection("users");
        }
        catch (Exception e){
        	JOptionPane.showMessageDialog(null, "Can't Connect to MongoDB with \nHOSTNAME: " + hostname + "\nPORT: " + port);
            System.exit(0);
        }
        gui = new MainGUI();
        gui.set("LoginGUI");
        
        
        
        // ********* below here is event of all application *********
        gui.getLoginGUI().getBtn1().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String username = gui.getLoginGUI().getF1().getText();
                String password = gui.getLoginGUI().getF2().getText();
                DBCursor curs = users.find();
                while (curs.hasNext()){
                    DBObject t = curs.next();
                    if (((String)t.get("username")).equals(username) && ((String)t.get("password")).equals(Base64.getEncoder().withoutPadding().encodeToString(password.getBytes()))){
                        gui.set("ManagementGUI");
                        myUsername = username;
                        login_success();
                        return;
                    }
                }
                gui.getLoginGUI().getL3().setText("Wrong Username or Password.");
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
                    	gui.getRegisterGUI().getL5().setText("This username already taken!!");
                    	gui.getRegisterGUI().getL5().setForeground(Color.RED);
                        return;
                    }
                }
                if (username.length() < 4 || username.length() > 20) {
                	gui.getRegisterGUI().getL5().setText("Username length should be 4-20 characters.");
                	gui.getRegisterGUI().getL5().setForeground(Color.RED);
                }
                else if (password.length() < 6 || username.length() > 30) {
                	gui.getRegisterGUI().getL5().setText("Password length should be 6-30 characters.");
                	gui.getRegisterGUI().getL5().setForeground(Color.RED);
                }
                else if (username.equals(password)) {
                	gui.getRegisterGUI().getL5().setText("Password should be different from your username.");
                	gui.getRegisterGUI().getL5().setForeground(Color.RED);
                }
                else if (password.equals(cpassword)){
                    boolean upper = false, lower = false, alphabet = true, number = false;
                    String check = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
                    for (int i = 0; i < password.length(); i++) {
                    	if (Character.isUpperCase(password.charAt(i))){
                    		upper = true;
                    	}
                    	if (Character.isLowerCase(password.charAt(i))){
                    		lower = true;
                    	}
                    	if (password.charAt(i) >= '0' && password.charAt(i) <= '9') {
                    		number = true;
                    	}
                    	if(!(check.contains("" + password.charAt(i)))) {
                    		alphabet = false;
                    	}
                    }
                    if (alphabet == false) {
                    	gui.getRegisterGUI().getL5().setText("Password can contain only letters a-z (A-Z) and any numbers from 0-9.");
                    	gui.getRegisterGUI().getL5().setForeground(Color.RED);
                    	return;
                    }
                    if (number == false || lower == false || upper == false) {
                    	gui.getRegisterGUI().getL5().setText("Password should have numbers upper case and lower case characters.");
                    	gui.getRegisterGUI().getL5().setForeground(Color.RED);
                    	return;
                    }
                    n.put("username", username);
                    n.put("password", Base64.getEncoder().withoutPadding().encodeToString(password.getBytes()));
                    users.insert(n);
                    gui.getRegisterGUI().getL5().setText("Register complete!!");
                	gui.getRegisterGUI().getL5().setForeground(Color.GREEN);
                	gui.getRegisterGUI().getF1().setText("");
                	gui.getRegisterGUI().getF2().setText("");
                	gui.getRegisterGUI().getF3().setText("");
                }
                else {
                	gui.getRegisterGUI().getL5().setText("Password not match!!");
                	gui.getRegisterGUI().getL5().setForeground(Color.RED);
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
        
        gui.getManagementGUI().getMenu3().addMouseListener(new MouseListener() {
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
        
        gui.getManagementGUI().getMenu4().addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				gui.getManagementGUI().set("setting");
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
        
        gui.getManagementGUI().getMenu2().addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				gui.getManagementGUI().set("score");
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
        
        gui.getManagementGUI().getAddDeleteStudentGUI().getRight().addMouseListener(new MouseListener() {
        	@Override
			public void mouseClicked(MouseEvent e) {
				gui.set("DeleteGUI");
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
        gui.getManagementGUI().getAddDeleteStudentGUI().getDeleteGUI().getBtn1().addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		gui.set("ManagementGUI");
        		
        	}
        });
    }
    
    // below here is method in all application
    
    public void addStudent() {
    	String studentID, title, name, surname, cardID, address, race, religion, bloodType, tel, height, weight, parentTel, enrollAt;
    	studentID = gui.getManagementGUI().getAddDeleteStudentGUI().getAddGUI().getF1().getText();
    	title = gui.getManagementGUI().getAddDeleteStudentGUI().getAddGUI().getF2().getText();
    	name = gui.getManagementGUI().getAddDeleteStudentGUI().getAddGUI().getF3().getText();
    	surname = gui.getManagementGUI().getAddDeleteStudentGUI().getAddGUI().getF4().getText();
    	cardID = gui.getManagementGUI().getAddDeleteStudentGUI().getAddGUI().getF5().getText();
    	address = gui.getManagementGUI().getAddDeleteStudentGUI().getAddGUI().getF6().getText();
    	race = gui.getManagementGUI().getAddDeleteStudentGUI().getAddGUI().getF7().getText();
    	religion = gui.getManagementGUI().getAddDeleteStudentGUI().getAddGUI().getF8().getText();
    	bloodType = gui.getManagementGUI().getAddDeleteStudentGUI().getAddGUI().getF9().getText();
    	tel = gui.getManagementGUI().getAddDeleteStudentGUI().getAddGUI().getF10().getText();
    	height = gui.getManagementGUI().getAddDeleteStudentGUI().getAddGUI().getF11().getText();
    	weight = gui.getManagementGUI().getAddDeleteStudentGUI().getAddGUI().getF12().getText();
    	parentTel = gui.getManagementGUI().getAddDeleteStudentGUI().getAddGUI().getF13().getText();
    	enrollAt = "" + java.time.LocalDate.now();
    	
    	BasicDBObject n = new BasicDBObject();
    	n.put("studentID", studentID);
    	n.put("title", title);
    	n.put("name", name);
    	n.put("surname", surname);
    	n.put("cardID", cardID);
    	n.put("address", address);
    	n.put("race", race);
    	n.put("religion", religion);
    	n.put("bloodType", bloodType);
    	n.put("tel", tel);
    	n.put("height", height);
    	n.put("weight", weight);
    	n.put("parentTel", parentTel);
    	n.put("enrollAt", enrollAt);
    	
    	DBCollection myStudent = db.getCollection(myUsername);
    	myStudent.insert(n);
    	
    	teacher.addStudent(new Student(studentID, title, name, surname, cardID, address, race, religion, bloodType, tel, height, weight, parentTel, enrollAt));
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
            teacher.addStudent(new Student((String)t.get("studentID"), (String)t.get("title"), (String)t.get("name"), (String)t.get("surname"), (String)t.get("cardID"), (String)t.get("address"), (String)t.get("race"), (String)t.get("religion"), (String)t.get("bloodType"), (String)t.get("tel"), (String)t.get("height"), (String)t.get("weight"), (String)t.get("parentTel"), (String)t.get("enrollAt")));
        }
        // update Table
        updateTable();
    }
    public void updateTable() {
    	ArrayList<Student> students = teacher.getStudents();
    	JTable table = new JTable();
    	String[][] data = new String[students.size()][4];
		for (int i = 0; i < students.size(); i++) {
			data[i] = students.get(i).getInfo();
		}
		String[] header = {"รหัสนักศึกษา", "ชื่อ", "นามสกุล", "เพิ่มเข้ามาในวันที่",""};
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



















