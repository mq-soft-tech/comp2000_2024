import java.awt.*;


public class Stage {
    Grid gridd;
    Actor dogg;
    Actor birdd;
    Actor catt;

    public Stage(){
        gridd = new Grid();
        dogg = new Dog(gridd.cells[5][3]);
        catt = new Cat(gridd.cells[7][5]);
        birdd = new Bird(gridd.cells[4][6]);
    }

    public void paint(Graphics g, Point p){
        gridd.paint(g, p);
        dogg.paint(g);
        catt.paint(g);
        birdd.paint(g);
    }
}
