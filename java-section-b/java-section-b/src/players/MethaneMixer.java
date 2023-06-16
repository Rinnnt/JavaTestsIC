package players;

import chemicals.Carbon;
import chemicals.Hydrogen;
import chemicals.Methane;
import domain.Player;
import exchange.Exchange;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MethaneMixer extends Player {

  private List<Hydrogen> hydrogens;
  private List<Carbon> carbons;

  public MethaneMixer(int thinkingTimeInMillis, Exchange exchange) {
    super(thinkingTimeInMillis, exchange);
    hydrogens = new ArrayList<>();
    carbons = new ArrayList<>();
  }

  @Override
  public void doAction() {
    // TODO: Q3
    while (hydrogens.size() < 2) {
      Optional<Hydrogen> hydrogen = exchange.buyHydrogen();
      hydrogen.ifPresent(hydrogens::add);
    }
    while (carbons.size() < 1) {
      Optional<Carbon> carbon = exchange.buyCarbon();
      carbon.ifPresent(carbons::add);
    }
    exchange.sellMethane(new Methane(carbons.remove(0), hydrogens.remove(0), hydrogens.remove(0)),
        this);
  }
}
