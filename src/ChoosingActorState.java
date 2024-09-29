import java.awt.Graphics;
import java.awt.Point;
import java.util.Optional;

public class ChoosingActorState extends StateCommon {
  public ChoosingActorState(Stage s) {
    super(s);
    stateName = "ChoosingActor";
  }

  public void paint(Graphics g, Point mouseLoc) {
  }

  public void mouseClicked(int x, int y) {
    stage.actorInAction = Optional.empty();
    for(Actor a: stage.actors) {
      if(a.loc.contains(x, y) && a.isHuman()) {
        stage.cellOverlay = stage.grid.getRadius(a.loc, a.moves);
        stage.actorInAction = Optional.of(a);
        stage.currentState = new SelectingNewLocationState(stage);
      }
    }
  }
}
