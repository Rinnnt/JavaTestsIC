package aeroplane;

public class BusinessClassPassenger extends NonCrewPassenger {

  private final Luxury luxury;

  public BusinessClassPassenger(String firstName, String lastName, int age, Luxury luxury) {
    super(firstName, lastName, age);
    this.luxury = luxury;
  }

  @Override
  public String toString() {
    return "[BUSINESS CLASS] " + super.toString() + " Luxury: " + luxury;
  }

}
