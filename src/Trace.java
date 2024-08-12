import java.awt.*;
import java.awt.event.*;

public class Trace {
    Pointer pointer = new Mouser();
    Grid grid = new Grid();

    public void paint (Graphics g, Point p) {
        g.setColor(Color.RED);
        g.fillOval(MouseInfo.getPointerInfo().getLocation().x, MouseInfo.getPointerInfo().getLocation().y, 10, 10);
        g.setColor(Color.RED);
        g.drawOval(MouseInfo.getPointerInfo().getLocation().x, MouseInfo.getPointerInfo().getLocation().y, 10, 10);
    }
}
