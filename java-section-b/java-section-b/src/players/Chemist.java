package players;

import chemicals.Methane;
import domain.Player;
import exchange.Exchange;
import java.util.Optional;

public class Chemist extends Player {

  public Chemist(int thinkingTimeInMillis, Exchange exchange) {
    super(thinkingTimeInMillis, exchange);
  }

  @Override
  public void doAction() {
    // TODO: Q3
    Optional<Methane> methane = exchange.buyMethane();
    if (methane.isPresent()) {
      think();
    } else {
      return;
    }
  }
}
