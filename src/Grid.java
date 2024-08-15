
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Color;
import java.util.ArrayList;

public class Grid {

    Cell[][] cells = new Cell[20][20];
    ArrayList<Point> mouseTrail = new ArrayList<>();
    int maxTrailSize = 100;

    public Grid() {
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                cells[i][j] = new Cell(10 + Cell.size * i, 10 + Cell.size * j);
            }
        }
    }

    public void paint(Graphics g, Point mousePos) {

        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                cells[i][j].paint(g, mousePos);
            }
        }

        if (mousePos != null && isMouseInsideGrid(mousePos)) {

            mouseTrail.add(mousePos);

            if (mouseTrail.size() > maxTrailSize) {
                mouseTrail.remove(0);
            }
        }

        g.setColor(new Color(169, 169, 169, 70));
        for (Point p : mouseTrail) {
            g.fillOval(p.x - 5, p.y - 5, 10, 10);
        }
    }

    private boolean isMouseInsideGrid(Point p) {
        for (Cell[] row : cells) {
            for (Cell cell : row) {
                if (cell.haspoint(p)) {
                    return true;
                }
            }
        }
        return false;
    }
}