import java.awt.*;

public abstract class Actor {
    Color me;
    Cell cell;
    public void paint(Graphics g){
        g.setColor(me);
        g.fillRect(cell.x+2, cell.y+2 , cell.width-4, cell.height-4);
        g.drawRect(cell.x+2, cell.y+2 , cell.width-4, cell.height-4);
    }

    
}
