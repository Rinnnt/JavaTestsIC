package domain.producttypes;

public abstract class Element extends ExchangeableChemical {

  public Element() {}

  @Override
  public String toString() {
    return "Element " + this.getClass().getName() + " [" + id + "]";
  }
}
