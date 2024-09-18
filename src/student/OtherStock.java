package student;

import java.util.ArrayList;
import java.util.List;

public class OtherStock {
    private List<ProductBrief> stock;
    private List<Integer> quantities;
    
    public OtherStock(List<ProductBrief> startingStock, List<Integer> qtys) {
        stock = startingStock;
        quantities = qtys;
    }

    public List<ProductBrief> getStockList() {
        return stock;
    }

    public List<Integer> getQuantities() {
        return quantities;
    }

    public int getQuantityOf(String name) {
        int index = indexOf(name);
        return quantities.get(index);
    }

    public void setQuantity(String name, int quantity) {
        int index = indexOf(name);
        quantities.set(index, quantity);
    }

    private int indexOf(String name) {
        Integer index = null;
        for (int i = 0; i < stock.size() && index == null; i++) {
            if (stock.get(i).getName().equals(name)) {
                index = i;
            }
        }
        return index;
    }

    List<TableRowModel> toTableRows() {
        List<TableRowModel> result = new ArrayList<>();

        for (int i = 0; i < stock.size(); i++) {
            ProductBrief item = stock.get(i);
            String name = item.getName();
            String quantity = quantities.get(i) + "";
            String path = item.getDataPath();
            result.add(new TableRowModel(name, quantity, path));
        }

        return result;
    }

}
