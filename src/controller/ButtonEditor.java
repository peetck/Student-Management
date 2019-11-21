package controller;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import model.*;
import view.*;

public class ButtonEditor extends DefaultCellEditor {
	  private JButton button;
	  private int row;
	  private String label;
	  private Teacher teacher;
	  private Student student;
	  private boolean isPushed;
	  private ManagementGUI managementPage;
	  public ButtonEditor(JCheckBox checkBox, Teacher teacher, ManagementGUI m, StudentManagement s) {
	    super(checkBox);
	    this.managementPage = m;
	    this.teacher = teacher;
	    button = new JButton("");
	    button.setFont(new Font("Kanit ExtraLight", Font.PLAIN, 16));
	    button.setBackground(new Color(156, 195, 213, 85));
	    button.addActionListener(new ActionListener() {
	      public void actionPerformed(ActionEvent e) {
	        fireEditingStopped();
	      }
	    });

	  }

	  public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
		  this.row = row;
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
