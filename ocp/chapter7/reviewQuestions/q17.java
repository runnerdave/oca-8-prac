import java.util.concurrent.*;
import java.util.concurrent.atomic.*;
import java.util.stream.*;
import java.util.*;

public class q17 {

	/*
	What is the result of calling the following method?
	
	A. It outputs 100 99.
	B. It outputs 100 100.
	C. The output cannot be determined ahead of time.
	D. The code will not compile because of line w1.
	E. The code will not compile because of line w2.
	F. The code will not compile because of line w3.
	G. It compiles but throws an exception at runtime.

	answer:
	The code compiles and runs without issue, so D, E, F, and G are incorrect. 
	The key aspect to notice in the code is that a single-thread executor is used, 
	meaning that no task will be executed concurrently. Therefore, the results are valid and 
	predictable with 100 100 being the output, and B is the correct answer. 
	If a pooled thread executor was used with at least two threads, 
	then the sheepCount2++ operations could overwrite each other, 
	making the second value indeterminate at the end of the program. 
	In this case, C would be the correct answer.

	*/
	
	private static AtomicInteger sheepCount1 = new AtomicInteger(0); // w1 
	private static int sheepCount2 = 0;
		
	public static void main(String[] args) throws InterruptedException { 
		ExecutorService service = null;
		try {
			service = Executors.newSingleThreadExecutor(); // w2
			for(int i=0; i<100; i++)
				service.execute(() ->
					{sheepCount1.getAndIncrement(); sheepCount2++;}); // w3
			Thread.sleep(100);
			System.out.println(sheepCount1+" "+sheepCount2); 
		} finally {
			if(service != null) service.shutdown(); 
		}
	}
	

}