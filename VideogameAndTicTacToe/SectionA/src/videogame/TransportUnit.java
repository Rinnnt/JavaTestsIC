package videogame;

import java.util.HashSet;
import java.util.Set;

// TODO: complete this class as part of Section A Question 4
public class TransportUnit extends Entity {

  private static final int DAMPING_FACTOR = 2;

  Set<Entity> transporting;

  public TransportUnit(String name, int lifePoints) {
    super(name, lifePoints);
    transporting = new HashSet<>();
  }

  public void add(Entity entity) {
    transporting.add(entity);
  }

  @Override
  protected int propagateDamage(int damageAmount) {
    int damage = super.propagateDamage(damageAmount);
    for (Entity entity : transporting) {
      damage += entity.propagateDamage(damageAmount / DAMPING_FACTOR);
    }
    return damage;
  }

  @Override
  public int minimumStrikeToDestroy() {
    return Math.max(lifePoints, 2 * transporting.stream()
        .map(Entity::minimumStrikeToDestroy)
        .reduce(0, Math::max));
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append(super.toString());
    sb.append(" transporting: [");
    boolean first = true;
    for (Entity entity : transporting) {
      if (first) {
        first = false;
      } else {
        sb.append(", ");
      }
      sb.append(entity);
    }
    sb.append("]");
    return sb.toString();
  }
}
