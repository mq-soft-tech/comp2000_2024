import java.awt.Graphics;
import java.awt.Color;

public class Bird extends actor {
    public Bird(Cell cell) {
      super(cell);
    }
  
    @Override
    public void paint(Graphics g) {
      g.setColor(Color.GREEN);
      g.fillRect(cell.x, cell.y, cell.width, cell.height);
      g.setColor(Color.BLACK);
      g.drawRect(cell.x, cell.y, cell.width, cell.height);
    }
  }
