package userinterface;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JPanel;

public class NavigationBar extends JPanel {
    public NavigationBar(UIService service, boolean showBack) {
        Box horizontal1 = Box.createHorizontalBox();

        Box centreBox = Box.createHorizontalBox();
        if (showBack) {
            JButton back = new JButton("< Back");
            back.addActionListener((unused) -> service.back());
            centreBox.add(back);
        }

        JButton store = new JButton("Store");
        store.addActionListener((unused) -> service.navigateTo(StockPage.ROUTE_NAME));
    
        JButton cart = new JButton("Cart");
        cart.addActionListener((unused) -> service.navigateTo(CartPage.ROUTE_NAME));

        centreBox.add(store);
        centreBox.add(cart);

        horizontal1.add(centreBox);
        super.add(horizontal1);
    }
}
