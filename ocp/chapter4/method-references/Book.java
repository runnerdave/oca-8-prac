import java.util.*;
/*
A java programer has written the following code:

*/

public class Book {
    private int id;
    private String title;
    private String genre;
    private String author;

    public Book(String title, String genre, String author){
        this.title = title; this.genre = genre; this.author = author;
    }

    String getGenre(){
      return genre;
    }

    String getTitle(){
      return title;
    }
    
    public static class BookFilter {
        //public boolean isFiction(Book b){ //original
        public static boolean isFiction(Book b){ 
            return b.getGenre().equals("fiction");
        }

    }

    public static void main(String... a) {
      //He wants to make use of the above code in another class as follows -

      List<Book> books = Arrays.asList(new Book("30 Days", "fiction", "K Larsen"),
            new Book("Fast Food Nation", "non-fiction", "Eric Schlosser"),
            new Book("Wired", "fiction", "D Richards"));
              
      books.stream()
          //.filter(new Book.BookFilter()) //LINE 10 -- original line
          //.filter(b->BookFilter.isFiction(b))//mysolution with lambda
          //.filter(BookFilter::isFiction)//mysolution with method reference
          .filter((Book b)->new BookFilter().isFiction(b))//my solution fixing the original line
          .forEach((Book b) -> System.out.print(b.getTitle()+", "));

      /*What changes mentioned below can he make independent of each other 
      so that the above code will print 30 Days, Wired ?
      a. Replace LINE 10 with: .filter((Book b)->Book.BookFilter::isFiction(b))

      b. Replace LINE 10 with: .filter((Book b)->new Book.BookFilter(b))

      c. Make the isFiction method in BookFilter class static 
      and replace LINE 10 with: .filter((Book b)->Book.BookFilter.isFiction(b))

      d. Make the isFiction method in BookFilter class static 
      and replace LINE 10 with: .filter(Book.BookFilter::isFiction)

      e. Add implements Predicate<Book> to BookFilter declaration.

      */

      /*
      Answer:

      c, d

      Explanation:
      The filter method of a stream expects a Predicate. So you can either write a class that implements
       Predicate and pass its instance to filter, or use a lambda expression to create a Predicate on the 
       fly. Option 3 shows a way to write such a lambda expression. 
       A simpler way to use a lambda expression would be: (Book b)->b.getGenre().equals("fiction") 
       In some cases, this approach is considered better because the filter condition can be changed 
       without disrupting much code.   Yet another way to do it is to make BookFilter class implement 
       Predicate interface:      
       static class BookFilter implements Predicate<Book>{
                public static boolean isFiction(Book b){
                     return b.getGenre().equals("fiction");
                  }         
                public boolean test(Book b) {
                             return isFiction(t);
                             //or return b.getGenre().equals("fiction");
                           }
                        } 
      This code reuses the isFiction method. But the test method can be eliminated altogether 
      using a method reference as shown in option 4.  

      You may check out the basics of method references here: https://docs.oracle.com/javase/tutorial/java/javaOO/methodreferences.html

      */

    }
    
}

