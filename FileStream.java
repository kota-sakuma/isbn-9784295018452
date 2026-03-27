import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

class FileStream {

  public static void main(String[] args) {
    // Validate the arguments
    if (args.length != 2) {
      System.out.println("Usage: java FileStream <input file> <output file>");
      System.exit(1);
    }

    // Get the input and output files
    String inputFile = args[0];
    String outputFile = args[1];

    // Copy the file
    copyFile(inputFile, outputFile);
  }

  private static void copyFile(String inputFile, String outputFile) {
    try (FileInputStream in = new FileInputStream(inputFile);
        FileOutputStream out = new FileOutputStream(outputFile)) {
      int data;
      while ((data = in.read()) != -1) {
        out.write(data);
      }
    } catch (IOException e) {
      System.out.println("Error copying file: " + e.getMessage());
      System.exit(1);
    }
  }
}
