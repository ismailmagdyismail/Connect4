public interface Board {
    public boolean isWinner();
    public boolean isDraw();
    public String[][] getGrid();
    public int[] addPiece(int column , String symbol);
    public boolean isValidColumn(int column );
    public boolean isValidRow(int row );
    public int getDimension();
}
