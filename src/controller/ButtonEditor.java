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
	  private ManagementGUI managementPage;
	  private StudentManagement s;
	  public ButtonEditor(JCheckBox checkBox, Teacher teacher, ManagementGUI m, StudentManagement s) {
	    super(checkBox);
	    this.managementPage = m;
	    this.teacher = teacher;
	    this.s = s;
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
		  //System.out.printf("Button press at (%d, %d)\n", this.row, this.col);
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

	    	managementPage.set("information");
	    	student = teacher.getStudents().get(row);
	    	managementPage.informationSet(student);
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
