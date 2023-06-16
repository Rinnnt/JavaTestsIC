public class AvgEmergencyDialler extends EmergencyDialler {

  public AvgEmergencyDialler(Location location, Dialler dialler) {
    super(location, dialler);
  }

  @Override
  public void addToEmergencyContactList(Contact contact) {
    double distance = 0;
    for (Person person : contact.getPeople()) {
      distance += location.distanceTo(person.getAddress());
    }
    distance = distance / contact.getPeople().size();
    queue.add(distance, contact);
  }
}
