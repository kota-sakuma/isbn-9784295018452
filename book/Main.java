import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {

  public static void main(String[] args) {
    List<Book> books =
        new ArrayList<>(
            List.of(
                new Book("Java", LocalDate.of(2020, 1, 1), "Learning Java"),
                new Book("Python", LocalDate.of(2021, 2, 2), "Learning Python"),
                new Book("C++", LocalDate.of(2022, 3, 3), "Learning C++")));
    books.sort(Comparator.comparing(Book::getTitle));
    for (Book book : books) {
      System.out.printf("%s %s %s%n", book.getTitle(), book.getPublishedDate(), book.getComment());
    }
  }
}
