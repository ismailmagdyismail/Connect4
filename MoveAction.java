import java.util.Scanner;

public class MoveAction {
    Printer printer;
    public MoveAction(Printer printer){
        this.printer = printer;
    }
    public boolean playMove(Board grid ,Player player){
        printer.printBoard(grid);
        printer.printPlayer(player);
        int column = getColumn(grid);
        if(!grid.isValidColumn(column)) {
            return false;
        }
        int[] cell = grid.addPiece(column,player.getSymbol());
        return cell[0] != -1 && cell[1] != -1;
    }
    private int getColumn(Board grid){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a column between 1 and "+grid.getDimension()+" to insert Symbol in :");
        int column = scanner.nextInt();
        column--;
        return column;
    }
}
