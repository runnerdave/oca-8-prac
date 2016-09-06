import java.util.stream.*;
import java.util.*;
public class InfiniteStreamsPrac {
	public static void main(String... args) {

		//question 6 in ocp book
		System.out.println("=====Q6");
		Stream<String> s = Stream.generate(() -> "meow"); 
		boolean match = s.allMatch(String::isEmpty);
		//boolean match = s.anyMatch(String::isEmpty); //Hangs
		//boolean match = s.findAny(String::isEmpty); //WRONG SYNTAX, should be: Optional match = s.findAny();
		//boolean match = s.findFirst(String::isEmpty);//WRONG SYNTAX, should be: Optional match = s.findFirst();
		//boolean match = s.noneMatch(String::isEmpty); //HANGS
		System.out.println(match);

		/*
		11. What changes need to be made for this code to print the string 12345? (Choose all that apply.)
		Stream.iterate(1, x -> x++).limit(5).map(x -> x).collect(Collectors. joining());
			A. Change Collectors.joining() to Collectors.joining("").
			B. Change map(x -> x) to map(x -> "" + x).
			C. Change x -> x++ to x -> ++x.
			D. Add forEach(System.out::print) after the call to collect().
			E. Wrap the entire line in a System.out.print statement.
			F. None of the above. The code already prints 12345.
		*/
		System.out.println("=====Q11");
		System.out.print(Stream.iterate(1, x -> ++x).limit(5).map(x -> "" + x).collect(Collectors.joining("")));

		/*
		13. Which of the following is true?
		List<Integer> l1 = Arrays.asList(1, 2, 3); 
		List<Integer> l2 = Arrays.asList(4, 5, 6); 
		List<Integer> l3 = Arrays.asList(); 
		Stream.of(l1, l2, l3).map(x -> x + 1)
			.flatMap(x -> x.stream()).forEach(System.out::print);

			A. The code compiles and prints 123456.
			B. The code compiles and prints 234567.
			C. The code compiles but does not print anything.
			D. The code compiles but prints stream references.
			E. The code runs infinitely.
			F. The code does not compile.
			G. The code throws an exception
		*/
		System.out.println("=====Q13");
		//the solution is to invert map and flatmap
		List<Integer> l1 = Arrays.asList(1, 2, 3); 
		List<Integer> l2 = Arrays.asList(4, 5, 6); 
		List<Integer> l3 = Arrays.asList(); 
		Stream.of(l1, l2, l3)				
				.flatMap(x -> x.stream())
				.map(x -> x + 1)
				.forEach(System.out::print);
			

		

	}
}
