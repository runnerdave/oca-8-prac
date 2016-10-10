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

		int length = wordStream.map(s -> s.length())
									.mapToInt(Integer::new)
									.sum();
 
		System.out.println(length);

		wordStream = list.stream();
		Stream<Integer> lengthStream = wordStream.map(s -> s.length());
		Optional<Integer> sum = lengthStream.reduce((x, y) -> x + y);
		//Optional<Integer> sum = lengthStream.reduce(Integer::sum);
		sum.ifPresent(System.out::println);


	}
}