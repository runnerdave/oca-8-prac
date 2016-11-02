


import java.util.concurrent.*;
import java.util.concurrent.locks.*;
import java.util.*;

public class q12 {

	/*
	What statements about the following code are true? (Choose all that apply.)
	A. It compiles and runs without issue.
	B. The code will not compile because of m1.
	C. The code will not compile because of m2.
	D. The code will not compile because of m3.
	E. It compiles but throws an exception at runtime.
	F. It compiles but hangs at runtime.

	Answer:
	The program compiles without issue, so B, C, and D are incorrect. Lines m2 and m3
	 throw a compiler warning about generics but still compile. Notice that RecursiveAction, 
	 unlike RecursiveTask, does not return a value. However, since we used a generic ForkJoinTask
	 reference, the code still compiles. The issue here is that the base condition is not reached 
	 since the numbers start/end are consistently positive. This causes an infinite loop, 
	 although since memory is finite, Java detects this and throws a StackOverflowError, so E is correct. 
	 In practice, this could also generate a locking exception before the StackOverflowError
	  when the program runs out of memory, but in either circumstance, the program will exit.
	*/
}

class CountNumbers extends RecursiveAction {
	private int start;
	private int end;
	public CountNumbers(int start, int end) {
		this.start = start;
		this.end = end; 
	}
		
	protected void compute() { 
		if (start<0) return;		
		else {
			int middle = start + ((end - start) / 2);
			invokeAll(new CountNumbers(start, middle), new CountNumbers(middle, end)); // m1
		} 
	}
	public static void main(String[] args) { 
		ForkJoinTask<?> task = new CountNumbers(0, 4); // m2 
		ForkJoinPool pool = new ForkJoinPool();
		Object result = pool.invoke(task); // m3
	} 
}