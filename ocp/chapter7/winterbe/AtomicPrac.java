import java.util.concurrent.*;
import java.util.concurrent.atomic.*;
import java.util.stream.*;
import java.util.*;
/*
from: http://winterbe.com/posts/2015/04/30/java8-concurrency-tutorial-synchronized-locks-examples/


*/
public class AtomicPrac {

	int count = 5;

	void increment() {
		count++;
	}

	public static void main(String... args) {

		AtomicPrac ap = new AtomicPrac();
		
		System.out.println("===Example of a AtomicInteger vs a regular int===");
		/*ExecutorService executor = Executors.newFixedThreadPool(10);

		AtomicInteger aInt = new AtomicInteger(5);

		IntStream.range(0, 1000)
    		.forEach(i -> {
    						executor.submit(aInt::incrementAndGet);
    						executor.submit(()->ap.increment());
    					});

		ConcurrentUtils.stop(executor);

		System.out.println(aInt.get());    // => 1005		
		System.out.println(ap.count);    // => 100something		

		System.out.println("===Example of a AtomicInteger vs a regular Integer with a more complex operation===");

		ExecutorService executor2 = Executors.newFixedThreadPool(10);
		AtomicInteger atoInt = new AtomicInteger(0);
		IntStream.range(0, 1000)
					//.peek(e->System.out.println("-atoInt:" + atoInt.get()))
				    .forEach(i -> {
				        Runnable task = () ->
				            atoInt.updateAndGet(n -> n + 2);
				        //System.out.println("i:" + i + "-atoInt:" + atoInt.get());
				        executor2.submit(task);
				    });

		System.out.println("final atoInt:" + atoInt.get());    // => 3005	

		ConcurrentUtils.stop(executor2);		*/    

		AtomicInteger atomicInt = new AtomicInteger(0);

		ExecutorService executor3 = Executors.newFixedThreadPool(2);

		IntStream.range(0, 1000)
		    .forEach(i -> {
		        Runnable task = () ->
		            atomicInt.updateAndGet(n -> n + 2);
		        executor3.submit(task);
		    });

		    System.out.println(atomicInt.get());    // => 2000

		    ConcurrentUtils.stop(executor3);	
	}
}