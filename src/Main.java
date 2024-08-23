import java.awt.Dimension;
import java.awt.Graphics;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main extends JFrame {
    public static void main(String[] args) throws Exception {
      Main window = new Main();
      window.run();
    }

    class Canvas extends JPanel {
      Stage stage;
      public Canvas() {
        setPreferredSize(new Dimension(720, 720));
        try {
          stage = StageReader.readStage("data/stage11.rvb");
        } catch (IOException e) {
          stage = new Stage();
          stage.actors.add(new Cat(stage.grid.cellAtColRow(0, 0)));
          stage.actors.add(new Dog(stage.grid.cellAtColRow(0, 15)));
          stage.actors.add(new Bird(stage.grid.cellAtColRow(12, 9)));
        }
      }

      @Override
      public void paint(Graphics g) {
        stage.paint(g, getMousePosition());
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
