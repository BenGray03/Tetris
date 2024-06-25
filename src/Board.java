import java.util.ArrayList;
import java.util.Arrays;

public class Board {
    protected char [][] board;

    protected ArrayList<Tetroids> tetroids;

    protected Tetroids current;

    protected Player player;

    public Board(int w, int h, Player p){
        board = new char [h][w];
        tetroids = new ArrayList<>();
        current = p.pop();
        addtet();
        player = p;
    }

    public void init(){
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                this.board[i][j] = '.';
            }
        }
    }

    public void print(){
        for (char[] chars : board) {
            for (char aChar : chars) {
                System.out.print(aChar);
                System.out.print(' ');
            }
            System.out.println();
        }
        System.out.println();
    }

    public void addtet(){//done
        tetroids.add(current);
    }

    public void draw(){
        for (Tetroids tetroid : tetroids) {
            int[][] blocks = tetroid.getBlocks();
            for (int[] block : blocks) {
                board[block[0]][block[1]] = '#';
            }
        }
    }

    public void turn(int direction){
        if(direction == 0) {
            if (checkPossible(0, 1)) {
                current.goDown();
            } else {
                //add checking of completed line only when switching to the next block
                checkBoard();
                //go to next tetroid
                current = player.pop();
                //pop next tetroid of queue and return
                addtet();
            }
        } else if (direction == -1) {
            if(checkPossible(-1, 0)){
                current.goLeft();
            }
        }  else if (direction == 1){
            if(checkPossible(1, 0)){
                current.goRight();
            }
        }
        init();
        draw();
    }

    public boolean checkPossible(int xadd, int yadd) {
        int[][] blocks = current.getBlocks();
        int[][] tetroidBlocks = current.getBlocks(); // Get blocks of the current tetroid

        for (int[] block : blocks) {
            int x = block[1]+xadd;//add a check that sees if the user is going left/right/down and will check that block instead.
            int y = block[0]+yadd;

            // Check if the block is outside the board's boundaries
            if (x < 0 || x >= 10 || y >= 15) {
                return false;
            }

            // Check if there's a block at the same position on the board and it's not part of the same tetroid
            if (y >= 0 && board[y][x] == '#' && !isBlockInTetroid(x, y, tetroidBlocks)) {
                return false;
            }
        }
        return true;
    }

    private boolean isBlockInTetroid(int x, int y, int[][] tetroidBlocks) {
        for (int[] tetroidBlock : tetroidBlocks) {
            if (tetroidBlock[1] == x && tetroidBlock[0] == y) {
                return true;
            }
        }
        return false;
    }

    private void checkBoard(){
        int [] lines = new int[15];
        for(int i = 0; i < 15; i++) {
            lines[i] = checkFullLine(board[i]) ? 1 : 0;
        }
        obliterateLines(lines);
    }

    private void obliterateLines(int [] lines){
        for (int i = 0; i < lines.length; i++) {
            if(lines[i]==1){
                //destroy the line
                Arrays.fill(board[i], '.');
                //pull down all '#' above to bring down
                for (int j = i-1; j >= 0; j--) {
                    for (int k = 0; k < 10; k++) {
                        if (board[j][k] == '#') {
                            board[j][k] = '.';
                            board[j + 1][k] = '#';
                        }
                    }
                }
            }
        }
    }
    private boolean checkFullLine(char[] line){
        for (char block: line) {
            if(block == '.'){
                return false;
            }
        }
        return true;
    }
}
