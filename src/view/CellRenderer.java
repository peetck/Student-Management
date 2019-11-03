package view;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;

public class CellRenderer extends DefaultTableCellRenderer {

	//private static final long serialVersionUID = 1L;
	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int col) {
	    super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, col);
	    this.setBackground(Color.WHITE);
	    this.setFont(new Font("itim", Font.PLAIN, 16));
	    this.setHorizontalAlignment( JLabel.CENTER );
	    return this;
	}
}