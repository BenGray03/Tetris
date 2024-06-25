import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        Player p = new Player();
        p.populatequeue();
        Board board = new Board(10, 15, p);
        board.init();
        try {
            for (int i = 0; i < 100; i++) {
                board.turn();
                TimeUnit.MILLISECONDS.sleep(1000);
            }
        }catch (Exception e){

        }

    }
}
