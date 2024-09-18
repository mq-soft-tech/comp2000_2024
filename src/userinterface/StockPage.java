package userinterface;

import java.awt.BorderLayout;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import student.Account;
import student.ItemInterface;
import student.TableRowModel;

public class StockPage extends Page {
    public static final String ROUTE_NAME = "stock-page";

    private List<TableRowModel> stockRows;
    private Consumer<String> detailsFn;

    public StockPage(UIService uiservice, Account account, List<TableRowModel> stock) {
        super(uiservice, account, ROUTE_NAME);
        stockRows = stock;
    }

    public void setDetailsButtonFn(Consumer<String> fn) {
        detailsFn = fn;
    }

    public void updateStockRows(List<TableRowModel> rows) {
        stockRows = rows;
    }

    @Override
    public void accept(ItemInterface data) {}  // empty

    @Override
    protected void init() {}

    @Override
    protected JPanel getCentre() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(PADDING, PADDING, PADDING, PADDING));

        String[] columns = new String[]{"Name", "Quantity", "File Path"};

        @SuppressWarnings("rawtypes")
        JScrollPane scrollPane = new JScrollPane(new Table(columns, stockRows, r -> {
            Object dataPath = r.column(r.numColumns() - 1);
            if (dataPath instanceof String) {
                detailsFn.accept((String) dataPath);
            }
            if (dataPath instanceof Optional && ((Optional) dataPath).get() instanceof String) {
                detailsFn.accept((String) ((Optional) dataPath).get());
            }
        }));
        panel.add(scrollPane, BorderLayout.CENTER);

        return panel;
    }

    @Override
    protected JPanel getBottom() {
        JPanel panel = new JPanel();
        return panel;
    }
    
}
