package burr;

/**
 * A driver class for the assignment
 */
public class Main {

  public static void main(String[] args) {
    // write your code here
    Player p1 = new Player();
    p1.setName("Matthew");
    p1.setHealth(100);
    p1.setMana(100);
    p1.setGold(50);
    p1.equip("Sword", 100);
    p1.equip("Armor", 500);
    p1.equip("Shield", 50);

    Game g = new Game(p1);

    String saveFile = "mygame.json";

    g.saveGame(saveFile);

    Game g2 = Game.loadGame(saveFile);

    g2.display();
  }
}
