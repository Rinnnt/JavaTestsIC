package generators;

public class HomogeneousPairGenerator<T> extends PairGenerator<T, T> {

  public HomogeneousPairGenerator(DataGenerator<T> firstGenerator,
      DataGenerator<T> secondGenerator) {
    super(firstGenerator, secondGenerator);
  }

}
