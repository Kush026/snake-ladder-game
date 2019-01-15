public class SnakeCell extends Cell {

    public SnakeCell(int cellNo, int goToCell) {
        super(cellNo, goToCell);
        if (cellNo < goToCell) throw new IllegalArgumentException("Invalid snake ends");
    }
}
