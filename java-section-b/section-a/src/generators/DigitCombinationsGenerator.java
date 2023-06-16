package generators;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class DigitCombinationsGenerator implements StringGenerator {

  public static final List<Character> digits = List.of('2', '3', '4', '5');
  private String combination = "";

  @Override
  public String next() {
    String result = combination;
    boolean carry = true;
    StringBuilder sb = new StringBuilder();
    for (int i = combination.length() - 1; i >= 0; i--) {
      sb.append(digits.get((digits.indexOf(combination.charAt(i)) + ((carry) ? 1 : 0)) % digits.size()));
      carry = carry && combination.charAt(i) == '5';
    }
    combination = sb.append((carry) ? '2' : "").reverse().toString();
    return result;
  }

  @Override
  public boolean hasNext() {
    return true;
  }

//  private Deque<String> queue;
//  public static final List<String> digits = List.of("2", "3", "4", "5");
//
//  public DigitCombinationsGenerator() {
//    queue = new ArrayDeque<>();
//    queue.addLast("");
//  }
//
//  @Override
//  public String next() {
//    String str = queue.removeFirst();
//    digits.forEach(digit -> queue.addLast(str + digit));
//    return str;
//
//  }
//
//  @Override
//  public boolean hasNext() {
//    return true;
//  }
}
