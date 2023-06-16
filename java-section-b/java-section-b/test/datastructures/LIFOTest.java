package datastructures;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class LIFOTest {

  LIFO<Integer> lifo;

  @Before
  public void initializeStock() {
    lifo = new LIFOImpl<>();
  }

  @Test
  public void theLIFOIsInitiallyEmpty() {
    assertEquals(0, lifo.size());
  }

  @Test
  public void pushPopAndSizeBehave() {
    assertEquals(0, lifo.size());
    lifo.push(1);
    assertEquals(1, lifo.size());
    lifo.push(1);
    assertEquals(2, lifo.size());
    lifo.push(2);
    assertEquals(3, lifo.size());

    var popped = lifo.pop();
    assertTrue(popped.isPresent());
    assertEquals(Integer.valueOf(2), popped.get());
    assertEquals(2, lifo.size());

    popped = lifo.pop();
    assertTrue(popped.isPresent());
    assertEquals(Integer.valueOf(1), popped.get());
    assertEquals(1, lifo.size());

    popped = lifo.pop();
    assertTrue(popped.isPresent());
    assertEquals(Integer.valueOf(1), popped.get());
    assertEquals(0, lifo.size());

    popped = lifo.pop();
    assertFalse(popped.isPresent());
    assertEquals(0, lifo.size());
  }
}
