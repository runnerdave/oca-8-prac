import java.util.concurrent.*;
import java.util.concurrent.atomic.*;
import java.util.stream.*;
import java.util.*;

public class q21 {

	/*
	Assuming an implementation of the performCount() method is provided prior to runtime, 
	which of the following are possible results of executing the following application? 
	(Choose all that apply.)

	A. It outputs a number 10 times.
	B. It outputs a Boolean value 10 times.
	C. It outputs a null value 10 times.
	D. It outputs Exception! 10 times.
	E. It hangs indefinitely at runtime.
	F. It throws an unhandled exception at runtime.
	G. The code will not compile because of line o1.
	H. The code will not compile because of line o2.

	answer:
	The code compiles and runs without issue, so G and H are incorrect. 
	The return type of performCount() is Integer, so the submit() is interpreted as being applied 
	to a Callable<Integer> value. In this manner, the Future<?> is really a Future<Integer> object. 
	One possible implementation of performCount() is just to return the input parameter; 
	therefore A is a correct answer. B is incorrect, because the return type is Integer, not Boolean. 
	The performCount() method could just return null, so C is a correct choice. 
	The performCount() can also throw a runtime exception; therefore D is also a correct answer. 
	It is also possible for our performCount() to hang indefinitely, such as in a deadlock. 
	This would cause Future.get() to hang in printResults(), making E also a correct answer. 
	Finally, any exception thrown in performCount() will appear as an exception in the get() operation. 
	Since the get() operations are caught in a try/catch block in printResults(), none of them will 
	be unhandled, and F is incorrect.

	*/
	
	public static Integer performCount(int exhibitNumber) { 
		// IMPLEMENTATION OMITTED
		return exhibitNumber; //I did this one myself, it could be another one that returns null
	}
	public static void printResults(Future<?> f) { 
		try {
			System.out.println(f.get()); // o1 
		} catch (Exception e) {
			System.out.println("Exception!"); }
		}
	public static void main(String[] args) throws InterruptedException, ExecutionException {
	ExecutorService service = Executors.newSingleThreadExecutor(); 
	final List<Future<?>> results = new ArrayList<>(); 
	IntStream.range(0, 10)
			.forEach(i -> results.add(
				service.submit(() -> performCount(i)))); // o2
	results.stream().forEach(f -> printResults(f));
	service.shutdown(); }
	

}