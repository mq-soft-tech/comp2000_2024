import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class Cell {
  // fields for locations
  int x;
  int y;
  static int size = 35; //global variable (static so it can't be modified)- changing magic varible 35.

  // constructors
  public Cell(int inX, int inY) {
    x = inX;
    y = inY;
  }

  // methods
  public void paint(Graphics g, Point mousePos) { //paint method of cell is updated with expected parameter mousePos
    if(contains(mousePos)) {
      g.setColor(Color.GRAY);
    } else {
      g.setColor(Color.WHITE);
    }
    g.fillRect(x, y, size, size);
    g.setColor(Color.BLACK);
    g.drawRect(x, y, size, size);
  }

  public boolean contains(Point p) { //simple method for checking if mouse is positioned in a cell by referencing Point's x and y.
    if(p != null) {
      return x < p.x && x+size > p.x && y < p.y && y+size > p.y;
    } else {
      return false;
    }
  }
}
