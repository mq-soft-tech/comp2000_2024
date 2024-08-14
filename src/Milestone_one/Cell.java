import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

public class Cell extends Rectangle {

    static int size = 35;

    public Cell(int inX, int inY) {
        super(inX, inY, size, size);
    }

    public void paint(Graphics g, Point mousePos) {
        if (haspoint(mousePos)) {
            g.setColor(Color.GRAY);
        } else {
            g.setColor(Color.WHITE);
        }
        g.fillRect(x, y, size, size);
        g.setColor(Color.BLACK);
        g.drawRect(x, y, size, size);
    }

    public boolean haspoint(Point p) {
        if (p != null) {
            return contains(p);
        } else {
            return false;
        }
    }
    }


