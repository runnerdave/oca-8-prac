import java.util.*;
import java.util.stream.*;

public class Book {
   private String title;
   private String genre;
   public Book(String title, String genre){
        this.title = title; this.genre = genre;
   }

   public String getGenre() {
   	return genre;
   }

   public String getTitle() {
   	return title;
   }

   public String toString() {
      return title + ":" + genre;
   }

   public static void main(String... args) {
   		//and the following code:

		List<Book> books = Arrays.asList(new Book("a","b"), new Book("c","d"), new Book("1","2"));

		Comparator<Book> c1 =  (b1, b2)->b1.getGenre().compareTo(b2.getGenre()); //1
		books.stream().sorted(c1.thenComparing(Book::getTitle)); //2
		System.out.println(books);

      //my own stuff
      Stream<Book> stream = books.stream().sorted(c1.thenComparing(Book::getTitle)); 
      System.out.println(stream.collect(Collectors.toList()));
      System.out.println(books);
      
		//Identify the correct statements.
   }
}

/*
a. It will print the list that is sorted by genre and then sorted by title within.
b. It will print the list that is sorted by title and then sorted by genre within.
c. It will print the list as it is.
d. Code will fail to compile because of code at //1.
e. Code will fail to compile because of code at //2.

answer c.

explanations:

1. Manipulating a stream doesn't manipulate the backing source of the stream. 
Here, when you chain the sorted method to a stream, it returns a reference to a 
Stream that appears sorted. The original List which was used to create the stream 
will remain as it is.  If you want to sort a List permanently, you should use one of 
the Collections.sort methods.  

2. There is another issue with this code. 
Stream.sorted is an intermediate operation. It will not be executed until a 
terminal operation is invoked on the stream. Therefore, in this case, the sorted 
method will not even be invoked.

Here, the argument to thenComparing is a method reference to a method that returns 
a String. This obviously does not capture Comparator interface. However, Comparator 
has three flavors of thenComparing method. One of them takes a Function (instead of 
a Comparator). It is this method that is being used here.  

public <U extends Comparable<? super U>> Comparator<T> thenComparing(Function<? super T,? extends U> keyExtractor) 
This method uses the supplied Function to get a value from the objects to be compared 
and then compares that value. The value returned by the function must be Comparable.

The third flavor of thenComparing is similar to the second except that the value 
returned by the function is compared using a given Comparator: 
public <U> Comparator<T> thenComparing(Function<? super T,? extends U> keyExtractor, Comparator<? super U> keyComparator) 
Returns a lexicographic-order comparator with a function that extracts a key to be compared with the given Comparator. 
This is useful when the value returned by the Function does not implement Comparable.

*/

