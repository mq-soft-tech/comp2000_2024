import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class Grid {
  Cell[][] cells = new Cell[20][20];
  List<actor> actors = new ArrayList<>();

  public Grid() {
    for (int i = 0; i < cells.length; i++) {
      for (int j = 0; j < cells[i].length; j++) {
        cells[i][j] = new Cell(10 + Cell.size * i, 10 + Cell.size * j);
      }
    }
    // Add actors to the grid at specific locations
    actors.add(new cat(cells[7][7]));
    actors.add(new Dog(cells[5][5]));
    actors.add(new Bird(cells[6][6]));
  }

  public void paint(Graphics g, Point mousePos) {
    for (int i = 0; i < cells.length; i++) {
      for (int j = 0; j < cells[i].length; j++) {
        cells[i][j].paint(g, mousePos);
      }
    }
    for (actor actor : actors) {
      actor.paint(g);
    }
  }
}
