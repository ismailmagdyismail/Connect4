public class Grid implements Board{
    private static int required;
    int dimensions ;
    private String[][] grid ;
    public Grid(int dimensions ){
        initializeGrid(dimensions);
    }
    @Override
    public boolean isWinner() {
        return checkColumn() || checkRow() || checkDiagonal();
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

    private boolean checkColumn() {
        for(int j = 0 ;j<dimensions;j++){
            int connected = 1;
            for (int i = 1 ; i<dimensions;i++){
                if(grid[i][j].equals(grid[i-1][j]))
                    connected++;
                else connected = 1;
                if(connected == required)
                    return true;
            }
        }
        return false;
    }
    private boolean checkRow() {
        for(int i = 0 ;i<dimensions;i++){
            int connected = 1;
            for (int j = 1 ; j<dimensions;j++){
                if(grid[i][j].equals(grid[i][j-1]))
                    connected++;
                else connected = 1;
                if(connected == required)
                    return true;
            }
        }
        return false;
    }
    private boolean checkDiagonal() {
        for(int i = 0 ;i<dimensions;i++){
            for (int j = 1 ; j<dimensions;j++){
                int x = i+1 , y = j+1;
                int connected = 1;
                while (i<dimensions && j<dimensions){
                    if(grid[x][y] .equals(grid[x-1][y-1]))
                        connected++;
                    else connected = 1;
                    if(connected == required)
                        return true;
                    i++;
                    j++;
                }
            }
        }
        return false;
    }
}
