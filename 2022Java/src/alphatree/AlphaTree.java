package alphatree;

import java.util.HashSet;
import java.util.Set;

public final class AlphaTree {

  private final Set<Character> chars;
  private int freq;
  private AlphaTree left;
  private AlphaTree right;

  public AlphaTree() {
    // TODO: Question 1
    chars = new HashSet<>();
    freq = 0;
    left = null;
    right = null;
  }

  public AlphaTree(char c, int weight) {
    // TODO: Question 1
    this();
    if (weight > 0) {
      chars.add(c);
    }
    freq = weight;
  }

  public AlphaTree(AlphaTree lt, AlphaTree rt) {
    // TODO: Question 1
    this();
    if (lt != null) {
      chars.addAll(lt.chars());
      freq += lt.freq();
      left = lt;
    }
    if (rt != null) {
      chars.addAll(rt.chars());
      freq += rt.freq();
      right = rt;
    }
  }

  public boolean isEmpty() {
    // TODO: Question 1
    return freq == 0;
  }

  public boolean isSingleton() {
    // TODO: Question 1
    return !isEmpty() && ((left == null && right == null) ||
        (left == null && right.isSingleton()) ||
        (right == null && left.isSingleton()));
  }

  public AlphaTree left() {
    // TODO: Question 1
    return left;
  }

  public AlphaTree right() {
    // TODO: Question 1
    return right;
  }

  public Set<Character> chars() {
    // TODO: Question 1
    return chars;
  }

  public int freq() {
    // TODO: Question 1
    return freq;
  }
}
