package videogame;

// TODO: complete this class as part of Section A Question 3
public class Magician extends Entity implements SpellCaster {

  private static final int STRENGTH_MULTIPLIER = 2;

  public Magician(String name, int lifePoints) {
    super(name, lifePoints);
  }
  @Override
  public int getStrength() {
    return STRENGTH_MULTIPLIER * lifePoints;
  }

  @Override
  protected int propagateDamage(int damageAmount) {
    return super.propagateDamage(damageAmount);
  }

  @Override
  public int minimumStrikeToDestroy() {
    return lifePoints;
  }

  @Override
  public String toString() {
    return super.toString();
  }
}