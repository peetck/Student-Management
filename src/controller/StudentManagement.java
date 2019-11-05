package controller;
import java.awt.*;

import java.awt.event.*;

import java.io.*;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import com.mongodb.*;

import java.util.*;


import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.*;


import model.*;
import view.*;
public class StudentManagement{
    private MainGUI gui;
    private Teacher teacher;
    private Mongo connect;
    private DB db;
    private DBCollection users;
    private String myUsername;
    private int currentPage = 1;
    private JTable table, scoreTable;
    
    
    private LoginGUI loginPage;
    private RegisterGUI registerPage;
    private ManagementGUI managementPage;
    private int TableSortStatus = 0;
    
    public StudentManagement(String hostname, int port){
        try{
            System.out.println("Connecting to mongoDB...");
            connect = new Mongo(hostname, port);
            db = connect.getDB("StudentManagement");
            users = db.getCollection("users");
            
            /* Auto register (admin/admin) register */
            BasicDBObject n = new BasicDBObject();
            n.put("username", "admin");
            n.put("password", Base64.getEncoder().withoutPadding().encodeToString("admin".getBytes()));
            users.insert(n);
            /*----------------*/
        }
        catch (Exception e){
        	JOptionPane.showMessageDialog(null, "Can't Connect to MongoDB with \nHOSTNAME: " + hostname + "\nPORT: " + port);
            System.exit(0);
        }
        gui = new MainGUI();
        gui.set("LoginGUI");
        
        loginPage = gui.getLoginGUI();
        registerPage = gui.getRegisterGUI();
        managementPage = gui.getManagementGUI();
        
        // ********* below here is event of all application *********
        loginPage.getBtn1().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String username = loginPage.getF1().getText();
                String password = loginPage.getF2().getText();
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
                loginPage.getL3().setText("Wrong Username or Password.");
            }
        });
        loginPage.getL4().addMouseListener (new MouseAdapter (){

            public void mouseClicked (MouseEvent e){
                gui.set("RegisterGUI");
            }

        });
        registerPage.getBtn2().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                System.out.println("RegisterGUI : Back btn clicked!!");
                gui.set("LoginGUI");
            }
        });
        registerPage.getBtn1().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                System.out.println("RegisterGUI : Register btn clicked!!");
                BasicDBObject n = new BasicDBObject();
                String username = registerPage.getF1().getText();
                String password = registerPage.getF2().getText();
                String cpassword = registerPage.getF3().getText();
                DBCursor curs = users.find();
                while (curs.hasNext()){
                    DBObject t = curs.next();
                    if (((String)t.get("username")).equals(username)){
                    	registerPage.getL5().setText("This username already taken!!");
                    	registerPage.getL5().setForeground(Color.RED);
                        return;
                    }
                }
                if (username.length() < 4 || username.length() > 20) {
                	registerPage.getL5().setText("Username length should be 4-20 characters.");
                	registerPage.getL5().setForeground(Color.RED);
                }
                else if (password.length() < 6 || username.length() > 30) {
                	registerPage.getL5().setText("Password length should be 6-30 characters.");
                	registerPage.getL5().setForeground(Color.RED);
                }
                else if (username.equals(password)) {
                	registerPage.getL5().setText("Password should be different from your username.");
                	registerPage.getL5().setForeground(Color.RED);
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
                    	registerPage.getL5().setText("Password can contain only letters a-z (A-Z) and any numbers from 0-9.");
                    	registerPage.getL5().setForeground(Color.RED);
                    	return;
                    }
                    if (number == false || lower == false || upper == false) {
                    	registerPage.getL5().setText("Password should have numbers upper case and lower case characters.");
                    	registerPage.getL5().setForeground(Color.RED);
                    	return;
                    }
                    n.put("username", username);
                    n.put("password", Base64.getEncoder().withoutPadding().encodeToString(password.getBytes()));
                    users.insert(n);
                    registerPage.getL5().setText("Register complete!!");
                	registerPage.getL5().setForeground(Color.GREEN);
                	registerPage.getF1().setText("");
                	registerPage.getF2().setText("");
                	registerPage.getF3().setText("");
                }
                else {
                	registerPage.getL5().setText("Password not match!!");
                	registerPage.getL5().setForeground(Color.RED);
                }
            }
        });
        // LoginGui enter event
        KeyListener loginListener = new KeyAdapter() {
        	public void keyPressed(KeyEvent e) {
        		int keycode = e.getKeyCode();
        		if (keycode == 10) {
        			loginPage.getBtn1().doClick();
        		}
        	}
        };
        loginPage.getF1().addKeyListener(loginListener);
        loginPage.getF2().addKeyListener(loginListener);
        
        KeyListener registerListener = new KeyAdapter() {

        	public void keyPressed(KeyEvent e) {
        		int keycode = e.getKeyCode();
        		if (keycode == 10) {
        			registerPage.getBtn1().doClick();
        		}
        	}

        };
        registerPage.getF1().addKeyListener(registerListener);
        registerPage.getF2().addKeyListener(registerListener);
        registerPage.getF3().addKeyListener(registerListener);
        
        managementPage.getMenu3().addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {
				if (currentPage == 3) {
					return;
				}
				managementPage.set("add/delete");
				
				currentPage = 3;
				updatePage();
			}

        });
        
        managementPage.getMenu1().addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {
				if (currentPage == 1) {
					return;
				}
				managementPage.set("mystudent");
				
				currentPage = 1;
				updatePage();
			}

        });
        
        managementPage.getMenu4().addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {
				int before = currentPage;
				currentPage = 4;
				updatePage();
				MyPanel p1 = Helper.createPanel("");
				JLabel msg = Helper.createLabel("รหัสนักศึกษา : ");
				JTextField tf = Helper.createTextField(10);
				p1.add(msg);
				p1.add(tf);
				int alert = JOptionPane.showConfirmDialog(null, p1, "ลบนักเรียน", JOptionPane.OK_CANCEL_OPTION);
				if (alert == JOptionPane.OK_OPTION) {
					if ((delete(tf.getText()))) {
						JLabel msg2 = Helper.createLabel("ลบนักศึกษานี้ออกจากระบบเรียบร้อยแล้ว");
	    				JOptionPane.showMessageDialog(null, msg2);
					}
					else{
						JLabel msg2 = Helper.createLabel("ไม่มีรหัสนักศึกษานี้อยู่ในระบบ");
	    				JOptionPane.showMessageDialog(null, msg2);
					}
                }
				currentPage = before;
				updatePage();
			}

        });
        
        managementPage.getMenu2().addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {
				if (currentPage == 2) {
					return;
				}
				managementPage.set("score");
				
				currentPage = 2;
				updatePage();
			}

        });
        managementPage.getMenu5().addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {
				if (currentPage == 5) {
					return;
				}
				managementPage.set("setting");
				
				currentPage = 5;
				updatePage();
			}

        });

        managementPage.getMenu6().addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {
				int before = currentPage;
				currentPage = 6;
				updatePage();
				JLabel msg = Helper.createLabel("คุณแน่ใจที่จะออกจากโปรแกรมใช่หรือไม่");
				int dialogButton = JOptionPane.YES_NO_OPTION;
				int dialogResult = JOptionPane.showConfirmDialog (null, msg, "Exit", dialogButton);
				if(dialogResult == JOptionPane.YES_OPTION){
					System.exit(0);
				}
				currentPage = before;
				updatePage();
			}

        });

        managementPage.getAddStudentGUI().getBtn1().addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		for (int i = 0; i < teacher.getStudents().size(); i++) {
        			if (teacher.getStudents().get(i).getStudentID().equals(managementPage.getAddStudentGUI().getF1().getText())) {
        				JLabel msg = Helper.createLabel("มีรหัสนักศึกษานี้อยู่ในระบบอยู่แล้ว คุณต้องการที่จะแก้ไขข้อมูลหรือไม่??");
        				int alert = JOptionPane.showConfirmDialog(null, msg, "ยืนยัน", JOptionPane.OK_CANCEL_OPTION);
        				if (alert == JOptionPane.OK_OPTION) {
        					delete(teacher.getStudents().get(i).getStudentID());
        					addStudent();
        				}
            			return;	
        			}
        		}
            	addStudent();
        	}
    	});

        managementPage.getScoreGUI().getBtn1().addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		MyPanel p1 = Helper.createPanel("");
				JLabel msg = Helper.createLabel("รหัสนักศึกษา : ");
				JTextField tf = Helper.createTextField(10);
				p1.add(msg);
				p1.add(tf);
				int alert = JOptionPane.showConfirmDialog(null, p1, "แก้ไขคะแนน", JOptionPane.OK_CANCEL_OPTION);
				if (alert == JOptionPane.OK_OPTION) {
					ArrayList<Student> arr = teacher.getStudents();
					for (int i = 0; i < arr.size(); i++) {
						if (tf.getText().equals(arr.get(i).getStudentID())) {
							// แก้ไข คะแนน
							MyPanel p2 = Helper.createPanel("");
							p2.setLayout(new GridLayout(4, 2));
							JLabel msg01 = Helper.createLabel("Assignment1");
							JLabel msg02 = Helper.createLabel("Assignment2");
							JLabel msg03 = Helper.createLabel("Midterm Score");
							JLabel msg04 = Helper.createLabel("Final Score");
							JTextField tf01 = Helper.createTextField(10);
							JTextField tf02 = Helper.createTextField(10);
							JTextField tf03 = Helper.createTextField(10);
							JTextField tf04 = Helper.createTextField(10);
							p2.add(msg01);
							p2.add(tf01);
							p2.add(msg02);
							p2.add(tf02);
							p2.add(msg03);
							p2.add(tf03);
							p2.add(msg04);
							p2.add(tf04);
							int alert2 = JOptionPane.showConfirmDialog(null, p2, "แก้ไขคะแนน", JOptionPane.OK_CANCEL_OPTION);
							if (alert2 == JOptionPane.OK_OPTION) {
								if (Double.parseDouble(tf01.getText()) + Double.parseDouble(tf02.getText()) + Double.parseDouble(tf03.getText()) + Double.parseDouble(tf04.getText()) > 100) {
									JOptionPane.showMessageDialog(null, Helper.createLabel("ไม่สามารถกําหนคะแนนให้เกิน 100 ได้"));
									return;
								}
								arr.get(i).setScore(Double.parseDouble(tf01.getText()), Double.parseDouble(tf02.getText()), Double.parseDouble(tf03.getText()), Double.parseDouble(tf04.getText()));
								updateScoreTable();
								
								BasicDBObject n = new BasicDBObject();
;
						    	
								
								DBCollection myStudent = db.getCollection(myUsername);
						    	DBCursor curs = myStudent.find();
						    	DBObject t = curs.next();
						    	for (int j = 0; j < i; j++) {
						    		t = curs.next();
						    	}
								
						    	n.putAll(t);
						    	n.put("assignment1", Double.parseDouble(tf01.getText()));
						    	n.put("assignment2", Double.parseDouble(tf02.getText()));
								n.put("midterm_score", Double.parseDouble(tf03.getText()));
								n.put("final_score", Double.parseDouble(tf04.getText()));
						    	
								myStudent.update(t, n);								
			    				JOptionPane.showMessageDialog(null, Helper.createLabel("แก้ไขคะแนนเรียบร้อยแล้ว"));
			    				updateScoreTable();
							}
							return;
						}
					}
					JLabel msg2 = Helper.createLabel("ไม่มีรหัสนักศึกษานี้อยู่ในระบบ");
    				JOptionPane.showMessageDialog(null, msg2);
                }
        	}
        });
        
        managementPage.getAddStudentGUI().getBtn2().addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		JFileChooser chooser = new JFileChooser();
        	    chooser.showOpenDialog(null);
        	    File f = chooser.getSelectedFile();
        	    String sourcePath = f.getAbsolutePath();

        	    
        	    
        	    Image img = Toolkit.getDefaultToolkit().getImage(sourcePath);
        	    img = img.getScaledInstance(150, 150, Image.SCALE_DEFAULT);
        	    ImageIcon icon = new ImageIcon(img);
        	    managementPage.getAddStudentGUI().getPictureLabel().setIcon(icon);
        	    managementPage.getAddStudentGUI().setPicturePath(sourcePath);

        	}
        });
        
        managementPage.getAddStudentGUI().getBtn3().addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		MyPanel p1 = Helper.createPanel("");
				JLabel msg = Helper.createLabel("รหัสนักศึกษา : ");
				JTextField tf = Helper.createTextField(10);
				p1.add(msg);
				p1.add(tf);
				int alert = JOptionPane.showConfirmDialog(null, p1, "ดึงข้อมูล", JOptionPane.OK_CANCEL_OPTION);
				if (alert == JOptionPane.OK_OPTION) {
					ArrayList<Student> arr = teacher.getStudents();
					for (int i = 0; i < arr.size(); i++) {
						if (arr.get(i).getStudentID().equals(tf.getText())) {
					    	HashMap<String, String> info = arr.get(i).getInformation();
					    	
					    	
					    	managementPage.getAddStudentGUI().getF1().setText(info.get("studentID"));

					    	managementPage.getAddStudentGUI().getF2().setSelectedItem(info.get("faculty"));
					    	
					    	
					    	managementPage.getAddStudentGUI().getF3().setSelectedItem(info.get("title"));
					    	managementPage.getAddStudentGUI().getF4().setText(info.get("name"));
					    	managementPage.getAddStudentGUI().getF5().setText(info.get("surname"));
					    	
					    	managementPage.getAddStudentGUI().getF6_1().setSelectedItem(info.get("day"));
					    	managementPage.getAddStudentGUI().getF6_2().setSelectedItem(info.get("month"));
					    	managementPage.getAddStudentGUI().getF6_3().setSelectedItem(info.get("year"));
					    	
					    	managementPage.getAddStudentGUI().getF7().setText(info.get("cardID"));
					    	managementPage.getAddStudentGUI().getF8().setText(info.get("address"));
					    	managementPage.getAddStudentGUI().getF9().setText(info.get("race"));
					    	managementPage.getAddStudentGUI().getF10().setText(info.get("religion"));
					    	managementPage.getAddStudentGUI().getF11().setText(info.get("bloodType"));
					    	managementPage.getAddStudentGUI().getF12().setText(info.get("tel"));
					    	managementPage.getAddStudentGUI().getF13().setText(info.get("email"));
					    	managementPage.getAddStudentGUI().getF14().setText(info.get("height"));
					    	managementPage.getAddStudentGUI().getF15().setText(info.get("weight"));
					    	managementPage.getAddStudentGUI().getF16().setText(info.get("parentTel"));
					    	managementPage.getAddStudentGUI().getF17().setText(info.get("disease"));
					    	
					    	String path = arr.get(i).getPicturePath();
					    	Image img = null;
					    	if (path.equals("default")) {
					    		img = Helper.getImage("/images/blank_profile.png");
					    	}
					    	else {
					    		img = Toolkit.getDefaultToolkit().getImage(path);
					    	}
					    	img = img.getScaledInstance(150, 150, Image.SCALE_DEFAULT);
				        	ImageIcon icon = new ImageIcon(img);
				        	managementPage.getAddStudentGUI().getPictureLabel().setIcon(icon);
							return;
						}
					}
				}
				else {
					return;
				}
				JLabel msg2 = Helper.createLabel("ไม่มีรหัสนักศึกษานี้อยู่ในระบบ");
				JOptionPane.showMessageDialog(null, msg2);
        	}
        });
        
        loginPage.getGithub().addMouseListener(new MouseAdapter() {
        	public void mouseClicked(MouseEvent e) {
				if (Desktop.isDesktopSupported()) {
					try {
				        Desktop.getDesktop().browse(new URI("https://github.com/peetck/Student-Management"));
					}
					catch (Exception e1) {}
				} 
				else {
					System.out.println("Desktop is not supported!!");
				}
			}
        });
        
     }
    
    // below here is method in all application

    public void addStudent() {
    	String studentID, faculty, title, name, surname, day, month, year, cardID,
    	address, race, religion, bloodType, tel, email, height, weight, sourcePath,
    	parentTel, disease, enrollAt, picturePath;
    	
    	studentID = managementPage.getAddStudentGUI().getF1().getText();

    	faculty = managementPage.getAddStudentGUI().getF2().getSelectedItem().toString();
    	title = managementPage.getAddStudentGUI().getF3().getSelectedItem().toString();
    	name = managementPage.getAddStudentGUI().getF4().getText();
    	surname = managementPage.getAddStudentGUI().getF5().getText();
    	
    	day = managementPage.getAddStudentGUI().getF6_1().getSelectedItem().toString();
    	month = managementPage.getAddStudentGUI().getF6_2().getSelectedItem().toString();
    	year = managementPage.getAddStudentGUI().getF6_3().getSelectedItem().toString();
    	
    	cardID = managementPage.getAddStudentGUI().getF7().getText();
    	address = managementPage.getAddStudentGUI().getF8().getText();
    	race = managementPage.getAddStudentGUI().getF9().getText();
    	religion = managementPage.getAddStudentGUI().getF10().getText();
    	bloodType = managementPage.getAddStudentGUI().getF11().getText();
    	tel = managementPage.getAddStudentGUI().getF12().getText();
    	email = managementPage.getAddStudentGUI().getF13().getText();
    	height = managementPage.getAddStudentGUI().getF14().getText();
    	weight = managementPage.getAddStudentGUI().getF15().getText();
    	parentTel = managementPage.getAddStudentGUI().getF16().getText();
    	disease = managementPage.getAddStudentGUI().getF17().getText();
    	enrollAt = "" + java.time.LocalDate.now();
    	
    	if (studentID.equals("") || name.equals("") || surname.equals("") || cardID.equals("") || address.equals("") ||
    		race.equals("") || religion.equals("") || bloodType.equals("") || tel.equals("") || email.equals("") ||
    		height.equals("") || weight.equals("") || parentTel.equals("") || disease.equals("")) {
    		
    		JOptionPane.showMessageDialog(null, Helper.createLabel("กรุณากรอกข้อมูลให้ครบถ้วน"));
    		return;
    	}
    	
    	sourcePath = managementPage.getAddStudentGUI().getPicturePath();
    	
    	try {
    		Path source = Paths.get(sourcePath);
        	Path targetDir = Paths.get(System.getProperty("user.home") + "/StudentManagement/" + myUsername + "/images/studentPicture");
        	Files.createDirectories(targetDir);
        	Path target = targetDir.resolve((studentID + ".jpg"));
        	Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);
        	picturePath = System.getProperty("user.home") + "/StudentManagement/" + myUsername + "/images/studentPicture/" + studentID + ".jpg";
    	}
    	catch(Exception e1) {
    		picturePath = "default";
    	}
	    
    	
	    
	    
    	HashMap<String, String> information = new HashMap<String, String>();
    	HashMap<String, Double> score = new HashMap<String, Double>();
    	
    	
    	
    	DBCollection myStudent = db.getCollection(myUsername);
    	


    	
    	BasicDBObject n = new BasicDBObject();

    	n.put("studentID", studentID);
    	n.put("faculty", faculty);
    	n.put("title", title);
    	n.put("name", name);
    	n.put("surname", surname);
    	
    	n.put("day", day);
    	n.put("month", month);
    	n.put("year", year);
    	
    	n.put("cardID", cardID);
    	n.put("address", address);
    	n.put("race", race);
    	n.put("religion", religion);
    	n.put("bloodType", bloodType);
    	n.put("tel", tel);
    	n.put("email", email);
    	n.put("height", height);
    	n.put("weight", weight);
    	n.put("parentTel", parentTel);
    	n.put("disease", disease);
    	n.put("enrollAt", enrollAt);
    	
    	n.put("midterm_score", 0.0);
    	n.put("final_score", 0.0);
    	n.put("assignment1", 0.0);
    	n.put("assignment2", 0.0);
    	
    	n.put("picturePath", picturePath);
    	
    	myStudent.insert(n);

    	information.put("studentID", studentID);
    	information.put("faculty", faculty);
    	information.put("title", title);
    	information.put("name", name);
    	information.put("surname", surname);
    	
    	information.put("day", day);
    	information.put("month", month);
    	information.put("year", year);
    	
    	information.put("cardID", cardID);
    	information.put("address", address);
    	information.put("race", race);
    	information.put("religion", religion);
    	information.put("bloodType", bloodType);
    	information.put("tel", tel);
    	information.put("email", email);
    	information.put("height", height);
    	information.put("weight", weight);
    	information.put("parentTel", parentTel);
    	information.put("disease", disease);
    	information.put("enrollAt", enrollAt);
    	
    	score.put("midterm_score", 0.0);
    	score.put("final_score", 0.0);
    	score.put("assignment1", 0.0);
    	score.put("assignment2", 0.0);
    	
    	teacher.addStudent(new Student(information, score, picturePath));
    	// add success
    	
    	// update table
    	sortTable(0, false);
    	updateTable();
    	updateScoreTable();
    	
    	managementPage.getAddStudentGUI().reset();
    	JLabel msg = Helper.createLabel("เพิ่มนักเรียนเรียบร้อยแล้ว");
		JOptionPane.showMessageDialog(null, msg);
    }
    

    public boolean delete(String studentID) {
    	DBCollection myStudent = db.getCollection(myUsername);
    	DBCursor curs = myStudent.find();
        while (curs.hasNext()){
            DBObject t = curs.next();
            if (((String)t.get("studentID")).equals(studentID)) {
            	myStudent.remove(t);
            	for (int i = 0; i < teacher.getStudents().size(); i++) {
            		if (teacher.getStudents().get(i).getStudentID().equals(studentID)) {
            			teacher.getStudents().remove(i);
            			break;
            		}
            	}
            	System.out.println("delete success");
                updateTable();
                updateScoreTable();
            	return true;
            }
        }
        sortTable(0, false);
        updateTable();
        updateScoreTable();
        return false;
    }
    public void login_success() {
        System.out.println("Login success!!");
    	teacher = new Teacher();
    	DBCollection myStudent = db.getCollection(myUsername);
    	DBCursor curs = myStudent.find();
        while (curs.hasNext()){
            DBObject t = curs.next();
            HashMap<String, String> information = new HashMap<String, String>();
        	HashMap<String, Double> score = new HashMap<String, Double>();
        	
        	information.put("studentID", "" + t.get("studentID"));
        	information.put("faculty", "" + t.get("faculty"));
        	information.put("title", "" + t.get("title"));
        	information.put("name", "" + t.get("name"));
        	information.put("surname", "" + t.get("surname"));
        	
        	information.put("day", "" + t.get("day"));
        	information.put("month", "" + t.get("month"));
        	information.put("year", "" + t.get("year"));
        	
        	information.put("cardID", "" + t.get("cardID"));
        	information.put("address", "" + t.get("address"));
        	information.put("race", "" + t.get("race"));
        	information.put("religion", "" + t.get("religion"));
        	information.put("bloodType", "" + t.get("bloodType"));
        	information.put("tel", "" + t.get("tel"));
        	information.put("email", "" + t.get("email"));
        	information.put("height", "" + t.get("height"));
        	information.put("weight", "" + t.get("weight"));
        	information.put("parentTel", "" + t.get("parentTel"));
        	information.put("disease", "" + t.get("disease"));
        	information.put("enrollAt", "" + t.get("enrollAt"));
        	
        	score.put("midterm_score", Double.parseDouble("" + t.get("midterm_score")));
        	score.put("final_score", Double.parseDouble("" + t.get("final_score")));
        	score.put("assignment1", Double.parseDouble("" + t.get("assignment1")));
        	score.put("assignment2", Double.parseDouble("" + t.get("assignment2")));
        	
        	String picturePath = "" + t.get("picturePath");
            teacher.addStudent(new Student(information, score, picturePath));
        }
        sortTable(0, false);
        updateTable();
        updateScoreTable();
        updatePage();
    }
    
    // update Student table method
    public void updateTable() {
    	ArrayList<Student> students = teacher.getStudents();
    	Object[][] data = new Object[students.size()][5];
		for (int i = 0; i < students.size(); i++) {
			data[i] = students.get(i).getTableHeadInfo();
		}
		Object[] header = {"รหัสนักศึกษา", "ชื่อ", "นามสกุล", "เพิ่มเข้ามาในวันที่"	,""};
		
		DefaultTableModel dm = new DefaultTableModel();
		dm.setDataVector(data, header);
		table = new JTable(dm);
		table.getColumn("").setCellRenderer(new ButtonRenderer());
		table.getColumn("").setCellEditor(new ButtonEditor(new JCheckBox(), teacher));
		
		table.getTableHeader().setReorderingAllowed(false);
		table.setDefaultEditor(Object.class, null);
		table.setFillsViewportHeight(true);
		
		for (int i = 0; i < table.getColumnCount() - 1; i++) {
			table.getColumnModel().getColumn(i).setCellRenderer(new CellRenderer());
		}
		table.setBorder(new LineBorder(Color.RED, 0));
		
		table.getTableHeader().addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseClicked(MouseEvent e) {
		        int col = table.columnAtPoint(e.getPoint());
		        sortTable(col, true);
		    }
		});
		
		managementPage.getMyStudentGUI().updateTable(table);
    }
    
    public void updateScoreTable() {
    	ArrayList<Student> students = teacher.getStudents();
    	Object[][] data = new Object[students.size()][7];
		for (int i = 0; i < students.size(); i++) {
			data[i] = students.get(i).getScore();
		}
		Object[] header = {"รหัสนักศึกษา", "Assignment1", "Assignment2", "Midterm", "Final", "รวมคะแนน", "เกรดที่ได้"};

		DefaultTableModel dm = new DefaultTableModel();

		dm.setDataVector(data, header);
		scoreTable = new JTable(dm);
		scoreTable.setDefaultEditor(Object.class, null);
		scoreTable.getTableHeader().setReorderingAllowed(false);
		scoreTable.setFillsViewportHeight(true);
		for (int i = 0; i < scoreTable.getColumnCount(); i++) {
			scoreTable.getColumnModel().getColumn(i).setCellRenderer(new CellRenderer());

		}
		
		scoreTable.setBorder(new LineBorder(Color.RED, 0));
		managementPage.getScoreGUI().updateTable(scoreTable);
    }
    public void updatePage() {      
    	managementPage.getMenu1().setBackground(new Color(156, 195, 213));
    	managementPage.getMenu2().setBackground(new Color(156, 195, 213));
		managementPage.getMenu3().setBackground(new Color(156, 195, 213));
		managementPage.getMenu4().setBackground(new Color(156, 195, 213));
		managementPage.getMenu5().setBackground(new Color(156, 195, 213));
		managementPage.getMenu6().setBackground(new Color(156, 195, 213));
    	switch(currentPage) {
    		case 1: managementPage.getMenu1().setBackground(Color.WHITE);break;
    		case 2: managementPage.getMenu2().setBackground(Color.WHITE);break;
    		case 3: managementPage.getMenu3().setBackground(Color.WHITE);break;
    		case 4: managementPage.getMenu4().setBackground(Color.WHITE);break;
    		case 5: managementPage.getMenu5().setBackground(Color.WHITE);break;
    		case 6: managementPage.getMenu6().setBackground(Color.WHITE);break;
    	}
    }
    
    public void sortTable(int col, boolean change) {
    	ArrayList<Student> arr = teacher.getStudents();
    	if (change) {
        	if (TableSortStatus == 0) {
        		TableSortStatus = 1;
        	}
        	else {
        		TableSortStatus = 0;
        	}
    	}
    	if (col == 0) { // studentID
    		sort(arr, 0, arr.size() - 1, "studentID");
    	}

    	
    	teacher.setStudents(arr);
    	updateTable();

    }
    public void sort(ArrayList<Student> arr, int l, int r, String select) {
    	if (l < r) {
    		int m = l + ((r - l) / 2);
    		sort(arr, l, m, select);
    		sort(arr, m + 1, r, select);
    		merge(arr, l, m, r, select);
    	}

    }
    public void merge(ArrayList<Student> arr, int l, int m, int r, String select) {
    	int s1 = m - l + 1;
    	int s2 = r - m;
    	Student[] n1 = new Student[s1];
    	Student[] n2 = new Student[s2];
    	for (int i = 0; i < s1; i++) {
    		n1[i] = arr.get(l + i);
    	}
    	for (int i = 0; i < s2; i++) {
    		n2[i] = arr.get(m + i + 1);
    	}
    	
    	int i = 0, j = 0, k = l;
    	if (select.equals("studentID")) {
    		if (this.TableSortStatus == 0) {
    			while (i < s1 && j < s2) {
            		if (Integer.parseInt(n1[i].getStudentID()) < Integer.parseInt(n2[j].getStudentID())){
            			arr.set(k, n1[i]);
            			i++;
            			k++;
            		}
            		else {
            			arr.set(k, n2[j]);
            			j++;
            			k++;
            		}
            	}
    		}
    		else if (this.TableSortStatus == 1) {
    			while (i < s1 && j < s2) {
            		if (Integer.parseInt(n1[i].getStudentID()) > Integer.parseInt(n2[j].getStudentID())){
            			arr.set(k, n1[i]);
            			i++;
            			k++;
            		}
            		else {
            			arr.set(k, n2[j]);
            			j++;
            			k++;
            		}
            	}
    		}
    		
    	}
    	
    	
    	while (i < s1) {
    		arr.set(k, n1[i]);
			i++;
			k++;
    	}
    	
    	while (j < s2) {
    		arr.set(k, n2[j]);
			j++;
			k++;
    	}
    }
}



















