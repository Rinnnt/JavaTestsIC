package generators;

public class CollatzSequenceGenerator implements IntegerGenerator {

  private int number;

  public CollatzSequenceGenerator(int number) {
    this.number = number;
  }

  @Override
  public Integer next() {
    if (number == 4) {
      throw new UnsupportedOperationException();
    }
    int result = number;
    number = (number % 2 == 0) ? number / 2 : 3 * number + 1;
    return result;
  }

  @Override
  public boolean hasNext() {
    return number != 4;
  }
}
