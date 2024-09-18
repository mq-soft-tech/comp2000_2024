package student;

import java.io.File;
import java.util.Scanner;

public class DataReader {

    static Scanner scannerFor(String path) throws Exception {
        File file = new File(path);
        Scanner scanner = null;
        scanner = new Scanner(file);
        return scanner;
    }

    public static ItemInterface read(String path) throws Exception {
        Scanner scanner = scannerFor(path);
        String firstLine = scanner.nextLine();
        scanner.nextLine();  // - name

        if (firstLine.contains("book")) {          // DO NOT MODIFY
            String title = scanner.nextLine();       // DO NOT MODIFY
            scanner.nextLine();  // - author            DO NOT MODIFY
            String author = scanner.nextLine();      // DO NOT MODIFY
            scanner.nextLine();  // - edition           DO NOT MODIFY
            String editionStr = scanner.nextLine();  // DO NOT MODIFY
            scanner.nextLine();  // - numPages          DO NOT MODIFY
            String numPagesStr = scanner.nextLine(); // DO NOT MODIFY
            scanner.nextLine();  // - description       DO NOT MODIFY
            String description = scanner.nextLine(); // DO NOT MODIFY
            scanner.nextLine();  // - price             DO NOT MODIFY
            String priceStr = scanner.nextLine();    // DO NOT MODIFY

            int edition = Integer.valueOf(editionStr);
            int numPages = Integer.valueOf(numPagesStr);
            double price = Double.valueOf(priceStr);
            
            return readBook(title, author, edition, numPages, description, price);
        } else {
            String name = scanner.nextLine();         // DO NOT MODIFY
            scanner.nextLine();  // - name               DO NOT MODIFY
            String description = scanner.nextLine();  // DO NOT MODIFY
            scanner.nextLine();  // - price              DO NOT MODIFY
            String priceStr = scanner.nextLine();     // DO NOT MODIFY

            double price = Double.valueOf(priceStr);

            return new Product(name, description, price);
        }
    }

    private static Book readBook(String title, String author, int edition, int nPages, String desc, double price) {
        String description = "Author: " + author + " | Edition: " + edition;
        description += " | Number of pages: " + nPages;
        description += " | Product description: " + desc;
        return new Book(title, description, price);
    }
}
