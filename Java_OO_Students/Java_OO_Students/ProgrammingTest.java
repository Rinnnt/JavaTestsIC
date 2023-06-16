import java.util.HashSet;
import java.util.Set;

public class ProgrammingTest {

  /* WRITE YOUR CODE HERE */

  public static void main(String[] args) {
    Set<Student> students = new HashSet<>();
    Academic ricardo = new Academic("Ricardo Rodriguez");
    Academic ismael = new Academic("Ismael Bento");
    Student student1 = new Undergraduate("gg4", "ggman", "gg4@ic.ac.uk", ricardo);
    Student student2 = new Undergraduate("pr3", "pr3man", "pr3@ic.ac.uk", ismael);
    Student student3 = new Postgraduate("te2", "te2man", "te2@ic.ac.uk", ricardo);
    Student student4 = new Postgraduate("yj34", "yj34man", "yj34@ic.ac.uk", ismael);
    Student student5 = new Postgraduate("jj8", "jj8man", "jj8@ic.ac.uk", ismael);

    students.add(student1);
    students.add(student2);
    students.add(student3);
    students.add(student4);
    students.add(student5);
    Course course = new Course("Programming Course", students);
    Set<Postgraduate> ismaels = course.getPostgraduates(ismael.getName());
    Notifier notifier = new Notifier(ismaels);
    notifier.doNotifyAll("You have been notified!");
  }

}
