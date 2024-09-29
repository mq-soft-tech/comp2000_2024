import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Optional;

public class SelectingNewLocationState extends StateCommon {
  public SelectingNewLocationState(Stage s) {
    super(s);
    stateName = "SelectingLocation";
  }

  public void paint(Graphics g, Point mouseLoc) {
  }

  public void mouseClicked(int x, int y) {
    Optional<Cell> clicked = Optional.empty();
    for(Cell c: stage.cellOverlay) {
      if(c.contains(x, y)) {
        clicked = Optional.of(c);
      }
    }
    stage.cellOverlay = new ArrayList<Cell>();
    if(clicked.isPresent() && stage.actorInAction.isPresent()) {
      stage.actorInAction.get().setLocation(clicked.get());
      stage.actorInAction.get().turns--;
      int humansWithMovesLeft = 0;
      for(Actor a: stage.actors) {
        if(a.isHuman() && a.turns > 0) {
          humansWithMovesLeft++;
        }
      }
      if(humansWithMovesLeft > 0) {
        stage.currentState = new ChoosingActorState(stage);
      } else {
        stage.currentState = new BotMovingState(stage);
      }
    }
  }
}
