package aeroplane;

public class CrewPassenger extends Passenger {

  public CrewPassenger(String firstName, String lastName) {
    super(firstName, lastName);
  }

  @Override
  boolean isAdult() {
    return true;
  }

  @Override
  public String toString() {
    return "[CREW] " + super.toString();
  }

}
