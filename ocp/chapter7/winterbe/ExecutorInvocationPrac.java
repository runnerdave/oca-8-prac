/*
from: http://winterbe.com/posts/2015/04/07/java8-concurrency-tutorial-thread-executor-examples/
*/
import java.util.concurrent.*;
import java.util.*;
public class ExecutorInvocationPrac {
	public static void main(String... args) throws InterruptedException, ExecutionException {
		System.out.println("=== (1) Executor invokeAll example===");

		ExecutorService executor = Executors.newWorkStealingPool();
		List<Callable<String>> callables = Arrays.asList(
															() -> "task1",
															() -> "task2",
															() -> "task3"
														);
		executor.invokeAll(callables)
					.stream()
					.map(future -> {
						try {
							return future.get();
						}
						catch (Exception e) {
							throw new IllegalStateException(e);
						}
					})
					.forEach(System.out::println);

		System.out.println("=== (2) Executor invokeAny example===");

		executor = Executors.newWorkStealingPool();

		callables = Arrays.asList(
		    callable("task1", 2),
		    callable("task2", 1),
		    callable("task3", 3));

		String result = executor.invokeAny(callables);
		System.out.println(result);

	}

	static Callable<String> callable(String result, long sleepSeconds) {
	    return () -> {
	        TimeUnit.SECONDS.sleep(sleepSeconds);
	        return result;
	    };
	}

}