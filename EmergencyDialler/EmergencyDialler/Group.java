import java.util.HashSet;
import java.util.Set;

public class Group implements Contact {

  private final String name;
  private final Set<Contact> contacts;

  public Group(String name) {
    this.name = name;
    contacts = new HashSet<>();
  }

  public void add(Contact contact) {
    contacts.add(contact);
  }

  public void remove(Contact contact) {
    contacts.remove(contact);
  }

  @Override
  public Set<Person> getPeople() {
    Set<Person> people = new HashSet<>();
    for (Contact contact : contacts) {
      people.addAll(contact.getPeople());
    }
    return people;
  }

  @Override
  public String getName() {
    return name;
  }
}
