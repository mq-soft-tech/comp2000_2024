package userinterface;

import java.awt.Component;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTable;

public class TableButton extends DefaultCellEditor {
    private JButton button;
    private String text;

    public TableButton(String text) {
        super(new JCheckBox());
        button = new JButton();
        button.setOpaque(true);
        button.addActionListener(e -> fireEditingStopped());
        this.text = text;
    }

    @Override
    public Component getTableCellEditorComponent(
        JTable table, Object value, boolean isSelected, int row, int column
    ) {
        button.setText(text);
        return button;
    }
}
