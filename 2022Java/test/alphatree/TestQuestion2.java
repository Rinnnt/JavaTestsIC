package alphatree;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;


public class TestQuestion2 {

  public static List<Character> fromAZString(String xs) {
    List<Character> cs = new ArrayList<Character>();
    for (char x : xs.toCharArray()) {
      if ('a' <= x && x <= 'z') {
        cs.add(x);
      }
    }

    return cs;
  }

  @Test
  public void alphaFreqEmpty() {
    AlphaFreq freq = new AlphaFreq();

    assertTrue(freq.isEmpty());
    assertEquals(0, freq.size());
    char c = 0;
    do {
      assertEquals(0, freq.get(c));
    } while (c > 0);
  }

  @Test
  public void alphaFreqNull() {
    AlphaFreq freq = new AlphaFreq(null);

    assertTrue(freq.isEmpty());
    assertEquals(0, freq.size());
    char c = 0;
    do {
      assertEquals(0, freq.get(c));
    } while (c > 0);
  }

  @Test
  public void alphaFreqEmptyString() {
    AlphaFreq freq = new AlphaFreq(fromAZString(""));

    assertTrue(freq.isEmpty());
    assertEquals(0, freq.size());
    char c = 0;
    do {
      assertEquals(0, freq.get(c));
    } while (c > 0);
  }

  @Test
  public void alphaFreqA() {
    AlphaFreq freq = new AlphaFreq(fromAZString("aaa"));

    assertFalse(freq.isEmpty());
    assertEquals(3, freq.size());
    assertEquals(3, freq.get('a'));
    char c = 0;
    do {
      if (c == 0) {
        continue;
      }
      assertEquals(0, freq.get(c));
    } while (c > 0);
  }

  @Test
  public void alphaFreqZ() {
    AlphaFreq freq = new AlphaFreq(fromAZString("zzzzz"));

    assertFalse(freq.isEmpty());
    assertEquals(5, freq.size());
    assertEquals(5, freq.get('z'));
    char c = 0;
    do {
      if (c == 25) {
        continue;
      }
      assertEquals(0, freq.get(c));
    } while (c > 0);
  }

  @Test
  public void alphaFreqAZ() {
    AlphaFreq freq = new AlphaFreq(fromAZString("abcdefghijklmnopqrstuvwxyz"));

    assertFalse(freq.isEmpty());
    assertEquals(26, freq.size());
    int c = 0;
    do {
      if ('a' <= (char) c && (char) c <= 'z') {
        assertEquals(1, freq.get((char) c));
      } else {
        assertEquals(0, freq.get((char) c));
      }
      c++;
    } while (c > 0);
  }

  @Test
  public void alphaFreqGarbage() {
    AlphaFreq freq =
        new AlphaFreq(fromAZString("!@#$%^&*()1234567890ABDEFGHIJKLMNOPQRSTUVWXYZ"));

    assertTrue(freq.isEmpty());
    assertEquals(0, freq.size());
    int c = 0;
    do {
      assertEquals(0, freq.get((char) c));
      c++;
    } while (c > 0);
  }

  @Test
  public void isEmptyEmpty() {
    AlphaFreq freq = new AlphaFreq();
    assertTrue(freq.isEmpty());
  }

  @Test
  public void isEmptyABC() {
    AlphaFreq freq = new AlphaFreq(fromAZString("abc"));
    assertFalse(freq.isEmpty());
  }

  @Test
  public void addAll() {
    AlphaFreq freq1 = new AlphaFreq(fromAZString("abcdefghijklmnopqrstuvwxyz"));
    AlphaFreq freq2 = new AlphaFreq();

    char c = 0;
    do {
      freq2.add(c);
      c++;
    } while (c > 0);

    c = 0;
    do {
      assertEquals(freq1.get(c), freq2.get(c));
      c++;
    } while (c > 0);
  }

  @Test
  public void getNone() {
    AlphaFreq freq = new AlphaFreq(new ArrayList<>());

    for (int c = 0; c <= Character.MAX_CODE_POINT; c++) {
      assertEquals(freq.get((char) c), 0);
    }
  }

  @Test
  public void getOne() {
    AlphaFreq freq = new AlphaFreq(fromAZString("a"));

    assertEquals(freq.get('a'), 1);
  }

  @Test
  public void getMany() {
    AlphaFreq freq = new AlphaFreq(fromAZString("aaaa"));

    assertEquals(freq.get('a'), 4);
  }

  @Test
  public void sizeZero() {
    AlphaFreq freq = new AlphaFreq(fromAZString(""));

    assertEquals(freq.size(), 0);
  }

  @Test
  public void sizeAZ() {
    AlphaFreq freq = new AlphaFreq(fromAZString("abcdefghijklmnopqrstuvwxyz"));

    assertEquals(freq.size(), 26);
  }

  @Test
  public void sizeAll() {
    AlphaFreq freq = new AlphaFreq();
    char c = 0;
    do {
      freq.add(c);
      c++;
    } while (c > 0);

    assertEquals(freq.size(), 26);
  }

  @Test
  public void resetIsEmpty() {
    AlphaFreq freq = new AlphaFreq(fromAZString("abcde"));
    freq.reset();
    assertTrue(freq.isEmpty());
  }

  @Test
  public void resetIsEmptyDuplicates() {
    AlphaFreq freq = new AlphaFreq(fromAZString("aaabbbcde"));
    freq.reset();
    assertTrue(freq.isEmpty());
  }
}
