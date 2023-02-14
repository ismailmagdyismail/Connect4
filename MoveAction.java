import java.util.Scanner;

public class MoveAction {
    public boolean makeMove(Board grid ,int column, Symbol symbol){
        int[] cell = grid.addPiece(column,symbol.toString());
        return cell[0] != -1 && cell[1] != -1;
    }

}
