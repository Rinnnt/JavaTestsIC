package bangman.player;

import bangman.Guess;
import java.util.Iterator;

/**
 * This player guesses each letter in turn that is stored in `chars`. Once it finds the letter, it
 * is added to the solution. When the final character is guessed, the next guess is the whole word.
 */
public abstract class PlayerBrute extends Player {

  private int secretLength;
  private int length;
  private char character;
  private StringBuilder word;

  private Iterator<Character> chars;

  public abstract Iterator<Character> makeChars();

  @Override
  public void newGame(int secretLength, String hint) {
    this.secretLength = secretLength;
    this.length = 0;
    this.word = new StringBuilder();
    this.chars = makeChars();
  }

  @Override
  public Guess guess() {
    if (length == secretLength) {
      return new Guess.Word(word.toString());
    } else {
      this.character = chars.next();
      return new Guess.Char(length, alphatree.Utils.singleton(character));
    }
  }

  @Override
  public void tell(boolean response, int turns, boolean finished) {
    if (response) {
      word.append(character);
      length++;
      chars = makeChars();
    }
  }

}
