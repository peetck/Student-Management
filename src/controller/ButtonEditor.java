package controller;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import model.*;
import view.Helper;

public class ButtonEditor extends DefaultCellEditor {
	  protected JButton button;
	  private int row;
	  private int col;
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
		  this.col = column;
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
	    	JPanel p1 = Helper.createPanel("");
	    	p1.setLayout(new GridBagLayout());
	    	GridBagConstraints gbc = new GridBagConstraints();
	    	gbc.insets = new Insets(10, 100, 5, 5);
	        gbc.fill = GridBagConstraints.BOTH;
	    	JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11, l12, l13, l14, l15;
	    	JLabel a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15;
	    	
	    	l1 = Helper.createLabel("รหัสนักศึกษา");

	    	l2 = Helper.createLabel("คํานําหน้า");
			l3 = Helper.createLabel("ชื่อ");
			l4 = Helper.createLabel("นามสกุล");
			l5 = Helper.createLabel("หมายเลขบัตรประชาชน");
			l6 = Helper.createLabel("ที่อยู่");
			l7 = Helper.createLabel("เชื้อชาติ");
			l8 = Helper.createLabel("ศาสนา");
			l9 = Helper.createLabel("หมู่เลือด");
			l10 = Helper.createLabel("เบอร์ติดต่อ");
			l11 = Helper.createLabel("อีเมล์");
			l12 = Helper.createLabel("ส่วนสูง");
			l13 = Helper.createLabel("นํ้าหนัก");
			l14 = Helper.createLabel("เบอร์ติดต่อผู้ปกครอง");
			l15 = Helper.createLabel("โรคประจําตัว");

			a1 = Helper.createLabel(choose.getStudentID());
			//a1.setHorizontalAlignment(JLabel.CENTER);
			a2 = Helper.createLabel(choose.getTitle());
			//a2.setHorizontalAlignment(JLabel.CENTER);
			a3 = Helper.createLabel(choose.getName());
			//a3.setHorizontalAlignment(JLabel.CENTER);
			a4 = Helper.createLabel(choose.getSurname());
			//a4.setHorizontalAlignment(JLabel.CENTER);
			a5 = Helper.createLabel(choose.getCardID());
			//a5.setHorizontalAlignment(JLabel.CENTER);
			a6 = Helper.createLabel(choose.getAddress());
			//a6.setHorizontalAlignment(JLabel.CENTER);
			a7 = Helper.createLabel(choose.getRace());
			//a7.setHorizontalAlignment(JLabel.CENTER);
			a8 = Helper.createLabel(choose.getReligion());
			//a8.setHorizontalAlignment(JLabel.CENTER);
			a9 = Helper.createLabel(choose.getBloodType());
			//a9.setHorizontalAlignment(JLabel.CENTER);
			a10 = Helper.createLabel(choose.getTel());
			//a10.setHorizontalAlignment(JLabel.CENTER);
			a11 = Helper.createLabel(choose.getEmail());
			//a11.setHorizontalAlignment(JLabel.CENTER);
			a12 = Helper.createLabel(choose.getHeight());
			//a12.setHorizontalAlignment(JLabel.CENTER);
			a13 = Helper.createLabel(choose.getWeight());
			//a13.setHorizontalAlignment(JLabel.CENTER);
			a14 = Helper.createLabel(choose.getParentTel());
			//a14.setHorizontalAlignment(JLabel.CENTER);
			a15 = Helper.createLabel(choose.getDisease());
			//a15.setHorizontalAlignment(JLabel.CENTER);

			p1.add(l1, gbc);
			gbc.gridx = 1;
			p1.add(a1, gbc);
			gbc.gridx = 0;
			gbc.gridy = 1;
			p1.add(l2, gbc);
			gbc.gridx = 1;
			p1.add(a2, gbc);
			gbc.gridx = 0;
			gbc.gridy = 2;
			p1.add(l3, gbc);
			gbc.gridx = 1;
			p1.add(a3, gbc);
			gbc.gridx = 0;
			gbc.gridy = 3;
			p1.add(l4, gbc);
			gbc.gridx = 1;
			p1.add(a4, gbc);
			gbc.gridx = 0;
			gbc.gridy = 4;
			p1.add(l5, gbc);
			gbc.gridx = 1;
			p1.add(a5, gbc);
			gbc.gridx = 0;
			gbc.gridy = 5;
			p1.add(l6, gbc);
			gbc.gridx = 1;
			p1.add(a6, gbc);
			gbc.gridx = 0;
			gbc.gridy = 6;
			p1.add(l7, gbc);
			gbc.gridx = 1;
			p1.add(a7, gbc);
			gbc.gridx = 0;
			gbc.gridy = 7;
			p1.add(l8, gbc);
			gbc.gridx = 1;
			p1.add(a8, gbc);
			gbc.gridx = 0;
			gbc.gridy = 8;
			p1.add(l9, gbc);
			gbc.gridx = 1;
			p1.add(a9, gbc);
			gbc.gridx = 0;
			gbc.gridy = 9;
			p1.add(l10, gbc);
			gbc.gridx = 1;
			p1.add(a10, gbc);
			gbc.gridx = 0;
			gbc.gridy = 10;
			p1.add(l11, gbc);
			gbc.gridx = 1;
			p1.add(a11, gbc);
			gbc.gridx = 0;
			gbc.gridy = 11;
			p1.add(l12, gbc);
			gbc.gridx = 1;
			p1.add(a12, gbc);
			gbc.gridx = 0;
			gbc.gridy = 12;
			p1.add(l13, gbc);
			gbc.gridx = 1;
			p1.add(a13, gbc);
			gbc.gridx = 0;
			gbc.gridy = 13;
			p1.add(l14, gbc);
			gbc.gridx = 1;
			p1.add(a14, gbc);
			gbc.gridx = 0;
			gbc.gridy = 14;
			p1.add(l15, gbc);
			gbc.gridx = 1;
			p1.add(a15, gbc);

			
			JOptionPane.showMessageDialog(null, p1, choose.getStudentID(), JOptionPane.OK_CANCEL_OPTION);
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
