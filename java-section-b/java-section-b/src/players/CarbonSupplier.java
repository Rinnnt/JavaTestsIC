package players;

import chemicals.Carbon;
import domain.Player;
import exchange.Exchange;

public class CarbonSupplier extends Player {

  public CarbonSupplier(int thinkingTimeInMillis, Exchange exchange) {
    super(thinkingTimeInMillis, exchange);
  }

  @Override
  public void doAction() {
    // TODO: Q3
    exchange.sellCarbon(new Carbon(), this);
  }
}
