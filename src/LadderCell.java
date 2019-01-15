public class LadderCell extends Cell {

    public LadderCell(int cellNo, int goToCell) {
        super(cellNo, goToCell);
        if (goToCell < cellNo) throw new IllegalArgumentException("Invalid ladder ends");
    }

    @Override
    public int getGoToCell() {
        return super.getGoToCell();
    }
}
