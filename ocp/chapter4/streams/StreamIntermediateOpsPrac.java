import java.util.stream.*;
import java.util.*;
public class StreamIntermediateOpsPrac {
	public static void main(String... args) {

		System.out.println("========filter========");
		Stream<String> apes = Stream.of("chimp", "monkey", "gorilla");
		apes.filter(x->x.startsWith("m")).forEach(System.out::println);

		System.out.println("========distinct========");
		Stream<String> apesRepeated = Stream.of("chimp", "monkey", "gorilla", "monkey");
		apesRepeated.distinct().forEach(System.out::println);

		System.out.println("========skip and limit========");
		Stream<Integer> s = Stream.iterate(1, n -> n + 1); 
		s.skip(5).limit(2).forEach(System.out::println); // 6 7

		System.out.println("========flatMap========");
		List<String> zero = Arrays.asList();
		List<String> one = Arrays.asList("Bonobo");
		List<String> two = Arrays.asList("Mama Gorilla", "Baby Gorilla"); 
		Stream<List<String>> animals = Stream.of(zero, one, two);
		animals.flatMap(l -> l.stream()).forEach(System.out::println);

		System.out.println("========sort========");
		Stream<String> sortable = Stream.of("brown-", "bear-"); 
		sortable.sorted().forEach(System.out::println); // bear-brown-

		System.out.println("========sort with Comparator========");
		sortable = Stream.of("brown bear-", "grizzly-"); 
		sortable.sorted(Comparator.reverseOrder()).forEach(System.out::println); 
		//sortable.sorted(Comparator::reverseOrder); // DOES NOT COMPILE
	}
}