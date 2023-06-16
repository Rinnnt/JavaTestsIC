import java.util.Set;
import java.util.stream.Collectors;

public class Course {

  private final String name;
  private Set<Student> students;

  public Course(String name, Set<Student> students) {
    this.name = name;
    this.students = Set.copyOf(students);
  }

  public Set<Postgraduate> getPostgraduates(String nameOfSupervisor) {
    return students.stream()
        .filter(s -> s instanceof Postgraduate)
        .map(s -> (Postgraduate) s)
        .filter(s -> s.getSupervisor().name.equals(nameOfSupervisor))
        .collect(Collectors.toSet());
  }

}
