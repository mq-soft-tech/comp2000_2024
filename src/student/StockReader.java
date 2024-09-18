package student;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StockReader {

    public static App read(String stockFilePath) throws Exception {
        File file = new File(stockFilePath);
        Scanner scanner = null;
        scanner = new Scanner(file);

        List<BookBrief> bookBriefs = new ArrayList<>();
        List<Integer> bookQtys = new ArrayList<>();
        List<ProductBrief> otherBriefs = new ArrayList<>();
        List<Integer> otherQtys = new ArrayList<>();

        String line = "";
        while (scanner.hasNextLine()) {              // DO NOT MODIFY
            line = scanner.nextLine();               // DO NOT MODIFY
            String[] parts = line.split(",");  // DO NOT MODIFY
            if (parts.length == 3 && parts[1].contains("book")) {
                bookBriefs.add(new BookBrief(parts[0], parts[1]));
                bookQtys.add(Integer.valueOf(parts[2]));
            }
            if (parts.length == 3 && !parts[1].contains("book")) {
                otherBriefs.add(new ProductBrief(parts[0], parts[1]));
                otherQtys.add(Integer.valueOf(parts[2]));
            }
        }
        scanner.close();

        BookStock bookStart = new BookStock(bookBriefs, bookQtys);
        OtherStock otherStart = new OtherStock(otherBriefs, otherQtys);

        return new App(bookStart, otherStart);

    }
}
