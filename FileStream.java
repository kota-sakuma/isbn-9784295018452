import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;

class FileStream {

  public static void main(String[] args) {
    validateArguments(args);

    copyFile(args[0], args[1]);
  }

  private static void validateArguments(String[] args) {
    if (args.length != 2) {
      throw new IllegalArgumentException("Usage: java FileStream <input file> <output file>");
    }
  }

  private static void copyFile(String inputFile, String outputFile) {
    try (FileInputStream in = new FileInputStream(inputFile);
        FileOutputStream out = new FileOutputStream(outputFile);
        GZIPOutputStream gzipOut = new GZIPOutputStream(out);
        BufferedOutputStream bufferedOut = new BufferedOutputStream(gzipOut)) {
      int data;
      while ((data = in.read()) != -1) {
        bufferedOut.write(data);
      }
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}
