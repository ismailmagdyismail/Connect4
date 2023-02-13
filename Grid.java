public class Grid implements Board{
    int dimensions ;
    private String[][] grid ;
    public Grid(int dimensions ){
        initializeGrid(dimensions);
    }
    @Override
    public boolean isWinner() {
        return false;
    }

    @Override
    public boolean isDraw() {
        return false;
    }

    @Override
    public String[][] getGrid() {
        return this.grid;
    }

    @Override
    public int[] addPiece(int column, String symbol) {
        column --;
        if(!isValidColumn(column)) {
            throw new IndexOutOfBoundsException("Invalid column");
        }
        int[] cell = new int[2];
        cell[0] = cell[1] = -1;
        for (int i = dimensions-1 ; i >= 0; i--){
            if(grid[i][column].equals("-")){
                cell[0] = i;
                cell[1] = column;
                break;
            }
        }
        return cell;
    }

    private void initializeGrid(int dimensions){
        if(dimensions < 5){
            throw new IndexOutOfBoundsException("Invalid column");
        }
        this.dimensions = dimensions;
        grid = new String[dimensions][dimensions];
        for (int i =0 ;i < dimensions;i++){
            for (int j= 0;j < dimensions;j++){
                grid[i][j] = "-";
            }
        }
      
    }
    private boolean isValidColumn(int column ){
        return  column >= 0 && column < dimensions;
    }
    private boolean isValidRow(int row ){
        return  row >= 0 && row < dimensions;
    }
}
