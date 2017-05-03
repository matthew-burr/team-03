package burr;

import java.util.HashMap;
import java.util.Map;

/**
 * Represents a player and their properties
 * @author Matthew Burr
 * @version 2.0
 * @since 2017-05-03
 */
public class Player {
  private String name;
  private int health;
  private int mana;
  private int gold;
  private Map<String, Integer> equipment;


  public Player() {
    name = "Unspecified";
    health = 0;
    mana = 0;
    gold = 0;
    equipment = new HashMap<>();
  }
  /**
   * Displays the Player
   */
  public void display() {
    System.out.format("Player: %s%n", name);
    System.out.format("Health: %s%n", health);
    System.out.format("Mana: %s%n", mana);
    System.out.format("Gold: %s%n", gold);
    System.out.println("Equipment:");
    equipment.forEach((n, c) -> { System.out.format("\tName: %s; Cost: %d%n", n, c); });
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

  /**
   * Add a piece of equipment to the Player
   * @param name the name of the equipment
   * @param cost how much the equipment costs (in gold pieces)
   */
  public void equip(String name, int cost) {
    equipment.put(name, cost);
  }
}
