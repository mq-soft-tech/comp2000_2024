import java.awt.Color;
import java.awt.Graphics;

public abstract class actor {
  protected Cell cell;

  public actor(Cell cell) {
    this.cell = cell;
  }

  public abstract void paint(Graphics g);
}
