package bangman.player;

import java.util.List;

public interface PlayerFactory {
  public Player makePlayer(List<String> words);
}
