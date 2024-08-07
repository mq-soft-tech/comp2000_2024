import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.*;

public class Cell extends Rectangle{
  // fields

  static int size = 35;

  // constructors
  public Cell(int inX, int inY) {
    super(inX, inY, size,size);
  }

  // methods
  public void paint(Graphics g, Point mousePos) {
    if(contains(mousePos)) {
      g.setColor(Color.GRAY);
    } else {
      g.setColor(Color.WHITE);
    }
    g.fillRect(x, y, size, size);
    g.setColor(Color.BLACK);
    g.drawRect(x, y, size, size);
  }

  public boolean contains(Point p) {
    if(p != null) {
      return super.contains(p);
    } else {
      return false;
    }
  }
}
