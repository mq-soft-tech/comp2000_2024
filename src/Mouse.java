import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class Mouse extends JFrame {

    int x;
    int y;
    int size = 35;
    Point curMousePos = getMousePosition();

    public Mouse(){

    }
    
    public void paint(Graphics g, Point mousePos) {
      System.out.println("test");
        if(mousePos != null && mousePos != curMousePos){
            g.setColor(Color.BLACK);
            g.fillOval(mousePos.x, mousePos.y, size, size);
            g.setColor(Color.BLACK);
            g.drawOval(mousePos.x,mousePos.y,size,size);
            curMousePos = mousePos;
        }
        System.out.println(getMousePosition());
    }

}