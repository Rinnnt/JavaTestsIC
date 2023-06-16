package bangman;

import bangman.player.Player;
import bangman.player.PlayerFactory;
import bangman.player.PlayerTerminal;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public final class Bangman {
  private Bangman() {
  }

  public static void main(String[] args) {
    PlayerTerminal.main(args);
  }

  public static int runGame(PlayerFactory factory) {
    List<String> words = new ArrayList<>();
    String fileName = "words.txt";

    try {
      words = Files.readAllLines(Paths.get(fileName));
    } catch (IOException e) {
      System.out.printf("file \"%s\" not found", fileName);
      System.exit(0);
    }

    Player player = factory.makePlayer(words);

    System.out.println("Bangman");

    Opponents opponents = new Opponents(words);
    int score = 0;
    for (Opponent opponent : opponents) {
      score += play(player, opponent);
    }

    System.out.printf("score: %d\n", score);
    return score;
  }

  private static int play(Player player, Opponent opponent) {

    player.newGame(opponent.secretLength(), opponent.hint());

    // Java style pattern match
    Guess.Visitor<Boolean> askVisitor = new Guess.Visitor<>() {
      @Override
      public Boolean visit(Guess.Char guess) {
        return opponent.ask(guess.idx, guess.chars);
      }

      @Override
      public Boolean visit(Guess.Word guess) {
        return opponent.ask(guess.word);
      }
    };

    for (int turn = 1; true; turn++) {
      Guess guess = player.guess();
      boolean response = guess.visit(askVisitor);
      player.tell(response, turn, opponent.finished());
      if (opponent.finished()) {
        return turn;
      }
    }
  }
}
