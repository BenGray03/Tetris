import java.util.concurrent.TimeUnit;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        Player p = new Player();
        p.populatequeue();
        Board board = new Board(10, 15, p);
        createBoardFrame(board);
    }

    public static void createBoardFrame(Board board){
        JFrame frame = new JFrame("Board Display");
        frame.setSize(1000,1000);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        BoardDisplay boardDisplay = new BoardDisplay(board);
        frame.add(boardDisplay);
        frame.setVisible(true);

        while(true) {
            try {
                boardDisplay.updateBoard();
                TimeUnit.MILLISECONDS.sleep(1000);

            } catch (Exception e) {
                System.out.println("Exception Occurred");
            }
        }
    }
}
