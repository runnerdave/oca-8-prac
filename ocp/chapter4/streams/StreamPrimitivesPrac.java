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

    	System.out.println("========SummaryStatistics");
    	System.out.println(range(IntStream.of(6,5,6,7)));//2
	}

	private static int range(IntStream ints) { 
		IntSummaryStatistics stats = ints.summaryStatistics(); 
		if (stats.getCount() == 0) throw new RuntimeException(); 
		return stats.getMax()-stats.getMin();
	}
}