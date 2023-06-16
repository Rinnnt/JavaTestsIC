package bangman;

import java.util.Set;

public class Opponent {
  private String secret;
  private boolean finished;

  public Opponent(String secret) {
    this.secret = secret;
    this.finished = false;
  }

  public boolean ask(int i, Set<Character> xs) {
    return xs.contains(secret.charAt(i));
  }

  public boolean ask(String xs) {
    finished = xs.equals(secret);
    return finished;
  }

  public int secretLength() {
    return secret.length();
  }

  public String hint() {
    return secret;
  }

  public boolean finished() {
    return finished;
  }
}
