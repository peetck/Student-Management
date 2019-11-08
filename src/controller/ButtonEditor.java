package controller;

import java.awt.*;
import java.util.*;
import java.awt.event.*;
import javax.swing.*;

import model.*;
import view.*;

public class ButtonEditor extends DefaultCellEditor {
	  protected JButton button;
	  private int row, col;
	  private String label;
	  private Teacher teacher;
	  private Student student;
	  private HashMap<String, String> information;
	  private boolean isPushed;
	  private MyPanel p1;
	  private JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11, l12, l13, l14, l15, l16, l17 , pictureLabel;
	  private JLabel a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16, a17, title;
	  private GridBagConstraints gbc;
	  
	  public ButtonEditor(JCheckBox checkBox, Teacher teacher) {
	    super(checkBox);
	    this.teacher = teacher;
	    button = Helper.createButton("");
	    button.setOpaque(true);
	    button.addActionListener(new ActionListener() {
	      public void actionPerformed(ActionEvent e) {
	        fireEditingStopped();
	      }
	    });

	  }

	  public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
		  this.row = row;
		  this.col = column;
		  System.out.printf("Button press at (%d, %d)\n", this.row, this.col);
		  if (isSelected) {
			  button.setForeground(table.getSelectionForeground());
			  button.setBackground(Color.WHITE);
		  }
		  else {
			  button.setForeground(table.getForeground());
			  button.setBackground(Color.WHITE);
		  }
		  if (value == null) {
			  label = "";
		  }
		  else {
			  label = value.toString();
		  }
		  button.setText(label);
		  isPushed = true;
		  return button;
	  }

	  public Object getCellEditorValue() {
	    if (isPushed) {
		    System.out.println("Pressed");
	    	student = teacher.getStudents().get(row);
	    	information = student.getInformation();
	    	
	    	p1 = Helper.createPanel("");
	    	p1.setLayout(new GridBagLayout());
	    	gbc = new GridBagConstraints();
	    	

	    	
	    	pictureLabel = Helper.createLabel("");
	    	pictureLabel.setBorder(BorderFactory.createLineBorder(Color.black));

	    	if ( ! (student.getPicturePath().equals("default"))) {
	    		Image img = Toolkit.getDefaultToolkit().getImage(student.getPicturePath());
		    	img = img.getScaledInstance(150, 150, Image.SCALE_DEFAULT);
			    pictureLabel.setIcon(new ImageIcon(img));
	    	}
	    	else {
	    		Image img = Helper.getImage("/images/blank_profile.png");
	    		img = img.getScaledInstance(150, 150, Image.SCALE_DEFAULT);
	    		pictureLabel.setIcon(new ImageIcon(img));
	    	}
	    	
	    	l1 = Helper.createLabel("รหัสนักเรียน");
	    	
	    	a1 = Helper.createLabel(information.get("studentID"));
	    	l2 = Helper.createLabel("คณะ");
	    	a2 = Helper.createLabel(information.get("faculty"));
	    	l3 = Helper.createLabel("คํานําหน้า");
	    	a3 = Helper.createLabel(information.get("title"));
	    	l4 = Helper.createLabel("ชื่อ");
	    	a4 = Helper.createLabel(information.get("name"));
	    	l5 = Helper.createLabel("นามสกุล");
	    	a5 = Helper.createLabel(information.get("surname"));
	    	
	    	l6 = Helper.createLabel("วันเดือนปีเกิด");
	    	a6 = Helper.createLabel(information.get("day") + information.get("month") + information.get("year"));
	    	l7 = Helper.createLabel("หมายเลขบัตรประชาชน");
	    	a7 = Helper.createLabel(information.get("cardID"));
	    	l8 = Helper.createLabel("ที่อยู่");
	    	a8 = Helper.createLabel(information.get("address"));
	    	
	    	l9 = Helper.createLabel("เชื้อชาติ");
	    	a9 = Helper.createLabel(information.get("race"));
	    	l10 = Helper.createLabel("ศาสนา");
	    	a10 = Helper.createLabel(information.get("religion"));
	    	l11 = Helper.createLabel("หมู่เลือด");
	    	a11 = Helper.createLabel(information.get("bloodType"));
	    	l12 = Helper.createLabel("เบอร์ติดต่อ");
	    	a12 = Helper.createLabel(information.get("tel"));
	    	l13 = Helper.createLabel("อีเมล์");
	    	a13 = Helper.createLabel(information.get("email"));
	    	l14 = Helper.createLabel("ส่วนสูง");
	    	a14 = Helper.createLabel(information.get("height"));
	    	l15 = Helper.createLabel("นํ้าหนัก");
	    	a15 = Helper.createLabel(information.get("weight"));
	    	l16 = Helper.createLabel("เบอร์ติดต่อผู้ปกครอง");
	    	a16 = Helper.createLabel(information.get("parentTel"));
	    	l17 = Helper.createLabel("โรคประจําตัว");
	    	a17 = Helper.createLabel(information.get("disease"));
	    	
	    	title = Helper.createLabel("ข้อมูลนักเรียน", 35);
	    	
	    	gbc.insets = new Insets(5, 10, 5, 0);
	    	
	        //gbc.fill = GridBagConstraints.BOTH;
	        
	        gbc.gridwidth = 1;
		    p1.add(pictureLabel, gbc);
		    gbc.gridwidth = 2;
		    gbc.gridx = 1;
		    p1.add(title, gbc);
		    gbc.fill = GridBagConstraints.BOTH;
		    gbc.gridwidth = 1;
		    gbc.gridx = 0;
		    gbc.gridy = 1;
		    gbc.insets = new Insets(20, 50, 5, 50);
		    gbc.anchor = GridBagConstraints.WEST;
		    p1.add(l1, gbc);
		    gbc.gridx = 1;
		    gbc.gridy = 1;
		    p1.add(a1, gbc);
		    gbc.insets = new Insets(5, 50, 5, 50);
		    gbc.gridx = 0;
		    gbc.gridy = 2;
		    p1.add(l2, gbc);
		    gbc.gridx = 1;
		    gbc.gridy = 2;
		    p1.add(a2, gbc);
		    gbc.gridx = 0;
		    gbc.gridy = 3;
		    p1.add(l3, gbc);
		    gbc.gridx = 1;
		    gbc.gridy = 3;
		    p1.add(a3, gbc);
		    gbc.gridx = 0;
		    gbc.gridy = 4;
		    p1.add(l4, gbc);
		    gbc.gridx = 1;
		    gbc.gridy = 4;
		    p1.add(a4, gbc);
		    gbc.gridx = 0;
		    gbc.gridy = 5;
		    p1.add(l5, gbc);
		    gbc.gridx = 1;
		    gbc.gridy = 5;
		    p1.add(a5, gbc);
		    gbc.gridx = 0;
		    gbc.gridy = 6;
		    p1.add(l6, gbc);
		    gbc.gridx = 1;
		    gbc.gridy = 6;
		    p1.add(a6, gbc);
		    gbc.gridx = 0;
		    gbc.gridy = 7;
		    p1.add(l7, gbc);
		    gbc.gridx = 1;
		    gbc.gridy = 7;
		    p1.add(a7, gbc);
		    gbc.gridx = 0;
		    gbc.gridy = 8;
		    p1.add(l8, gbc);
		    gbc.gridx = 1;
		    gbc.gridy = 8;
		    p1.add(a8, gbc);
		    
		    gbc.gridx = 0;
		    gbc.gridy = 9;
		    p1.add(l9, gbc);
		    gbc.gridx = 1;
		    gbc.gridy = 9;
		    p1.add(a9, gbc);
		    gbc.gridx = 0;
		    gbc.gridy = 10;
		    p1.add(l10, gbc);
		    gbc.gridx = 1;
		    gbc.gridy = 10;
		    p1.add(a10, gbc);
		    gbc.gridx = 0;
		    gbc.gridy = 11;
		    p1.add(l11, gbc);
		    gbc.gridx = 1;
		    gbc.gridy = 11;
		    p1.add(a11, gbc);
		    gbc.gridx = 0;
		    gbc.gridy = 12;
		    p1.add(l12, gbc);
		    gbc.gridx = 1;
		    gbc.gridy = 12;
		    p1.add(a12, gbc);
		    gbc.gridx = 0;
		    gbc.gridy = 13;
		    p1.add(l13, gbc);
		    gbc.gridx = 1;
		    gbc.gridy = 13;
		    p1.add(a13, gbc);
		    gbc.gridx = 0;
		    gbc.gridy = 14;
		    p1.add(l14, gbc);
		    gbc.gridx = 1;
		    gbc.gridy = 14;
		    p1.add(a14, gbc);
		    gbc.gridx = 0;
		    gbc.gridy = 15;
		    p1.add(l15, gbc);
		    gbc.gridx = 1;
		    gbc.gridy = 15;
		    p1.add(a15, gbc);
		    gbc.gridx = 0;
		    gbc.gridy = 16;
		    p1.add(l16, gbc);
		    gbc.gridx = 1;
		    gbc.gridy = 16;
		    p1.add(a16, gbc);
		    gbc.gridx = 0;
		    gbc.gridy = 17;
		    p1.add(l17, gbc);
		    gbc.gridx = 1;
		    gbc.gridy = 17;
		    p1.add(a17, gbc);

		    
			JOptionPane.showMessageDialog(null, p1, "ข้อมูลเพิ่มเติม : " + information.get("studentID"), -1);
	    }
	    isPushed = false;
	    return new String(label);
	  }

	  public boolean stopCellEditing() {
	    isPushed = false;
	    return super.stopCellEditing();
	  }

	  protected void fireEditingStopped() {
	    super.fireEditingStopped();
	  }
	}
