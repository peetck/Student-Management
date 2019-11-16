package view;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;

public class CellRenderer extends DefaultTableCellRenderer {


	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int col) {
	    super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, col);
	    this.setFont(new Font("Kanit ExtraLight", Font.PLAIN, 16));
	    this.setHorizontalAlignment( JLabel.CENTER );
	    if (col == 6) {
	    	String grade = this.getText();
	    	switch(grade) {
	    		case "A": 	this.setBackground(new Color(62, 193, 79, 100));break;
	    		case "B+": 	this.setBackground(new Color(62, 193, 79, 85));break;
	    		case "B": 	this.setBackground(new Color(62, 193, 79, 75));break;
	    		case "C+": 	this.setBackground(new Color(62, 193, 79, 65));break;
	    		case "C": 	this.setBackground(new Color(62, 193, 79, 55));break;
	    		case "D+": 	this.setBackground(new Color(62, 193, 79, 45));break;
	    		case "D": 	this.setBackground(new Color(62, 193, 79, 35));break;
	    		case "F": 	this.setBackground(new Color(62, 193, 79, 25));break;
	    	}
	    	
	    }
	    else {
		    this.setBackground(Color.WHITE);
	    }
	    return this;
	}
}