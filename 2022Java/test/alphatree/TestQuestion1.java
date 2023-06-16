package alphatree;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.Set;
import org.junit.Test;

public class TestQuestion1 {

  // LetterTree

  @Test
  public void letterTreeEmpty() {
    AlphaTree t = new AlphaTree();

    assertTrue(t.isEmpty());
    assertFalse(t.isSingleton());
    assertNull(t.left());
    assertNull(t.right());
    assertEquals(0, t.freq());
    assertTrue(t.chars().isEmpty());
  }

  @Test
  public void letterTreeSingle() {
    AlphaTree t = new AlphaTree('a', 42);

    assertFalse(t.isEmpty());
    assertTrue(t.isSingleton());
    assertNull(t.left());
    assertNull(t.right());
    assertEquals(42, t.freq());
    assertEquals(alphatree.Utils.toSet("a"), t.chars());
  }

  @Test
  public void letterTreeBinary() {
    AlphaTree lt = new AlphaTree('a', 42);
    AlphaTree rt = new AlphaTree('b', 37);

    AlphaTree t = new AlphaTree(lt, rt);

    assertFalse(t.isEmpty());
    assertFalse(t.isSingleton());
    assertEquals(lt, t.left());
    assertEquals(rt, t.right());
    assertEquals(42 + 37, t.freq());
    assertEquals(alphatree.Utils.toSet("ab"), t.chars());
  }

  @Test
  public void letterTreeBinaryNullLeft() {
    AlphaTree lt = null;
    AlphaTree rt = new AlphaTree('b', 37);

    AlphaTree t = new AlphaTree(lt, rt);

    assertFalse(t.isEmpty());
    assertTrue(t.isSingleton());
    assertEquals(lt, t.left());
    assertNull(t.left());
    assertEquals(37, t.freq());
    assertEquals(alphatree.Utils.toSet("b"), t.chars());
  }

  @Test
  public void letterTreeBinaryNullRight() {
    AlphaTree lt = new AlphaTree('a', 42);
    AlphaTree rt = null;

    AlphaTree t = new AlphaTree(lt, rt);

    assertFalse(t.isEmpty());
    assertTrue(t.isSingleton());
    assertEquals(lt, t.left());
    assertNull(t.right());
    assertEquals(42, t.freq());
    assertEquals(alphatree.Utils.toSet("a"), t.chars());
  }


  // isEmpty()

  @Test
  public void isEmptyEmpty() {
    AlphaTree t = new AlphaTree();

    assertTrue(t.isEmpty());
  }

  @Test
  public void isEmptySingleton() {
    AlphaTree t = new AlphaTree('a', 42);

    assertFalse(t.isEmpty());
  }

  @Test
  public void isEmptyBinary() {
    AlphaTree lt = new AlphaTree('a', 42);
    AlphaTree rt = new AlphaTree('b', 37);
    AlphaTree t = new AlphaTree(lt, rt);

    assertFalse(t.isEmpty());
  }

  // isSingleton

  @Test
  public void isSingletonEmpty() {
    AlphaTree t = new AlphaTree();

    assertFalse(t.isSingleton());
  }

  @Test
  public void isSingletonSingleton() {
    AlphaTree t = new AlphaTree('a', 42);

    assertTrue(t.isSingleton());
  }

  @Test
  public void isSingletonBinary() {
    AlphaTree lt = new AlphaTree('a', 42);
    AlphaTree rt = new AlphaTree('b', 37);
    AlphaTree t = new AlphaTree(lt, rt);

    assertFalse(t.isSingleton());
  }

  // left

  @Test
  public void leftEmpty() {
    AlphaTree t = new AlphaTree();

    assertNull(t.left());
  }

  @Test
  public void leftSingle() {
    AlphaTree t = new AlphaTree('a', 42);

    assertNull(t.left());
  }

  @Test
  public void leftBinary() {
    AlphaTree lt = new AlphaTree('a', 42);
    AlphaTree rt = new AlphaTree('b', 37);
    AlphaTree t = new AlphaTree(lt, rt);

    assertEquals(lt, t.left());
  }

  // right

  @Test
  public void rightEmpty() {
    AlphaTree t = new AlphaTree();

    assertNull(t.right());
  }

  @Test
  public void rightSingle() {
    AlphaTree t = new AlphaTree('a', 42);

    assertNull(t.right());
  }

  @Test
  public void rightBinary() {
    AlphaTree lt = new AlphaTree('a', 42);
    AlphaTree rt = new AlphaTree('b', 37);
    AlphaTree t = new AlphaTree(lt, rt);

    assertEquals(rt, t.right());
  }

  @Test
  public void charsEmpty() {
    AlphaTree t = new AlphaTree();

    assertTrue(t.chars().isEmpty());
  }

  @Test
  public void charsSingleton() {
    AlphaTree t = new AlphaTree('a', 42);
    Set<Character> letters = alphatree.Utils.toSet("a");

    assertEquals(letters, t.chars());
  }

  @Test
  public void charsBinary() {
    AlphaTree lt = new AlphaTree('a', 42);
    AlphaTree rt = new AlphaTree('b', 37);

    AlphaTree t = new AlphaTree(lt, rt);

    assertEquals(alphatree.Utils.toSet("ab"), t.chars());
  }


  @Test
  public void weightEmpty() {
    AlphaTree t = new AlphaTree();

    assertEquals(0, t.freq());
  }

  @Test
  public void weightSingleton() {
    AlphaTree t = new AlphaTree('a', 42);
    assertEquals(42, t.freq());
  }

  @Test
  public void weightBinary() {

    AlphaTree lt = new AlphaTree('a', 42);
    AlphaTree rt = new AlphaTree('b', 37);

    AlphaTree t = new AlphaTree(lt, rt);

    assertEquals(42 + 37, t.freq());
  }


}
