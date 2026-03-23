class StrongBox<E> {

  private E item;
  private int attemptCount;
  private final KeyType keyType;

  enum KeyType {
    PADLOCK(1024),
    BUTTON(10000),
    DIAL(30000),
    FINGERPRINT(1000000);

    private final int requiredAttempts;

    private KeyType(int requiredAttempts) {
      this.requiredAttempts = requiredAttempts;
    }

    public int getRequiredAttempts() {
      return this.requiredAttempts;
    }
  }

  public StrongBox(KeyType keyType) {
    this.keyType = keyType;
  }

  public void put(E item) {
    this.item = item;
  }

  public E get() {
    this.attemptCount++;
    if (this.attemptCount < this.keyType.getRequiredAttempts()) {
      return null;
    }
    return this.item;
  }
}
