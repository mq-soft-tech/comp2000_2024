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
      Point lastposition = null;
  
      public Canvas() {
          setPreferredSize(new Dimension(720, 720));
      }
  
      @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            Point currentposition = getMousePosition();
          if (currentposition != null) {
            if (lastposition == null || lastposition.equals(currentposition)) {
                trail.add_position(currentposition);
                   lastposition = currentposition;
     }
    }

          
          grid.paint(g, currentposition);
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