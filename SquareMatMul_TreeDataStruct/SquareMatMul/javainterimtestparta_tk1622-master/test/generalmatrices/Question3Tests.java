package generalmatrices;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.Test;

public class Question3Tests {
  /*
  @Test
  public void testMultiplyNestedMatrices1() {

    final Matrix<Matrix<Integer>> dummyMatrix1
            = new Matrix<>(List.of(new Matrix<>(List.of(2))));
    final Matrix<Matrix<Integer>> dummyMatrix2
            = new Matrix<>(List.of(new Matrix<>(List.of(8))));
    final Matrix<Matrix<Integer>> dummyProduct
            = ExampleMethods.multiplyNestedMatrices(dummyMatrix1, dummyMatrix2);
    assertEquals(1, dummyProduct.getOrder());
    assertEquals(1, dummyProduct.get(0, 0).getOrder());
    assertEquals(Integer.valueOf(16), dummyProduct.get(0, 0).get(0, 0));
  }

  @Test
  public void testMultiplyNestedMatrices2() {
    final Matrix<Integer> innerMatrix = new Matrix<>(List.of(1, 2, 2, 1));
    final Matrix<Matrix<Integer>> nestedMatrix = new Matrix<>(List.of(innerMatrix,
            innerMatrix, innerMatrix, innerMatrix));
    final Matrix<Matrix<Integer>> nestedProduct = ExampleMethods.multiplyNestedMatrices(
            nestedMatrix, nestedMatrix);
    assertEquals(2, nestedProduct.getOrder());
    assertEquals(2, nestedProduct.get(0, 0).getOrder());

    for (int row = 0; row < 2; row++) {
      for (int col = 0; col < 2; col++) {
        assertEquals(Integer.valueOf(10), nestedProduct.get(row, col).get(0, 0));
        assertEquals(Integer.valueOf(8), nestedProduct.get(row, col).get(0, 1));
        assertEquals(Integer.valueOf(8), nestedProduct.get(row, col).get(1, 0));
        assertEquals(Integer.valueOf(10), nestedProduct.get(row, col).get(1, 1));
      }
    }

  }

  @Test
  public void testMultiplyPairMatrices() {
    List<Matrix<Pair>> pairMatrices = new ArrayList<>();
    for (int i = 0; i < 5; i++) {
      pairMatrices.add(
          new Matrix<>(
              Stream.iterate(
                      new Pair(i, -i), item -> new Pair(item.getCoordX() + 1, item.getCoordY() - 1))
                  .limit(9)
                  .collect(Collectors.toList())));
    }
    final Matrix<Pair> product = ExampleMethods.multiplyPairMatrices(pairMatrices);

    assertEquals(product.get(0, 0), new Pair(189702, -189702));
    assertEquals(product.get(0, 1), new Pair(215784, -215784));
    assertEquals(product.get(0, 2), new Pair(241866, -241866));
    assertEquals(product.get(1, 0), new Pair(603288, -603288));
    assertEquals(product.get(1, 1), new Pair(686232, -686232));
    assertEquals(product.get(1, 2), new Pair(769176, -769176));
    assertEquals(product.get(2, 0), new Pair(1016874, -1016874));
    assertEquals(product.get(2, 1), new Pair(1156680, -1156680));
    assertEquals(product.get(2, 2), new Pair(1296486, -1296486));
  }
  */
}
