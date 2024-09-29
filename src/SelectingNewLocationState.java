import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Optional;

public class SelectingNewLocationState  implements GameState {
  public void paint(Graphics g, Point mouseLoc, Stage s) {
  }

  public void mouseClicked(int x, int y, Stage s) {
    Optional<Cell> clicked = Optional.empty();
    for(Cell c: s.cellOverlay) {
      if(c.contains(x, y)) {
        clicked = Optional.of(c);
      }
    }
    s.cellOverlay = new ArrayList<Cell>();
    if(clicked.isPresent() && s.actorInAction.isPresent()) {
      s.actorInAction.get().setLocation(clicked.get());
      s.actorInAction.get().turns--;
      int humansWithMovesLeft = 0;
      for(Actor a: s.actors) {
        if(a.isHuman() && a.turns > 0) {
          humansWithMovesLeft++;
        }
      }
      if(humansWithMovesLeft > 0) {
        s.currentState = new ChoosingActorState();
      } else {
        s.currentState = new BotMovingState();
      }
    }
  }

  public String toString() {
    return "SelectingNewLocation";
  }
}
