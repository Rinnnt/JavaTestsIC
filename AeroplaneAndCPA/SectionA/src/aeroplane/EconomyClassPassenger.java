package aeroplane;

public class EconomyClassPassenger extends NonCrewPassenger {

  public EconomyClassPassenger(String firstName, String lastName, int age) {
    super(firstName, lastName, age);
  }

  @Override
  public String toString() {
    return "[ECONOMY CLASS] " + super.toString();
  }
}
