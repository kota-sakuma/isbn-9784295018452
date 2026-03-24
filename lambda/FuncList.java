package lambda;

class FuncList {

  static boolean isOdd(int x) {
    return x % 2 == 1;
  }

  String passCheck(int point, String name) {
    return name + " is " + (point >= 65 ? "passed" : "failed");
  }
}
