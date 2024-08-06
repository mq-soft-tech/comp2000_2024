import java.awt.Color;
import java.awt.Graphics;

public class Cell {

    int xPosition;
    int yPosition;
    int cellSize;

    //class constructor
    Cell(int x, int y, int size)
    {
        xPosition = x;
        yPosition = y;

        cellSize = size;
    }

    void paint(Graphics g)
    {
        g.setColor(Color.WHITE);
        g.fillRect(xPosition, yPosition, cellSize, cellSize);
        g.setColor(Color.BLACK);
        g.drawRect(xPosition, yPosition, cellSize, cellSize);
    }
}