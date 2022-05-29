package app;
import utils.Coordinate;

public class Game {

    private final Player player1;
    private final Player player2;
    private final Board board;
    private GameState gameState;
    private Player currentPlayer;

    public Game(String player1, String player2) {
        this.player1 = new Player(player1, Literal.X);
        this.player2 = new Player(player2, Literal.O);
        this.board = new Board();
        this.gameState = GameState.IN_PROGRESS;
        this.currentPlayer = this.player1; // by default player 1 gets first chance to play
    }

    private GameState gameStatus() {

        // implement game rule here
        for(int r = 0; r < this.board.rowLength(); r++) {
            for(int c = 0; c < this.board.columnLength(); c++) {

            }
        }

        return GameState.IN_PROGRESS;
    }

    // change the turn of players
    private void flipTurn () {
        if(this.currentPlayer == this.player1) {
            this.currentPlayer = this.player2;
        } else {
            this.currentPlayer = this.player1;
        }
    }

    public void play() {
        System.out.println("Game Started!");
        while(this.gameStatus() == GameState.IN_PROGRESS) {
            // keep playing
            // give chance to both the players one by one

            this.board.display();
            Boolean response = false; // keep taking input until user inputs a valid coordinate values

            while(!response) {
                Coordinate coordinates = this.currentPlayer.play();
                response = this.board.mark(coordinates, this.currentPlayer.getLiteral());
            }

            this.flipTurn();
        }

        this.gameState = GameState.OVER;
    }

}
