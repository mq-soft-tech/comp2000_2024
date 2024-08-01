import javax.swing.*;
import java.awt.*;

public class Main extends JFrame{

    public static void main(String[] args) throws Exception {
        Main window = new Main();
    }

    class Canvas extends JPanel {
        public Canvas(){
            setPreferredSize(new Dimension(720,720));
        }
    }
    private Main() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Canvas canvas = new Canvas();
        this.setContentPane(canvas);
        this.pack();
        this.setVisible(b:true);
    }
}