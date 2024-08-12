import java.awt.Graphics;
import java.awt.MouseInfo;
import java.awt.Color;
import java.awt.Point;
import java.awt.event.*;


public class Pointer {
    Color color;

    public void paint (Graphics g) {
    g.setColor(Color.RED);
    g.fillOval(MouseInfo.getPointerInfo().getLocation().x, MouseInfo.getPointerInfo().getLocation().y, 10, 10);
    g.setColor(Color.RED);
    g.drawOval(MouseInfo.getPointerInfo().getLocation().x, MouseInfo.getPointerInfo().getLocation().y, 10, 10);
    }

}
