package userinterface;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import student.Account;
import student.ItemInterface;

public abstract class Page extends JPanel {

    protected final int PADDING = 20;

    protected UIService service;
    protected Account userAccount;
    String routeName;

    public Page(UIService uiservice, Account account, String name) {
        service = uiservice;
        userAccount = account;
        routeName = name;
    }

    public abstract void accept(ItemInterface data);

    protected abstract void init();

    public void buildPage() {
        removeAll();
        setLayout(new BorderLayout());
        add(getTop(), BorderLayout.PAGE_START);
        add(getCentre(), BorderLayout.CENTER);
        add(getBottom(), BorderLayout.SOUTH);
    }

    protected JPanel getTop() {
        JPanel top = new JPanel();
        top.setLayout(new GridLayout(3, 0));
        top.add(new NavigationBar(service, false));
        top.add(new JLabel("Current page: " + routeName, SwingConstants.CENTER));
        top.add(new JLabel(String.format("Current credit: %.2f", userAccount.credit), SwingConstants.CENTER));
        return top;
    }

    protected abstract JPanel getCentre();

    protected abstract JPanel getBottom();
}
