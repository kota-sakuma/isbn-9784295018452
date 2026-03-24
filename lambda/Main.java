package lambda;

import java.util.function.BiFunction;
import java.util.function.Function;

public class Main {

  public static void main(String[] args) {
    Function<Integer, Boolean> isOdd = x -> x % 2 == 1;
    BiFunction<Integer, String, String> passCheck =
        (point, name) -> name + " is " + (point > 65 ? "passed" : "failed");

    System.out.println(isOdd.apply(1));
    System.out.println(passCheck.apply(65, "John"));
    System.out.println(passCheck.apply(80, "Jane"));
  }
}
