import java.util.stream.*;
import java.util.*;

public class IntStreamPrac {
	public static void main(String... args) {

		//What will the following code print when compiled and run?

		Stream<Integer> values = IntStream.rangeClosed(10, 15).boxed(); //1
		Object obj = values.collect(Collectors.partitioningBy(x->x%2==0)); //2
		System.out.println(obj);

		/*
		a. Compilation error at //1
		b. Compilation error at //2
		c. {[11, 13, 15], [10, 12, 14]}
		d. [[11, 13, 15], [10, 12, 14]]
		e. {false=[11, 13, 15], true=[10, 12, 14]}

		Answer:

		e.

		This code illustrates the use of Collectors.partitioningBy method. 
		This method takes a Predicate and returns Collector that distributes the elements of 
		the stream into two groups - one containing elements for which the Predicate returns true, 
		and another containing elements for which the Predicate returns false. 
		The return type is a Map containing two keys - true and false and the values are Lists of 
		the elements.  IntStream.rangeClosed(10, 15) creates an IntStream of int primitives 
		containing elements 10, 11, 12, 13, 14, and 15 (Observe that 15 is included). 
		IntStream does not support the various collect methods supported by a regular Stream of objects. 
		But it does support a boxed() method that returns a Stream<Integer> containing Integer objects.

		*/


		//prove that is a map

		Map map = (Map)obj;
		System.out.println("Map size:" + map.size());
	}
}