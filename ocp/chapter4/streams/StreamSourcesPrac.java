import java.util.*;
import java.util.stream.*;
public class StreamSourcesPrac {
	public static void main(String... a) {
		Stream<String> empty = Stream.empty(); // count = 0
		System.out.println("Empty stream count:" + empty.count());

		Stream<Integer> singleElement = Stream.of(1);
		System.out.println("single elemente stream count:" + singleElement.count());

		Stream<Integer> fromArray = Stream.of(1, 2, 3);
		System.out.println("stream from array count:" + fromArray.count());

		List<String> list = Arrays.asList("a", "b", "c");
		Stream<String> fromList = list.stream();
		System.out.println("stream from list count:" + fromList.count());

		Stream<String> fromListParallel = list.parallelStream();
		System.out.println("stream from fromListParallel count:" + fromListParallel.count());

		System.out.println("=========generate 5 random numbers:");
		Stream<Double> randoms = Stream.generate(Math::random);
		randoms.limit(5).forEach(System.out::println);

		System.out.println("=========iterate 5 odd numbers:");
		Stream<Integer> oddNumbers = Stream.iterate(1, n -> n + 2);
		oddNumbers.limit(5).forEach(System.out::println);

		System.out.println("=========return Optional<String> from min method call on stream:");
		Stream<String> s = Stream.of("monkey", "ape", "bonobo");
		Optional<String> min = s.min((s1, s2) -> s1.length()-s2.length());
		min.ifPresent(System.out::println); // ape

		System.out.println("=========return optional from min method call on empty stream:");
		Optional<?> minEmpty = Stream.empty().min((s1, s2) -> 0);
		System.out.println(minEmpty.isPresent()); // false

		System.out.println("=========findAny and findFirst:");
		Stream<String> s = Stream.of("monkey", "gorilla", "bonobo");
		Stream<String> infinite = Stream.generate(() -> "chimp");
		s.findAny().ifPresent(System.out::println); // monkey
		infinite.findAny().ifPresent(System.out::println); // chimp
	}
}