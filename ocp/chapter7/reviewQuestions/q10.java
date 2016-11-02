import java.util.concurrent.*;
import java.util.stream.*;
import java.util.*;

public class q10 {

	/*
	What statements about the following code are true? (Choose all that apply.)
	A. It compiles and runs without issue, outputting the total length of all strings in the stream.
	B. The code will not compile because of line q1. 
	C. The code will not compile because of line q2.
	D. The code will not compile because of line q3.
	E. It compiles but throws an exception at runtime.
	*/
	public static void main(String... args) {
		System.out.println(Arrays.asList("duck","chicken","flamingo","pelican") 
				.parallelStream().parallel() // q1
				.reduce(0,
				//original: (c1, c2) -> c1.length() + c2.length(), // q2 
				(c1, c2) -> c1 + c2.length(), // q2 fixed 
				(s1, s2) -> s1 + s2)); // q3
	}
}