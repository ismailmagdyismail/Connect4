public class Grid implements Board{
    private static int connectN = 4;
    int dimension;
    private String[][] grid ;
    public Grid(int dimension)
    {
        this.dimension = dimension;
        initializeGrid();
    }
    @Override
    public boolean isWinner() {
        return checkColumn() || checkRow() || checkLeftDiagonal() || checkRightDiagonal();
    }

    @Override
    public boolean isDraw() {
        int occupiedCells = 0 ;
        int totalCells = dimension * dimension;
        for (int i = 0; i< dimension; i++){
            for (int j = 0; j< dimension; j++){
                if(!grid[i][j].equals("-")){
                    occupiedCells++;
                }
            }
        }
        return occupiedCells == totalCells && !isWinner();
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
        for (int i = dimension -1; i >= 0; i--){
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
        return this.dimension;
    }
    public boolean isValidColumn(int column){
        return  column >= 0 && column < dimension;
    }
    public boolean isValidRow(int row ){
        return  row >= 0 && row < dimension;
    }
    private void initializeGrid(){
        if(dimension <= connectN){
            throw new IndexOutOfBoundsException("Invalid dimensions");
        }
        this.dimension = dimension;
        grid = new String[dimension][dimension];
        for (int i = 0; i < dimension; i++){
            for (int j = 0; j < dimension; j++){
                grid[i][j] = "-";
            }
        }
      
    }

    private boolean checkColumn() {
        for(int j = 0; j< dimension; j++){
            int connected = 1;
            for (int i = 1; i< dimension; i++){
                if(grid[i][j].equals(grid[i-1][j]) && !grid[i][j].equals("-") )
                    connected++;
                else connected = 1;
                if(connected == connectN)
                    return true;
            }
        }
        return false;
    }
    private boolean checkRow() {
        for(int i = 0; i< dimension; i++){
            int connected = 1;
            for (int j = 1; j< dimension; j++){
                if(grid[i][j].equals(grid[i][j-1]) && !grid[i][j].equals("-"))
                    connected++;
                else connected = 1;
                if(connected == connectN)
                    return true;
            }
        }
        return false;
    }
    private boolean checkLeftDiagonal() {
        for(int i = 0; i< dimension; i++){
            for (int j = 0; j< dimension; j++){
                int x = i+1 , y = j+1;
                int connected = 1;
                while (isValidRow(x) && isValidColumn(y)){
                    if(grid[x][y].equals(grid[x-1][y-1]) && !grid[x][y].equals("-"))
                        connected++;
                    else connected = 1;
                    if(connected == connectN)
                        return true;
                    x++;
                    y++;
                }
            }
        }
        return false;
    }

    private boolean checkRightDiagonal() {
        for(int i = 0; i< dimension; i++){
            for (int j = dimension -1; j>=0; j--){
                int x = i+1 , y = j-1;
                int connected = 1;
                while (isValidRow(x) && isValidColumn(y)){
                    if(grid[x][y].equals(grid[x-1][y+1]) && !grid[x][y].equals("-"))
                        connected++;
                    else connected = 1;
                    if(connected == connectN)
                        return true;
                    x++;
                    y--;
                }
            }
        }
        return false;
    }
}
