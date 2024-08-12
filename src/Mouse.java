import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.LinkedList;
import javax.swing.JFrame;



public class Mouse extends JFrame {
    int x;
    int y;
    int size = 10;
    Point curMousePos = getMousePosition();
    LinkedList<Point> prevMousePos;

    public Mouse(){
        prevMousePos = new LinkedList<>();
    }
    
    public void paint(Graphics g, Point mousePos) {
      if(mousePos != null){
        prevMousePos.addFirst(new Point(mousePos.x, mousePos.y));
        if(mousePos != prevMousePos.getFirst()){
            System.out.println(prevMousePos.getFirst());
            if (prevMousePos.size() > 100){
                prevMousePos.removeLast();
            }
            for(int i = 0; i<prevMousePos.size();i++){
                Point pos = prevMousePos.get(i);
                g.setColor(Color.BLACK);
                g.fillOval(pos.x, pos.y, size, size);
                g.setColor(Color.BLACK);
                g.drawOval(pos.x,pos.y,size,size);
            } 
        }

    }
    }

}
 //&& mousePos != curMousePos