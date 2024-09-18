package userinterface;

import java.awt.Component;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class TableButtonRenderer extends JButton implements TableCellRenderer {

    private String text;

    public TableButtonRenderer(String text) {
        setOpaque(true);
        this.text = text;
    }

    @Override
    public Component getTableCellRendererComponent(
            JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column
    ) {
        setText(text);
        return this;
    }
    
}
