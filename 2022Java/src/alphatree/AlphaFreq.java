package alphatree;

import java.util.Arrays;
import java.util.List;

public class AlphaFreq {

  private final int[] freqs;

  public AlphaFreq() {
    // TODO: Question 2
    freqs = new int[26];
  }

  public AlphaFreq(List<Character> cs) {
    // TODO: Question 2
    freqs = new int[26];
    if (cs != null) {
      cs.forEach(this::add);
    }
  }

  public boolean isEmpty() {
    // TODO: Question 2
    return Arrays.stream(freqs).noneMatch(i -> i > 0);
  }

  public int size() {
    // TODO: Question 2
    return Arrays.stream(freqs).reduce(0, Integer::sum);
  }

  public int get(char c) {
    // TODO: Question 2
    if (c >= 'a' && c <= 'z') {
      return freqs[c - 'a'];
    }
    return 0;
  }

  public void add(char c) {
    // TODO: Question 2
    if (c >= 'a' && c <= 'z') {
      freqs[c - 'a']++;
    }
  }

  public void reset() {
    // TODO: Question 2
    Arrays.fill(freqs, 0);
  }
}
