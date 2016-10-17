/*
* from: http://www.programcreek.com/2014/01/reduce-stream-examples/
*/
import java.util.*;
import java.util.stream.*;
public class ReducePrac1 {
	public static void main(String... a) {
		List<String> list = new ArrayList<String>();
		list.add("java");
		list.add("php");
		list.add("python");
		list.add("perl");
		list.add("c");
		list.add("lisp");
		list.add("c#");
		Stream<String> wordStream = list.stream();

		System.out.println("=====given the following list of languages:");

		list.forEach(System.out::println);

		System.out.println("=====calculate the total number of letters they add up to.");

		System.out.println("=====solving with map:");

		int length = wordStream.map(s -> s.length())
									.mapToInt(Integer::new)
									.sum();
 
		System.out.println(length);

		System.out.println("=====solving with reduce and optional:");

		wordStream = list.stream();
		Stream<Integer> lengthStream = wordStream.map(s -> s.length());
		Optional<Integer> sum = lengthStream.peek(System.out::println).reduce((x, y) -> x + y);
		//Optional<Integer> sum = lengthStream.reduce(Integer::sum); //can also be like this
		sum.ifPresent(System.out::println);

		System.out.println("=====solving with an identity value of 0:");

		wordStream = list.stream();
		lengthStream = wordStream.map(s -> s.length());
		int suma = lengthStream.reduce(0, (x, y) -> x + y);
		System.out.println(suma);

		System.out.println("=====solving with an identity, accumulator, combiner:");

		wordStream = list.stream();
		int s = wordStream.reduce(0, (x, y) -> x + y.length(), (x, y) -> x + y);
		System.out.println(s);

	}
}