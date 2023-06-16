package generators;

public class PairGenerator<S, T> implements DataGenerator<Pair<S, T>> {

  private DataGenerator<S> firstGenerator;
  private DataGenerator<T> secondGenerator;

  public PairGenerator(DataGenerator<S> firstGenerator, DataGenerator<T> secondGenerator) {
    this.firstGenerator = firstGenerator;
    this.secondGenerator = secondGenerator;
  }

  @Override
  public Pair<S, T> next() {
    if (!hasNext()) {
      throw new UnsupportedOperationException();
    }
    return new Pair<>(firstGenerator.next(), secondGenerator.next());
  }

  @Override
  public boolean hasNext() {
    return firstGenerator.hasNext() && secondGenerator.hasNext();
  }
}
