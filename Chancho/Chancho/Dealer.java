import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * The class Dealer encapsulates the actions of a Chancho game-dealer. The game
 * dealer is responsible for dealing cards from the provided game-deck to each
 * player, and scheduling rounds of the game until a player has won the game.
 * All players who have declared themselves as a winner should be congratulated.
 * 
 * Developers should provide the constructor,
 * 
 * public Dealer(Set<Player> players, Deck gameDeck);
 * 
 */
public final class Dealer {

  private final Set<Player> players;
  private final Deck deck;

  public Dealer(Set<Player> players, Deck deck) {
    this.players = players;
    this.deck = deck;
  }

  private void deal() {
    for (Player player : players) {
      for (int i = 0; i < Player.HANDSIZE; i++) {
        player.addToHand(deck.removeFromTop());
      }
    }
  }

  public void playGame() {
    deal();
    Set<Player> winners = players.stream().filter(Player::hasWon).collect(Collectors.toSet());
    while (winners.isEmpty()) {
      for (Player player : players) {
        player.discard();
      }
      for (Player player : players) {
        player.pickup();
      }
      winners = players.stream().filter(Player::hasWon).collect(Collectors.toSet());
    }
    congratulateWinners();
  }

  private void congratulateWinners() {
    Set<Player> winners = players.stream().filter(Player::hasWon).collect(Collectors.toSet());
    System.out.println("The game has been won! Congratulations to:");
    for (Player winner : winners) {
      System.out.println(winner);
    }
  }
}