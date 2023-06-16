import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Grid grid = makeInitialGrid();

        int userAttempts = 0;
        while (!grid.areAllSunk()) {
            System.out.println(grid.toPlayerString());
            System.out.println("Please enter a coordinate to attack:");
            System.out.print("> ");

            Coordinate attack = Util.parseCoordinate(input.next());
            userAttempts++;
            if (grid.wouldAttackSucceed(attack)) {
                System.out.println("Direct Hit!");
            }
            grid.attackCell(attack);
        }
        System.out.println("You took " + userAttempts + " attacks to sink all ships.");
        System.out.println(grid.toPlayerString());
    }

    private static Grid makeInitialGrid() {
        Grid grid = new Grid();

        String[] coords = { "A7", "B1", "B4", "D3", "F7", "H1", "H4" };
        int[] sizes = { 2, 4, 1, 3, 1, 2, 5 };
        boolean[] isDowns = { false, true, true, false, false, true, false };

        for (int i = 0; i < coords.length; i++) {
            Coordinate c = Util.parseCoordinate(coords[i]);
            grid.placeShip(c, sizes[i], isDowns[i]);
        }

        return grid;
    }
}
