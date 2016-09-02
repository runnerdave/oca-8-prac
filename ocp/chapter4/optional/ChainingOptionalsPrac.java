import java.util.*;
public class ChainingOptionalsPrac {
	public static void main(String... args) {
		System.out.println("============Chaining methods in optional");
		threeDigit(Optional.of(123));
		threeDigit(Optional.of(1234));//does nothing

		System.out.println("============Mapping a String to a Integer");		
		Optional<Integer> result = Optional.of("pedro").map(String::length);
		result.ifPresent(System.out::println);

		result = calculator("pedro");//this time with a method
		result.ifPresent(System.out::println);

		//trying with a method reference
		//result = Optional.of("pedro").map(ChainingOptionalsPrac::calculator);// DOES NOT COMPILE 
		/*
			The problem is that calculator returns Optional<Integer>. The map() method adds
			another Optional, giving us Optional<Optional<Integer>>
		*/
		result = Optional.of("pedro").flatMap(ChainingOptionalsPrac::calculator);
		result.ifPresent(System.out::println);
	}

	private static void threeDigit(Optional<Integer> optional) {
		optional.map(n -> "" + n) // part 1
		.filter(s -> s.length() == 3) // part 2
		.ifPresent(System.out::println); // part 3
	}

	private static Optional<Integer> calculator(String s) {
		return Optional.of(s).map(String::length);
	}
}