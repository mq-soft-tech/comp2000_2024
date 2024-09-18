package student;

public class Book implements ItemInterface {
    String title;
    String description;
    double price;

    public Book(String t, String desc, double p) {
        title = t;
        description = desc;
        price = p;
    }

    @Override
    public String getName() {
        return title;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public String getDataPath() {
        return "";
    }

    @Override
    public boolean isBook() {
        return true;
    }

    public double getPrice() {
        return price;
    }

}
