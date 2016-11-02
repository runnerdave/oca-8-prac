import java.util.concurrent.*;
import java.util.stream.*;
import java.util.*;

public class q8 {

	/*
	What statements about the following code are true? (Choose all that apply.)
	A. It outputs 1 6.
	B. It outputs 1 10.
	C. The code will not compile because of line y1.
	D. The code will not compile because of line y2.
	E. The code will not compile because of line y3.
	F. It compiles but throws an exception at runtime.
	G. The output cannot be determined ahead of time.
	H. It compiles but waits forever at runtime.
	*/
	public static void main(String... args) {
		Integer i1 = Arrays.asList(1,2,3,4,5).stream().findAny().get(); 
		synchronized(i1) { // y1
			Integer i2 = Arrays.asList(6,7,8,9,10) 
				.parallelStream()
				.sorted() // y2
				.findAny().get(); // y3
			System.out.println(i1+" "+i2); 
		}
	}
}