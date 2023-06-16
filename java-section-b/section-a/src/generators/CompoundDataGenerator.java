package generators;

import java.util.List;
import java.util.stream.Stream;

public class CompoundDataGenerator<T> implements DataGenerator<T> {

  private List<DataGenerator<T>> generators;
  private int idx;

  public CompoundDataGenerator(List<DataGenerator<T>> generators) {
    this.generators = generators;
    idx = 0;
  }

  @Override
  public T next() {
    if (idx < generators.size()) {
      return generators.get(idx).next();
    } else {
      throw new UnsupportedOperationException();
    }
  }

  @Override
  public boolean hasNext() {
    while (idx < generators.size()) {
      if (generators.get(idx).hasNext()) {
        return true;
      }
      idx++;
    }
    return false;
  }
}
