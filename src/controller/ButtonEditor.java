package controller;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import model.*;
import view.Helper;

public class ButtonEditor extends DefaultCellEditor {
	  protected JButton button;
	  private int row;
	  private String label;
	  private Teacher teacher;
	  private boolean isPushed;

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
		  if (isSelected) {
			  button.setForeground(table.getSelectionForeground());
			  //button.setBackground(table.getSelectionBackground());
			  button.setBackground(Color.WHITE);
		  }
		  else {
			  button.setForeground(table.getForeground());
			  //button.setBackground(table.getBackground());
			  button.setBackground(Color.WHITE);
		  }
		  label = (value == null) ? "" : value.toString();
		  button.setText(label);
		  isPushed = true;
		  return button;
	  }

	  public Object getCellEditorValue() {
	    if (isPushed) {
	    	Student choose = teacher.getStudents().get(row);
	    	// event if in row student get click for more information
	    	System.out.println(choose.getStudentID());
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
