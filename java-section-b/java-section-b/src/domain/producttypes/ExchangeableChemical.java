package domain.producttypes;

import java.util.concurrent.atomic.AtomicInteger;

public abstract class ExchangeableChemical {

  private static final AtomicInteger nextUniqueId = new AtomicInteger(0);
  public final int id = ExchangeableChemical.nextUniqueId.getAndIncrement();

  @Override
  public final boolean equals(Object obj) {
    if (obj instanceof ExchangeableChemical) {
      return id == ((ExchangeableChemical) obj).id;
    }
    return false;
  }

  @Override
  public int hashCode() {
    return id;
  }
}
