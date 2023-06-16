package generalmatrices;

import static org.junit.Assert.assertEquals;

import java.util.List;
import org.junit.Test;

public class Question2Tests {
  /*
  @Test
  public void testSum() {
    final Matrix<Integer> integerMatrix1 = new Matrix<>(
            List.of(-1, 5, 8, -42));
    final Matrix<Integer> integerMatrix2 = new Matrix<>(
            List.of(2, 0, -4, 127));
    final Matrix<Integer> integerMatrixMaxSum =
            integerMatrix1.sum(integerMatrix2, Math::max);
    assertEquals(Integer.valueOf(2), integerMatrixMaxSum.get(0, 0));
    assertEquals(Integer.valueOf(5), integerMatrixMaxSum.get(0, 1));
    assertEquals(Integer.valueOf(8), integerMatrixMaxSum.get(1, 0));
    assertEquals(Integer.valueOf(127), integerMatrixMaxSum.get(1, 1));
  }

  @Test
  public void testProductStrings() {
    final Matrix<String> stringMatrix1 = new Matrix<>(
            List.of("hi", "fi", "wi", "fi"));
    final Matrix<String> stringMatrix2 = new Matrix<>(
            List.of("si", "fi", "py", "py"));
    final Matrix<String> stringMatrixProduct =
            stringMatrix1.product(stringMatrix2, String::concat,
                    (a, b) -> a + "!" + b);
    assertEquals("hi!sifi!py", stringMatrixProduct.get(0, 0));
    assertEquals("hi!fifi!py", stringMatrixProduct.get(0, 1));
    assertEquals("wi!sifi!py", stringMatrixProduct.get(1, 0));
    assertEquals("wi!fifi!py", stringMatrixProduct.get(1, 1));
  }

  @Test
  public void testProductBooleans() {
    final Matrix<Boolean> booleanMatrix1 = new Matrix<>(
            List.of(true, false, false, false, true, false, false, false, true));
    final Matrix<Boolean> booleanMatrix2 = new Matrix<>(
            List.of(true, false, true, false, true, false, true, true, false));
    //noinspection ConstantConditions (work around bug in IntelliJ's inspections)
    final Matrix<Boolean> booleanMatrixProduct =
            booleanMatrix1.product(booleanMatrix2, Boolean::logicalOr, Boolean::logicalAnd);
    assertEquals(true, booleanMatrixProduct.get(0, 0));
    assertEquals(false, booleanMatrixProduct.get(0, 1));
    assertEquals(true, booleanMatrixProduct.get(0, 2));
    assertEquals(false, booleanMatrixProduct.get(1, 0));
    assertEquals(true, booleanMatrixProduct.get(1, 1));
    assertEquals(false, booleanMatrixProduct.get(1, 2));
    assertEquals(true, booleanMatrixProduct.get(2, 0));
    assertEquals(true, booleanMatrixProduct.get(2, 1));
    assertEquals(false, booleanMatrixProduct.get(2, 2));
  }
  */
}
