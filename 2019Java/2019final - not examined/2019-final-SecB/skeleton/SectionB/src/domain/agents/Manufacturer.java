package domain.agents;

import domain.MarketPlace;
import domain.goods.PlasticGood;
import domain.goods.RawPlastic;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Manufacturer extends Agent {

  private final int neededRawPlasticBatches;
  private final List<RawPlastic> rawPlastics;

  public Manufacturer(int neededRawPlasticBatches, int thinkingTimeInMillis,
      MarketPlace marketPlace) {
    super(thinkingTimeInMillis, marketPlace);
    if (neededRawPlasticBatches < 1) {
      throw new IllegalArgumentException();
    }
    this.neededRawPlasticBatches = neededRawPlasticBatches;
    rawPlastics = new ArrayList<>();
  }

  @Override
  protected void doAction() {
    //TODO for Question 3
    while (rawPlastics.size() < neededRawPlasticBatches) {
      Optional<RawPlastic> plastic = marketPlace.buyRawPlastic();
      if (plastic.isPresent()) {
        rawPlastics.add(plastic.get());
      } else {
        think();
      }
    }
    marketPlace.sellPlasticGood(new PlasticGood(rawPlastics));
    rawPlastics.clear();
  }
}
