package student;

import java.util.List;
import java.util.ArrayList;

public class Cart {
    public List<Book> books;
    public List<Integer> bookQuantities;
    public List<Product> products;
    public List<Integer> productQuantities;

    public Cart() {
        books = new ArrayList<>();
        bookQuantities = new ArrayList<>();
        products = new ArrayList<>();
        productQuantities = new ArrayList<>();
    }

    public void clear() {
        books.clear();
        bookQuantities.clear();
        products.clear();
        productQuantities.clear();
    }

    public void add(ItemInterface item) {
        if (item instanceof Book) {
            add((Book) item);
        }
        if (item instanceof Product) {
            add((Product) item);
        }
    }

    public void add(Book book) {
        int bookIndex = books.indexOf(book);
        if (bookIndex < 0) {
            books.add(book);
            bookQuantities.add(1);
        } else {
            bookQuantities.set(bookIndex, bookQuantities.get(bookIndex) + 1);
        }
    }

    public void add(Product product) {
        int productIndex = products.indexOf(product);
        if (productIndex < 0) {
            products.add(product);
            productQuantities.add(1);
        } else {
            productQuantities.set(productIndex, productQuantities.get(productIndex) + 1);
        }
    }

    public boolean buy(Account user, BookStock from) {
        double totalCost = 0;

        for (int i = 0; i < books.size(); i++) {
            Book orderBook = books.get(i);
            Integer orderQuantity = bookQuantities.get(i);
            totalCost += orderBook.getPrice() * orderQuantity;
            
            int stockQuantity = from.getQuantityOf(orderBook.getName());

            if (stockQuantity == 0 || stockQuantity < orderQuantity) {
                System.err.println("There is not enough " + orderBook.getName() + " in stock for purchase");
                return false;
            }
        }
        if (totalCost > user.credit) {
            System.err.println("User does not have enough credit for purchase");
            return false;
        }
        user.credit -= totalCost;

        // Remove from stock
        for (int i = 0; i < books.size(); i++) {
            Book orderBook = books.get(i);
            Integer orderQuantity = bookQuantities.get(i);

            int newQuantity = from.getQuantityOf(orderBook.getName()) - orderQuantity;

            from.setQuantity(orderBook.getName(), newQuantity);
        }

        return true;
    }

    public boolean buy(Account user, OtherStock from) {
        double totalCost = 0;

        for (int i = 0; i < products.size(); i++) {
            Product orderProduct = products.get(i);
            Integer orderQuantity = productQuantities.get(i);
            totalCost += orderProduct.getPrice() * orderQuantity;
            
            int stockQuantity = from.getQuantityOf(orderProduct.getName());

            if (stockQuantity == 0 || stockQuantity < orderQuantity) {
                System.err.println("There is not enough " + orderProduct.getName() + " in stock for purchase");
                return false;
            }
        }
        if (totalCost > user.credit) {
            System.err.println("User does not have enough credit for purchase");
            return false;
        }
        user.credit -= totalCost;

        // Remove from stock
        for (int i = 0; i < products.size(); i++) {
            Product orderProduct = products.get(i);
            Integer orderQuantity = productQuantities.get(i);

            int newQuantity = from.getQuantityOf(orderProduct.getName()) - orderQuantity;

            from.setQuantity(orderProduct.getName(), newQuantity);
        }

        return true;
    }

    public List<TableRowModel> toTableRows() {
        List<TableRowModel> result = new ArrayList<>(books.size() + products.size());

        for (int i = 0; i < books.size(); i++) {
            Book book = books.get(i);
            Integer quantity = bookQuantities.get(i);
            result.add(new TableRowModel(book.getName(), book.getPrice() + "", quantity + ""));
        }
        for (int i = 0; i < products.size(); i++) {
            Product product = products.get(i);
            Integer quantity = productQuantities.get(i);
            result.add(new TableRowModel(product.getName(), product.getPrice() + "", quantity + ""));
        }

        return result;
    }
}
