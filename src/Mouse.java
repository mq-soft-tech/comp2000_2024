import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.LinkedList;
import javax.swing.JFrame;



public class Mouse extends JFrame {
    int size = 10;
    Point curMousePos = null;
    LinkedList<Point> prevMousePos;

    public Mouse(){
        prevMousePos = new LinkedList<>();
    }
    
    public void paint(Graphics g, Point mousePos) {
      if(mousePos != null ){
        curMousePos = mousePos;
        prevMousePos.addFirst(new Point(mousePos.x, mousePos.y));
        //System.out.println(mousePos);
        //System.out.println(prevMousePos.get(0));
        if (prevMousePos.size() > 100){
            prevMousePos.removeLast();
        }

        }
        g.setColor(new Color(0,0,0,30));
        for(int i = 0; i<prevMousePos.size();i++){
            Point pos = prevMousePos.get(i);

            g.fillOval(pos.x, pos.y, size, size);
        } 

    }
    

}
//&& !mousePos.equals(curMousePos)