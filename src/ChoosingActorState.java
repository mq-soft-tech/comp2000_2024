import java.awt.Graphics;
import java.awt.Point;
import java.util.Optional;

public class ChoosingActorState implements GameState {
  public void paint(Graphics g, Point mouseLoc, Stage s) {
  }

  public void mouseClicked(int x, int y, Stage s) {
    s.actorInAction = Optional.empty();
    for(Actor a: s.actors) {
      if(a.loc.contains(x, y) && a.isHuman()) {
        s.cellOverlay = s.grid.getRadius(a.loc, a.moves);
        s.actorInAction = Optional.of(a);
        s.currentState = new SelectingNewLocationState();
      }
    }
  }

  public String toString() {
    return "ChoosingActor";
  }
}
