import java.util.*;
import java.util.stream.*;
import java.util.function.*;

//What is the output of the following?

public class GroupingByvsPartitioningBy {
	public static void main(String... args) {
		Stream<String> s = Stream.empty();
		Stream<String> s2 = Stream.empty();
		Predicate<String> condition = b -> b.startsWith("c");
		Map<Boolean, List<String>> p = s.collect(
		   Collectors.partitioningBy(condition));
	    Map<Boolean, List<String>> g = s2.collect(
	       //Collectors.groupingBy(b -> b.startsWith("c")));
	    	Collectors.groupingBy(condition));
	    System.out.println(p + " " + g);
	}
}
/*
Answer, it does not compile .

This question is really tricky. Did we catch you? 
The code b -> b.startsWith("c") can be passed directly to partitioningBy() or groupingBy(). 
Java will infer the right type and pass a Predicate to the former and a Function to the later. 
However, that's not what happens in this example. By actually creating a Predicate variable, 
the type has to match and the call to groupingBy() does not compile.

*/