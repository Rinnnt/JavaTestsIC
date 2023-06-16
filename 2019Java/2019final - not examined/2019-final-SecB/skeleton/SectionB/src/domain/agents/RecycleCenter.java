package domain.agents;

import domain.MarketPlace;
import domain.goods.RawPlastic;
import domain.goods.RawPlastic.Origin;

public class RecycleCenter extends Agent {

  private int newPlastics;
  private int recycledPlastics;

  public RecycleCenter(int thinkingTimeInMillis, MarketPlace marketPlace) {
    super(thinkingTimeInMillis, marketPlace);
    newPlastics = 0;
    recycledPlastics = 0;
  }

  @Override
  protected void doAction() {
    //TODO for Question 3
    marketPlace.collectDisposedGood().ifPresent(good -> {
      for (RawPlastic plastic : good.getBasicMaterials()) {
        if (plastic.origin == Origin.NEW) {
          newPlastics++;
        } else {
          recycledPlastics++;
        }
      }
      for (int i = 0; i < newPlastics + (recycledPlastics / 2); i++) {
        marketPlace.sellRawPlastic(new RawPlastic(Origin.RECYCLED));
      }
      newPlastics = 0;
      recycledPlastics = recycledPlastics % 2;
    });
  }
}
