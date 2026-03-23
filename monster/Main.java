package monster;

import java.util.ArrayList;
import java.util.List;

public class Main {
  public static void main(String[] args) {
    List<Monster> monsters =
        new ArrayList<>(
            List.of(
                new Monster("Mushroom", 10, false),
                new Monster("Goblin", 25, false),
                new Monster("Dragon", 120, true)));
    printMonsters(monsters);
  }

  private static void printMonsters(List<Monster> monsters) {
    for (Monster monster : monsters) {
      System.out.printf("%s %d %b%n", monster.name(), monster.hp(), monster.isBoss());
    }
  }
}
