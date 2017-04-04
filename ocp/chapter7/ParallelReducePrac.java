import java.util.stream.*;
import java.util.*;
public class ParallelReducePrac {
	
	public static void main(String... args) {
		System.out.println("example of concatenation and non associative accumulator:");
		String cc = Arrays.asList("w","o","l","f")
								.parallelStream()
								.reduce("X",String::concat);
		System.out.println("parallel concatenation");								
		System.out.println(cc);

		cc = Arrays.asList("w","o","l","f")
								.stream()
								.reduce("X",String::concat);

		System.out.println("sequential concatenation");								
		System.out.println(cc);								

		int calcParallel = Arrays.asList(1,2,3,4,5,6)
							.parallelStream()
							//.peek(System.out::println)
							.reduce(0,(a,b) -> (a-b)); // NOT AN ASSOCIATIVE ACCUMULATOR

		int calc = Arrays.asList(1,2,3,4,5,6)
							.stream()
							.reduce(0,(a,b) -> (a-b));

		System.out.println(calcParallel);
		System.out.println(calc);

	}

}