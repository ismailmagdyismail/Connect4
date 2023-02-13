import java.util.Scanner;

public class Game {
    private Scanner scanner  = new Scanner(System.in);
    private  Board grid;
    private Player[] players;
    private Printer printer;
    private MoveAction moveAction;
    public Game(){
        players = new Player[2];
        printer = new Printer();
        moveAction = new MoveAction();
    }

    public void run(){
        getGridDimension();
        String[][] board = grid.getGrid();
        for (int i =0 ; i<grid.getGrid().length;i++){
            for (int j =0 ; j<grid.getGrid().length;j++){
               board[i][j]= "1";
            }
        }
        printer.PrintBoard(grid);
    }

    private void getGridDimension(){
        int dimension = 0;
        while (dimension <= 0){
            System.out.print("Please,Enter valid Board dimension(s) :");
            dimension = scanner.nextInt();
        }
        grid = new Grid(dimension);
    }
}
