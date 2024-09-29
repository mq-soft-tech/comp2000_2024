import java.awt.Graphics;
import java.awt.Point;

// Alternative solution to Task 17b - extra parameter "Stage s" removed from both methods
public interface GameState {
  public void paint(Graphics g, Point mouseLoc);
  public void mouseClicked(int x, int y);
}
