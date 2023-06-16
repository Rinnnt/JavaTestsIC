import java.util.Arrays;

public class Grid {

    private static final int WIDTH = 10;
    private static final int HEIGHT = 10;

    private final Piece[][] grid = new Piece[HEIGHT][WIDTH];

    public Grid() {
        for (Piece[] row : grid) {
            Arrays.setAll(row, i -> Piece.WATER);
        }
    }

    public boolean canPlace(Coordinate c, int size, boolean isDown) {
        for (int i = 0; i < size; i++) {
            int row = c.getRow() + ((isDown) ? i : 0);
            int column = c.getColumn() + ((isDown) ? 0 : i);
            if (row < 0 ||
                row >= HEIGHT ||
                column < 0 ||
                column >= WIDTH ||
                grid[row][column] != Piece.WATER) {
                return false;
            }
        }
        return true;
    }

    public void placeShip(Coordinate c, int size, boolean isDown) {
        for (int i = 0; i < size; i++) {
            int row = c.getRow() + ((isDown) ? i : 0);
            int column = c.getColumn() + ((isDown) ? 0 : i);
            grid[row][column] = Piece.SHIP;
        }
    }

    public boolean wouldAttackSucceed(Coordinate c) {
        return grid[c.getRow()][c.getColumn()] == Piece.SHIP;
    }

    public void attackCell(Coordinate c) {
        switch (grid[c.getRow()][c.getColumn()]) {
            case SHIP -> grid[c.getRow()][c.getColumn()] = Piece.DAMAGED_SHIP;
            case WATER -> grid[c.getRow()][c.getColumn()] = Piece.MISS;
            default -> {}
        }
    }

    public boolean areAllSunk() {
        for (Piece[] row : grid) {
            if (Arrays.stream(row).anyMatch(piece -> piece == Piece.SHIP)) {
                return false;
            }
        }
        return true;
    }

    public String toPlayerString() {
        Piece[][] playerGrid = Util.deepClone(grid);
        Util.hideShips(playerGrid);
        return renderGrid(playerGrid);
    }

    @Override
    public String toString() {
        return renderGrid(grid);
    }

    private static String renderGrid(Piece[][] grid) {
        StringBuilder sb = new StringBuilder();
        sb.append(" 0123456789\n");
        for (int i = 0; i < grid.length; i++) {
            sb.append((char) ('A' + i));
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == null) {
                    return "!";
                }
                switch (grid[i][j]) {
                case SHIP:
                    sb.append('#');
                    break;
                case DAMAGED_SHIP:
                    sb.append('*');
                    break;
                case MISS:
                    sb.append('o');
                    break;
                case WATER:
                    sb.append('.');
                    break;
                }

            }
            sb.append('\n');
        }

        return sb.toString();
    }
}
