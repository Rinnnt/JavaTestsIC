package generalmatrices;

import java.util.Objects;

public final class Pair {

  private final Integer coordX;
  private final Integer coordY;

  public Pair(Integer coordX, Integer coordY) {
    this.coordX = coordX;
    this.coordY = coordY;
  }

  public Integer getCoordX() {
    return coordX;
  }

  public Integer getCoordY() {
    return coordY;
  }

  @Override
  public String toString() {
    return "(" + coordX + ", " + coordY + ")";
  }

  @Override
  public boolean equals(Object that) {
    if (!(that instanceof Pair thatPair)) {
      return false;
    }
    return this.coordX.equals(thatPair.coordX) && this.coordY.equals(thatPair.coordY);
  }

  @Override
  public int hashCode() {
    return Objects.hash(coordX, coordY);
  }
}
