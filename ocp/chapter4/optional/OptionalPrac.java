import java.util.*;
public class OptionalPrac {
	
	public static Optional<Double> average(int... scores) {
		if (scores.length == 0) return Optional.empty();
		int sum = 0;
		for (int score: scores) sum += score;
		return Optional.of((double) sum / scores.length);
	}

	public static void main(String... a) {
		System.out.println(average(90, 100)); // Optional[95.0]
		System.out.println(average()); // Optional.empty

		System.out.println(average().isPresent());
		System.out.println(average(45, 46, 47).isPresent());

		System.out.println(Optional.ofNullable(average()));
		System.out.println(Optional.ofNullable(average(45,46,47)));

		try {
			System.out.println(average(90, 100).get());//no exception thrown
			average().get();
		} catch(Exception e) {
			System.out.println("exception caught:" + e.getMessage());
		}

		average(40,20).ifPresent(System.out::println);
		average().ifPresent(System.out::println); //does nothing

		System.out.println(average().orElse(0.0));
		//System.out.println(average().orElse("nothing")); //DOES NOT COMPILE, incompatible types: String cannot be converted to Double

		System.out.println(average().orElseGet(()->0.0));
		//System.out.println(average().orElseGet(()->"nothing")); //DOES NOT COMPILE, incompatible types: String cannot be converted to Double

		System.out.println(Optional.of(2.0));

		try {
			System.out.println(average(90, 100).orElseThrow(Exception::new));//no exception thrown
			average().orElseThrow(()->new Exception("nothing"));
		} catch(Exception e) {
			System.out.println("exception caught:" + e.getMessage());
		}
	}
}