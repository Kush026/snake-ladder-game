
public abstract class Cell {

    private int cellNo;
    private Player player;
    private int goToCell;

    public Cell(int cellNo, int goToCell) {
        this.cellNo = cellNo;
        this.goToCell = goToCell;
    }

    public int getCellNo() {
        return cellNo;
    }

    public int getGoToCell() {
        return goToCell;
    }

    public boolean isOccupied() {
        return player != null;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
