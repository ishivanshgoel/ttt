package app;
import utils.Coordinate;

public class Board {
    private final int rows = 3;
    private final int columns = 3;
    private Literal[][] board;

    Board () {
        this.board = new Literal[this.rows][this.columns];

        // initialize the board with Literal.E
        for(int r = 0; r < this.rows; r++) {
            for(int c = 0; c < this.columns; c++) {
                this.board[r][c] = Literal.E;
            }
        }
    }

    private Boolean isValidCoordinate(Coordinate coordinate) {
        return coordinate.xCor() >= 0 && coordinate.xCor() < this.rows
                && coordinate.yCor() >= 0 && coordinate.yCor() < this.columns;
    }

    private Boolean isEmpty(Coordinate coordinate) {
        return this.board[coordinate.xCor()][coordinate.yCor()] == Literal.E;
    }

    // mark the literal on the board
    Boolean mark(Coordinate coordinate, Literal literal) {

        if(!isValidCoordinate(coordinate)) {
            System.out.println("Coordinates are invalid! Try Again...");
            return false;
        }

        // coordinate is not empty
        if(!this.isEmpty(coordinate)){
            System.out.println("This Coordinate is already filled! Try Again...");
            return false;
        }

        // mark with given literal
        this.board[coordinate.xCor()][coordinate.yCor()] = literal;
        return true;
    }

    // getter method for board rows length
    int rowLength() {
        return this.rows;
    }

    // getter method for board column lengths
    int columnLength() {
        return this.columns;
    }

    // display board
    void display() {
        for(int r = 0; r < this.rows; r++) {
            for(int c = 0; c < this.columns; c++) {
                if(this.board[r][c] == Literal.O) {
                    System.out.print("|O |");
                } else if (this.board[r][c] == Literal.X) {
                    System.out.print("|X |");
                } else {
                    System.out.print("| |");
                }
            }
            System.out.println();
        }
    }

}
