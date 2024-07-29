import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class Cell {
    int x, y;
    int size = 35;

    public Cell(int x, int y, Graphics g, Point p) {
        if (p!=null && (p.x - 10) / size == x && (p.y - 10) / size == y )
            g.setColor(Color.GREEN);
        else    
            g.setColor(Color.WHITE);    
        g.fillRect(x * size + 10, y * size + 10, size, size);
        g.setColor(Color.BLACK);
        g.drawRect(x * size + 10, y * size + 10, size, size);
    }

}
