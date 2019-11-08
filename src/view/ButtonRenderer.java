package view;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;
public class ButtonRenderer extends JButton implements TableCellRenderer{
	public ButtonRenderer() {
	    setOpaque(true);
	    setFont(new Font("Kanit ExtraLight", Font.PLAIN, 16));

	 }

	  public Component getTableCellRendererComponent(JTable table, Object value,
	      boolean isSelected, boolean hasFocus, int row, int column) {
	    if (isSelected) {
	      setForeground(table.getSelectionForeground());
	      //setBackground(table.getSelectionBackground());
	      setBackground(Color.WHITE);
	    } else {
	      setForeground(table.getForeground());
	      //setBackground(UIManager.getColor("Button.background"));
	      setBackground(Color.WHITE);
	      
	    }
	    if (value == null) {
	    	setText("");
	    }
	    else {
	    	setText(value.toString());
	    }
	    return this;
	  }
}
