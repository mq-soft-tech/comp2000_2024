import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {

    public static void main(String[] args) throws Exception {
        Main window = new Main();
    }

    private  int numRows = 20;
    private  int numCols = 20;
    private  int cellSize = 35;
    private  int padding = 10;
    private Grid grid;

    public Main() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        grid = new Grid(numRows, numCols, cellSize, padding);
        this.setContentPane(grid);
        this.pack();
        this.setVisible(true);
    }
}

class Grid extends JPanel {

    private  int numRows;
    private  int numCols;
    private  int cellSize;
    private  Cell[][] cells; 

    public Grid(int numRows, int numCols, int cellSize, int padding) {
        this.numRows = numRows;
        this.numCols = numCols;
        this.cellSize = cellSize;
        this.cells = new Cell[numRows][numCols];

     
        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                int x = padding + col * cellSize;
                int y = padding + row * cellSize;
                cells[row][col] = new Cell(x, y, cellSize);
            }
        }

       
        setPreferredSize(new Dimension(padding + numCols * cellSize, padding + numRows * cellSize));
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g); 
        for (Cell[] row : cells) {
            for (Cell cell : row) {
                cell.paint(g);
            }
        }
    }
}

class Cell {

    private final int x;
    private final int y;
    private final int size;
    private Color color; 

    public Cell(int x, int y, int size) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.color = Color.BLACK; 
    }

    public void paint(Graphics g) {
        g.setColor(color);
        g.drawRect(x, y, size, size);
    }
}
