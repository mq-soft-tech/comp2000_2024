package userinterface;

import javax.swing.JPanel;

import student.ItemInterface;

import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.util.Stack;

public class UIService {
    
    private CardLayout layout;
    private JPanel panel;
    private Stack<String> history;

    public UIService() {
        history = new Stack<>();
        layout = new CardLayout();
        panel = new JPanel(layout);
        panel.setPreferredSize(new Dimension(1280, 720));
    }

    public JPanel getPanel() {
        return panel;
    }

    public void addPage(Page page) {
        panel.add(page, page.routeName);
    }

    Page getActivePage() {
        Page page = null;
        for (Component c : panel.getComponents()) {
            if (c.isVisible()) {
                page = (Page) c;
            }
        }
        return page;
    }

    String lastPageRoute() {
        if (history.size() <= 1) {
            return "";
        }
        String current = history.pop();
        String last = history.peek();
        history.push(current);
        return last;
    }

    void refresh() {
        String current = history.peek();
        if (history.size() > 1) {
            back();
        }
        navigateTo(current);
    }

    public void navigateTo(String route) {
        if (history.size() > 0 && history.peek().equals(route)) {
            return;
        }
        history.push(route);
        layout.show(panel, route);
        getActivePage().buildPage();
        getActivePage().validate();
    }

    public void navigateTo(String route, ItemInterface data) {
        if (history.size() > 0 && history.peek().equals(route)) {
            return;
        }
        history.push(route);
        layout.show(panel, route);
        getActivePage().accept(data);
        getActivePage().buildPage();
        getActivePage().validate();
    }

    void back() {
        String last = lastPageRoute();
        if (!last.isEmpty()) {
            navigateTo(last);
        }
    }
}
