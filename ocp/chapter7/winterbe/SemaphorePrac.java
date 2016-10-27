import java.util.concurrent.*;
import java.util.concurrent.locks.*;
import java.util.stream.*;
import java.util.*;
/*
from: http://winterbe.com/posts/2015/04/30/java8-concurrency-tutorial-synchronized-locks-examples/

In addition to locks the Concurrency API also supports counting semaphores. Whereas locks usually 
grant exclusive access to variables or resources, a semaphore is capable of maintaining whole sets 
of permits. This is useful in different scenarios where you have to limit the amount concurrent 
access to certain parts of your application.

Here's an example how to limit access to a long running task simulated by sleep(5):
*/
public class SemaphorePrac {

	public static void main(String... args) {
		System.out.println("===Example of a Semaphore===");
		ExecutorService executor = Executors.newFixedThreadPool(10);

		Semaphore semaphore = new Semaphore(5);

		Runnable longRunningTask = () -> {
		    boolean permit = false;
		    try {
		        permit = semaphore.tryAcquire(1, TimeUnit.SECONDS);
		        if (permit) {
		            System.out.println("Semaphore acquired");
		            ConcurrentUtils.sleep(5);
		        } else {
		            System.out.println("Could not acquire semaphore");
		        }
		    } catch (InterruptedException e) {
		        throw new IllegalStateException(e);
		    } finally {
		        if (permit) {
		            semaphore.release();
		        }
		    }
		};

		IntStream.range(0, 10)
		    .forEach(i -> executor.submit(longRunningTask));

		ConcurrentUtils.stop(executor);

		/*
		The executor can potentially run 10 tasks concurrently but we use a semaphore of size 5, 
		thus limiting concurrent access to 5. It's important to use a try/finally block to properly 
		release the semaphore even in case of exceptions.

		The semaphores permits access to the actual long running operation simulated by sleep(5) 
		up to a maximum of 5. Every subsequent call to tryAcquire() elapses the maximum wait 
		timeout of one second, resulting in the appropriate console output that no semaphore could be acquired.
		*/
	}
}