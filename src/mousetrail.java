import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;

public class mousetrail {

    public ArrayList<Point> position = new ArrayList<>();
    public static final int length_off_trail= 100;


public void add_position(Point p){
    if (p != null){
        position.add(p);
    }
    if(position.size()>length_off_trail){
        position.remove(0);
    }
}
    public void paint (Graphics g){
        int circle = 255;
        int step =255/ length_off_trail;

        for (int i = 0; i < position.size(); i++) {
            Point p = position.get(i);
            Color circlecolor = Color.GRAY;
            g.fillOval(p.x - 10, p.y - 10, 20, 20); 
            circle -= step;
    }
}
}