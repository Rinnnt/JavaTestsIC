package aeroplane;

import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

public class Seat {

	// TODO: Section A, Tasks 1 and 3

  private final int row;
  private final char letter;
  private static final int ROW_START = 1;
  private static final int ROW_END = 50;
  private static final String LETTERS = "ABCDEF";
  private static final Set<Integer> emergencyExitRows = new HashSet<>(List.of(1, 10, 30));

  public Seat(int row, char letter) {
    if (row < ROW_START || row > ROW_END || !LETTERS.contains(String.valueOf(letter))) {
      throw new IllegalArgumentException("Invalid Seat of Row: " + row + ", Letter: " + letter);
    }
    this.row = row;
    this.letter = letter;
  }

  boolean isEmergencyExit() {
    return emergencyExitRows.contains(row);
  }

  boolean hasNext() {
    return !(row == ROW_END && letter == LETTERS.charAt(LETTERS.length() - 1));
  }

  Seat next() {
    if (!hasNext()) {
      throw new NoSuchElementException("Next seat does not exist");
    }

    if (letter == LETTERS.charAt(LETTERS.length() - 1)) {
      return new Seat(row + 1, LETTERS.charAt(0));
    } else {
      return new Seat(row, LETTERS.charAt(LETTERS.indexOf(letter) + 1));
    }

  }

  @Override
  public String toString() {
    return String.valueOf(row) + letter;
  }

  @Override
  public boolean equals(Object other) {
    if (!(other instanceof Seat that)) {
      return false;
    }

    return row == that.row && letter == that.letter;
  }

  @Override
  public int hashCode() {
    return row * LETTERS.length() + (int) letter;
  }
}
