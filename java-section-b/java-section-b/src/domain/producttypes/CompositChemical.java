package domain.producttypes;

import java.util.Collections;
import java.util.Set;

public abstract class CompositChemical extends ExchangeableChemical {

  private final Set<Element> constituentMaterials;

  public CompositChemical(Set<Element> constituentMaterials) {
    this.constituentMaterials = Collections.unmodifiableSet(constituentMaterials);
  }

  public Set<Element> getConstituentMaterials() {
    return constituentMaterials;
  }

  @Override
  public String toString() {
    return "CompositChemical "
        + this.getClass().getName()
        + " ["
        + id
        + ", Materials: "
        + constituentMaterials
        + "]";
  }
}
