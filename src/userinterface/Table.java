package userinterface;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import student.TableRowModel;

public class Table extends JTable {

    private static final String FN_COLUMN_NAME = "Action";
    private static final String TABLE_BUTTON_TEXT = "View Details";

    final String[] COLUMNS;
    final String[][] DATA;
    
    public Table(List<TableRowModel> rows) {
        this(new String[0], rows, null);
    }

    public Table(String[] columns, List<TableRowModel> rows) {
        this(columns, rows, null);
    }

    @SuppressWarnings("rawtypes")
    public Table(String[] columns, List<TableRowModel> rows, Consumer<TableRowModel> fn) {
        super();

        // Initalise table structure
        int maxColumns = 0;
        int fnOffset = 0;
        for (TableRowModel row : rows) {
            if (row.numColumns() > maxColumns) {
                maxColumns = row.numColumns();
            }
        }
        if (fn != null) {
            // make an extra column in the table for a button
            fnOffset = 1;
        }
        COLUMNS = new String[maxColumns + fnOffset];
        for (int i = 0; i < columns.length && i < maxColumns; i++) {
            COLUMNS[i] = columns[i];
        }
        for (int i = columns.length; i < maxColumns; i++) {
            COLUMNS[i] = "";
        }
        if (fnOffset == 1) {
            COLUMNS[maxColumns] = FN_COLUMN_NAME;
        }

        DATA = new String[rows.size()][maxColumns + fnOffset];
        for (int i = 0; i < rows.size(); i++) {
            // populate DATA array with data from each row of the model
            TableRowModel row = rows.get(i);

            for (int k = 0; k < row.numColumns(); k++) {
                Object data = row.column(k);
                if (data == null) continue;
                if (data instanceof String) {
                    DATA[i][k] = (String) data;
                }
                else if (data instanceof Optional && ((Optional) data).get() instanceof String) {
                    DATA[i][k] = (String) ((Optional) data).get();
                } else {
                    DATA[i][k] = "";
                }
            }
        }

        super.setModel(new DefaultTableModel(DATA, COLUMNS));

        if (fnOffset == 1) {
            getColumn(FN_COLUMN_NAME).setCellRenderer(new TableButtonRenderer(TABLE_BUTTON_TEXT));
            getColumn(FN_COLUMN_NAME).setCellEditor(new TableButton(TABLE_BUTTON_TEXT));
            ListSelectionListener listener = new ListSelectionListener() {
                @Override
                public void valueChanged(ListSelectionEvent e) {
                    if (e.getValueIsAdjusting()) return;
                    int selectedRow = getSelectedRow();
                    boolean buttonColumn = getSelectedColumn() == COLUMNS.length - 1;
                    if (selectedRow >= 0 && selectedRow < DATA.length && buttonColumn) {
                        fn.accept(rows.get(selectedRow));
                    }
                }
            };
            getColumnModel().getSelectionModel().addListSelectionListener(listener);
            getSelectionModel().addListSelectionListener(listener);
        }

    }
}
