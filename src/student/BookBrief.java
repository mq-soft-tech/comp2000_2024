package student;

public class BookBrief implements ItemInterface {
    public String title;
    public String dataPath;

    public BookBrief(String t, String path) {
        title = t;
        dataPath = path;
    }

    @Override
    public String getName() {
        return title;
    }

    @Override
    public String getDescription() {
        return "";
    }

    @Override
    public String getDataPath() {
        return dataPath;
    }

    @Override
    public boolean isBook() {
        return true;
    }

    @Override
    public double getPrice() {
        return 0;
    }
    
}
