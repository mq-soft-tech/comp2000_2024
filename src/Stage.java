import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class Stage {
  Grid grid;
  List<Actor> actors;

  public Stage() {
    grid = new Grid();
    actors = new ArrayList<Actor>();
    actors.add(new Cat(grid.cellAtColRow(0, 0)));
    actors.add(new Dog(grid.cellAtColRow(0, 15)));
    actors.add(new Bird(grid.cellAtColRow(12, 9)));
  }

  public void paint(Graphics g, Point mouseLoc) {
    grid.paint(g, mouseLoc);
    for(Actor a: actors) {
      a.paint(g);
    }
  }
}
