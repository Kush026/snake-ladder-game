public class Player implements Comparable<Player> {

    private String name;
    private Cell cell;
    private int order;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public void setCell(Cell cell) {
        this.cell = cell;
    }

    public Cell getCell() {
        return cell;
    }

    public int getCellNo() {
        return getCell().getCellNo();
    }

    @Override
    public int compareTo(Player o) {
        return o.getOrder()-this.getOrder();
    }
}
