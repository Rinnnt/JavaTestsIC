package generators;

public class MissingPrimesGenerator implements IntegerGenerator {

  private int number = 1;

  @Override
  public Integer next() {
    int result = number;
    do {
      number = number + 1;
    } while ((number % 2 == 0 && number % 5 != 0) ||  (number % 2 != 0 && number % 5 == 0));
    return result;
  }

  @Override
  public boolean hasNext() {
    return true;
  }
}
