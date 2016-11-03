import java.util.concurrent.*;
import java.util.stream.*;
import java.util.*;

public class q14 {

	/*
	What is the result of calling the following method?
	
	A. It outputs 20 85.
	B. It outputs 103 85.
	C. It outputs 20 103.
	D. The code will not compile.
	E. It compiles but throws an exception at runtime.
	F. The output cannot be determined ahead of time.

	answer:
	The methods on line 5, 6, 7, and 8 each throw InterruptedException, which is a checked exception; 
	therefore the method does not compile and D is the only correct answer. 
	If the method signature was updated to include throws InterruptedException, then the answer would be F, 
	because the deque may be blocked at runtime when the offerFirst(),
	offerLast(), pollFirst(), and pollLast() operations are called. Finally, if they were not blocked and
	there were no other operations on the deque, then the output would be 20 85, 
	 and the answer would be A.

	*/
	public static void main(String... args) {
	// public static void main(String... args) throws InterruptedException {
		q14 o = new q14();
		BlockingDeque<Integer> bq = new LinkedBlockingDeque<Integer>();
		o.addAndPrintItems(bq);
	}

	public void addAndPrintItems(BlockingDeque<Integer> deque) {
	// public void addAndPrintItems(BlockingDeque<Integer> deque) throws InterruptedException {
		deque.offer(103);
		deque.offerFirst(20, 1, TimeUnit.SECONDS);
		deque.offerLast(85, 7, TimeUnit.HOURS);
		System.out.print(deque.pollFirst(200, TimeUnit.NANOSECONDS));
		System.out.print(" "+deque.pollLast(1, TimeUnit.MINUTES));
	}

}