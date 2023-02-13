public interface Board {
    public boolean isWinner();
    public boolean isDraw();
    public String[][] getGrid();
    public int[] addPiece(int column , String symbol);
}
