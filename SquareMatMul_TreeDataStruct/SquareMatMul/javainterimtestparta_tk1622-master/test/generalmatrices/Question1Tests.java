package generalmatrices;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.Test;

public class Question1Tests {
  /*
  @Test
  public void testGet() {
    final Matrix<String> stringMatrix = createStringMatrix();
    final Matrix<Integer> integerMatrix = createIntegerMatrix();
    final Matrix<Matrix<Integer>> integerMatrixMatrix = createIntegerMatrixMatrix();
    assertEquals("f", stringMatrix.get(1, 2));
    assertEquals(Integer.valueOf(4), integerMatrix.get(1, 1));
    assertEquals(Integer.valueOf(1), integerMatrixMatrix.get(1, 1).get(0, 1));
  }

  @Test
  public void testGetOrder() {
    final Matrix<String> stringMatrix = createStringMatrix();
    final Matrix<Integer> integerMatrix = createIntegerMatrix();
    final Matrix<Matrix<Integer>> integerMatrixMatrix = createIntegerMatrixMatrix();
    assertEquals(3, stringMatrix.getOrder());
    assertEquals(2, integerMatrix.getOrder());
    assertEquals(2, integerMatrixMatrix.getOrder());
    assertEquals(2, integerMatrixMatrix.get(0, 0).getOrder());
  }

  @Test
  public void testIllegalArgumentNonSquareMatrix() {
    try {
      new Matrix<>(List.of(1, 2, 3, 4, 5));
      fail("Expected IllegalArgumentException on attempt to create non-square matrix");
    } catch (IllegalArgumentException exception) {
      // Good: exception should be thrown
    }
  }

  @Test
  public void testIllegalArgumentEmptyMatrix() {
    try {
      new Matrix<>(Collections.emptyList());
      fail("Expected IllegalArgumentException on attempt to create empty matrix");
    } catch (IllegalArgumentException exception) {
      // Good: exception should be thrown
    }
  }

  @Test
  public void testToString() {
    final Matrix<String> stringMatrix = createStringMatrix();
    final Matrix<Integer> integerMatrix = createIntegerMatrix();
    final Matrix<Matrix<Integer>> integerMatrixMatrix = createIntegerMatrixMatrix();
    assertEquals("[[a b c][d e f][g h i]]", stringMatrix.toString());
    assertEquals("[[1 2][3 4]]", integerMatrix.toString());
    assertEquals("[[[[1 2][3 4]] [[2 3][4 1]]][[[3 4][1 2]] [[4 1][2 3]]]]",
            integerMatrixMatrix.toString());
  }

  @Test
  public void testSquare() {
    final Set<Integer> perfectSquares = new HashSet<>();
    for (int i = 1; i <= 10; i++) {
      perfectSquares.add(i * i);
    }
    for (int i = 1; i <= 100; i++) {
      List<Integer> data = new ArrayList<>();
      for (int j = 0; j < i; j++) {
        data.add(j);
      }
      try {
        new Matrix<>(data);
        assertTrue(perfectSquares.contains(i));
      } catch (IllegalArgumentException exception) {
        assertFalse(perfectSquares.contains(i));
      }
    }
  }


  private static Matrix<String> createStringMatrix() {
    return new Matrix<>(
            List.of("a", "b", "c", "d", "e", "f", "g", "h", "i"));
  }

  private static Matrix<Integer> createIntegerMatrix() {
    return new Matrix<>(
            List.of(1, 2, 3, 4));
  }

  private static Matrix<Matrix<Integer>> createIntegerMatrixMatrix() {
    return new Matrix<>(
            List.of(
                    createIntegerMatrix(),
                    new Matrix<>(List.of(2, 3, 4, 1)),
                    new Matrix<>(List.of(3, 4, 1, 2)),
                    new Matrix<>(List.of(4, 1, 2, 3))));
  }
  */
}
