import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Main extends JFrame {
    private GridPanel gridPanel;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Main frame = new Main();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }

    public Main() {
        gridPanel = new GridPanel(20, 20, 35);
        DrawingCanvas canvas = new DrawingCanvas();
        this.setContentPane(canvas);
        this.pack();
    }

    class DrawingCanvas extends JPanel {
        public DrawingCanvas() {
            setPreferredSize(new Dimension(720, 720));
            addMouseMotionListener(new MouseAdapter() {
             
                public void mouseMoved(MouseEvent e) {
                    Point p = e.getPoint();
                    gridPanel.updateHighlight(p.x, p.y);
                    repaint(); 
                }
            });
        }

        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            gridPanel.drawGrid(g);
        }
    }

    class GridPanel {
        private GridCell[][] gridCells;
        private int numRows, numCols, cellDimension;
        private int marginX = 10, marginY = 10;
        private int highlightedRow = -1, highlightedCol = -1;

        public GridPanel(int rows, int cols, int cellSize) {
            this.numRows = rows;
            this.numCols = cols;
            this.cellDimension = cellSize;
            gridCells = new GridCell[rows][cols];
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    gridCells[i][j] = new GridCell(i, j, cellSize);
                }
            }
        }

        public void drawGrid(Graphics g) {
            for (int i = 0; i < numRows; i++) {
                for (int j = 0; j < numCols; j++) {
                    boolean isHighlighted = (i == highlightedRow && j == highlightedCol);
                    gridCells[i][j].render(g, marginX, marginY, isHighlighted);
                }
            }
        }

        public void updateHighlight(int mouseX, int mouseY) {
            int row = (mouseY - marginY) / cellDimension;
            int col = (mouseX - marginX) / cellDimension;
            
         
            if (row >= 0 && row < numRows && col >= 0 && col < numCols) {
                highlightedRow = row;
                highlightedCol = col;
            } else {
                highlightedRow = -1;
                highlightedCol = -1;
            }
        }
    }

    class GridCell {
        private int rowIndex, colIndex, size;

        public GridCell(int row, int col, int size) {
            this.rowIndex = row;
            this.colIndex = col;
            this.size = size;
        }

        public void render(Graphics g, int marginX, int marginY, boolean isHighlighted) {
            int x = marginX + colIndex * size;
            int y = marginY + rowIndex * size;
            if (isHighlighted) {
                g.setColor(Color.GRAY);
                g.fillRect(x, y, size, size); 
            } else {
                g.setColor(Color.BLACK);
            }
            g.drawRect(x, y, size, size);
        }
    }
}