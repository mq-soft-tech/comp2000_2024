import javax.swing.*;
import java.awt.*;

public class Main
        extends JFrame {

    public static void main(String[] args) throws Exception {
        Main window = new Main();
        window.run();
    }

    class Canvas extends JPanel {
        public Canvas() {
            setPreferredSize(new Dimension(720, 720));
        }

        @Override
            public void paint(Graphics g) {
            Point p = getMousePosition();
            System.out.println(p);
            Grid grid = new Grid(g, p);
            }
    }

    private Main() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Canvas canvas = new Canvas();
        this.setContentPane(canvas);
        this.pack();
        this.setVisible(true);
    }
    public void run(){
        while(true)
            this.repaint();
    }
}