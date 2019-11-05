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
	  private JLabel l1, l2, l3, pictureLabel;
	  private JLabel a1, a2, a3;
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
	    	l2 = Helper.createLabel("คํานําหน้า");
	    	a2 = Helper.createLabel(information.get("title"));
	    	l3 = Helper.createLabel("ชื่อ");
	    	a3 = Helper.createLabel(information.get("name"));
	    	

	    	gbc.insets = new Insets(5, 10, 5, 0);
	        //gbc.fill = GridBagConstraints.BOTH;
	        
	        gbc.gridwidth = 2;
		    p1.add(pictureLabel, gbc);
		    gbc.gridwidth = 1;
		    gbc.gridx = 0;
		    gbc.gridy = 1;
		    p1.add(l1, gbc);
		    gbc.gridx = 1;
		    gbc.gridy = 1;
		    p1.add(a1, gbc);
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
	    	
			JOptionPane.showMessageDialog(null, p1, information.get("studentID"), -1);
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
