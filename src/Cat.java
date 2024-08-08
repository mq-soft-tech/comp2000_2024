import java.awt.Color;
import java.awt.Graphics;

public class Cat extends actor {
  public Cat(Cell cell) {
    super(cell);
  }

  @Override
  public void paint(Graphics g) {
    g.setColor(Color.BLUE);
    g.fillRect(cell.x, cell.y, cell.width, cell.height);
    g.setColor(Color.BLACK);
    g.drawRect(cell.x, cell.y, cell.width, cell.height);
  }
}

