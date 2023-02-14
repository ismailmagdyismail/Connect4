import java.util.Scanner;

public class MoveAction {
    public boolean makeMove(Board grid , Symbol symbol){
        int column = getCell(grid);
        int[]cell = grid.addPiece(column,symbol.toString());
        return cell[0] != -1 && cell[1] != -1;
    }
    private int getCell(Board grid){
        Scanner scanner  = new Scanner(System.in);
        int column = -1;
        while (!grid.isValidColumn(column)){
            System.out.print("Enter a column to insert Symbol in :");
            column = scanner.nextInt();
        }
        return column;
    }
}
