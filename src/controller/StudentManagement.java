package controller;

import java.awt.*;

import java.awt.event.*;

import java.io.*;
import java.net.URI;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.mongodb.*;

import mdlaf.animation.MaterialUIMovement;

import java.util.*;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.*;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import model.*;
import view.*;
public class StudentManagement{
    private MainGUI gui;
    private Teacher teacher;
    private MongoClient connect;
    private DB db;
    private DBCollection users;
    private String myUsername;
    private int currentPage = 1;
    private JTable table, scoreTable, scoreTable2, scoreTable3;
    
    
    private LoginGUI loginPage;
    private RegisterGUI registerPage;
    private ManagementGUI managementPage;
    private int TableSortStatus = 0;
    private boolean connected = false;
    private String hostname;
    private int port;
    private HashMap<String, Double> emptyScore = new HashMap<String, Double>();
    public StudentManagement(String inpHostname, int inpPort){
    	
    	emptyScore.put("s1_assignment", 0.0);
    	emptyScore.put("s1_project", 0.0);
    	emptyScore.put("s1_midterm", 0.0);
    	emptyScore.put("s1_final", 0.0);
    	
    	emptyScore.put("s2_assignment", 0.0);
    	emptyScore.put("s2_project", 0.0);
    	emptyScore.put("s2_midterm", 0.0);
    	emptyScore.put("s2_final", 0.0);
    	
    	emptyScore.put("s3_assignment", 0.0);
    	emptyScore.put("s3_project", 0.0);
    	emptyScore.put("s3_midterm", 0.0);
    	emptyScore.put("s3_final", 0.0);
    	
    	
    	
        this.hostname = inpHostname;
        this.port = inpPort;
    	
        
        gui = new MainGUI();
        
        gui.set("LoginGUI");
        loginPage = gui.getLoginGUI();
        registerPage = gui.getRegisterGUI();
        managementPage = gui.getManagementGUI();
        connectDB(hostname, port);
        if (!connected) {
        	MyPanel p = Helper.createPanel("");
			p.setLayout(new BorderLayout());
			MyPanel p2 = Helper.createPanel("");
			p2.setLayout(new GridLayout(2, 2));
			JLabel m1 = Helper.createLabel("HOST : ");
			JLabel m2 = Helper.createLabel("PORT : ");
			JLabel l1 = Helper.createLabel(hostname);
			JLabel l2 = Helper.createLabel("" + port);

			p2.add(m1);
			p2.add(l1);
			p2.add(m2);
			p2.add(l2);
			
			p.add(Helper.createLabel("เชื่อมต่อกับฐานข้อมูลไม่สําเร็จ"), BorderLayout.NORTH);
			p.add(p2);

			JOptionPane.showOptionDialog(null, p, "ตั้งค่าฐานข้อมูล", JOptionPane.CANCEL_OPTION, JOptionPane.ERROR_MESSAGE, null, new String[] {"ยืนยัน"}, null);
		}
        
        
        
        
        // ********* below here is event of all application *********
        loginPage.getBtn1().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
            	if (!connected) {
            		MyPanel p = Helper.createPanel("");
					p.setLayout(new BorderLayout());
					MyPanel p2 = Helper.createPanel("");
					p2.setLayout(new GridLayout(2, 2));
					JLabel m1 = Helper.createLabel("HOST : ");
					JLabel m2 = Helper.createLabel("PORT : ");
					JLabel l1 = Helper.createLabel(hostname);
					JLabel l2 = Helper.createLabel("" + port);

					p2.add(m1);
					p2.add(l1);
					p2.add(m2);
					p2.add(l2);
					
					p.add(Helper.createLabel("เชื่อมต่อกับฐานข้อมูลไม่สําเร็จ"), BorderLayout.NORTH);
					p.add(p2);

					JOptionPane.showOptionDialog(null, p, "ตั้งค่าฐานข้อมูล", JOptionPane.CANCEL_OPTION, JOptionPane.ERROR_MESSAGE, null, new String[] {"ยืนยัน"}, null);
            		return;
            	}
                String username = loginPage.getF1().getText();
                String password = loginPage.getF2().getText();
                DBCursor curs = users.find();
                while (curs.hasNext()){
                    DBObject t = curs.next();
                    if (((String)t.get("username")).equals(username) && ((String)t.get("password")).equals(Base64.getEncoder().withoutPadding().encodeToString(password.getBytes()))){
                        gui.set("ManagementGUI");
                        myUsername = username;
                        login_success();
                        managementPage.setUser(myUsername);
                        return;
                    }
                }
                loginPage.getL3().setText("ชื่อผู้ใช้ หรือ รหัสผ่านผิด");
            }
        });
        loginPage.getL4().addMouseListener (new MouseAdapter (){

            public void mouseClicked (MouseEvent e){
                gui.set("RegisterGUI");
            }

        });
        registerPage.getBtn2().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){


                gui.set("LoginGUI");
            }
        });
        registerPage.getBtn1().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){

            	if (!connected) {
            		MyPanel p = Helper.createPanel("");
					p.setLayout(new BorderLayout());
					MyPanel p2 = Helper.createPanel("");
					p2.setLayout(new GridLayout(2, 2));
					JLabel m1 = Helper.createLabel("HOST : ");
					JLabel m2 = Helper.createLabel("PORT : ");
					JLabel l1 = Helper.createLabel(hostname);
					JLabel l2 = Helper.createLabel("" + port);

					p2.add(m1);
					p2.add(l1);
					p2.add(m2);
					p2.add(l2);
					
					p.add(Helper.createLabel("เชื่อมต่อกับฐานข้อมูลไม่สําเร็จ"), BorderLayout.NORTH);
					p.add(p2);

					JOptionPane.showOptionDialog(null, p, "ตั้งค่าฐานข้อมูล", JOptionPane.CANCEL_OPTION, JOptionPane.ERROR_MESSAGE, null, new String[] {"ยืนยัน"}, null);
            		return;
            	}
                BasicDBObject n = new BasicDBObject();
                String username = registerPage.getF1().getText();
                String password = registerPage.getF2().getText();
                String cpassword = registerPage.getF3().getText();
                DBCursor curs = users.find();
                while (curs.hasNext()){
                    DBObject t = curs.next();
                    if (((String)t.get("username")).equals(username)){
                    	registerPage.getL5().setText("ชื่อผู้ใช้นี้มีคนใช้แล้ว");
                    	registerPage.getL5().setForeground(Color.RED);
                        return;
                    }
                }
                for (int i = 0; i < username.length(); i++) {
                	if (!((username.charAt(i) >= 48 && username.charAt(i) <= 57) || (username.charAt(i) >= 65 && username.charAt(i) <= 90) || (username.charAt(i) >= 97 && username.charAt(i) <= 122))) {
                		registerPage.getL5().setText("ชื่อผู้ใช้สามารถประกอบด้วยตัวอักษร a ถึง z (A ถึง Z) และตัวเลขเท่านั้น");
                    	registerPage.getL5().setForeground(Color.RED);
                    	return;
                	}
                }
                if (username.length() < 4 || username.length() > 20) {
                	registerPage.getL5().setText("ชื่อผู้ใช้ต้องมีความยาว 4 - 20 ตัวอักษร");
                	registerPage.getL5().setForeground(Color.RED);
                }
                else if (password.length() < 6 || username.length() > 30) {
                	registerPage.getL5().setText("รหัสผ่านต้องมีความยาว 6 - 30 ตัวอักษร");
                	registerPage.getL5().setForeground(Color.RED);
                }
                else if (username.equals(password)) {
                	registerPage.getL5().setText("รหัสผ่านต้องไม่เหมือนกับชื่อผู้ใช้");
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
                    	registerPage.getL5().setText("รหัสผ่านสามารถเป็นได้แค่ตัวอักษร a ถึง z (A ถึง Z) และตัวเลข  0 ถึง 9.");
                    	registerPage.getL5().setForeground(Color.RED);
                    	return;
                    }
                    if (number == false || lower == false || upper == false) {
                    	registerPage.getL5().setText("รหัสผ่านต้องมีตัวอักษรตัวเล็กตัวใหญ่และตัวเลขอย่างน้อยตัวละ 1 ตัวอักษร");
                    	registerPage.getL5().setForeground(Color.RED);
                    	return;
                    }
                    n.put("username", username);
                    n.put("password", Base64.getEncoder().withoutPadding().encodeToString(password.getBytes()));
                    n.put("subject1", "");
                    n.put("subject2", "");
                    n.put("subject3", "");
                    
                    users.insert(n);
                    registerPage.getL5().setText("สมัครสมาชิกเรียบร้อยแล้ว สามารถเข้าใช้งานได้เลยทันที");
                	registerPage.getL5().setForeground(Color.GREEN);
                	registerPage.getF1().setText("");
                	registerPage.getF2().setText("");
                	registerPage.getF3().setText("");
                }
                else {
                	registerPage.getL5().setText("รหัสผ่านทั้งสองช่องไม่ตรงกัน");
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
				
				managementPage.set("mystudent");
				
				currentPage = 1;
				updatePage();
			}

        });
        

        
        managementPage.getMenu2().addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {
				
				managementPage.set("subject");
				
				currentPage = 2;
				updatePage();
			}

        });
        managementPage.getMenu4().addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {
				if (currentPage == 4) {
					return;
				}
				managementPage.set("setting");
				
				currentPage = 4;
				updatePage();
			}

        });

        managementPage.getMenu5().addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {
				int before = currentPage;
				currentPage = 5;
				updatePage();
				JLabel msg = Helper.createLabel("คุณแน่ใจที่จะออกจากโปรแกรมใช่หรือไม่");

				int alert = JOptionPane.showOptionDialog(null, msg, "ออกจากโปรแกรม", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, new String[] {"ออกจากโปรแกรม", "ยกเลิก"}, null);
				if(alert == JOptionPane.OK_OPTION){
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
        				JLabel msg = Helper.createLabel("มีรหัสนักเรียนนี้อยู่ในระบบอยู่แล้ว คุณต้องการที่จะแก้ไขข้อมูลหรือไม่??");
        				int alert = JOptionPane.showOptionDialog(null, msg, "แก้ไขข้อมูล", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, new String[] {"แก้ไขข้อมูล", "ยกเลิก"}, null);
        				if (alert == JOptionPane.OK_OPTION) {
        					HashMap<String, Double> score = teacher.getStudents().get(i).getScore();
        					delete(teacher.getStudents().get(i).getStudentID());
        					addStudent(score);
        				}
            			return;	
        			}
        		}
             	addStudent(emptyScore);
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
        
        loginPage.getGithub().addMouseListener(new MouseAdapter() {
        	public void mouseClicked(MouseEvent e) {
        		int alert = JOptionPane.showOptionDialog(null, Helper.createLabel("คุณต้องการจะไปที่ github ของพวกเราใช่หรือไม่"), "ลิ้งไปยังหน้า github", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, new String[] {"ยืนยัน", "ยกเลิก"}, null);
				if (alert == JOptionPane.OK_OPTION) {
					if (Desktop.isDesktopSupported()) {
						try {
					        Desktop.getDesktop().browse(new URI("https://github.com/peetck/Student-Management"));
						}
						catch (Exception e1) {}
					} 

				}
				
			}
        });
        
        loginPage.getBtn2().addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		MyPanel p1 = Helper.createPanel("");
				p1.setLayout(new GridLayout(2, 2));
				JLabel msg01 = Helper.createLabel("HOST : ");
				JLabel msg02 = Helper.createLabel("PORT : ");
				JTextField tf01 = Helper.createTextField(10);
				JTextField tf02 = Helper.createTextField(10);
				p1.add(msg01);
				p1.add(tf01);
				p1.add(msg02);
				p1.add(tf02);
				tf01.setText(hostname);
				tf02.setText("" + port);
				

				int alert = JOptionPane.showOptionDialog(null, p1, "ตั้งค่าฐานข้อมูล", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, new String[] {"เชื่อมต่อ", "ยกเลิก"}, null);
				if (alert == JOptionPane.OK_OPTION) {
					hostname = tf01.getText();
					try {
						port = Integer.parseInt(tf02.getText());
					}
					catch(Exception err) {
						JLabel d = Helper.createLabel("กรุณาใส่ PORT เป็นตัวเลขเท่านั้น");
						JOptionPane.showOptionDialog(null, d, "ตั้งค่าฐานข้อมูล", JOptionPane.CANCEL_OPTION, JOptionPane.ERROR_MESSAGE, null, new String[] {"ยืนยัน"}, null);
						return;
					}
					connectDB(hostname, port);
					if (connected) {
						MyPanel p = Helper.createPanel("");
						p.setLayout(new BorderLayout());
						MyPanel p2 = Helper.createPanel("");
						p2.setLayout(new GridLayout(2, 2));
						JLabel m1 = Helper.createLabel("HOST : ");
						JLabel m2 = Helper.createLabel("PORT : ");
						JLabel l1 = Helper.createLabel(hostname);
						JLabel l2 = Helper.createLabel("" + port);

						p2.add(m1);
						p2.add(l1);
						p2.add(m2);
						p2.add(l2);
						
						p.add(Helper.createLabel("เชื่อมต่อกับฐานข้อมูลสําเร็จ"), BorderLayout.NORTH);
						p.add(p2);

						JOptionPane.showOptionDialog(null, p, "ตั้งค่าฐานข้อมูล", JOptionPane.CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, new String[] {"ยืนยัน"}, null);
					}
					else {
						MyPanel p = Helper.createPanel("");
						p.setLayout(new BorderLayout());
						MyPanel p2 = Helper.createPanel("");
						p2.setLayout(new GridLayout(2, 2));
						JLabel m1 = Helper.createLabel("HOST : ");
						JLabel m2 = Helper.createLabel("PORT : ");
						JLabel l1 = Helper.createLabel(hostname);
						JLabel l2 = Helper.createLabel("" + port);

						p2.add(m1);
						p2.add(l1);
						p2.add(m2);
						p2.add(l2);
						
						p.add(Helper.createLabel("เชื่อมต่อกับฐานข้อมูลไม่สําเร็จ"), BorderLayout.NORTH);
						p.add(p2);

						JOptionPane.showOptionDialog(null, p, "ตั้งค่าฐานข้อมูล", JOptionPane.CANCEL_OPTION, JOptionPane.ERROR_MESSAGE, null, new String[] {"ยืนยัน"}, null);

					}
				}
        	}
        });
        
        managementPage.getInformationGUI().getBtn1().addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		
        		managementPage.set("add/delete");
				currentPage = 3;
				updatePage();
				pullInformation(managementPage.getInformationGUI().getInformation(), managementPage.getInformationGUI().getPicturePath());
        	}
        });
        
        managementPage.getInformationGUI().getBtn2().addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
				
        		String studentID = managementPage.getInformationGUI().getStudentID();
        		HashMap<String, Double> score = new HashMap<String, Double>();
        		ArrayList<Student> arr = teacher.getStudents();
        		for (int i = 0; i < arr.size(); i++) {
        			if (arr.get(i).getStudentID().equals(studentID)) {
        				score = arr.get(i).getScore();
        				break;
        			}
        		}
        		
				ChartPanel graph = createStudentGraph(studentID, score);
				
        		managementPage.set("information_graph");
        		managementPage.getInformationGraphGUI().updateGraph(graph);
				// show graph
        	}
        });
        
        managementPage.getInformationGUI().getBtn3().addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		managementPage.set("mystudent");
				currentPage = 1;
				updatePage();

        	}
        });
        
        managementPage.getInformationGraphGUI().getBtn1().addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		managementPage.set("subject");
				currentPage = 2;
				updatePage();
        		
				
        	}
        });
        
        managementPage.getInformationGraphGUI().getBtn2().addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		
        		managementPage.set("information");
				
        	}
        });
        
        managementPage.getSettingGUI().getBtn1().addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) { // change password
        		MyPanel p1 = Helper.createPanel("");
				p1.setLayout(new GridLayout(3, 2));
				JLabel msg01 = Helper.createLabel("รหัสผ่านเดิม");
				JLabel msg02 = Helper.createLabel("รหัสผ่านใหม่");
				JLabel msg03 = Helper.createLabel("ยืนยันรหัสผ่านใหม่");
				JPasswordField pf1 = Helper.createPasswordField(10);
				JPasswordField pf2 = Helper.createPasswordField(10);
				JPasswordField pf3 = Helper.createPasswordField(10);
				p1.add(msg01);
				p1.add(pf1);
				p1.add(msg02);
				p1.add(pf2);
				p1.add(msg03);
				p1.add(pf3);
				int alert = JOptionPane.showOptionDialog(null, p1, "เปลี่ยนรหัสผ่าน", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, new String[] {"เปลี่ยนรหัสผ่าน", "ยกเลิก"}, null);
				if (alert == JOptionPane.OK_OPTION) {
					changePassword(pf1.getText(), pf2.getText(), pf3.getText());
				}
        	}
        });
        
        managementPage.getSettingGUI().getBtn2().addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) { // logout
        		JLabel l = Helper.createLabel("คุณต้องการที่จะล็อกเอ้าท์ออกจากระบบใช่หรือไม่");

        		int alert = JOptionPane.showOptionDialog(null, l, "ล็อกเอ้าท์", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, new String[] {"ล็อกเอ้าท์", "ยกเลิก"}, null);
				if (alert == JOptionPane.OK_OPTION) {
	        		gui.set("LoginGUI");
	        		managementPage.set("mystudent");
					
					currentPage = 1;
					updatePage();
				}
        	}
        });

        managementPage.getSettingGUI().getBtn3().addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) { // delete account
        		JLabel l = Helper.createLabel("คุณต้องการที่จะลบบัญชีนี้ใช่หรือไม่");
        		int alert = JOptionPane.showOptionDialog(null, l, "ลบบัญชี", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, new String[] {"ลบบัญชี", "ยกเลิก"}, null);
				if (alert == JOptionPane.OK_OPTION) {
					MyPanel p1 = Helper.createPanel("");
					JLabel msg01 = Helper.createLabel("รหัสผ่าน : ");
					JPasswordField pf = Helper.createPasswordField(10);
					p1.add(msg01);
					p1.add(pf);
					int alert2 = JOptionPane.showConfirmDialog(null, p1, "ลบบัญชี", JOptionPane.OK_CANCEL_OPTION);
					if (alert2 == JOptionPane.OK_OPTION) {
						String inp = Base64.getEncoder().withoutPadding().encodeToString(pf.getText().getBytes());
						if (deleteAccount(inp)) {
							JLabel d = Helper.createLabel("ลบบัญชีนี้เรียบร้อยแล้ว");
							JOptionPane.showOptionDialog(null, d, "ลบบัญชี", JOptionPane.CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, new String[] {"ยืนยัน"}, null);
							
							gui.set("LoginGUI");
			        		managementPage.set("mystudent");
							
							currentPage = 1;
							updatePage();
							
						}
						else {
							JLabel d = Helper.createLabel("รหัสผ่านไม่ถูกต้อง");
							JOptionPane.showOptionDialog(null, d, "ลบบัญชี", JOptionPane.CANCEL_OPTION, JOptionPane.ERROR_MESSAGE, null, new String[] {"ยืนยัน"}, null);
						}
					}
				}
        	}
        });

        managementPage.getSubjectGUI().getBtn1().addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if (managementPage.getSubjectGUI().getSubject1().getSubject().equals("empty")) {
        			addSubject(1);
        		}
        		else {
        			managementPage.set("subject1");
        		}
        		
        	}
        });
        
        managementPage.getSubjectGUI().getBtn2().addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if (managementPage.getSubjectGUI().getSubject2().getSubject().equals("empty")) {
        			addSubject(2);
        		}
        		else {
        			managementPage.set("subject2");
        		}
        		
        	}
        });
        
        managementPage.getSubjectGUI().getBtn3().addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if (managementPage.getSubjectGUI().getSubject3().getSubject().equals("empty")) {
        			addSubject(3);
        		}
        		else {
        			managementPage.set("subject3");
        		}
        		
        	}
        });
        
        // set score subject1
        managementPage.getSubjectGUI().getSubject1().getBtn1().addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		updateScore(1);
        	}
        });
        
        // set score subject2
        managementPage.getSubjectGUI().getSubject2().getBtn1().addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		updateScore(2);
        	}
        });
        
        // set score subject3
        managementPage.getSubjectGUI().getSubject3().getBtn1().addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {

        		updateScore(3);
        	}
        });
        
        // delete subject1
        managementPage.getSubjectGUI().getSubject1().getBtn2().addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		deleteSubject(1);
        	}
        });
        
        // delete subject2
        managementPage.getSubjectGUI().getSubject2().getBtn2().addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		deleteSubject(2);
        	}
        });
        
        // delete subject3
        managementPage.getSubjectGUI().getSubject3().getBtn2().addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		deleteSubject(3);
        	}
        });
        
        // export score as CSV {subject 1}
        managementPage.getSubjectGUI().getSubject1().getBtn4().addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
				exportCSV(1);
        	}
        });
        
        // export score as CSV {subject 2}
        managementPage.getSubjectGUI().getSubject2().getBtn4().addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		exportCSV(2);
        	}
        });
        
        // export score as CSV {subject 3}
        managementPage.getSubjectGUI().getSubject3().getBtn4().addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		exportCSV(3);
        	}
        });
        
        // import CSV to score {subject 1}
        managementPage.getSubjectGUI().getSubject1().getBtn3().addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		importCSV(1);
        	}
        });
        
		// import CSV to score {subject 2}
		managementPage.getSubjectGUI().getSubject2().getBtn3().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				importCSV(2);
			}
		});

		// import CSV to score {subject 3}
		managementPage.getSubjectGUI().getSubject3().getBtn3().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				importCSV(3);
			}
		});
     }
    
    
    // below here is method in all application -------------------------------------------------------------------------------------------------------------------------
    
    public ChartPanel createStudentGraph(String studentID, HashMap<String, Double> score) {
    	DefaultCategoryDataset data = new DefaultCategoryDataset();
    	
    	String subject1 = managementPage.getSubjectGUI().getSubject1().getSubject();
    	String subject2 = managementPage.getSubjectGUI().getSubject2().getSubject();
    	String subject3 = managementPage.getSubjectGUI().getSubject3().getSubject();
    	
   	
    	if (subject1.equals("empty")) {
    		subject1 = "วิชาที่1 (Empty)";
    	}
		if (subject2.equals("empty")) {
			subject2 = "วิชาที่2 (Empty)";
		}
		if (subject3.equals("empty")) {
			subject3 = "วิชาที่3 (Empty)";
		}

		data.addValue(score.get("s1_assignment"), "คะแนนเก็บ", subject1);
    	data.addValue(score.get("s1_project"), "คะแนนโครงงาน", subject1);
    	data.addValue(score.get("s1_midterm"), "คะแนนกลางภาค", subject1);
    	data.addValue(score.get("s1_final"), "คะแนนไฟนอล", subject1);
    	
    	data.addValue(score.get("s2_assignment"), "คะแนนเก็บ", subject2);
    	data.addValue(score.get("s2_project"), "คะแนนโครงงาน", subject2);
    	data.addValue(score.get("s2_midterm"), "คะแนนกลางภาค", subject2);
    	data.addValue(score.get("s2_final"), "คะแนนไฟนอล", subject2);
    	
    	data.addValue(score.get("s3_assignment"), "คะแนนเก็บ", subject3);
    	data.addValue(score.get("s3_project"), "คะแนนโครงงาน", subject3);
    	data.addValue(score.get("s3_midterm"), "คะแนนกลางภาค", subject3);
    	data.addValue(score.get("s3_final"), "คะแนนไฟนอล", subject3);
    	
		JFreeChart chart = ChartFactory.createBarChart("คะแนนของนักเรียนรหัส " + studentID, "", "คะแนน", data, PlotOrientation.VERTICAL, true, true, false);

		StandardChartTheme chartTheme = (StandardChartTheme) org.jfree.chart.StandardChartTheme.createJFreeTheme();
		Font oldExtraLargeFont = chartTheme.getExtraLargeFont();
		Font oldLargeFont = chartTheme.getLargeFont();
		Font oldRegularFont = chartTheme.getRegularFont();
		Font oldSmallFont = chartTheme.getSmallFont();

		Font extraLargeFont = new Font("Kanit ExtraLight", oldExtraLargeFont.getStyle(), oldExtraLargeFont.getSize());
		Font largeFont = new Font("Kanit ExtraLight", oldLargeFont.getStyle(), oldLargeFont.getSize());
		Font regularFont = new Font("Kanit ExtraLight", oldRegularFont.getStyle(), oldRegularFont.getSize());
		Font smallFont = new Font("Kanit ExtraLight", oldSmallFont.getStyle(), oldSmallFont.getSize());

		chartTheme.setExtraLargeFont(extraLargeFont);
		chartTheme.setLargeFont(largeFont);
		chartTheme.setRegularFont(regularFont);
		chartTheme.setSmallFont(smallFont);

		chartTheme.setRangeGridlinePaint(Color.BLACK);

		chartTheme.apply(chart);

		CategoryPlot carPlot = chart.getCategoryPlot();

		CategoryPlot plot = (CategoryPlot) carPlot;
		NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
		rangeAxis.setRange(0, 100);
		plot.setBackgroundPaint(Color.WHITE);

		ChartPanel chartPanel = new ChartPanel(chart);

		chartPanel.setDomainZoomable(false);
		chartPanel.setRangeZoomable(false);
		
		return chartPanel;
    }
    
    public void importCSV(int select) {
    	MyPanel main = Helper.createPanel("");
    	main.setLayout(new BorderLayout());
    	MyPanel p = Helper.createPanel("");
    	p.setLayout(new GridLayout(7, 1));
    	JLabel l1 = Helper.createLabel("คุณลักษณะของไฟล์", 20, true);
    	l1.setHorizontalAlignment(JLabel.CENTER);
    	JLabel l2 = Helper.createLabel("- ต้องเป็นไฟล์ .csv เท่านั้น");
    	JLabel l3 = Helper.createLabel("- แถวแรก(ไม่นับเฮดเดอร์) จะต้องเป็นรหัสนักเรียน, คะแนนเก็บ, คะแนนกลางภาค, คะแนนปลายภาค ตามลําดับ");
    	JLabel l4 = Helper.createLabel("- หากมีคอลัมน์เกินมาจะไม่สนใจ");
    	JLabel l5 = Helper.createLabel("- หากรหัสนักเรียนหรือคะแนนในแต่ละช่องไม่สมเหตุสมผลหรือไม่มีรหัสนักเรียนในระบบก็จะข้ามไปทําแถวถัดไป");
    	JLabel l6 = Helper.createLabel("- รหัสนักเรียนที่มีในระบบแต่ไม่มีในไฟล์ก็จะไมได้รับการอัพเดทคะแนน");
    	JLabel l7 = Helper.createLabel("รูปตัวอย่างไฟล์ที่ถูกต้อง", 18, true);
    	l7.setHorizontalAlignment(JLabel.CENTER);
    	JLabel picture = Helper.createLabel("", "/images/correct_csv.png", 700, 200);
    	picture.setBorder(BorderFactory.createLineBorder(Color.black));
    	picture.setHorizontalAlignment(JLabel.CENTER);
    	
    	p.add(l1);
    	p.add(l2);
    	p.add(l3);
    	p.add(l4);
    	p.add(l5);
    	p.add(l6);
    	p.add(l7);

    	
    	main.add(p);
    	main.add(picture, BorderLayout.SOUTH);
    	JOptionPane.showOptionDialog(null, main, "อัพโหลดคะแนน", JOptionPane.CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, new String[] {"ยืนยัน", }, null);
    	
    	JFileChooser chooser = new JFileChooser();
		chooser.setAcceptAllFileFilterUsed(false);
		chooser.setDialogTitle("อัพโหลดคะแนน");
		
		FileNameExtensionFilter filter = new FileNameExtensionFilter("CSV file", "csv");
		chooser.addChoosableFileFilter(filter);

		String path = "";
		if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			path = "" + chooser.getSelectedFile();
		}
		else {

			return;
		}
		
		String data = "";
		try {
			Scanner scan = new Scanner(new File(path));
	        scan.useDelimiter(",");
	        while(scan.hasNext()){
	        	data += scan.next() + "#";
	        }
	        scan.close();
		}
		catch(FileNotFoundException e) {
			JOptionPane.showOptionDialog(null, Helper.createLabel("ระบบไม่สามารถหาไฟล์ได้"), "อัพโหลดคะแนน", JOptionPane.CANCEL_OPTION, JOptionPane.ERROR_MESSAGE, null, new String[] {"ยืนยัน", }, null);
			return;
		}
    	
		String[] row = data.split("\n");
		ArrayList<Student> arr = teacher.getStudents();
		HashMap<String, String[]> map = new HashMap<String, String[]>();
		for (int i = 0; i < row.length; i++) {

			String[] each = row[i].split("#");
			if (each.length >= 1) {
				map.put(each[0], each);
			}
	
		}
		
		es : for (int i = 0; i < arr.size(); i++) {
			Student s = arr.get(i);
			String id = s.getStudentID();
			
			
			
			DBCollection myStudent = db.getCollection(myUsername);
	    	DBCursor curs = myStudent.find();
	    	BasicDBObject n = new BasicDBObject();
	    	while (curs.hasNext()) {
	    		DBObject t = curs.next();
	    		if (((String)t.get("studentID")).equals(id) && map.containsKey(id)) {
	    			
	    			double assignment = 0;
	    			double project = 0;
	    			double midterm = 0;
	    			double finals = 0;
	    			try {
	    				assignment = Double.parseDouble(map.get(id)[1]);
		    			project = Double.parseDouble(map.get(id)[2]);
		    			midterm = Double.parseDouble(map.get(id)[3]);
		    			finals = Double.parseDouble(map.get(id)[4]);
	    			}
	    			catch(Exception e) {
	    				continue es;
	    			}
	    			
	    			if (assignment + project + midterm + finals > 100) {
	    				continue es;
	    			}

	    			s.setScore(select, assignment, project, midterm, finals);
	    			
	    			n.putAll(t);
			    	n.put("s" + select + "_assignment", assignment);
			    	n.put("s" + select + "_project", project);
					n.put("s" + select + "_midterm", midterm);
					n.put("s" + select + "_final", finals);
			    	
					myStudent.update(t, n);								
    				
    				updateScoreTable();
    				
    				break;
	    		}
	    	}
		}
		JOptionPane.showOptionDialog(null, "อัพโหลดคะแนนนักเรียนจากไฟล์ CSV เรียบร้อยแล้ว", "อัพโหลดคะแนน", JOptionPane.CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, new String[] {"ยืนยัน", }, null);
    }
    
    public void exportCSV(int select) {
    	String title = "";
		if (select == 1) {
			title = managementPage.getSubjectGUI().getSubject1().getSubject();
		}
		else if (select == 2) {
			title = managementPage.getSubjectGUI().getSubject2().getSubject();
		}
		else if (select == 3) {
			title = managementPage.getSubjectGUI().getSubject3().getSubject();
		}
		
    	ArrayList<Student> arr = teacher.getStudents();
		JFileChooser chooser = new JFileChooser();
		chooser.setAcceptAllFileFilterUsed(false);
		chooser.setDialogTitle("ดาวน์โหลดคะแนน");
		
		FileNameExtensionFilter filter = new FileNameExtensionFilter("CSV file", "csv");
		chooser.addChoosableFileFilter(filter);
		chooser.setSelectedFile(new File(title + "_score"));
		chooser.setApproveButtonText("Save");
		
		String path = "";
		if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			path = "" + chooser.getSelectedFile();
			if (!path.contains(".csv")) {
				 path += ".csv";
			}
		}
		else {

			return;
		}
    	try{
    		
			PrintWriter pw = new PrintWriter(new File(path));
			StringBuilder builder = new StringBuilder();

			String ColumnNamesList = "studentID,Accumulated Score,Project Score,Midterm Score,Final Score,Total Score,Grade";
			
			builder.append(ColumnNamesList +"\n");
			
			for (int i = 0; i < arr.size(); i++) {
	    		Object[] score = arr.get(i).getGrade(select);
	    		
	    		builder.append(score[0] + ",");
	    		builder.append(score[1] + ",");
	    		builder.append(score[2] + ",");
	    		builder.append(score[3] + ",");
	    		builder.append(score[4] + ",");
	    		builder.append(score[5] + ",");
	    		builder.append(score[6]);
				builder.append('\n');
	    	}
			pw.write(builder.toString());
			pw.close();
			JOptionPane.showOptionDialog(null, "ดาวน์โหลดคะแนนนักเรียนเรียบร้อยแล้ว", "ดาวน์โหลดคะแนน", JOptionPane.CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, new String[] {"ยืนยัน", }, null);

		}
		catch (FileNotFoundException err) {

		}
    }
    public void deleteSubject(int select) {
    	String msg = "";
    	if (select == 1) {
    		msg = managementPage.getSubjectGUI().getSubject1().getSubject();
    	}
    	else if (select == 2) {
    		msg = managementPage.getSubjectGUI().getSubject2().getSubject();
    	}
    	else if (select == 3) {
    		msg = managementPage.getSubjectGUI().getSubject3().getSubject();
    	}
    	JLabel l = Helper.createLabel("คุณต้องการที่จะลบวิชา " + msg + " ใช่หรือไม่");
		int alert = JOptionPane.showOptionDialog(null, l, "ลบวิชา " + msg, JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, new String[] {"ลบวิชา", "ยกเลิก"}, null);
		if (alert == JOptionPane.OK_OPTION) {
			DBCursor curs = users.find();
			while (curs.hasNext()){
	            DBObject t = curs.next();
	            if (((String)t.get("username")).equals(myUsername)) {
	            	BasicDBObject n = new BasicDBObject();
	            	n.putAll(t);
	            	
	            	n.put("subject" + select, "");
	            	
	            	users.remove(t);
	            	users.insert(n);
	              	managementPage.getSubjectGUI().setSubject( ((String)n.get("subject1")) , ((String)n.get("subject2")), ((String)n.get("subject3")));
	              	
	              	DBCollection myStudent = db.getCollection(myUsername);
	              	DBCursor curs2 = myStudent.find();
	              	while (curs2.hasNext()) {
	              		DBObject t2 = curs2.next();
	              		BasicDBObject n2 = new BasicDBObject();
	              		n2.putAll(t2);
	              		n2.put("s" + select + "_assignment", 0);
	              		n2.put("s" + select + "_project", 0);
	              		n2.put("s" + select + "_midterm", 0);
	              		n2.put("s" + select + "_final", 0);
	              		
	              		myStudent.remove(t2);
	              		myStudent.insert(n2);
	              	}
	            	
	              	ArrayList<Student> arr = teacher.getStudents();
	              	for (int i = 0; i < arr.size(); i++) {
	              		arr.get(i).setScore(select, 0.0, 0.0, 0.0, 0.0);
	              	}
	              	
	            	managementPage.set("subject");
					currentPage = 2;
					updatePage();
					JOptionPane.showOptionDialog(null, Helper.createLabel("ลบวิชา " + msg + " เรียบร้อยแล้ว"), "ลบวิชา " + msg, JOptionPane.CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, new String[] {"ยืนยัน"}, null);
	            	return;
	            }
			}
		}
    	
    }
    
    public void updateScore(int select) {
    	String subjectTitle = "";
    	if (select == 1) {
    		subjectTitle = managementPage.getSubjectGUI().getSubject1().getSubject();
    	}
    	else if (select == 2) {
    		subjectTitle = managementPage.getSubjectGUI().getSubject2().getSubject();
    	}
    	else if (select == 3) {
    		subjectTitle = managementPage.getSubjectGUI().getSubject3().getSubject();
    	}
		MyPanel p1 = Helper.createPanel("");
		p1.setLayout(new GridLayout(1, 2));
		JLabel msg = Helper.createLabel("รหัสนักเรียน : ");
		JTextField tf = Helper.createTextField(10);
		p1.add(msg);
		p1.add(tf);
		int alert = JOptionPane.showOptionDialog(null, p1, "แก้ไขคะแนนวิชา " + subjectTitle, JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, new String[] {"แก้ไขคะแนน", "ยกเลิก"}, null);
		if (alert == JOptionPane.OK_OPTION) {
			ArrayList<Student> arr = teacher.getStudents();
			for (int i = 0; i < arr.size(); i++) {
				if (tf.getText().equals(arr.get(i).getStudentID())) {
					// แก้ไข คะแนน
					MyPanel p2 = Helper.createPanel("");
					p2.setLayout(new GridLayout(4, 2));
					JLabel msg01 = Helper.createLabel("คะแนนเก็บ");
					JLabel msg02 = Helper.createLabel("คะแนนโครงงาน");
					JLabel msg03 = Helper.createLabel("คะแนนกลางภาค");
					JLabel msg04 = Helper.createLabel("คะแนนปลายภาค");
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

					int alert2 = JOptionPane.showOptionDialog(null, p2, "แก้ไขคะแนนวิชา " + subjectTitle, JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, new String[] {"แก้ไขคะแนน", "ยกเลิก"}, null);
					if (alert2 == JOptionPane.OK_OPTION) {
						if (tf01.getText().equals("") || tf02.getText().equals("") || tf03.getText().equals("") || tf04.getText().equals("")) {
							JOptionPane.showOptionDialog(null, Helper.createLabel("กรุณากรอกคะแนนให้ครบถ้วน"), "แก้ไขคะแนนวิชา" + subjectTitle	, JOptionPane.CANCEL_OPTION, JOptionPane.ERROR_MESSAGE, null, new String[] {"ยืนยัน"}, null);
							return;
						}
						if (Double.parseDouble(tf01.getText()) + Double.parseDouble(tf02.getText()) + Double.parseDouble(tf03.getText()) + Double.parseDouble(tf04.getText()) > 100) {
							JOptionPane.showOptionDialog(null, Helper.createLabel("ไม่สามารถกําหนคะแนนให้เกิน 100 ได้"), "แก้ไขคะแนนวิชา " + subjectTitle	, JOptionPane.CANCEL_OPTION, JOptionPane.ERROR_MESSAGE, null, new String[] {"ยืนยัน"}, null);
							return;
						}
						arr.get(i).setScore(select, Double.parseDouble(tf01.getText()), Double.parseDouble(tf02.getText()), Double.parseDouble(tf03.getText()), Double.parseDouble(tf04.getText()));
						
						updateScoreTable();
						
						BasicDBObject n = new BasicDBObject();

				    	
						
						DBCollection myStudent = db.getCollection(myUsername);
				    	DBCursor curs = myStudent.find();
				    	while (curs.hasNext()) {
				    		DBObject t = curs.next();
				    		if (((String)t.get("studentID")).equals(tf.getText())) {
				    			n.putAll(t);
						    	n.put("s" + select + "_assignment", Double.parseDouble(tf01.getText()));
						    	n.put("s" + select + "_project", Double.parseDouble(tf02.getText()));
								n.put("s" + select + "_midterm", Double.parseDouble(tf03.getText()));
								n.put("s" + select + "_final", Double.parseDouble(tf04.getText()));
						    	
								myStudent.update(t, n);								
			    				JOptionPane.showOptionDialog(null, Helper.createLabel("แก้ไขคะแนนวิชา " + subjectTitle + "เรียบร้อยแล้ว"), "แก้ไขคะแนนวิชา" + subjectTitle, JOptionPane.CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, new String[] {"ยืนยัน"}, null);
			    				updateScoreTable();
				    			return;
				    		}
				    	}
						
				    	
					}
					return;
				}
			}
			JLabel msg2 = Helper.createLabel("ไม่มีรหัสนักเรียนนี้อยู่ในระบบ");
			JOptionPane.showOptionDialog(null, msg2, "แก้ไขคะแนนวิชา " + subjectTitle, JOptionPane.CANCEL_OPTION, JOptionPane.ERROR_MESSAGE, null, new String[] {"ยืนยัน"}, null);
        }
    }
    public void addSubject(int select) {


    	
    	MyPanel p1 = Helper.createPanel("");
    	p1.setLayout(new GridLayout(2, 2));
		JLabel msg = Helper.createLabel("รหัสวิชา : ");
		JLabel msg2 = Helper.createLabel("ชื่อวิชา");
		JTextField tf = Helper.createTextField(10);
		JTextField tf2 = Helper.createTextField(10);
		p1.add(msg);
		p1.add(tf);
		p1.add(msg2);
		p1.add(tf2);
		int alert = JOptionPane.showOptionDialog(null, p1, "เพิ่มวิชา", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, new String[] {"เพิ่มวิชา", "ยกเลิก"}, null);
		if (alert == JOptionPane.OK_OPTION) {
			DBCursor curs = users.find();
			while (curs.hasNext()){
	            DBObject t = curs.next();
	            if (((String)t.get("username")).equals(myUsername)) {
	            	BasicDBObject n = new BasicDBObject();
                    n.put("username", myUsername);
                    n.put("password", (String)t.get("password"));
                    n.put("subject1", (String)t.get("subject1"));
	            	n.put("subject2", (String)t.get("subject2"));
	            	n.put("subject3", (String)t.get("subject3"));
                    String sub = tf2.getText() + "#" + tf.getText();
                    if (select == 1) {
                    	n.put("subject1", sub);
                 	}
                     else if (select == 2) {
                    	 n.put("subject2", sub);
                     }
                     else {
                    	 n.put("subject3", sub);
                     }

	            	
	            	
	            	users.remove(t);
	            	users.insert(n);
	            	managementPage.getSubjectGUI().setSubject( ((String)n.get("subject1")) , ((String)n.get("subject2")), ((String)n.get("subject3")));
	            	
	            	updateScoreTable();
	            	JLabel l = Helper.createLabel("เพิ่มวิชา " + tf2.getText() + " เรียบร้อยแล้ว");
	        		JOptionPane.showOptionDialog(null, l, "เพิ่มวิชา ", JOptionPane.CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, new String[] {"ยืนยัน"}, null);
	            	return;
	            }
			}
		}
    }
    
    public void changePassword(String old, String newP, String comP) {
    	old = Base64.getEncoder().withoutPadding().encodeToString(old.getBytes()); // UGVlbG9naW43ODkxMA

    	DBCursor curs = users.find();
        while (curs.hasNext()){
            DBObject t = curs.next();
            if (((String)t.get("username")).equals(myUsername)) {
            	if (old.equals(((String)t.get("password")))){
            		if (newP.equals(comP)) {
            			if (newP.length() < 6) {
            				JLabel d = Helper.createLabel("รหัสผ่านต้องมีความยาว 6 - 30 ตัวอักษร");
    						JOptionPane.showOptionDialog(null, d, "เปลี่ยนรหัสผ่าน", JOptionPane.CANCEL_OPTION, JOptionPane.ERROR_MESSAGE, null, new String[] {"ยืนยัน"}, null);
        					return;
            			}
                        else if (myUsername.equals(newP)) {
                        	JLabel d = Helper.createLabel("รหัสผ่านต้องไม่เหมือนกับชื่อผู้ใช้");
                        	JOptionPane.showOptionDialog(null, d, "เปลี่ยนรหัสผ่าน", JOptionPane.CANCEL_OPTION, JOptionPane.ERROR_MESSAGE, null, new String[] {"ยืนยัน"}, null);
        					return;
                        }
                        boolean upper = false, lower = false, alphabet = true, number = false;
                        String check = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
                        for (int i = 0; i < newP.length(); i++) {
                            if (Character.isUpperCase(newP.charAt(i))){
                            	upper = true;
                            }
                            if (Character.isLowerCase(newP.charAt(i))){
                            	lower = true;
                            }
                            if (newP.charAt(i) >= '0' && newP.charAt(i) <= '9') {
                            	number = true;
                            }
                            if(!(check.contains("" + newP.charAt(i)))) {
                            	alphabet = false;
                            }
                        }
                        if (alphabet == false) {
                        	JLabel d = Helper.createLabel("รหัสผ่านสามารถเป็นได้แค่ตัวอักษร a ถึง z (A ถึง Z) และตัวเลข  0 ถึง 9.");
                        	JOptionPane.showOptionDialog(null, d, "เปลี่ยนรหัสผ่าน", JOptionPane.CANCEL_OPTION, JOptionPane.ERROR_MESSAGE, null, new String[] {"ยืนยัน"}, null);
        					return;
                        }
                        if (number == false || lower == false || upper == false) {
                        	JLabel d = Helper.createLabel("รหัสผ่านต้องมีตัวอักษรตัวเล็กตัวใหญ่และตัวเลขอย่างน้อยตัวละ 1 ตัวอักษร");
                        	JOptionPane.showOptionDialog(null, d, "เปลี่ยนรหัสผ่าน", JOptionPane.CANCEL_OPTION, JOptionPane.ERROR_MESSAGE, null, new String[] {"ยืนยัน"}, null);
        					return;
                        }
                		users.remove(t);
                		BasicDBObject n = new BasicDBObject();
                        n.put("username", myUsername);
                        n.put("password", Base64.getEncoder().withoutPadding().encodeToString(newP.getBytes()));
                        users.insert(n);
                        JLabel d = Helper.createLabel("เปลี่ยนรหัสผ่านเรียบร้อยแล้ว");
                        JOptionPane.showOptionDialog(null, d, "เปลี่ยนรหัสผ่าน", JOptionPane.CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, new String[] {"ยืนยัน"}, null);
    					return;
            		}
            		else {
                		JLabel d = Helper.createLabel("กรุณากรอกรหัสผ่านใหม่ให้ตรงกัน");
                		JOptionPane.showOptionDialog(null, d, "เปลี่ยนรหัสผ่าน", JOptionPane.CANCEL_OPTION, JOptionPane.ERROR_MESSAGE, null, new String[] {"ยืนยัน"}, null);
    					return;
                	}
                }
            	else {
            		JLabel d = Helper.createLabel("รหัสผ่านเดิมไม่ถูกต้อง");
            		JOptionPane.showOptionDialog(null, d, "เปลี่ยนรหัสผ่าน", JOptionPane.CANCEL_OPTION, JOptionPane.ERROR_MESSAGE, null, new String[] {"ยืนยัน"}, null);
    				return;
            	}
            }
        }
    }

    public boolean deleteAccount(String password) {
    	DBCollection myStudent = db.getCollection(myUsername);
    	DBCursor curs = users.find();
        while (curs.hasNext()){
            DBObject t = curs.next();
            if (((String)t.get("username")).equals(myUsername) && password.equals((String)t.get("password"))) {
            	users.remove(t);
            	myStudent.drop();
				return true;
            }
        }
        return false;
    }
    
    public void pullInformation(HashMap<String, String> info, String path) {
    	managementPage.getAddStudentGUI().getF1().setText(info.get("studentID"));

    	managementPage.getAddStudentGUI().getF2().setSelectedItem(info.get("faculty"));
    	
    	
    	managementPage.getAddStudentGUI().getF3().setSelectedItem(info.get("title"));
    	managementPage.getAddStudentGUI().getF4().setText(info.get("name"));
    	managementPage.getAddStudentGUI().getF5().setText(info.get("surname"));
    	
		LocalDate ld = LocalDate.of(Integer.parseInt(info.get("year")), Integer.parseInt(info.get("month")), Integer.parseInt(info.get("day")));
    	managementPage.getAddStudentGUI().getF6().setDate(ld);

    	
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
    	managementPage.getAddStudentGUI().setPicturePath(path);
    }
    public void connectDB(String hostname, int port) {
    	JOptionPane opt = new JOptionPane(Helper.createLabel("กําลังเชื่อมต่อกับฐานข้อมูล (MongoDB)..."), JOptionPane.WARNING_MESSAGE, JOptionPane.DEFAULT_OPTION, null, new Object[]{}); // no buttons
         JDialog dlg = opt.createDialog("กําลังเชื่อมต่อกับฐานข้อมูล (MongoDB)");
        new Thread(new Runnable(){
                public void run(){
                  try{
                	  try{
                          System.out.println("Connecting to mongoDB..." + hostname + " " + port);
                          
                          connect = new MongoClient(hostname, port);
                          db = connect.getDB("StudentManagement");
                          users = db.getCollection("users");
                          connected = true;
                          DBCursor curs = users.find();
                          boolean haveAdmin = false;
                          while (curs.hasNext()){
                              DBObject t = curs.next();
                              if (((String)t.get("username")).equals("admin")) {
                            	  haveAdmin = true;
                              }

                          }
                          if (!haveAdmin) {
                        	  BasicDBObject n = new BasicDBObject();
                              n.put("username", "admin");
                              n.put("password", Base64.getEncoder().withoutPadding().encodeToString("admin".getBytes()));
                              n.put("subject1", "");
                              n.put("subject2", "");
                              n.put("subject3", "");
                              
                              users.insert(n);
                          }
                          System.out.println("Connect successfully");
                          loginPage.connected(true);
                      }
                      catch (Exception e){
                      	connected = false;
                      	System.out.println("Connect un-successfully");
                      	loginPage.connected(false);
                      }
                	  dlg.dispose();
                  }
                  catch (Exception e){}
                }
              }).start();
        dlg.setVisible(true);
    	
    }
    
    public void addStudent(HashMap<String, Double> score) {
    	String studentID, faculty, title, name, surname, day, month, year, cardID,
    	address, race, religion, bloodType, tel, email, height, weight, sourcePath,
    	parentTel, disease, enrollAt, picturePath;
    	
    	studentID = managementPage.getAddStudentGUI().getF1().getText();

    	faculty = managementPage.getAddStudentGUI().getF2().getSelectedItem().toString();
    	title = managementPage.getAddStudentGUI().getF3().getSelectedItem().toString();
    	name = managementPage.getAddStudentGUI().getF4().getText();
    	surname = managementPage.getAddStudentGUI().getF5().getText();
    	
    	LocalDate date = managementPage.getAddStudentGUI().getF6().getDate();
    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd LLLL yyyy");
    	
    	try {
    		String formattedString = date.format(formatter);
        	
        	String[] inpDate = formattedString.split(" ");
        	
        	HashMap<String, Integer> monthList = new HashMap<String, Integer>();
        	monthList.put("January", 1);
        	monthList.put("February", 2);
        	monthList.put("March", 3);
        	monthList.put("April", 4);
        	monthList.put("May", 5);
        	monthList.put("June", 6);
        	monthList.put("July", 7);
        	monthList.put("August", 8);
        	monthList.put("September", 9);
        	monthList.put("October", 10);
        	monthList.put("November", 11);
        	monthList.put("December", 12);
        	
        	day =  inpDate[0];
        	month = "" + monthList.get(inpDate[1]);
        	year = inpDate[2];
    	}
    	catch(Exception e) {

    		JOptionPane.showOptionDialog(null, Helper.createLabel("กรุณากรอกข้อมูลให้ครบถ้วน"), "เพิ่มนักเรียน", JOptionPane.CANCEL_OPTION, JOptionPane.ERROR_MESSAGE, null, new String[] {"ยืนยัน"}, null);
    		return;
    	}

    	for (int i = 0; i < studentID.length(); i++) {
    		if(!(studentID.charAt(i) >= '0' && studentID.charAt(i) <= '9')){
    			JOptionPane.showOptionDialog(null, Helper.createLabel("กรุณากรอกรหัสนักเรียนเป็นตัวเลขเท่านั้น"), "เพิ่มนักเรียน", JOptionPane.CANCEL_OPTION, JOptionPane.ERROR_MESSAGE, null, new String[] {"ยืนยัน"}, null);
        		return;
    		}
    	}

    	
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
    		
    		JOptionPane.showOptionDialog(null, Helper.createLabel("กรุณากรอกข้อมูลให้ครบถ้วน"), "เพิ่มนักเรียน", JOptionPane.CANCEL_OPTION, JOptionPane.ERROR_MESSAGE, null, new String[] {"ยืนยัน"}, null);
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
    	
    	n.put("s1_midterm", score.get("s1_midterm"));
    	n.put("s1_final", score.get("s1_final"));
    	n.put("s1_assignment", score.get("s1_assignment"));
    	n.put("s1_project", score.get("s1_project"));
    	
    	n.put("s2_midterm", score.get("s2_midterm"));
    	n.put("s2_final", score.get("s2_final"));
    	n.put("s2_assignment", score.get("s2_assignment"));
    	n.put("s2_project", score.get("s2_project"));
    	
    	n.put("s3_midterm", score.get("s3_midterm"));
    	n.put("s3_final", score.get("s3_final"));
    	n.put("s3_assignment", score.get("s3_assignment"));
    	n.put("s3_project", score.get("s3_project"));
    	
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

    	
    	teacher.addStudent(new Student(information, score, picturePath));
    	// add success
    	
    	// update table
    	sortTable(false);
    	updateTable();
    	updateScoreTable();
    	
    	managementPage.getAddStudentGUI().reset();
    	JLabel msg = Helper.createLabel("เพิ่มนักเรียนเรียบร้อยแล้ว");
		JOptionPane.showOptionDialog(null, msg, "เพิ่มนักเรียน", JOptionPane.CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, new String[] {"ยืนยัน"}, null);
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


            	updateTable();
                updateScoreTable();
            	return true;
            }
        }

        return false;
    }
    public void login_success() {
        System.out.println("Login success!!");
        
        DBCursor ucurs = users.find();
        boolean haveAdmin = false;
        while (ucurs.hasNext()){
            DBObject t = ucurs.next();
            if (((String)t.get("username")).equals(myUsername)) {
          	  	managementPage.getSubjectGUI().setSubject( ((String)t.get("subject1")) , ((String)t.get("subject2")), ((String)t.get("subject3")));
          	  
            }

        }
        
        
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
        	
        	score.put("s1_midterm", Double.parseDouble(("" + t.get("s1_midterm"))));
        	score.put("s1_final", Double.parseDouble(("" + t.get("s1_final"))));
        	score.put("s1_assignment", Double.parseDouble(("" + t.get("s1_assignment"))));
        	score.put("s1_project", Double.parseDouble(("" + t.get("s1_project"))));
        	
        	score.put("s2_midterm", Double.parseDouble(("" + t.get("s2_midterm"))));
        	score.put("s2_final", Double.parseDouble(("" + t.get("s2_final"))));
        	score.put("s2_assignment", Double.parseDouble(("" + t.get("s2_assignment"))));
        	score.put("s2_project", Double.parseDouble(("" + t.get("s2_project"))));
        	
        	score.put("s3_midterm", Double.parseDouble(("" + t.get("s3_midterm"))));
        	score.put("s3_final", Double.parseDouble(("" + t.get("s3_assignment"))));
        	score.put("s3_assignment", Double.parseDouble(("" + t.get("s3_assignment"))));
        	score.put("s3_project", Double.parseDouble(("" + t.get("s3_project"))));
        	
        	String picturePath = "" + t.get("picturePath");
            teacher.addStudent(new Student(information, score, picturePath));
        }
        sortTable(false);
        updateTable();
        updateScoreTable();
        updatePage();
    }
    
    // update Student table method
    
    
    public void updateTable() {
    	ArrayList<Student> students = teacher.getStudents();
    	Object[][] data = new Object[students.size()][6];
		for (int i = 0; i < students.size(); i++) {
			data[i] = students.get(i).getTableHeadInfo();
		}

		
		DefaultTableModel dm = new DefaultTableModel();
		
		if (this.TableSortStatus == 0) {
			Object[] header = {"รหัสนักเรียน <", "ชื่อ", "นามสกุล", "เพิ่มเข้ามาในวันที่"	, " ", "  "};
			dm.setDataVector(data, header);
		}
		else {
			Object[] header = {"รหัสนักเรียน  >", "ชื่อ", "นามสกุล", "เพิ่มเข้ามาในวันที่"	, " ", "  "};
			dm.setDataVector(data, header);
		}
		table = new JTable(dm);
		table.getColumn(" ").setCellRenderer(new ButtonRenderer());
		table.getColumn(" ").setCellEditor(new ButtonEditor(new JCheckBox(), teacher, managementPage, this));
		
		table.getColumn("  ").setCellRenderer(new ButtonRenderer());
		table.getColumn("  ").setCellEditor(new ButtonEditor2(new JCheckBox(), teacher, this));
		
		table.getTableHeader().setReorderingAllowed(false);
		table.getTableHeader().setResizingAllowed(false);
		table.setDefaultEditor(Object.class, null);
		table.setFillsViewportHeight(true);
		
		for (int i = 0; i < table.getColumnCount() - 1; i++) {
			if (table.getColumnModel().getColumn(i) == table.getColumn(" ") || table.getColumnModel().getColumn(i) == table.getColumn("  ")) {
				continue;
			}
			table.getColumnModel().getColumn(i).setCellRenderer(new CellRenderer());
		}
		table.setBorder(new LineBorder(Color.RED, 0));
		
		table.getTableHeader().addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseClicked(MouseEvent e) {
		        int col = table.columnAtPoint(e.getPoint());
		        if (col == 0) {
		        	sortTable(true);
		        	updateTable();
		        	updateScoreTable();
		        }
		    }
		});
		
		managementPage.getMyStudentGUI().updateTable(table);
    }
    
    public void updateScoreTable() {
    	ArrayList<Student> students = teacher.getStudents();
    	Object[][] data = new Object[students.size()][7];
    	Object[][] data2 = new Object[students.size()][7];
    	Object[][] data3 = new Object[students.size()][7];
		for (int i = 0; i < students.size(); i++) {
			data[i] = students.get(i).getGrade(1);
			data2[i] = students.get(i).getGrade(2);
			data3[i] = students.get(i).getGrade(3);
		}

		DefaultTableModel dm = new DefaultTableModel();

		if (this.TableSortStatus == 0) {
			Object[] header = {"รหัสนักเรียน <", "คะแนนเก็บ", "คะแนนโครงงาน", "คะแนนกลางภาค", "คะแนนปลายภาค", "รวมคะแนน", "เกรดที่ได้"};
			
			dm.setDataVector(data, header);
		}
		else {
			Object[] header = {"รหัสนักเรียน >", "คะแนนเก็บ", "คะแนนโครงงาน", "คะแนนกลางภาค", "คะแนนปลายภาค", "รวมคะแนน", "เกรดที่ได้"};
			dm.setDataVector(data, header);
		}
		scoreTable = new JTable(dm);
		scoreTable.setDefaultEditor(Object.class, null);
		scoreTable.getTableHeader().setReorderingAllowed(false);
		scoreTable.getTableHeader().setResizingAllowed(false);
		scoreTable.setFillsViewportHeight(true);
		for (int i = 0; i < scoreTable.getColumnCount(); i++) {
			scoreTable.getColumnModel().getColumn(i).setCellRenderer(new CellRenderer());

		}
		scoreTable.getTableHeader().addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseClicked(MouseEvent e) {
		        int col = scoreTable.columnAtPoint(e.getPoint());
		        if (col == 0) {
		        	sortTable(true);
		        	updateTable();
		        	updateScoreTable();
		        }
       
		    }
		});
		dm = new DefaultTableModel();

		if (this.TableSortStatus == 0) {
			Object[] header = {"รหัสนักเรียน <", "คะแนนเก็บ", "คะแนนโครงงาน", "คะแนนกลางภาค", "คะแนนปลายภาค", "รวมคะแนน", "เกรดที่ได้"};
			
			dm.setDataVector(data2, header);
		}
		else {
			Object[] header = {"รหัสนักเรียน >", "คะแนนเก็บ", "คะแนนโครงงาน", "คะแนนกลางภาค", "คะแนนปลายภาค", "รวมคะแนน", "เกรดที่ได้"};
			dm.setDataVector(data2, header);
		}
		scoreTable2 = new JTable(dm);
		scoreTable2.setDefaultEditor(Object.class, null);
		scoreTable2.getTableHeader().setReorderingAllowed(false);
		scoreTable2.getTableHeader().setResizingAllowed(false);
		scoreTable2.setFillsViewportHeight(true);
		for (int i = 0; i < scoreTable2.getColumnCount(); i++) {
			scoreTable2.getColumnModel().getColumn(i).setCellRenderer(new CellRenderer());

		}
		scoreTable2.getTableHeader().addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseClicked(MouseEvent e) {
		        int col = scoreTable2.columnAtPoint(e.getPoint());
		        if (col == 0) {
		        	sortTable(true);
		        	updateTable();
		        	updateScoreTable();
		        }
       
		    }
		});
		
		dm = new DefaultTableModel();

		if (this.TableSortStatus == 0) {
			Object[] header = {"รหัสนักเรียน <", "คะแนนเก็บ", "คะแนนโครงงาน", "คะแนนกลางภาค", "คะแนนปลายภาค", "รวมคะแนน", "เกรดที่ได้"};
			
			dm.setDataVector(data3, header);
		}
		else {
			Object[] header = {"รหัสนักเรียน >", "คะแนนเก็บ", "คะแนนโครงงาน", "คะแนนกลางภาค", "คะแนนปลายภาค", "รวมคะแนน", "เกรดที่ได้"};
			dm.setDataVector(data3, header);
		}
		
		scoreTable3 = new JTable(dm);
		scoreTable3.setDefaultEditor(Object.class, null);
		scoreTable3.getTableHeader().setReorderingAllowed(false);
		scoreTable3.getTableHeader().setResizingAllowed(false);
		scoreTable3.setFillsViewportHeight(true);
		for (int i = 0; i < scoreTable3.getColumnCount(); i++) {
			scoreTable3.getColumnModel().getColumn(i).setCellRenderer(new CellRenderer());

		}
		scoreTable3.getTableHeader().addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseClicked(MouseEvent e) {
		        int col = scoreTable3.columnAtPoint(e.getPoint());
		        if (col == 0) {
		        	sortTable(true);
		        	updateTable();
		        	updateScoreTable();
		        }
       
		    }
		});
		
		
		scoreTable.setBorder(new LineBorder(Color.RED, 0));
		scoreTable2.setBorder(new LineBorder(Color.RED, 0));
		scoreTable3.setBorder(new LineBorder(Color.RED, 0));
		
		if (!managementPage.getSubjectGUI().getSubject1().getSubject().equals("empty")) {
			managementPage.getSubjectGUI().getSubject1().updateTable(scoreTable);
		}
		if (!managementPage.getSubjectGUI().getSubject2().getSubject().equals("empty")) {
			managementPage.getSubjectGUI().getSubject2().updateTable(scoreTable2);
		}
		if (!managementPage.getSubjectGUI().getSubject3().getSubject().equals("empty")) {
			managementPage.getSubjectGUI().getSubject3().updateTable(scoreTable3);
		}

    }
    public void updatePage() {      
    	managementPage.getMenu1().setBackground(new Color(156, 195, 213));
    	managementPage.getMenu2().setBackground(new Color(156, 195, 213));
		managementPage.getMenu3().setBackground(new Color(156, 195, 213));
		managementPage.getMenu4().setBackground(new Color(156, 195, 213));
		managementPage.getMenu5().setBackground(new Color(156, 195, 213));
    	switch(currentPage) {
    		case 1: managementPage.getMenu1().setBackground(Color.WHITE);break;
    		case 2: managementPage.getMenu2().setBackground(Color.WHITE);break;
    		case 3: managementPage.getMenu3().setBackground(Color.WHITE);break;
    		case 4: managementPage.getMenu4().setBackground(Color.WHITE);break;
    		case 5: managementPage.getMenu5().setBackground(Color.WHITE);break;
    	}
    }
    
    public void sortTable(boolean change) {
    	ArrayList<Student> arr = teacher.getStudents();
    	if (change) {
        	if (this.TableSortStatus == 0) {
        		this.TableSortStatus = 1;
        	}
        	else {
        		this.TableSortStatus = 0;
        	}
    	}
    	sort(arr, 0, arr.size() - 1);
    	
    	teacher.setStudents(arr);


    }
    public void sort(ArrayList<Student> arr, int l, int r) {
    	if (l < r) {
    		int m = l + ((r - l) / 2);
    		sort(arr, l, m);
    		sort(arr, m + 1, r);
    		merge(arr, l, m, r);
    	}

    }
    public void merge(ArrayList<Student> arr, int l, int m, int r) {
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



















