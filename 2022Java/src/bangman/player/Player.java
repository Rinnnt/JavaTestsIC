package bangman.player;

import bangman.Guess;

public abstract class Player {
  public static PlayerFactory factory;

  public abstract void newGame(int secretLength, String hint);

  public abstract Guess guess();

  public abstract void tell(boolean response, int turns, boolean finished);
}

