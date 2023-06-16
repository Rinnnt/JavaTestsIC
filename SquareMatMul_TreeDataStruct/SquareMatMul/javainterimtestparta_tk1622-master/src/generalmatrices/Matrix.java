package generalmatrices;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BinaryOperator;

public final class Matrix<T> {

  private final List<T> content;
  private final int order;

  public Matrix(List<T> content) {
    int order = (int) Math.sqrt(content.size());
    if (content.size() == 0 || order * order != content.size()) {
      throw new IllegalArgumentException("Given array must have a non-zero perfect square size");
    }
    this.content = List.copyOf(content);
    this.order = order;
  }

  public T get(int row, int col) {
    return content.get(row * order + col);
  }

  public int getOrder() {
    return order;
  }

  // PRE: other has the same order as target matrix
  public Matrix<T> sum(Matrix<T> other, BinaryOperator<T> elementSum) {
    List<T> result = new ArrayList<>(getOrder() * getOrder());
    for (int i = 0; i < getOrder(); i++) {
      for (int j = 0; j < getOrder(); j++) {
        result.add(elementSum.apply(get(i, j), other.get(i, j)));
      }
    }
    return new Matrix<>(result);
  }

  // PRE: other has the same order as the target matrix
  public Matrix<T> product(
      Matrix<T> other, BinaryOperator<T> elementSum, BinaryOperator<T> elementProduct) {
    List<T> result = new ArrayList<>(getOrder() * getOrder());
    for (int i = 0; i < getOrder(); i++) {
      for (int j = 0; j < getOrder(); j++) {
        T acc = null;
        for (int k = 0; k < getOrder(); k++) {
          if (k == 0) {
            acc = elementProduct.apply(get(i, k), other.get(k, j));
          } else {
            acc = elementSum.apply(acc, elementProduct.apply(get(i, k), other.get(k, j)));
          }
        }
        result.add(acc);
      }
    }
    return new Matrix<>(result);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("[");
    for (int i = 0; i < getOrder(); i++) {
      sb.append("[");
      sb.append(get(i, 0));
      for (int j = 1; j < getOrder(); j++) {
        sb.append(" ");
        sb.append(get(i, j));
      }
      sb.append("]");
    }
    sb.append("]");
    return sb.toString();
  }

  @Override
  public boolean equals(Object other) {
    if (!(other instanceof Matrix<?> that)) {
      return false;
    }

    if (getOrder() != that.getOrder()) {
      return false;
    }

    for (int i = 0; i < getOrder(); i++) {
      for (int j = 0; j < getOrder(); j++) {
        if (!get(i, j).equals(that.get(i, j))) {
          return false;
        }
      }
    }

    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = getOrder();
    for (int i = 0; i < getOrder(); i++) {
      for (int j = 0; j < getOrder(); j++) {
        hashCode += get(i, j).hashCode();
      }
    }
    return hashCode;
  }
}
