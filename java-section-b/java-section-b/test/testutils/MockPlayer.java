package testutils;

import domain.Player;
import exchange.Exchange;

public class MockPlayer extends Player {

  public MockPlayer(Exchange exchange) {
    this(1, exchange);
  }

  public MockPlayer(int thinkingTimeInMillis, Exchange exchange) {
    super(thinkingTimeInMillis, exchange);
  }

  @Override
  public void doAction() {}
}
