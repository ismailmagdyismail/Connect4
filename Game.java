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
            boolean isValidFirstMove = false;
            while (!isValidFirstMove){
                printer.PrintBoard(grid);
                System.out.print("FIRST ");
                System.out.println(players[0].getName());
                int column = getColumn();
                isValidFirstMove = moveAction.makeMove(grid,column,Symbol.R);
            }
            if(grid.isWinner()) {
                printer.PrintBoard(grid);
                System.out.println("Congrats, Player 1 Won");
                break;
            }
            else if (grid.isDraw()) {
                printer.PrintBoard(grid);
                System.out.println("The game ended in a Draw");
                break;
            }
            boolean isValidSecondMove = false;
            while (!isValidSecondMove){
                printer.PrintBoard(grid);
                System.out.print("SECOND ");
                System.out.println(players[1].getName());
                int column = getColumn();
                isValidSecondMove = moveAction.makeMove(grid,column,Symbol.Y);
            }
            if(grid.isWinner()) {
                printer.PrintBoard(grid);
                System.out.println("Congrats, Player 2 Won");
                break;
            }
            else if (grid.isDraw()) {
                printer.PrintBoard(grid);
                System.out.println("The game ended in a Draw");
                break;
            }
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
        players[1] = new Player(secondPlayerName, Symbol.Y);
    }

    private void getGridDimension(){
        int dimension = 0;
        while (dimension < 5){
            System.out.print("Please,Enter valid Board dimension(s) :");
            dimension = scanner.nextInt();
        }
        grid = new Grid(dimension);
    }

    private int getColumn(){
        int column = -1;
        while (!grid.isValidColumn(column)){
            System.out.print("Enter a column between 1 and "+grid.getDimension()+" to insert Symbol in");
            column = scanner.nextInt();
            column--;
        }
        return column;
    }
}
