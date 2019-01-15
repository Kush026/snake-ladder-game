public class Board {

    private Cell[] cells;

    public Board(int n, int[][] ladders, int[][] snakes) {
        this.cells = new Cell[n+1];

        for (int[] ladder: ladders) {
            Cell cell = new LadderCell(ladder[0], ladder[1]);
            this.cells[ladder[0]] = cell;
        }

        for (int[] snake: snakes) {
            Cell cell = new SnakeCell(snake[0], snake[1]);
            this.cells[snake[0]] = cell;
        }

        for (int i = 1; i < cells.length; i++) {
            if (cells[i] == null) {
                Cell cell = new NormalCell(i);
                this.cells[i] = cell;
            }
        }
    }

    public Cell getFirstCell() {
        return cells[1];
    }

    public Cell getLastCell() {
        return cells[cells.length-1];
    }

    public void movePlayer(Player player, int cellNo) {

        if (!moveValidation(cellNo)) {
            System.out.println("invalid move");
            return;
        }

        player.getCell().setPlayer(null);
        int newCellNo = getCell(cellNo).getGoToCell();

        if (newCellNo > cellNo) {
            System.out.println("ladder found, going to: "+newCellNo);
        }
        else if (newCellNo < cellNo) {
            System.out.println("snake found, going down: "+newCellNo);
        }

        Cell cell = getCell(newCellNo);

        //
        if (cell.isOccupied()) {
            moveToHome(cell.getPlayer());
        }

        // moving player to cell
        cell.setPlayer(player);
        player.setCell(cell);
    }

    public Cell getCell(int cellNo) {
        return cells[cellNo];
    }

    public void moveToHome(Player player) {
        player.setCell(getFirstCell());
    }

    public boolean moveValidation(int cellNo) {
        return cellNo > 0 && cellNo < cells.length;
    }
}
