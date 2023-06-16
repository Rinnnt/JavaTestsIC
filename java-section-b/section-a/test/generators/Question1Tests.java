package generators;


import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.Assert;
import org.junit.Test;

public class Question1Tests {

    @Test
    public void testCollatzSequenceGenerator1() {
      final List<Integer> expected = List.of(27, 82, 41, 124, 62, 31, 94, 47, 142);
      final IntegerGenerator generator = new CollatzSequenceGenerator(27);
      for (var i : expected) {
        Assert.assertTrue(generator.hasNext());
        Assert.assertEquals(i, generator.next());
      }
    }

    @Test
    public void testCollatzSequenceGenerator2() {
      final IntegerGenerator generator = new CollatzSequenceGenerator(2051);
      try {
        for (int i = 0; i < 100; i++) {
          generator.next();
        }
        Assert.fail("An exception was expected.");
      } catch (UnsupportedOperationException exception) {
        // Good: an exception should have been thrown.
      }
    }

    @Test
    public void testCollatzSequenceGenerator3() {
      final IntegerGenerator generator = new CollatzSequenceGenerator(4);
      Assert.assertFalse(generator.hasNext());
      try {
        generator.next();
        Assert.fail("An exception was expected.");
      } catch (UnsupportedOperationException exception) {
        // Good: an exception should have been thrown.
      }
    }

    @Test
    public void testMissingPrimesGenerator() {
      final Set<Integer> expected = new HashSet<>(Arrays.asList(
          1, 3, 7, 9, 10, 11, 13, 17, 19,
          20, 21, 23, 27, 29, 30, 31, 33, 37, 39,
          40, 41, 43, 47, 49, 50, 51, 53, 57, 59,
          60, 61, 63, 67, 69, 70, 71, 73, 77, 79,
          80, 81, 83, 87, 89, 90, 91, 93, 97, 99,
          100, 101, 103, 107, 109, 110, 111, 113, 117, 119,
          120, 121, 123, 127, 129, 130, 131, 133, 137, 139,
          140, 141, 143, 147, 149, 150, 151, 153, 157, 159,
          160, 161, 163, 167, 169, 170, 171, 173, 177, 179,
          180, 181, 183, 187, 189, 190, 191, 193, 197, 199,
          200
      ));

      final IntegerGenerator generator = new MissingPrimesGenerator();
      for (int i = 0; i < 100; i++) {
        Assert.assertTrue(generator.hasNext());
        int element = generator.next();
        Assert.assertTrue("Did not expect " + element, expected.contains(element));
        expected.remove(element);
      }
      Assert.assertTrue("Expected but did not see " + expected, expected.isEmpty());
    }

}
