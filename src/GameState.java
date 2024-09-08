import java.awt.Graphics;
import java.awt.Point;

public interface GameState {
  public void paint(Graphics g, Point mouseLoc);
  public void mouseClicked(int x, int y);
}
