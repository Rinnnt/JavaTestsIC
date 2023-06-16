package bangman.player;

import static java.lang.System.out;

import bangman.Bangman;
import bangman.Guess;
import java.util.List;
import java.util.Scanner;

public class PlayerTerminal extends Player {
  public static PlayerFactory factory = new PlayerFactory() {
    public Player makePlayer(List<String> words) {
      return new PlayerTerminal(words);
    }
  };
  final Scanner scanner;
  final List<String> words;
  int secretLength;

  public PlayerTerminal(List<String> words) {
    this.words = words;
    scanner = new Scanner(System.in);
    scanner.useDelimiter(System.lineSeparator());

    out.println("To guess a word, enter it on a single line");
    out.println("To guess a character, enter the position and the word on separate lines");
    out.println("To exit, press Ctrl-C");
  }

  public static void main(String[] args) {
    Bangman.runGame(PlayerTerminal.factory);

  }

  @Override
  public void newGame(int secretLength, String hint) {
    this.secretLength = secretLength;

    out.printf("Guess the word, it has %d letters\n", secretLength);
    out.printf("Hint: %s\n", hint); // This might help!
  }

  @Override
  public Guess guess() {
    scanner.hasNextLine();
    while (scanner.hasNext()) {
      // This ensures that an integer can be read from the stream and
      // that it is strictly less than the secret length
      if (scanner.hasNextInt(secretLength)) {
        int i = scanner.nextInt();
        String xs = scanner.next();
        return new Guess.Char(i, alphatree.Utils.toSet(xs));
      } else {
        String xs = scanner.next();
        return new Guess.Word(xs);
      }
    }

    return null;
  }

  @Override
  public void tell(boolean response, int turns, boolean finished) {
    out.println(response);
    if (finished) {
      out.printf("Correct! You took %d turns\n\n", turns);
    }
  }
}

