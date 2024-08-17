import java.awt.Color;
import java.awt.Graphics;

public class Dog extends actor {
  public Dog(Cell cell) {
    super(cell);
  }

  @Override
  public void paint(Graphics g) {
    g.setColor(Color.YELLOW);
    g.fillRect(cell.x, cell.y, cell.width, cell.height);
    g.setColor(Color.BLACK);
    g.drawRect(cell.x, cell.y, cell.width, cell.height);
  }
}

