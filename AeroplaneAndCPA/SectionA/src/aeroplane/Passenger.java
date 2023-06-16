package aeroplane;

public abstract class Passenger {

	// TODO: Section A, Task 2

  private final String firstName;

  private final String lastName;

  public Passenger(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
  }

  abstract boolean isAdult();

  @Override
  public String toString() {
    return firstName + ", " + lastName;
  }

}
