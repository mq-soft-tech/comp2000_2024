package student;

import java.util.ArrayList;
import java.util.List;

public class TableRowModel {

    private List<String> columnData;

    public TableRowModel(String... values) {
        columnData = new ArrayList<>(values.length);
        for (int i = 0; i < values.length; i++) {
            columnData.add(values[i]);
        }
    }

    public int numColumns() {
        return columnData.size();
    }

    public String column(int i) {
        return columnData.get(i);
    }
}
