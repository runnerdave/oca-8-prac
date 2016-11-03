import java.util.concurrent.*;
import java.util.concurrent.atomic.*;
import java.util.stream.*;
import java.util.*;

public class q18 {

	/*
	What is the result of calling the following method?
	
	A. It outputs Stock Room Full!
	B. The code will not compile because of line j1.
	C. The code will not compile because of line j2.
	D. The code will not compile because of line j3.
	E. It compiles but throws an exception at runtime.
	F. It compiles but waits forever at runtime.

	answer:
	The code compiles without issue, so B, C, and D are incorrect. 
	The limit on the cyclic barrier is 10, but the stream can generate only up to 9 threads 
	that reach the barrier; therefore the limit can never be reached, and F is the correct answer, 
	making A and E incorrect. Note that even if the limit(9) statement was changed to limit(10), 
	the program could still hang, since the JVM might not allocate 10 threads to the parallel stream.

	*/
	
	public static void await(CyclicBarrier cb) { // j1
		try { cb.await(); } catch (InterruptedException | BrokenBarrierException e) {

		// Handle exception 
		}
	}

	public static void main(String[] args) {
		CyclicBarrier cb = new CyclicBarrier(10,
			() -> System.out.println("Stock Room Full!")); // j2
		IntStream.iterate(1, i -> 1).limit(9) 
			.parallel().forEach(i -> await(cb)); // j3
	}
	

}