import java.util.stream.*;
import java.util.*;
public class StreamPrimitivesPrac {
	public static void main(String... args) {
		System.out.println("========IntStream");
		Random rand = new Random();
		IntStream ints = rand.ints();
		ints.limit(3)
		    .forEach(System.out::println);

		System.out.println("========DoubleStream");
		DoubleStream doubles = DoubleStream.generate(Math::random);
		doubles.limit(3)
				.forEach(System.out::println);

		int random = (int)(Math.random() * 50); 
    	System.out.println(random);
	}
}