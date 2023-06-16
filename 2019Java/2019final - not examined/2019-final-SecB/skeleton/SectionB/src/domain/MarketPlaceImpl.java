package domain;

import domain.goods.ExchangeableGood;
import domain.goods.PlasticGood;
import domain.goods.RawPlastic;
import domain.goods.RawPlastic.Origin;
import java.util.Optional;
import utils.Queue;
import utils.SafeQueueFineGrained;


public class MarketPlaceImpl implements MarketPlace {

  private final boolean DEBUG_MESSAGES = true;
  private final Queue<RawPlastic> recycledPlastics;
  private final Queue<RawPlastic> rawPlastics;
  private final Queue<PlasticGood> plasticGoods;
  private final Queue<PlasticGood> disposedGoods;

  public MarketPlaceImpl() {
    recycledPlastics = new SafeQueueFineGrained<>();
    rawPlastics = new SafeQueueFineGrained<>();
    plasticGoods = new SafeQueueFineGrained<>();
    disposedGoods = new SafeQueueFineGrained<>();
  }

  public void sellRawPlastic(RawPlastic plasticItem) {
    if (DEBUG_MESSAGES) {
      System.out
          .println("Thread: " + Thread.currentThread().getId() + " - Sell plastic: " + plasticItem);
    }

    //TODO for Question 2
    if (plasticItem.origin == Origin.NEW) {
      rawPlastics.push(plasticItem);
    } else {
      recycledPlastics.push(plasticItem);
    }
  }

  public Optional<RawPlastic> buyRawPlastic() {
    //TODO for Question 2
    Optional<RawPlastic> plastic = recycledPlastics.pop();
    if (plastic.isPresent()) {
      return plastic;
    } else {
      return rawPlastics.pop();
    }
  }

  public void sellPlasticGood(PlasticGood good) {
    if (DEBUG_MESSAGES) {
      System.out.println("Thread: " + Thread.currentThread().getId() + " - Sell good: " + good);
    }
    //TODO for Question 2
    plasticGoods.push(good);
  }

  public Optional<PlasticGood> buyPlasticGood() {
    //TODO for Question 2
    return plasticGoods.pop();
  }

  public void disposePlasticGood(PlasticGood good) {
    if (DEBUG_MESSAGES) {
      System.out.println("Thread: " + Thread.currentThread().getId() + " - Dispose good: " + good);
    }
    //TODO for Question 2

    disposedGoods.push(good);
  }

  public Optional<PlasticGood> collectDisposedGood() {
    //TODO for Question 2
    return disposedGoods.pop();
  }
}
