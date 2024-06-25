import javax.swing.*;
import java.awt.*;

public class BoardDisplay extends JPanel {
    private final int TILE_SIZE = 30; // Size of each tile
    private final Board board; // Your board data

    public BoardDisplay(Board board) {
        this.board = board;
        setPreferredSize(new Dimension(board.board[0].length * TILE_SIZE, board.board.length * TILE_SIZE));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setFont(new Font("Arial", Font.PLAIN, 12));
        FontMetrics metrics = g.getFontMetrics();

        for (int row = 0; row < board.board.length; row++) {
            for (int col = 0; col < board.board[row].length; col++) {
                // Draw the tile
                g.drawRect(col * TILE_SIZE, row * TILE_SIZE, TILE_SIZE, TILE_SIZE);

                // Draw the character centered in the tile
                char c = board.board[row][col];
                int charWidth = metrics.charWidth(c);
                int charHeight = metrics.getAscent();

                int x = col * TILE_SIZE + (TILE_SIZE - charWidth) / 2;
                int y = row * TILE_SIZE + ((TILE_SIZE - charHeight) / 2) + charHeight;

                g.drawString(String.valueOf(c), x, y);
            }
        }
    }

    public void updateBoard() {
        board.turn(0);
        revalidate();
        repaint();
    }
}

