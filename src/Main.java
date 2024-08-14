import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;


public class Main extends JFrame{
    public static void main(String[] args) throws Exception {
      Main window = new Main();
      window.run();
    }

    class Canvas extends JPanel implements MouseMotionListener {
      Grid grid = new Grid();
      mousetrail trail = new mousetrail();
  
      public Canvas() {
          setPreferredSize(new Dimension(720, 720));
          addMouseMotionListener(this);
      }
  
      @Override
      public void paint(Graphics g) {
          super.paint(g);
          grid.paint(g, getMousePosition());
          trail.paint(g);
      }

      @Override
      public void mouseMoved(MouseEvent e) {
          trail.add_position(e.getPoint());
          repaint();
      }

      @Override
      public void mouseDragged(MouseEvent e) {
          trail.add_position(e.getPoint());
          repaint();
      }
  }

    private Main() {
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      Canvas canvas = new Canvas();
      this.setContentPane(canvas);
      this.pack();
      this.setVisible(true);
    }

    public void run() {
      while(true) {
        repaint();
      }
    }
}