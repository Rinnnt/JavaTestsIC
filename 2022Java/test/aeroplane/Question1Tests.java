package aeroplane;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.NoSuchElementException;
import org.junit.Test;

public class Question1Tests {

  /*
  @Test
  public void testConstructorInvalidRow1() {
    try {
      new Seat(0, 'A');
      fail("An IllegalArgumentException was expected");
    } catch (IllegalArgumentException exception) {
      // Good: an exception should have been thrown.
    }
  }

  @Test
  public void testConstructorInvalidRow2() {
    try {
      new Seat(51, 'A');
      fail("An IllegalArgumentException was expected");
    } catch (IllegalArgumentException exception) {
      // Good: an exception should have been thrown.
    }
  }

  @Test
  public void testConstructorInvalidLetter1() {
    try {
      new Seat(1, 'a');
      fail("An IllegalArgumentException was expected");
    } catch (IllegalArgumentException exception) {
      // Good: an exception should have been thrown.
    }
  }

  @Test
  public void testConstructorInvalidLetter2() {
    try {
      new Seat(50, 'G');
      fail("An IllegalArgumentException was expected");
    } catch (IllegalArgumentException exception) {
      // Good: an exception should have been thrown.
    }
  }

  @Test
  public void testToString1() {
    assertEquals("01A", new Seat(1, 'A').toString());
  }

  @Test
  public void testToString2() {
    assertEquals("50A", new Seat(50, 'A').toString());
  }

  @Test
  public void testToString3() {
    assertEquals("03F", new Seat(3, 'F').toString());
  }

  @Test
  public void testIsEmergencyExit1() {
    assertTrue(new Seat(1, 'A').isEmergencyExit());
    assertTrue(new Seat(10, 'B').isEmergencyExit());
    assertTrue(new Seat(30, 'C').isEmergencyExit());
  }

  @Test
  public void testIsEmergencyExit2() {
    assertFalse(new Seat(2, 'D').isEmergencyExit());
    assertFalse(new Seat(9, 'E').isEmergencyExit());
    assertFalse(new Seat(40, 'F').isEmergencyExit());
  }

  @Test
  public void testHasNext1() {
    for (int row = 1; row <= 50; row++) {
      for (char letter = 'A'; letter <= 'F'; letter++) {
        if (row == 50 && letter == 'F') {
          continue;
        }
        assertTrue(new Seat(row, letter).hasNext());
      }
    }
  }

  @Test
  public void testHasNext2() {
    assertFalse(new Seat(50, 'F').hasNext());
  }

  @Test
  public void testNext1() {
    assertEquals("01B", new Seat(1, 'A').next().toString());
    assertEquals("02A", new Seat(1, 'F').next().toString());
    assertEquals("50F", new Seat(50, 'E').next().toString());
  }

  @Test
  public void testNext2() {
    try {
      new Seat(50, 'F').next();
      fail("A NoSuchElementException was expected");
    } catch (NoSuchElementException exception) {
      // Good; this kind of exception is expected.
    }
  }
   */

}
