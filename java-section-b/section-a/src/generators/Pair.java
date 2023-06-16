package generators;

import java.util.Objects;

public final class Pair<S, T> {
  private final S elem1;
  private final T elem2;

  public Pair(S elem1, T elem2) {
    this.elem1 = elem1;
    this.elem2 = elem2;
  }

  public S getElem1() {
    return elem1;
  }

  public T getElem2() {
    return elem2;
  }

  @Override
  public String toString() {
    return "[" + elem1.toString() + ", " + elem2.toString() + "]";
  }

  @Override
  public boolean equals(Object other) {
    if (!(other instanceof Pair<?, ?>)) {
      return false;
    }
    Pair<?, ?> pair = (Pair<?, ?>) other;
    return elem1.equals(pair.elem1) && elem2.equals(pair.elem2);
  }

  @Override
  public int hashCode() {
    return elem1.hashCode() * elem2.hashCode();
  }

}
