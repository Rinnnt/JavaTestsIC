import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class AutoPlayer extends AbstractPlayer {

  private final Random generator;

  public AutoPlayer(CardPile left, CardPile right, String name) {
    super(left, right, name);
    generator = new Random();
  }

  @Override
  protected int selectCard() {
    Map<Card, Integer> cardFreq = new HashMap<>();
    for (Card c : cards) {
      cardFreq.put(c, cardFreq.getOrDefault(c, 0) + 1);
    }

    Card maxCard = cards[0];
    boolean unique = true;
    int maxFreq = 0;
    for (Map.Entry<Card, Integer> entry : cardFreq.entrySet()) {
      if (entry.getValue() > maxFreq) {
        maxCard = entry.getKey();
        maxFreq = entry.getValue();
        unique = true;
      }
      if (entry.getValue() == maxFreq) {
        unique = false;
      }
    }

    if (unique) {
      int idx = generator.nextInt(HANDSIZE);
      while (cards[idx].equals(maxCard)) {
        idx = generator.nextInt(HANDSIZE);
      }
      return idx;
    } else {
      return generator.nextInt(HANDSIZE);
    }

  }
}