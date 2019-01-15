import java.util.Random;

public class Dice {

    private static final Dice DICE = new Dice();
    private Random random = new Random();

    private Dice() {
    }

    // this is sudo random number generator
    public int roll() {
        return 1+random.nextInt(6);
    }

    public static Dice getInstance() {
        return DICE;
    }
}
