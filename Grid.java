public class Grid implements Board{
    private static int required = 4;
    int dimensions ;
    private String[][] grid ;
    public Grid(int dimensions ){
        initializeGrid(dimensions);
    }
    @Override
    public boolean isWinner() {
        return checkColumn() || checkRow() || checkLeftDiagonal() || checkRightDiagonal();
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
        if(!isValidColumn(column)) {
            throw new IndexOutOfBoundsException("Invalid column");
        }
        int[] cell = new int[2];
        cell[0] = cell[1] = -1;
        for (int i = dimensions-1 ; i >= 0; i--){
            if(grid[i][column].equals("-")){
                cell[0] = i;
                cell[1] = column;
                grid[i][column] = symbol;
                break;
            }
        }
        return cell;
    }
    public int getDimension(){
        return this.dimensions;
    }
    public boolean isValidColumn(int column){
        return  column >= 0 && column < dimensions;
    }
    public boolean isValidRow(int row ){
        return  row >= 0 && row < dimensions;
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

    private boolean checkColumn() {
        for(int j = 0 ;j<dimensions;j++){
            int connected = 1;
            for (int i = 1 ; i<dimensions;i++){
                if(grid[i][j].equals(grid[i-1][j]) && !grid[i][j].equals("-") )
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
                if(grid[i][j].equals(grid[i][j-1]) && !grid[i][j].equals("-"))
                    connected++;
                else connected = 1;
                if(connected == required)
                    return true;
            }
        }
        return false;
    }
    private boolean checkLeftDiagonal() {
        for(int i = 0 ;i<dimensions;i++){
            for (int j = 0 ; j<dimensions;j++){
                int x = i+1 , y = j+1;
                int connected = 1;
                while (isValidRow(x) && isValidColumn(y)){
                    if(grid[x][y].equals(grid[x-1][y-1]) && !grid[x][y].equals("-"))
                        connected++;
                    else connected = 1;
                    if(connected == required)
                        return true;
                    x++;
                    y++;
                }
            }
        }
        return false;
    }

    private boolean checkRightDiagonal() {
        for(int i = 0 ;i<dimensions;i++){
            for (int j = dimensions-1 ; j>=0;j--){
                int x = i+1 , y = j-1;
                int connected = 1;
                while (isValidRow(x) && isValidColumn(y)){
                    if(grid[x][y].equals(grid[x-1][y+1]) && !grid[x][y].equals("-"))
                        connected++;
                    else connected = 1;
                    if(connected == required)
                        return true;
                    x++;
                    y--;
                }
            }
        }
        return false;
    }
}
