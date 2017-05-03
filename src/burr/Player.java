package burr;

/**
 * Represents a player and their properties
 * @author Matthew Burr
 * @version 1.0
 * @since 2017-05-02
 */
public class Player {
  private String name;
  private int health;
  private int mana;
  private int gold;



  /**
   * Displays the Player
   */
  public void display() {
    System.out.format("Player: %s%n", name);
    System.out.format("Health: %s%n", health);
    System.out.format("Mana: %s%n", mana);
    System.out.format("Gold: %s%n", gold);
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getHealth() {
    return health;
  }

  public void setHealth(int health) {
    this.health = health;
  }

  public int getMana() {
    return mana;
  }

  public void setMana(int mana) {
    this.mana = mana;
  }

  public int getGold() {
    return gold;
  }

  public void setGold(int gold) {
    this.gold = gold;
  }
}
