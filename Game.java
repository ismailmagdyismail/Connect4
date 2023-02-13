import java.awt.*;
import java.util.Scanner;

public class Game {
    private final Scanner scanner  = new Scanner(System.in);
    private  Board grid;
    private Player[] players;
    private final Printer printer;
    private final MoveAction moveAction;
    public Game(){
        players = new Player[2];
        printer = new Printer();
        moveAction = new MoveAction();
    }

    public void run(){
        getPlayersInfo();
        getGridDimension();
        while (true){
            printer.PrintBoard(grid);
            // make move 1
            // check winner , draw
            // make move 2
            // check winner , draw
            break;
        }
    }

    private void getPlayersInfo(){
        String firstPlayerName  = new String();
        while (firstPlayerName.isEmpty()){
            System.out.print("Enter Red player's Name :");
            firstPlayerName = scanner.nextLine();
        }
        players[0] = new Player(firstPlayerName, Symbol.R);

        String secondPlayerName  = new String();
        while (secondPlayerName.isEmpty()){
            System.out.print("Enter Yellow player's Name :");
            secondPlayerName = scanner.nextLine();
        }
        players[0] = new Player(secondPlayerName, Symbol.Y);
    }

    private void getGridDimension(){
        int dimension = 0;
        while (dimension < 5){
            System.out.print("Please,Enter valid Board dimension(s) :");
            dimension = scanner.nextInt();
        }
        grid = new Grid(dimension);
    }


}
