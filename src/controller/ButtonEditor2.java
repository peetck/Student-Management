package controller;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import model.*;
import view.*;
// for Delete Student
public class ButtonEditor2 extends DefaultCellEditor {
	  protected JButton button;
	  private int row, col;
	  private Teacher teacher;
	  private Student student;
	  private String label;
	  private boolean isPushed;
	  private JLabel msg;
	  private StudentManagement stu;
	  
	  public ButtonEditor2(JCheckBox checkBox, Teacher teacher, StudentManagement stu) {
		super(checkBox);
		this.teacher = teacher;
		this.stu = stu;
		button = new JButton("");
		button.setFont(new Font("Kanit ExtraLight", Font.PLAIN, 16));
		button.setBackground(new Color(255, 0, 0, 40));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fireEditingStopped();
			}
		});

	  }

	  public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
		  this.row = row;
		  this.col = column;
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
			msg = Helper.createLabel(Language.get("ButtonEditor2_msg1") + " " + student.getStudentID() + " " + Language.get("ButtonEditor2_msg2"));

			int alert = JOptionPane.showConfirmDialog(null, msg, Language.get("ButtonEditor2_msg3"), JOptionPane.OK_CANCEL_OPTION);
			if (alert == JOptionPane.OK_OPTION) {
				if ((stu.delete(student.getStudentID()))) {
					JLabel msg2 = Helper.createLabel(Language.get("ButtonEditor2_msg4") + " " + student.getStudentID() + " " + Language.get("ButtonEditor2_msg5"));
    				JOptionPane.showMessageDialog(null, msg2);
				}
				else{
					JLabel msg2 = Helper.createLabel(Language.get("nostudent"));
    				JOptionPane.showMessageDialog(null, msg2);
				}
            }
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
