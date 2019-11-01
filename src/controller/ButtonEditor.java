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
	    	
	    	
	    	Image img = Toolkit.getDefaultToolkit().createImage(choose.getPicturePath());
	    	img = img.getScaledInstance(150, 150, Image.SCALE_DEFAULT);
	    	JLabel pictureLabel = Helper.createLabel("");
		    pictureLabel.setIcon(new ImageIcon(img));
		    p1.add(pictureLabel);
	    	
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
