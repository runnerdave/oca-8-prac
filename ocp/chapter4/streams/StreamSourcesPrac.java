import java.util.*;
import java.util.stream.*;
import java.util.function.*;
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
		Stream<String> streamOfApes = Stream.of("monkey", "gorilla", "bonobo");
		Stream<String> infinite = Stream.generate(() -> "chimp");
		streamOfApes.findAny().ifPresent(System.out::println); // monkey
		infinite.findAny().ifPresent(System.out::println); // chimp

		System.out.println("=========allMatch(), anyMatch() and noneMatch():");
		List<String> stringList = Arrays.asList("monkey", "2", "chimp"); 
		Stream<String> infiniteChimps = Stream.generate(() -> "chimp"); 
		Predicate<String> pred = x -> Character.isLetter(x.charAt(0)); 
		System.out.println(stringList.stream().anyMatch(pred)); // true 
		System.out.println(stringList.stream().allMatch(pred)); // false 
		System.out.println(stringList.stream().noneMatch(pred)); // false 
		System.out.println(infiniteChimps.anyMatch(pred)); // true

		System.out.println("=========reduce:");
		Stream<Integer> ints = Stream.of(2,4,6);
		Optional<Integer> reduceValue = ints.reduce((c,d)->c*d);
		int reduceValueWithIdentity = Stream.of(2,4,6).reduce(1, (c,d)->c*d); //CANNOT REUSE ints
		System.out.println(reduceValue);
		System.out.println(reduceValueWithIdentity);

		System.out.println("=========collect:");
		Stream<String> wolfstream = Stream.of("w", "o", "l", "f"); 
		StringBuilder word = wolfstream.collect(StringBuilder::new,	StringBuilder::append, StringBuilder::append);
		System.out.println("word is:" + word);

		wolfstream = Stream.of("w", "o", "l", "f");
		TreeSet<String> set = wolfstream.collect(TreeSet::new, TreeSet::add, TreeSet::addAll);
		System.out.println(set); // [f, l, o, w]
	}
}