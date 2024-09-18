package userinterface;

import java.util.function.Consumer;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import student.Account;
import student.ItemInterface;

public class ProductPage extends Page {

    public static final String ROUTE_NAME = "product-page";

    private ItemInterface display;
    private Consumer<ItemInterface> addFn;

    public ProductPage(UIService uiservice, Account account) {
        super(uiservice, account, ROUTE_NAME);
    }

    public void setAddToCartAction(Consumer<ItemInterface> addToCartFn) {
        addFn = addToCartFn;
    }

    @Override
    public void accept(ItemInterface data) {
        display = data;
    }

    @Override
    protected void init() {}

    @Override
    protected JPanel getCentre() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(PADDING, PADDING, PADDING, PADDING));

        panel.add(new JLabel("Name:"));
        panel.add(new JLabel(display == null ? "" : display.getName()));
        panel.add(new JPanel());
        panel.add(new JLabel("Description:"));
        panel.add(new JLabel(display == null ? "" : display.getDescription()));
        panel.add(new JPanel());
        panel.add(new JLabel("Price:"));
        panel.add(new JLabel(display == null ? "" : display.getPrice() + ""));

        return panel;
    }

    @Override
    protected JPanel getBottom() {
        JPanel panel = new JPanel();

        JButton buy = new JButton();
        buy.setText("Add to cart");
        buy.addActionListener(e -> addFn.accept(display));

        panel.add(buy);
        return panel;
    }
    
}
