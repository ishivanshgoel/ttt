package app;
import utils.Coordinate;

public class Game {

    private final Player player1;
    private final Player player2;
    private final Board board;
    private GameState gameState;
    private Player currentPlayer;
    private Player winner;

    public Game(String player1, String player2) {
        this.player1 = new Player(player1, Literal.X);
        this.player2 = new Player(player2, Literal.O);
        this.board = new Board();
        this.gameState = GameState.IN_PROGRESS;
        this.currentPlayer = this.player1; // by default player 1 gets first chance to play
        this.winner = null;
    }

    private GameState gameStatus() {

        // assuming rows and column in board are 3 and 3 respectively
        // check all rows
        for(int row = 0; row < this.board.rowLength(); row++){
            if(this.board.getValue(row, 0 ) == this.board.getValue(row, 1)
                    && this.board.getValue(row, 1) == this.board.getValue(row, 2)){
                if(this.board.getValue(row, 0) == Literal.X) {
                    this.winner = this.player1;
                    return GameState.OVER;
                } else if(this.board.getValue(row, 0) == Literal.O) {
                    this.winner = this.player2;
                    return GameState.OVER;
                }
            }
        }

        // check for all columns
        for(int column = 0; column < this.board.columnLength(); column++){
            if(this.board.getValue(0, column ) == this.board.getValue(1, column)
                    && this.board.getValue(1, column) == this.board.getValue(2, column)){
                if(this.board.getValue(0, column) == Literal.X) {
                    this.winner = this.player1;
                    return GameState.OVER;
                } else if(this.board.getValue(0, column) == Literal.O){
                    this.winner = this.player2;
                    return GameState.OVER;
                }
            }
        }

        // check for left diagonal
        if(this.board.getValue(0,0) == this.board.getValue(1, 1)
                && this.board.getValue(1,1) == this.board.getValue(2, 2)){
            if(this.board.getValue(0, 0) == Literal.X) {
                this.winner = this.player1;
                return GameState.OVER;
            } else if(this.board.getValue(0, 0) == Literal.O) {
                this.winner = this.player2;
                return GameState.OVER;
            }
        }

        // check for right diagonal
        if(this.board.getValue(0,2) == this.board.getValue(1, 1)
                && this.board.getValue(1,1) == this.board.getValue(2, 0)){
            if(this.board.getValue(0, 2) == Literal.X) {
                this.winner = this.player1;
                return GameState.OVER;
            } else if(this.board.getValue(0, 2) == Literal.O) {
                this.winner = this.player2;
                return GameState.OVER;
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
        System.out.println("Game Status "+this.gameStatus());
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

        if(this.winner != null)
            System.out.println("Winner " + this.winner.getName());
        this.gameState = GameState.OVER;
    }

}
