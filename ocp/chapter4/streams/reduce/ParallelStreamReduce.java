import java.util.*;
import java.util.stream.*;
class ParallelStreamReduce {
	public static void main(String... args) {

		//Identify correct statements about the following code:  

		List<String> vals = Arrays.asList("a", "b"); 
		String join = vals.parallelStream()
						.reduce("_",
								(a, b)->a.concat(b)
								);
		System.out.println(join);

		/*
		a. It will always print _ab
		b. It will always print either _ab or _ba
		c. It will print either _ab or _a_b
		d. It will print any of the following: _ab, _ba, _a_b,_b_a

		answer:
		c. Since we are creating a parallel stream, it is possible for both the elements of the stream to be 
		processed by two different threads. In this case, the identity argument will be used to reduce both 
		the elements. Thus, it will print _a_b.
		It is also possible that the result of the first reduction ( _a ) is reduced further using 
		the second element (b). In this case, it will print _ab. 

		Even though the elements may be processed out of order individualy in different threads, 
		the final output will be produced by joining the individual reduction results in the same order. 
		Thus, the output can never have b before a.
		*/

		List<String> vals2 = Arrays.asList("a", "b", "c", "d", "e", "f", "g", 
						"a", "b", "c", "d", "e", "f", "g", 
						"a", "b", "c", "d", "e", "f", "g", 
						"a", "b", "c", "d", "e", "f", "g"); 
		String join2 = vals2.parallelStream() 
						.peek(System.out::println) //this shows how the elements are retrieved from the stream 
						.reduce("_", 
							(a, b)->{ System.out.println("reducing "+a+" and "+b+" Thread: "+Thread.currentThread().getName()); 
								return a.concat(b); 
						}, 
							(a, b)->{ System.out.println("combining "+a+" and "+b+" Thread: "+Thread.currentThread().getName()); 
								return a.concat(b); 
						} ); 
						System.out.println(join2); 
	}
}