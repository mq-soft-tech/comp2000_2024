package student;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import userinterface.CartPage;
import userinterface.ProductPage;
import userinterface.StockPage;
import userinterface.UIService;

public class App {
    public static final String DATA_DIR = "./data";

    private OtherStock otherStock;
    private BookStock bookStock;
    private UIService ui;
    private Account account;
    private Cart cart;
    private JFrame frame;

    public App(BookStock bookStartingStock, OtherStock otherStartingStock) {
        bookStock = bookStartingStock;
        otherStock = otherStartingStock;
        ui = new UIService();
        account = new Account();
        cart = new Cart();
        
        account.credit = 100;

        List<TableRowModel> stockRows = combinedRows(bookStock.toTableRows(), otherStock.toTableRows());
        StockPage stockPage = new StockPage(ui, account, stockRows);
        setupDetailsButtonAction(stockPage);

        ProductPage productPage = new ProductPage(ui, account);
        setupAddToCartAction(productPage);

        CartPage cartPage = new CartPage(ui, account, cart);
        setupPurchaseAction(cartPage, stockPage);

        ui.addPage(stockPage);
        ui.addPage(productPage);
        ui.addPage(cartPage);
        
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(ui.getPanel());
        frame.pack();
        frame.setVisible(true);
        ui.navigateTo(StockPage.ROUTE_NAME);
    }

    void setupDetailsButtonAction(StockPage page) {
        page.setDetailsButtonFn((data) -> {
            try {
                ui.navigateTo(ProductPage.ROUTE_NAME, DataReader.read(data));
            } catch (Exception e) {
                e.printStackTrace();
                System.exit(1);
            }
        });
    }

    void setupAddToCartAction(ProductPage page) {
        page.setAddToCartAction(product -> cart.add(product));
    }

    void setupPurchaseAction(CartPage page, StockPage pageToUpdate) {
        page.setPurchaseFn(() -> {
            if (cart.buy(account, bookStock)) {
                List<TableRowModel> rows = combinedRows(bookStock.toTableRows(), otherStock.toTableRows());
                pageToUpdate.updateStockRows(rows);
            }
            if (cart.buy(account, otherStock)) {
                cart.clear();
                List<TableRowModel> rows = combinedRows(bookStock.toTableRows(), otherStock.toTableRows());
                pageToUpdate.updateStockRows(rows);
            }
        });
    }

    private static List<TableRowModel> combinedRows(List<TableRowModel> a, List<TableRowModel> b) {
        List<TableRowModel> result = new ArrayList<>(a.size() + b.size());
        a.forEach(result::add);
        b.forEach(result::add);
        return result;
    }

    public static void main(String[] args) throws Exception {
        StockReader.read(DATA_DIR + "/stock");
    }
}
