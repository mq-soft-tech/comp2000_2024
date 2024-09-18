package student;

public class Product implements ItemInterface {
    public String name;
    public String description;
    public double price;

    public Product(String n, String desc, double p) {
        name = n;
        description = desc;
        price = p;
    }

    public String tableName() {
        return name;
    }

    public String tableInfo() {
        return description;
    }

    @Override
    public String getName() {
        return name;
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
        return false;
    }

    @Override
    public double getPrice() {
        return price;
    }

}
