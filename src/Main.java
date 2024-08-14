import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main extends JFrame {
  private static final int DELAY = 5; 

  public static void main(String[] args) {
    Main window = new Main();
    window.run();
  }

  class Canvas extends JPanel {
    Grid grid = new Grid();

    public Canvas() {
      setPreferredSize(new Dimension(720, 720));
    }

    @Override
    public void paint(Graphics g) {
      grid.paint(g, getMousePosition());
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
    long lastUpdate = System.currentTimeMillis();
    while (true) {
      long now = System.currentTimeMillis();
      if (now - lastUpdate >= DELAY) {
        repaint();
        lastUpdate = now;
      }
      try {
        Thread.sleep(8); 
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}
