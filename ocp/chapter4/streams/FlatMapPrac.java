import java.util.*;
import java.util.function.*;
import java.util.stream.*;
public class FlatMapPrac {
	public static void main(String... a) {
		/*
		Quiz 5.2: Mapping
		1. Given a list of numbers, how would you return a list of the square of each number? For example, given [1, 2, 3, 4, 5] you should return [1, 4, 9, 16, 25].
		*/
		List<Integer> ints = Arrays.asList(1, 2, 3, 4, 5);
		System.out.println(ints);
		System.out.println("square them up!");
		System.out.println(ints.stream().map(s->Integer.valueOf(s*s)).collect(Collectors.toList()));

		/*
		2. Given two lists of numbers, how would you return all pairs of numbers? 
		For example, given a list [1, 2, 3] and a list [3, 4] 
		you should return [(1, 3), (1, 4), (2, 3), (2, 4), (3, 3), (3, 4)]. 
		For simplicity, you can represent a pair as an array with two elements.
		*/
		List<Integer> ints1 = Arrays.asList(1, 2, 3);
		List<Integer> ints2 = Arrays.asList(3, 4);
		List<int[]> pairs = ints1.stream()
								 .flatMap(i->ints2.stream()
												  .map(j->new int[]{i,j}))
								 .collect(Collectors.toList()); 
		System.out.println("combine these two arrays: [1, 2, 3] and [3, 4]");						 
		//System.out.println(pairs);
		// for (int[] pair : pairs) {
		// 	System.out.println(Arrays.toString(pair));
		// }
		String pairList = pairs.stream().map(pair->Arrays.toString(pair)).collect(Collectors.joining(","));
		System.out.println(pairList);

		/*
		3. How would you extend the previous example to return only pairs whose sum is divisible by 3? 
		For example, (2, 4) and (3, 3) are valid.
		*/
		List<int[]> pairsFilteredMySolution = ints1.stream()
								 .flatMap(i->ints2.stream()
												  .map(j->new int[]{i,j}))
								 .filter(pair->(pair[0] + pair[1])%3 == 0)
								 .collect(Collectors.toList()); 
		List<int[]> pairsFilteredBookSolution = ints1.stream()
								 .flatMap(i->ints2.stream()
								 				  .filter(j->(i+j)%3 == 0)
												  .map(j->new int[]{i,j}))
								 .collect(Collectors.toList());			
		System.out.println("filter only the pairs whose sum is divisible by 3");		
		System.out.println(pairsFilteredMySolution.stream()
									    .map(pair->Arrays.toString(pair))
									    .collect(Collectors.joining(",")));				 
		System.out.println(pairsFilteredBookSolution.stream()
									    .map(pair->Arrays.toString(pair))
									    .collect(Collectors.joining(",")));				 
	}
}