package lambda;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Predicate;

public class Main {

  private static final int PASS_SCORE = 65;
  private static final int MIN_NAME_LENGTH = 4;
  private static final List<String> MEMBERS = List.of("John", "Jane", "Jimmy", "Jill");

  enum ExamResult {
    PASSED("passed"),
    FAILED("failed");

    private final String result;

    private ExamResult(String result) {
      this.result = result;
    }

    public String getResult() {
      return result;
    }
  }

  public static void main(String[] args) {
    Predicate<Integer> isOdd = x -> x % 2 == 1;
    BiFunction<Integer, String, String> passCheck =
        (point, name) ->
            name
                + " is "
                + (point >= PASS_SCORE ? ExamResult.PASSED : ExamResult.FAILED).getResult();

    System.out.println(isOdd.test(1));
    System.out.println(passCheck.apply(65, "John"));
    System.out.println(passCheck.apply(80, "Jane"));

    MEMBERS.stream().filter(name -> name.length() >= MIN_NAME_LENGTH).forEach(System.out::println);
  }
}
