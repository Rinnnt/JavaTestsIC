package generalmatrices;

import java.util.List;
import java.util.function.BinaryOperator;

public class ExampleMethods {

  // PRE: Two matrices and nested matrices has same order
  public static Matrix<Matrix<Integer>> multiplyNestedMatrices(
      Matrix<Matrix<Integer>> first, Matrix<Matrix<Integer>> second) {
    return first.product(second, new MatrixSum(), new MatrixProduct());
  }

  // PRE: matrices have same order, and given list is non-empty
  public static Matrix<Pair> multiplyPairMatrices(List<Matrix<Pair>> matrices) {
    return matrices.stream()
        .reduce(
            (pairMatrix1, pairMatrix2) ->
                pairMatrix1.product(pairMatrix2, new PairSum(), new PairProduct()))
        .get();
  }

  private static class MatrixSum implements BinaryOperator<Matrix<Integer>> {
    @Override
    public Matrix<Integer> apply(Matrix<Integer> integerMatrix1, Matrix<Integer> integerMatrix2) {
      return integerMatrix1.sum(integerMatrix2, Integer::sum);
    }
  }

  private static class MatrixProduct implements BinaryOperator<Matrix<Integer>> {
    @Override
    public Matrix<Integer> apply(Matrix<Integer> integerMatrix1, Matrix<Integer> integerMatrix2) {
      return integerMatrix1.product(
          integerMatrix2, Integer::sum, (integer1, integer2) -> integer1 * integer2);
    }
  }

  private static class PairSum implements BinaryOperator<Pair> {
    @Override
    public Pair apply(Pair pair1, Pair pair2) {
      return new Pair(pair1.getCoordX() + pair2.getCoordX(), pair1.getCoordY() + pair2.getCoordY());
    }
  }

  private static class PairProduct implements BinaryOperator<Pair> {
    @Override
    public Pair apply(Pair pair1, Pair pair2) {
      return new Pair(pair1.getCoordX() * pair2.getCoordX(), pair1.getCoordY() * pair2.getCoordY());
    }
  }
}
