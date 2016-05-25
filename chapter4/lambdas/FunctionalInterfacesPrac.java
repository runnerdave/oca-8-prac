import java.util.function.*;
import java.util.concurrent.*;
public class FunctionalInterfacesPrac {

	public static void main(String... a) throws Exception {
		Predicate<Integer> isOdd = n -> n % 2 != 0;
		Predicate<Integer> isEven = (n) -> {return n % 2 == 0;};
		
		BiPredicate<Integer,Integer> firstHigherThanSecond = (h, l) -> h > l;
		BinaryOperator<Integer> sum = (x, y) -> x + y;

		Callable<Integer> callMe = () -> 42;
		Callable<Integer> callMeToo = () -> (432);
		Callable<Integer> callMeToo2 = () -> {return 4321;};
		Runnable runner = () -> { System.out.println("Hello World!"); };

		System.out.println("is 2 odd? " + isOdd.test(2));
		System.out.println("is 2 even? " + isEven.test(2));
		System.out.println("is 10 higher than 20? " + firstHigherThanSecond.test(10, 20));
		System.out.println("is 20 higher than 10? " + firstHigherThanSecond.test(20, 10));
		System.out.println("sum 1 and 1 " + sum.apply(1,1));
		System.out.println("callMe:" + callMe.call());
		System.out.println("callMeToo:" + callMeToo.call());
		System.out.println("callMeToo2:" + callMeToo2.call());
		runner.run();

	}

	
}
