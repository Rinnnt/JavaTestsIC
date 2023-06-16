package aeroplane;

public abstract class NonCrewPassenger extends Passenger {

  private final int age;

  public NonCrewPassenger(String firstName, String lastName, int age) {
    super(firstName, lastName);
    if (age < 0) {
      throw new IllegalArgumentException("Age should be non-negative");
    }
    this.age = age;
  }

  @Override
  boolean isAdult() {
    return age >= 18;
  }

  @Override
  public String toString() {
    return super.toString() + " Age: " + age;
  }

}
