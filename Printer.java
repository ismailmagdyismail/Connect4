public class Printer {
    public void PrintBoard(Board board){
        String[][] grid = board.getGrid();
        int rows = grid.length;
        int columns = grid.length;
        for (int i = 1;i <= columns;i++){
            System.out.print(i);
            System.out.print("    ");
        }
        System.out.print('\n');
        for (int i = 0 ;i<rows;i++){
            for (int j =0;j < columns;j++){
                System.out.print("=====");
            }
            System.out.print('\n');
            for (int j =0;j < columns;j++){
                System.out.print(grid[i][j]+" || ");
            }
            System.out.print('\n');
        }
    }
}