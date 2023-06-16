package exchange;

import chemicals.Carbon;
import chemicals.Hydrogen;
import chemicals.Methane;
import datastructures.Stock;
import datastructures.StockImpl;
import domain.Player;
import domain.producttypes.ExchangeableChemical;
import java.util.Optional;

public class ExchangeImpl implements Exchange {

  private final Stock<Hydrogen> hydrogens;
  private final Stock<Carbon> carbons;
  private final Stock<Methane> methanes;

  public ExchangeImpl() {
    hydrogens = new StockImpl<>();
    carbons = new StockImpl<>();
    methanes = new StockImpl<>();
  }

  @Override
  public void sellHydrogen(Hydrogen item, Player player) {
    // TODO Q3
    hydrogens.push(item, player);
  }

  @Override
  public Optional<Hydrogen> buyHydrogen() {
    // TODO Q3
    return hydrogens.pop();
  }

  @Override
  public void sellCarbon(Carbon item, Player player) {
    // TODO Q3
    carbons.push(item, player);
  }

  @Override
  public Optional<Carbon> buyCarbon() {
    // TODO Q3
    return carbons.pop();
  }

  @Override
  public void sellMethane(Methane item, Player player) {
    // TODO Q3
    methanes.push(item, player);
  }

  @Override
  public Optional<Methane> buyMethane() {
    // TODO Q3
    return methanes.pop();
  }
}
