/*
from: http://winterbe.com/posts/2015/04/07/java8-concurrency-tutorial-thread-executor-examples/
*/
import java.util.concurrent.*;
import java.util.*;
public class ScheduledExecutorPrac {
	public static void main(String... args) throws InterruptedException, ExecutionException {
		System.out.println("=== (1) ScheduledExecutorService schedule example===");
		ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
		Runnable task = () -> System.out.println(" - Scheduling: " + System.nanoTime());
		ScheduledFuture<?> future = executor.schedule(task, 3, TimeUnit.SECONDS);

		TimeUnit.MILLISECONDS.sleep(1337);

		long remainingDelay = future.getDelay(TimeUnit.MILLISECONDS);
		System.out.printf(" - Remaining Delay: %sms", remainingDelay);

		

		System.out.println();

		System.out.println("=== (2) ScheduledExecutorService schedule-at-fixed-rate example===");
		int initialDelay = 0;
		int period = 1;
		executor.scheduleAtFixedRate(task, initialDelay, period, TimeUnit.SECONDS);
		TimeUnit.MILLISECONDS.sleep(6000);

		System.out.println();

		System.out.println("=== (3) ScheduledExecutorService schedule-with-fixed-delay example===");

		Runnable taskWithDelay = () -> {
		    try {
		        TimeUnit.SECONDS.sleep(2);
		        System.out.println(" - (with delay) Scheduling: " + System.nanoTime());
		    }
		    catch (InterruptedException e) {
		        System.err.println("task interrupted");
		    }
		};

		initialDelay = 0;
		period = 1;
		executor.scheduleWithFixedDelay(taskWithDelay, initialDelay, period, TimeUnit.SECONDS);
		TimeUnit.MILLISECONDS.sleep(6000);


		executor.shutdownNow();
	}
}