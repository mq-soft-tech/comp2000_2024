import java.awt.Graphics;
import java.awt.Point;

public abstract class StateCommon implements GameState {
  protected Stage stage;
  protected String stateName;

  public StateCommon(Stage s) {
    stage = s;
  }

  public void paint(Graphics g, Point mouseLoc) {

  }

  public void mouseClicked(int x, int y) {
  }

  public String toString() {
    return stateName;
  }
}
