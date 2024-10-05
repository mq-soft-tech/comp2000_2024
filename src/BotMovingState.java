import java.awt.Graphics;
import java.awt.Point;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BotMovingState extends StateCommon {
  public BotMovingState(Stage s) {
    super(s);
    stateName = "BotMoving";
  }

  public void paint(Graphics g, Point mouseLocs) {
    // do we have AI moves to make?
    for(Actor a: stage.actors) {
      if(!a.isHuman()) {
        List<Cell> possibleLocs = getClearRadius(a.loc, a.moves);
        Cell nextLoc = a.strat.chooseNextLoc(possibleLocs);
        a.setLocation(nextLoc);
      }
    }
    stage.currentState = new ChoosingActorState(stage);
    for(Actor a: stage.actors) {
      a.turns = 1;
    }
  }

  public List<Cell> getClearRadius(Cell from, int size) {
    // task 20
    // create a Set of Actor locations that can be filtered out
    final Set<Cell> actorLocs = new HashSet<Cell>(
      stage.actors.stream().map(a -> a.loc).collect(Collectors.toSet())
    );
    // un-comment the following lines and complete them
    Stream<Cell> init = stage.grid.getRadius(from, size).stream();
    Stream<Cell> clear = init.filter(c -> ! actorLocs.contains(c));
    return clear.collect(Collectors.toList());
  }

  public void mouseClicked(int x, int y) {
    // should never happen
    System.out.println(stage.currentState);
  }
}
