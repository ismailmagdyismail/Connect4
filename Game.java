import java.util.Scanner;
public class Game {
    private final Scanner scanner  = new Scanner(System.in);
    private  Board grid;
    private Player[] players;
    private final Printer printer;
    private final MoveAction move;
    public Game(){
        players = new Player[2];
        printer = new Printer();
        move = new MoveAction(printer);
    }

    public void runGame(){
        getPlayersInfo();
        getGridDimension();
        int idx = 0 ;
        while (true){
            boolean isValidMove = false;
            while (!isValidMove){
                isValidMove = move.playMove(grid,players[idx]);
            }
            if(grid.isWinner()) {
                printer.printBoard(grid);
                printer.printWinningMsg(players[idx]);
                break;
            }
            else if (grid.isDraw()) {
                printer.printBoard(grid);
                printer.printDrawMsg();
                break;
            }
            idx++;
            idx %= 2;
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


}
