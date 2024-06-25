
public class Tetroids {
    protected int [][] blocks;
    protected int pivot;
    public Tetroids(int i){

        switch (i) {
            case 0 -> setLong();
            case 1 -> setSquare();
            case 2 -> setT();
            case 3 -> setSquiggly();
            case 4 -> setRevSquiggly();
            case 5 -> setL();
            case 6 -> setRevL();
        }
    }

    private void setLong(){
        this.blocks = new int[][] {{0,0}, {0, 1}, {0, 2}, {0,3}};
        pivot = 2;
    }

    private void setSquare(){
        this.blocks = new int[][] {{0,0}, {0,1}, {1,0}, {1,1}};
        pivot = -1;
    }

    private void setT(){
        this.blocks = new int[][] {{0,0}, {0,1}, {0,2},{1,1}};

        pivot = 2;
    }

    private void setSquiggly(){
        this.blocks = new int[][] {{0, 1}, {0,2}, {1,0}, {1,1}};

        pivot = 1;
    }

    private void setRevSquiggly(){
        this.blocks = new int[][]{{0, 0}, {0,1}, {1,1}, {1,2}};
        pivot = 1;
    }

    private void setL(){
        this.blocks = new int[][]{{0,0}, {1,0}, {1,1}, {1,2}};
        pivot = 2;
    }
    private void setRevL(){
        this.blocks = new int[][]{{1,0},{1,1},{1,2}, {0,2}};
        pivot = 2;
    }

    public int [][] getBlocks(){
        return blocks;
    }

    public void goDown(){
        for (int i = 0; i < blocks.length; i++) {
            blocks[i][0]++;
        }
    }

    public void goLeft(){//need to add error checking
        for(int i = 0; i < blocks.length; i++){
            blocks[i][1]--;
        }
    }
    public void goRight(){//need to add error checking
        for(int i = 0; i < blocks.length; i++){
            blocks[i][1]++;
        }
    }


}
