package alphatree;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class TestQuestion3 {

  @Test
  public void alphaTreeQueueEmpty() {
    AlphaTreeQueue queue = new AlphaTreeQueue();

    assertEquals(0, queue.size());
    assertNull(queue.poll());
    assertNull(queue.peek());
  }

  @Test
  public void alphaTreeQueueFreqNull() {
    AlphaTreeQueue queue = new AlphaTreeQueue(null);

    assertEquals(0, queue.size());
    assertNull(queue.poll());
    assertNull(queue.peek());
  }

  @Test
  public void alphaTreeQueueFreqEmpty() {
    AlphaTreeQueue queue = new AlphaTreeQueue(new AlphaFreq());

    assertEquals(0, queue.size());
    assertNull(queue.poll());
    assertNull(queue.peek());
  }

  @Test
  public void alphaTreeQueueOther() {
    AlphaTreeQueue queue =
        new AlphaTreeQueue(new AlphaFreq(TestQuestion2.fromAZString("abcaba")));

    assertEquals(3, queue.size());
  }

  @Test
  public void addNull() {
    AlphaTreeQueue queue = new AlphaTreeQueue();

    queue.add(null);
    assertEquals(0, queue.size());
  }

  @Test
  public void addEmpty() {
    AlphaTreeQueue queue = new AlphaTreeQueue();

    queue.add(new AlphaTree());
    assertEquals(0, queue.size());
  }

  @Test
  public void addOne() {
    AlphaTreeQueue queue = new AlphaTreeQueue();

    queue.add(new AlphaTree('a', 5));
    assertEquals(1, queue.size());
  }

  @Test
  public void addMany() {
    AlphaTreeQueue queue = new AlphaTreeQueue();

    queue.add(new AlphaTree('a', 5));
    queue.add(new AlphaTree('b', 8));
    queue.add(new AlphaTree('c', 3));
    assertEquals(3, queue.size());
  }

  @Test
  public void addBinary() {
    AlphaTreeQueue queue = new AlphaTreeQueue();

    queue.add(new AlphaTree(new AlphaTree('a', 3), new AlphaTree('b', 7)));

    assertEquals(1, queue.size());
  }

  @Test
  public void addAllMany() {
    AlphaTreeQueue queue = new AlphaTreeQueue();

    List<Character> chars = TestQuestion2.fromAZString("aaaaabbbbbbbbccc");
    queue.addAll(new AlphaFreq(chars));

    AlphaTree tree = null;

    tree = queue.poll();
    assertEquals(Utils.singleton('c'), tree.chars());
    assertEquals(3, tree.freq());

    tree = queue.poll();
    assertEquals(Utils.singleton('a'), tree.chars());
    assertEquals(5, tree.freq());

    tree = queue.poll();
    assertEquals(Utils.singleton('b'), tree.chars());
    assertEquals(8, tree.freq());
  }


  @Test
  public void pollEmpty() {
    AlphaTreeQueue queue = new AlphaTreeQueue();

    queue.poll();
    assertEquals(queue, queue);
  }

  @Test
  public void pollOne() {
    AlphaTreeQueue queue = new AlphaTreeQueue();

    AlphaTree t1 = new AlphaTree('a', 42);
    queue.add(t1);
    AlphaTree t2 = queue.poll();
    assertEquals(0, queue.size());
    assertEquals(t1, t2);
  }

  @Test
  public void pollSome() {
    AlphaTreeQueue queue =
        new AlphaTreeQueue(new AlphaFreq(TestQuestion2.fromAZString("abcbdecc")));
    assertEquals(5, queue.size());

    final AlphaTree t1 = queue.poll();
    assertEquals(4, queue.size());

    final AlphaTree t2 = queue.poll();
    assertEquals(3, queue.size());

    final AlphaTree t3 = queue.poll();
    assertEquals(2, queue.size());

    final AlphaTree t4 = queue.poll();
    assertEquals(1, queue.size());

    final AlphaTree t5 = queue.poll();
    assertEquals(0, queue.size());

    assertTrue(t1.chars().contains('a'));
    assertEquals(1, t1.freq());
    assertTrue(t2.chars().contains('d'));
    assertEquals(1, t2.freq());
    assertTrue(t3.chars().contains('e'));
    assertEquals(1, t3.freq());
    assertTrue(t4.chars().contains('b'));
    assertEquals(2, t4.freq());
    assertTrue(t5.chars().contains('c'));
    assertEquals(3, t5.freq());
  }

  @Test
  public void peekEmpty() {
    AlphaTreeQueue queue = new AlphaTreeQueue();

    AlphaTree t1 = new AlphaTree('a', 42);
    queue.add(t1);
    AlphaTree t2 = queue.peek();
    assertEquals(1, queue.size());
    assertEquals(t1, t2);
  }

  @Test
  public void peekSome() {
    AlphaTreeQueue queue =
        new AlphaTreeQueue(new AlphaFreq(TestQuestion2.fromAZString("abbcccdde")));

    final AlphaTree t1 = queue.peek();
    final AlphaTree t2 = queue.peek();
    final AlphaTree t3 = queue.peek();
    final AlphaTree t4 = queue.peek();
    final AlphaTree t5 = queue.peek();

    assertEquals(5, queue.size());
    assertTrue(t1.chars().contains('a'));
    assertTrue(t2.chars().contains('a'));
    assertTrue(t3.chars().contains('a'));
    assertTrue(t4.chars().contains('a'));
    assertTrue(t5.chars().contains('a'));
  }

  @Test
  public void sizeEmpty() {
    AlphaTreeQueue queue = new AlphaTreeQueue();

    assertEquals(0, queue.size());
  }

  @Test
  public void sizeSingleton() {
    AlphaTreeQueue queue = new AlphaTreeQueue();
    queue.add(new AlphaTree('a', 42));
    assertEquals(1, queue.size());
  }
}
