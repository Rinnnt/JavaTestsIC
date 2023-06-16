package bangman.player;

import alphatree.AlphaFreq;
import bangman.Bangman;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class PlayerBruteFreq extends PlayerBrute {

  public static PlayerFactory factory = new PlayerFactory() {
    public Player makePlayer(List<String> words) {
      return new PlayerBruteFreq(words);
    }
  };
  private final PriorityQueue<Character> initialQueue;

  PlayerBruteFreq(List<String> words) {

    List<Character> chars = new LinkedList<Character>();
    for (String word : words) {
      for (char c : word.toCharArray()) {
        chars.add(c);
      }
    }

    AlphaFreq freqMap = new AlphaFreq(chars);

    Comparator<Character> charCompare = new Comparator<Character>() {
      @Override
      public int compare(Character c1, Character c2) {
        return Integer.compare(freqMap.get(c2), freqMap.get(c1));
      }
    };
    initialQueue = new PriorityQueue<Character>(26, charCompare);
    for (char c = 'a'; c <= 'z'; c++) {
      initialQueue.add(c);
    }
  }

  public static void main(String[] args) {
    Bangman.runGame(PlayerBruteFreq.factory);
  }

  @Override
  public Iterator<Character> makeChars() {
    return initialQueue.iterator();
  }
}
