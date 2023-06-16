package bangman.player;

import bangman.Bangman;
import bangman.Guess;
import java.util.List;

public class PlayerBruteWord extends Player {

  public static PlayerFactory factory = new PlayerFactory() {
    public Player makePlayer(List<String> words) {
      return new PlayerBruteWord(words);
    }
  };
  private List<String> words;
  private int length;

  public PlayerBruteWord(List<String> words) {
    this.words = words;
  }

  public static void main(String[] args) {
    Bangman.runGame(PlayerBruteWord.factory);
  }

  @Override
  public void newGame(int secretLength, String hint) {
    this.length = 0;
  }

  @Override
  public Guess guess() {
    return new Guess.Word(words.get(length++));
  }

  @Override
  public void tell(boolean response, int turns, boolean finished) {
  }

}
