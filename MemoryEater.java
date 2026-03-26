import java.util.Locale;

class MemoryEater {

  private static final int ARRAY_SIZE = 1280000;

  public static void main(String[] args) {
    Locale locale = Locale.getDefault();
    printExecutingMessage(locale);

    long[] array = new long[ARRAY_SIZE];
    System.out.println(array.length);
  }

  private static void printExecutingMessage(Locale locale) {
    if (locale.equals(Locale.JAPAN)) {
      System.out.println("メモリを消費します...");
    } else {
      System.out.println("Consuming memory...");
    }
  }
}
