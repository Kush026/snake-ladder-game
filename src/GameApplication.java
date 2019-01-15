import java.util.Scanner;

public class GameApplication {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of players:");
        int n = sc.nextInt();
        Player[] players = new Player[n];

        for (int i = 1; i <= n; i++) {
            System.out.println("Enter player "+i+" name: ");
            Player player = new Player(sc.next());
            players[i-1] = player;
        }

        int[][] ladders = {{5, 25}, {10, 29}, {22, 41}, {28, 55}, {44, 95}, {70, 89}, {79, 81}};
        int[][] snakes = {{31, 11}, {37, 17}, {73, 53}, {78, 39}, {92, 35}, {99, 7}};
        Board board = new Board(100, ladders, snakes);

        Game game = new Game(players, board);
        game.start();
    }
}
