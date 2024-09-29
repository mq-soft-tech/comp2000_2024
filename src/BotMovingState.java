import java.awt.Graphics;
import java.awt.Point;
import java.util.List;

public class BotMovingState  implements GameState {
  public void paint(Graphics g, Point mouseLoc, Stage s) {
    // do we have AI moves to make?
    for(Actor a: s.actors) {
      if(!a.isHuman()) {
        List<Cell> possibleLocs = s.getClearRadius(a.loc, a.moves);
        Cell nextLoc = a.strat.chooseNextLoc(possibleLocs);
        a.setLocation(nextLoc);
      }
    }
    s.currentState = new ChoosingActorState();
    for(Actor a: s.actors) {
      a.turns = 1;
    }
  }

  public void mouseClicked(int x, int y, Stage s) {
    // should never happen
    System.out.println(s.currentState);
  }

  public String toString() {
    return "BotMoving";
  }
}
