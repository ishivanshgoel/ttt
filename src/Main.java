import app.Game;
import java.util.Scanner;

public class Main {

    private static Game game;

    public static void main(String[] args) {
        String player1, player2;
        Scanner sc = new Scanner(System.in);
        System.out.print("Player 1 name: ");
        player1 = sc.nextLine();
        System.out.print("Player 2 name: ");
        player2 = sc.nextLine();
        game = new Game(player1, player2);
        game.play();
    }
}
