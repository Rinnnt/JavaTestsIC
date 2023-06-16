public class BuildEmergencyDialler {

  public static void main(String[] args) {
    EmergencyDialler em = new AvgEmergencyDialler(new Location(0, 0), new Dialler());
    Contact contact1 = new Person("Jensen", 4, 2, -9);
    Group contact2 = new Group("contact2");
    contact2.add(new Person("Jamil", 3, 0, 32));
    Group contact2_1 = new Group("contact2_1");
    contact2_1.add(new Person("Ji", 5, -4, 9));
    contact2_1.add(new Person("Jane", 2, -4, 1));
    contact2.add(contact2_1);
    Group contact3 = new Group("contact3");
    contact3.add(new Person("Joe", 1, 2, 3));
    em.addToEmergencyContactList(contact1);
    em.addToEmergencyContactList(contact2);
    em.addToEmergencyContactList(contact3);
    System.out.println("SUCCESS in calling: " + em.emergency().getName());;
  }

}
