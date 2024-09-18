package userinterface;

import java.awt.BorderLayout;
import java.util.List;
import java.util.Optional;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import student.Account;
import student.ItemInterface;
import student.TableRowModel;
import student.Cart;

public class CartPage extends Page {

    public static final String ROUTE_NAME = "cart-page";

    private Cart cart;
    private Optional<Runnable> purchaseFn = Optional.empty();  // Changed to Optional

    public CartPage(UIService uiservice, Account account, Cart cart) {
        super(uiservice, account, ROUTE_NAME);
        this.cart = cart;
    }

    public void setPurchaseFn(Runnable fn) {
        this.purchaseFn = Optional.ofNullable(fn);
    }

    @Override
    public void accept(ItemInterface data) {}  // empty

    @Override
    protected void init() {}

    @Override
    protected JPanel getCentre() {
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(PADDING, PADDING, PADDING, PADDING));

        String[] columns = new String[]{"Name", "Price", "Quantity"};
        List<TableRowModel> rows = cart.toTableRows();

        JScrollPane scrollPane = new JScrollPane(new Table(columns, rows));
        panel.add(scrollPane, BorderLayout.CENTER);

        return panel;
    }

    @Override
    protected JPanel getBottom() {
        JPanel panel = new JPanel();

        JButton purchaseButton = new JButton();
        purchaseButton.setText("Purchase");
        purchaseButton.addActionListener(e -> {
            purchaseFn.ifPresent(Runnable::run);
            service.refresh();
        });
        panel.add(purchaseButton);

        JButton clearButton = new JButton();
        clearButton.setText("Clear");
        clearButton.addActionListener(e -> {
            cart.clear();
            service.refresh();
        });
        panel.add(clearButton);

        return panel;
    }

}