import java.util.ArrayList;
import java.util.Random;
public class Player {
    protected int score;
    protected ArrayList<Tetroids> tetroidqueue;

    public Player(){
        score = 0;
        tetroidqueue = new ArrayList<>();
        populatequeue();
    }

    public void populatequeue(){
        Random rand = new Random();
        for (int i = 0; i < 5; i++) {
            tetroidqueue.add(new Tetroids(rand.nextInt(7)));
        }
    }

    public void addToQueue(){
        Random rand = new Random();
        tetroidqueue.add(new Tetroids(rand.nextInt(7)));
    }

    public Tetroids pop(){
        addToQueue();
        return tetroidqueue.remove(0);
    }

}
