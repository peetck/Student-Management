package view;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;

public class CellRenderer extends DefaultTableCellRenderer {

	private static final long serialVersionUID = 1L;
	
	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
	    super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
	    this.setValue(table.getValueAt(row, column));
	    this.setFont(new Font("itim", Font.PLAIN, 16));
	    return this;
	}
}