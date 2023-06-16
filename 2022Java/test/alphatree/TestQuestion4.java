package alphatree;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class TestQuestion4 {
  @Test
  public void allLettersPresent() {
    AlphaTree t = Utils.newAlphaTree("abcdefgh");
    Set<Character> letters = alphatree.Utils.toSet("abcdefgh");

    assertEquals(letters, t.chars());
  }

  @Test
  public void charsLeftAndRight() {
    AlphaTree t = Utils.newAlphaTree("abcdefgh");
    Set<Character> letters = alphatree.Utils.toSet("abcdefgh");
    Set<Character> union = new HashSet<>(t.left().chars());
    union.addAll(t.right().chars());

    assertEquals(union, letters);
  }

  @Test
  public void weightString() {
    AlphaTree t = Utils.newAlphaTree("abcdefgh");

    assertEquals(t.freq(), 8);
  }

  @Test
  public void weightStringRepeats() {
    AlphaTree t = Utils.newAlphaTree("ababa");

    assertEquals(t.freq(), 5);
  }

  @Test
  public void charsFrequentRight() {
    AlphaTree t = Utils.newAlphaTree("ababa");
    Set<Character> a = alphatree.Utils.toSet("a");

    assertEquals(a, t.right().chars());
    assertEquals(3, t.right().freq());
  }

  @Test
  public void charsFrequentLeft() {
    AlphaTree t = Utils.newAlphaTree("ababa");
    Set<Character> b = alphatree.Utils.toSet("b");

    assertEquals(b, t.left().chars());
    assertEquals(2, t.left().freq());
  }

  @Test
  public void charsEntireTree() {
    AlphaTree t = Utils.newAlphaTree("abcbdecc");

    assertEquals(alphatree.Utils.toSet("abcde"), t.chars());
    assertEquals(8, t.freq());
    assertEquals(alphatree.Utils.toSet("be"), t.left().chars());
    assertEquals(3, t.left().freq());
    assertEquals(alphatree.Utils.toSet("e"), t.left().left().chars());
    assertEquals(1, t.left().left().freq());
    assertEquals(alphatree.Utils.toSet("b"), t.left().right().chars());
    assertEquals(2, t.left().right().freq());
    assertEquals(alphatree.Utils.toSet("acd"), t.right().chars());
    assertEquals(5, t.right().freq());
    assertEquals(alphatree.Utils.toSet("ad"), t.right().left().chars());
    assertEquals(2, t.right().left().freq());
    assertEquals(alphatree.Utils.toSet("a"), t.right().left().left().chars());
    assertEquals(1, t.right().left().left().freq());
    assertEquals(alphatree.Utils.toSet("d"), t.right().left().right().chars());
    assertEquals(1, t.right().left().right().freq());
    assertEquals(alphatree.Utils.toSet("c"), t.right().right().chars());
    assertEquals(3, t.right().right().freq());
  }

}
