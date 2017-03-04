//in exam3

import java.util.*;
import java.util.stream.*;

public class Q75 {
	public static void main(String... args) {

		//what will the following code print?

		List<Book> books = Arrays.asList(
			new Book("Gone with the wind", 5.0),
			new Book("Gone with the wind", 10.0),
			new Book("Atlas Shrugged", 15.0) );

		books.stream().collect(Collectors.toMap((b->b.getTitle()), b->b.getPrice()))
				.forEach((a, b)->System.out.println(a+" "+b));

		//the above stream throws an exception for duplicate keys, to fix this the following can be done
		//with the Collectors.toMap(Function, Function, BinaryOperator) method. 
		//The third parameter is used to merge the duplicate entries to produce one entry. 
		//For example, in this case, you can do: 

		//Collectors.toMap(b->b.getTitle(), b->b.getPrice(), (v1, v2)->v1+v2) 

		// books.stream().collect(Collectors.toMap((b->b.getTitle()), b->b.getPrice(), (v1, v2)->v1+v2))
		// 		.forEach((a, b)->System.out.println(a+" "+b));

		//This Collector will sum the values of the entries that have the same key. 
		//Therefore, it will print : Gone with the wind 15.0 Atlas Shrugged 15.0
	}
}