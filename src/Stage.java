import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Stage {
  Grid grid;
  List<Actor> actors;
  List<Cell> cellOverlay;
  Optional<Actor> actorInAction;

  GameState currentState;

  public Stage() {
    grid = new Grid();
    actors = new ArrayList<Actor>();
    cellOverlay = new ArrayList<Cell>();
    actorInAction = Optional.empty();
    currentState = new ChoosingActorState();
  }

  public void paint(Graphics g, Point mouseLoc) {
    currentState.paint(g, mouseLoc, this);
    grid.paint(g, mouseLoc);
    grid.paintOverlay(g, cellOverlay, new Color(0f, 0f, 1f, 0.5f));
    for(Actor a: actors) {
      a.paint(g);
    }

    // where to draw text in the information area
    final int hTab = 10;
    final int blockVT = 35;
    final int margin = 21*blockVT;
    int yLoc = 20;

    // state display
    g.setColor(Color.DARK_GRAY);
    g.drawString(currentState.toString(), margin, yLoc);
    yLoc = yLoc + blockVT;
    Optional<Cell> underMouse = grid.cellAtPoint(mouseLoc);
    if(underMouse.isPresent()) {
      Cell hoverCell = underMouse.get();
      g.setColor(Color.DARK_GRAY);
      String coord = String.valueOf(hoverCell.col) + String.valueOf(hoverCell.row);
      g.drawString(coord, margin, yLoc);
    }

    // agent display
    final int vTab = 15;
    final int labelIndent = margin + hTab;
    final int valueIndent = margin + 3*blockVT;
    yLoc = yLoc + 2*blockVT;
    for(int i = 0; i < actors.size(); i++){
      Actor a = actors.get(i);
      yLoc = yLoc + 2*blockVT;
      g.drawString(a.getClass().toString(), margin, yLoc);
      g.drawString("location:", labelIndent, yLoc+vTab);
      g.drawString(Character.toString(a.loc.col) + Integer.toString(a.loc.row), valueIndent, yLoc+vTab);
      g.drawString("artificiality:", labelIndent, yLoc+2*vTab);
      g.drawString(a.isHuman() ? "Human" : "Bot", valueIndent, yLoc+2*vTab);
      g.drawString("strategy:", labelIndent, yLoc+3*vTab);
      g.drawString(a.strat.toString(), valueIndent, yLoc+3*vTab);
    }    
  }

  public List<Cell> getClearRadius(Cell from, int size) {
    List<Cell> init = grid.getRadius(from, size);
    for(Actor a: actors) {
      init.remove(a.loc);
    }
    return init;
  }

  public void mouseClicked(int x, int y) {
    currentState.mouseClicked(x, y, this);
  }
}
