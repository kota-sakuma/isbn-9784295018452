package monster;

record Monster(String name, int hp, boolean isBoss) {
  public Monster {
    if (hp < 0) {
      throw new IllegalArgumentException("hp must not be negative");
    }
  }
}
