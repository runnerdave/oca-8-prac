
import java.util.stream.*;
import java.util.*;

public class FunctionalVsImperative {
	public static void main(String... args) {
		//find the first of sqrt of first k prime numbers starting from n
		System.out.println("ComputeImperative: " + computeImperative(51, 101)); //should be 1759.17
		System.out.println("List primes:" + countPrimes(51,101));
		System.out.println("computeFunctional: " + computeFunctional(51, 101));
	}

	public static boolean isPrime(int number) {
		return number > 1 && IntStream.range(2, number)
									.noneMatch(i -> number % i == 0);
	}

	public static double computeFunctional(int n, int k) {
		return Stream.iterate(0, e -> e +1)
						.filter(FunctionalVsImperative::isPrime)
						.limit(k)
						.map(Math::sqrt)
						.reduce(0.0, Double::sum);
	}
	

	public static double computeImperative(int n, int k) {
		int index = 0;
		int count = 0;
		double total = 0;

		while(count<k) {
			if (isPrime(index)) {
				total += Math.sqrt(index);
				count++;
			}
			index++;
		}

		return total;
	}

	public static long countPrimes(int n, int k) {
		return IntStream.range(n, k).filter(s -> isPrime(s)).peek(System.out::println).count();
	}

	// public static double computeFunctional(int n, int k) {
	// 	return IntStream.range(n,n+1)
	// 					.
	// }
	
}