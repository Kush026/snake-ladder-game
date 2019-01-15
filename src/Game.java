import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Game {

    private Board board;
    private Player[] players;
    private Player winner;
    private Dice dice = Dice.getInstance();
    private Scanner scanner = new Scanner(System.in);

    public Game(Player[] players, Board board) {
        this.players = players;
        this.board = board;

        for (Player player: players) {
            player.setCell(board.getFirstCell());
        }
    }

    public void start() {
        initialRolls();

        int pos = 0;

        while (!isDone()) {
            Player player = players[pos];
            System.out.println(player.getName()+" is at "+player.getCellNo() + "(press enter)");
            scanner.nextLine();
            int roll = dice.roll();
            System.out.println(player.getName()+" rolled: "+roll);
            int newCellNo = player.getCellNo()+roll;
            board.movePlayer(player, newCellNo);
            pos++;
            pos %= players.length;

            if (board.getLastCell().isOccupied()) {
                winner = board.getLastCell().getPlayer();
            }
        }

        System.out.println("Winner is: "+winner.getName());
    }

    public void initialRolls() {
        for (Player player: players) {
            System.out.println(player.getName()+" is rolling...(press enter)");
            scanner.nextLine();
            int roll = dice.roll();
            System.out.println(player.getName()+" rolled: "+roll);
            player.setOrder(roll);
        }

        Arrays.sort(players);
    }

    public boolean isDone() {
        return winner != null;
    }
}
