import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Point;


public class Main extends JFrame {
    public static void main(String[] args) throws Exception {
      Main window = new Main();
      window.run();
    }

    class Canvas extends JPanel {
      Grid grid = new Grid();
      mousetrail trail = new mousetrail();
      
  
      public Canvas() {
          setPreferredSize(new Dimension(720, 720));
      }
  
      @Override
      public void paint(Graphics g) {
          Point mousePos = getMousePosition();
          trail.add_position(mousePos);
          
          grid.paint(g, mousePos);
          trail.paint(g); 
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