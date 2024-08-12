import java.awt.Graphics;
import java.awt.Point;
import java.awt.Color;
import java.awt.*;

public class Stage {
  Grid grid;
  Actor cat;
  Actor dog;
  Actor bird;
  Mouser mouser;
  MouserArray mouserArray;

  public Stage() {
    grid = new Grid();
    cat = new Cat(grid.cellAtColRow(0, 0));
    dog = new Dog(grid.cellAtColRow(0, 15));
    bird = new Bird(grid.cellAtColRow(12, 9));
    mouser = new Mouser();
    mouserArray = new MouserArray();
  }

  public void paint(Graphics g, Point mouseLoc) {
    grid.paint(g, mouseLoc);
    cat.paint(g);
    dog.paint(g);
    bird.paint(g);
    mouser.paint(g);
  }
}
