package domain.agents;

import domain.MarketPlace;

public class Consumer extends Agent {

  public Consumer(int thinkingTimeInMillis, MarketPlace marketPlace) {
    super(thinkingTimeInMillis, marketPlace);
  }

  @Override
  protected void doAction() {
    //TODO for Question 3
    marketPlace.buyPlasticGood().ifPresent(good -> {
      think();
      marketPlace.disposePlasticGood(good);
    });
  }
}
