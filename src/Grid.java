import java.awt.Graphics;
import java.awt.Point;

public class Grid {
  // fields-made up of cells.
  Cell[][] cells = new Cell[20][20];
  
  // constructors
  public Grid() { //default constructor.
    for(int i=0; i<cells.length; i++) {
      for(int j=0; j<cells[i].length; j++) {
        cells[i][j] = new Cell(10+Cell.size*i, 10+Cell.size*j);//margin is 10
      }
    }
  }
  // methods
  public void paint(Graphics g, Point mousePos) {  //expecting a point as well
    for(int i=0; i<cells.length; i++) {
      for(int j=0; j<cells[i].length; j++) {
        cells[i][j].paint(g, mousePos); //the way the cell draws itself is changed.
      }
    }
  }
}
