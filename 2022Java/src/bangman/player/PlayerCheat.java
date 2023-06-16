package bangman.player;

import bangman.Bangman;
import bangman.Guess;
import java.util.List;

public class PlayerCheat extends Player {
  public static PlayerFactory factory = new PlayerFactory() {
    public Player makePlayer(List<String> words) {
      return new PlayerCheat();
    }
  };
  private String hint;

  public static void main(String[] args) {
    Bangman.runGame(PlayerCheat.factory);
  }

  @Override
  public void newGame(int secretLength, String hint) {
    this.hint = hint;
  }

  @Override
  public Guess guess() {
    return new Guess.Word(hint);
  }

  @Override
  public void tell(boolean response, int turns, boolean finished) {
    return;
  }

}
