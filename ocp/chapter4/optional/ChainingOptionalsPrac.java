import java.util.*;
public class ChainingOptionalsPrac {
	public static void main(String... args) {
		threeDigit(Optional.of(123));
	}

	private static void threeDigit(Optional<Integer> optional) {
		optional.map(n -> "" + n) // part 1
		.filter(s -> s.length() == 3) // part 2
		.ifPresent(System.out::println); // part 3
	}
}