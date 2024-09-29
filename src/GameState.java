import java.awt.Graphics;
import java.awt.Point;

// Naive solution to Task 17b - extra parameter "Stage s" added to both methods
public interface GameState {
  public void paint(Graphics g, Point mouseLoc, Stage s);
  public void mouseClicked(int x, int y, Stage s);
}
