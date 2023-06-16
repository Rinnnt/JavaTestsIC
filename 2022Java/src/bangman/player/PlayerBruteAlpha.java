package bangman.player;

import bangman.Bangman;
import java.util.Iterator;
import java.util.List;
import java.util.stream.IntStream;

public class PlayerBruteAlpha extends PlayerBrute {

  public static PlayerFactory factory = new PlayerFactory() {
    public Player makePlayer(List<String> words) {
      return new PlayerBruteAlpha();
    }
  };

  public static void main(String[] args) {
    Bangman.runGame(PlayerBruteAlpha.factory);
  }

  @Override
  public Iterator<Character> makeChars() {
    return IntStream.rangeClosed('a', 'z').mapToObj(c -> (char) c).iterator();
  }
}
