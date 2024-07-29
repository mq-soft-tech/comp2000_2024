import java.awt.*;

public class Grid {
    Cell[][] cells = new Cell[20][20];

    public Grid(Graphics g, Point p) {
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                cells[i][j] = new Cell(i, j, g, p);
            }
        }
    }
}
