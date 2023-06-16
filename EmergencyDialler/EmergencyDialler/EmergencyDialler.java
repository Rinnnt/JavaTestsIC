import java.util.Iterator;
import java.util.Queue;

public abstract class EmergencyDialler {

  protected PriorityQueue<Contact> queue;
  protected Location location;
  private final Dialler dialler;

  public EmergencyDialler(Location location, Dialler dialler) {
    this.location = location;
    this.dialler = dialler;
    queue = new LinkedListPriorityQueue<Contact>();
  }

  public Contact emergency() {
    int call = 0;
    for (Contact contact : queue) {
      call++;
      if (dialler.call(call, "HELP!")) {
        return contact;
      }
    }
    return null;
  }

  public abstract void addToEmergencyContactList(Contact contact);
}
