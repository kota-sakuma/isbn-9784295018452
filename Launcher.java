import java.lang.reflect.Method;
import java.util.Arrays;

class Launcher {

  private static final double BYTES_PER_MB = 1024 * 1024;

  public static void main(String[] args) throws Exception {
    // Check if the arguments are valid
    if (args.length != 2) {
      System.out.println("Usage: java Launcher <FQCN> <E|I>");
      System.exit(1);
    }

    // Get the class and launch method
    Class<?> clazz = Class.forName(args[0]);
    LaunchMethod launchMethod = LaunchMethod.valueOf(args[1].toUpperCase());

    int exitCode = run(clazz, launchMethod);

    System.exit(exitCode);
  }

  private enum LaunchMethod {
    E,
    I
  }

  private static int run(Class<?> clazz, LaunchMethod launchMethod) throws Exception {
    printCurrentMemoryUsageMb();
    printClassMethods(clazz);

    int exitCode = launch(clazz, launchMethod);

    printCurrentMemoryUsageMb();
    return exitCode;
  }

  private static void printCurrentMemoryUsageMb() {
    Runtime runtime = Runtime.getRuntime();
    long usedMemory = runtime.totalMemory() - runtime.freeMemory();
    System.out.printf("Used Memory: %.2f MB%n", (double) usedMemory / BYTES_PER_MB);
  }

  private static void printClassMethods(Class<?> clazz) {
    Method[] methods = clazz.getMethods();
    Arrays.stream(methods).map(Method::getName).distinct().sorted().forEach(System.out::println);
  }

  private static int launch(Class<?> clazz, LaunchMethod launchMethod) throws Exception {
    switch (launchMethod) {
      case E -> {
        // Execute the class with ProcessBuilder
        ProcessBuilder processBuilder =
            new ProcessBuilder(
                "java", "-cp", System.getProperty("java.class.path"), clazz.getName());
        processBuilder.inheritIO();
        Process process = processBuilder.start();
        return process.waitFor();
      }
      case I -> {
        // Execute the class with the reflection
        Method mainMethod = clazz.getMethod("main", String[].class);
        mainMethod.invoke(null, (Object) new String[0]);
        return 0;
      }
      default -> throw new IllegalArgumentException("Invalid launch method: " + launchMethod);
    }
  }
}
