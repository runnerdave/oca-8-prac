import java.util.*;
import java.util.stream.*;

public class Q38 {
    public static void main(String... args) {
        
        //Assuming that Book has appropriate constructor and accessor methods, what will the following code print?

        List<Book> books = Arrays.asList(
                new Book("Freedom at Midnight", 5.0),
                new Book("Gone with the wind", 5.0),
                new Book("Midnight Cowboy", 15.0)
        );

        books.stream()
                  .filter(b->b.getTitle().startsWith("F"))
                  .forEach(b->b.setPrice(10.0));
        books.stream()
                  .forEach(b->System.out.println(b.getTitle()+":"+b.getPrice()));

   }

}

 class Book {
   private String title;
   private Double price;
   public Book(String title, Double price){
        this.title = title; this.price = price;
   }

   public Double getPrice() {
    return price;
   }

   public void setPrice(Double price) {
    this.price = price;
   }

   public String getTitle() {
    return title;
   }

   public String toString() {
      return title + ":" + price;
   }

   
}