package generalmatrices;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.Test;

public class Question4Tests {
  /*
  @Test
  public void testEquals1() {
    final Matrix<Integer> integerMatrix = new Matrix<>(List.of(1, 2, 3, 4));
    //noinspection AssertBetweenInconvertibleTypes
    assertNotEquals(integerMatrix, new IOException());
  }

  @Test
  public void testEquals2() {
    final Matrix<Integer> integerMatrix = new Matrix<>(List.of(1, 2, 3, 4));
    assertNotEquals(integerMatrix, null);
  }

  @Test
  public void testEquals3() {
    final Matrix<Integer> integerMatrix = new Matrix<>(List.of(1, 2, 3, 4));
    assertEquals(integerMatrix, integerMatrix);
  }

  @Test
  public void testEquals4() {
    final Matrix<Integer> integerMatrix1 = new Matrix<>(List.of(1, 2, 3, 4));
    final Matrix<Integer> integerMatrix2 = new Matrix<>(List.of(1, 2, 3, 5));
    assertNotEquals(integerMatrix1, integerMatrix2);
  }

  @Test
  public void testEquals5() {
    final Matrix<Integer> integerMatrix1 = new Matrix<>(List.of(1, 2, 3, 4));
    final Matrix<Integer> integerMatrix2 = new Matrix<>(List.of(
            1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16));
    assertNotEquals(integerMatrix1, integerMatrix2);
    assertNotEquals(integerMatrix2, integerMatrix1);
  }

  @Test
  public void testEquals6() {
    final Matrix<Integer> integerMatrix1 = new Matrix<>(List.of(1, 2, 3, 4));
    final Matrix<Integer> integerMatrix2 = new Matrix<>(List.of(1, 2, 3, 4));
    assertEquals(integerMatrix1, integerMatrix2);
  }

  @Test
  public void testEquals7() {
    final Matrix<String> stringMatrix1 = new Matrix<>(List.of("A", "BB", "C", "DD"));
    //noinspection StringBufferReplaceableByString
    final StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append("B");
    stringBuilder1.append("B");
    //noinspection StringBufferReplaceableByString
    final StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append("D");
    stringBuilder2.append("D");
    final Matrix<String> stringMatrix2 = new Matrix<>(List.of("A", stringBuilder1.toString(), "C",
            stringBuilder2.toString()));
    assertEquals(stringMatrix1, stringMatrix2);
  }

  @Test
  public void testEquals8() {
    final Matrix<Integer> integerMatrix1 = new Matrix<>(List.of(1, 2, 3, 4));
    final Matrix<Integer> integerMatrix2 = new Matrix<>(List.of(1, 2, 3, 4));
    Set<Matrix<Integer>> matrices = new HashSet<>();
    matrices.add(integerMatrix1);
    assertTrue(matrices.contains(integerMatrix2));
  }
  */
}
