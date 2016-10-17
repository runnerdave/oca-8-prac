import java.util.*;
import java.util.stream.*;
public class CollectPracFromJavaAPI {
	/*
		<R> R collect(Supplier<R> supplier,
              BiConsumer<R,? super T> accumulator,
              BiConsumer<R,R> combiner)
		Performs a mutable reduction operation on the elements of this stream. 
		A mutable reduction is one in which the reduced value is a mutable result container, 
		such as an ArrayList, and elements are incorporated by updating the state of the result 
		rather than by replacing the result. This produces a result equivalent to:

		     R result = supplier.get();
		     for (T element : this stream)
		         accumulator.accept(result, element);
		     return result;
		 
		Like reduce(Object, BinaryOperator), collect operations can be parallelized without 
		requiring additional synchronization.

		This is a terminal operation.
	*/

	public static void main(String... args) {
		System.out.println("example of a list from the API:");
		Stream<String> stringStream = Stream.of("hola", "bola", "pepsicola");

		List<String> asList = stringStream.collect(ArrayList::new, ArrayList::add,
                                                ArrayList::addAll);

		System.out.println("As list:");
		System.out.println(asList);

		stringStream = Stream.of("hola", "bola", "pepsicola");
		String concat = stringStream.collect(StringBuilder::new, StringBuilder::append,
                                          StringBuilder::append)
                                 .toString();

        System.out.println("Concatenated:");
        System.out.println(concat);
	}
}