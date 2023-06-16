package exchange;

import chemicals.Carbon;
import chemicals.Hydrogen;
import chemicals.Methane;
import domain.Player;
import java.util.Optional;

public interface Exchange {

  void sellHydrogen(Hydrogen item, Player player);

  Optional<Hydrogen> buyHydrogen();

  void sellCarbon(Carbon item, Player player);

  Optional<Carbon> buyCarbon();

  void sellMethane(Methane item, Player player);

  Optional<Methane> buyMethane();
}
