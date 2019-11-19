package view;
import java.awt.*;

import javax.swing.*;
import javax.swing.table.*;

public class ButtonRenderer extends JLabel implements TableCellRenderer{
	public ButtonRenderer() {
	    setFont(new Font("Kanit ExtraLight", Font.PLAIN, 16));
	    setHorizontalAlignment(JLabel.CENTER);
	 }

	  public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
	    if (column == 5) {
	      setForeground(table.getSelectionForeground());
	      setBackground(new Color(255, 0, 0, 60));
	    }
	    else if (column == 4){
	      setForeground(table.getForeground());
	      setBackground(new Color(156, 195, 213, 85));
	    }
	    setText(value.toString());
	    return this;
	  }
}
