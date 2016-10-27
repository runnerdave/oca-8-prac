import java.util.concurrent.*;
import java.util.concurrent.atomic.*;
import java.util.stream.*;
import java.util.*;
/*
from: http://winterbe.com/posts/2015/04/30/java8-concurrency-tutorial-synchronized-locks-examples/


*/
public class AtomicPrac {

	static int count = 0;

	static void increment() {
		count++;
	}

	public static void main(String... args) {			
		incrementAndGetExample();
		updateAndGetExample();		
		accumulateAndGetExample();   
		longAdderExample(); 	
		longAccumulator();
	}

	public static void updateAndGetExample() {
		System.out.println("===Example of a AtomicInteger with a more complex operation===");
		AtomicInteger atomicInt = new AtomicInteger(0);
		//atomicInt.set(0);

        ExecutorService executor = Executors.newFixedThreadPool(2);

        IntStream.range(0, 1000)
                .forEach(i -> {
                    Runnable task = () ->
                            atomicInt.updateAndGet(n -> n + 2);
                    executor.submit(task);
                });

        ConcurrentUtils.stop(executor);

        System.out.format("Update: %d\n", atomicInt.get());
	}

	public static void incrementAndGetExample() {
		System.out.println("===Example of a AtomicInteger vs a regular int===");
		ExecutorService executor = Executors.newFixedThreadPool(2);

		AtomicInteger aInt = new AtomicInteger(0);

		IntStream.range(0, 1000)
    		.forEach(i -> {
    						executor.submit(aInt::incrementAndGet);
    						executor.submit(()->increment());
    					});

		ConcurrentUtils.stop(executor);

		System.out.println(aInt.get());    // => 1000		
		System.out.println(count);    // => 100something	
	}

	public static void accumulateAndGetExample() {
		System.out.println("===Example of a AtomicInteger accumulation===");
		AtomicInteger atomicInt = new AtomicInteger(0);

		ExecutorService executor = Executors.newFixedThreadPool(2);

		IntStream.range(0, 4)
		    .forEach(i -> {
		        Runnable task = () ->
		            atomicInt.accumulateAndGet(i, (n, m) -> n + m);
		        executor.submit(task);
		    });

		ConcurrentUtils.stop(executor);

		System.out.println(atomicInt.get());    // => 
	}

	public static void longAdderExample() {
		System.out.println("===Example of a long adder===");

		LongAdder adder = new LongAdder();

		ExecutorService executor = Executors.newFixedThreadPool(2);

		IntStream.range(0, 1000)
		    .forEach(i -> executor.submit(adder::increment));

		ConcurrentUtils.stop(executor);

		System.out.println(adder.sumThenReset());   // => 1000
	}

	public static void longAccumulator() {
		System.out.println("===Example of a long accumulator===");

		java.util.function.LongBinaryOperator op = (x, y) -> 2 * x + y;
		LongAccumulator accumulator = new LongAccumulator(op, 1L);

		ExecutorService executor = Executors.newFixedThreadPool(2);

		IntStream.range(0, 4)
		    .forEach(i -> executor.submit(() -> accumulator.accumulate(i)));

		ConcurrentUtils.stop(executor);

		System.out.println(accumulator.getThenReset());     // => 2539
	}
}