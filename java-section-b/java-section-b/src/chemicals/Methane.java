package chemicals;

import domain.producttypes.CompositChemical;
import java.util.Set;

public class Methane extends CompositChemical {

  public Methane(Carbon carbon1, Hydrogen hydrogen1, Hydrogen hydrogen2) {
    super(Set.of(carbon1, hydrogen1, hydrogen2));
  }
}
