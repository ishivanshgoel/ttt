package app;
import utils.Coordinate;
import java.util.Scanner;

public class Player {
    private String name;
    private Literal literal;

    Player (String name, Literal literal){
        this.name = name;
        this.literal = literal;
    }

    Coordinate play(){
        System.out.println(name + "'s turn...");
        int x, y;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter X Coordinate ");
        x = sc.nextInt();
        System.out.print("Enter Y Coordinate ");
        y = sc.nextInt();
        return new Coordinate(x, y);
    }

    Literal getLiteral () {
        return literal;
    }

}
