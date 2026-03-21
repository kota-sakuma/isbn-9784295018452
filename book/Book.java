import java.time.LocalDate;
import java.util.Objects;

public class Book implements Cloneable, Comparable<Book> {

  private String title;
  private LocalDate publishedDate;
  private String comment;

  public Book(String title, LocalDate publishedDate, String comment) {
    this.title = title;
    this.publishedDate = publishedDate;
    this.comment = comment;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Book)) return false;
    Book book = (Book) o;
    return Objects.equals(title, book.title) && Objects.equals(publishedDate, book.publishedDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(title, publishedDate);
  }

  @Override
  protected Book clone() {
    try {
      Book clone = (Book) super.clone();
      clone.title = title;
      clone.publishedDate = publishedDate;
      clone.comment = comment;
      return clone;
    } catch (CloneNotSupportedException e) {
      throw new AssertionError();
    }
  }

  @Override
  public int compareTo(Book o) {
    return this.publishedDate.compareTo(o.publishedDate);
  }

  public String getTitle() {
    return title;
  }

  public LocalDate getPublishedDate() {
    return publishedDate;
  }

  public String getComment() {
    return comment;
  }
}
