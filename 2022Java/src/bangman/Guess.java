package bangman;

import java.util.Set;

// data Guess = GuessChar Int String | GuessWord String
public abstract class Guess {
  public abstract <A> A visit(Visitor<A> visitor);

  public static class Char extends Guess {
    public final int idx;
    public final Set<Character> chars;

    public Char(int idx, Set<Character> chars) {
      this.idx = idx;
      this.chars = chars;
    }

    @Override
    public <A> A visit(Visitor<A> visitor) {
      return visitor.visit(this);
    }
  }

  public static class Word extends Guess {
    public final String word;

    public Word(String word) {
      this.word = word;
    }

    @Override
    public <A> A visit(Visitor<A> visitor) {
      return visitor.visit(this);
    }
  }

  /**
   * This is the Visitor Pattern: in essence, it allows for the pattern matching of Guesses.
   */
  public abstract static class Visitor<A> {
    public abstract A visit(Char guess);

    public abstract A visit(Word guess);
  }

}
