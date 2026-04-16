package chapter07;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;
import java.util.ResourceBundle;

public class Main {
  public static void main(String[] args) {
    Properties properties = new Properties();

    // Read the properties file with UTF-8 encoding
    try (BufferedReader reader =
        Files.newBufferedReader(Paths.get("chapter07/pref.properties"), StandardCharsets.UTF_8)) {
      properties.load(reader);
      String capital = properties.getProperty("aichi.capital");
      String food = properties.getProperty("aichi.food");
      System.out.println(capital + ":" + food);
    } catch (IOException e) {
      e.printStackTrace();
    }

    // In the case of using ResourceBundle (7-2)
    ResourceBundle resourceBundle = ResourceBundle.getBundle("chapter07/pref");
    String capital = resourceBundle.getString("aichi.capital");
    String food = resourceBundle.getString("aichi.food");
    System.out.println(capital + ":" + food);

    // 7-3
    Employee employee = new Employee();
    employee.name = "田中太郎";
    employee.age = 41;
    Department department = new Department();
    department.name = "総務部";
    department.leader = employee;

    try (ObjectOutputStream outputStream =
        new ObjectOutputStream(new FileOutputStream("chapter07/company.dat"))) {
      outputStream.writeObject(department);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
