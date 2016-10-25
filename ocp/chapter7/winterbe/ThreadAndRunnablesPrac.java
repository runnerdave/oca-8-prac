/*
from: http://winterbe.com/posts/2015/04/07/java8-concurrency-tutorial-thread-executor-examples/
*/
import java.util.concurrent.*;
public class ThreadAndRunnablesPrac {
	public static void main(String... args) {
		System.out.println("=== (1) Simple implementation of a thread using lambdas===");
		Runnable task = () -> {
			String threadName = Thread.currentThread().getName();
			System.out.println("(simple)Hello " + threadName);
		};

		task.run();

		Thread thread = new Thread(task);
		thread.start();

		System.out.println("Done!");

		System.out.println("=== (2) Simple implementation of a thread using lambdas and sleep===");

		Runnable runnable = () -> {
			try {
				String name = Thread.currentThread().getName();
				System.out.println("Foo " + name);
				TimeUnit.MILLISECONDS.sleep(500);
				System.out.println("Bar " + name);
			}
			catch (InterruptedException ie) {
				ie.printStackTrace();
			}
		};
		thread = new Thread(runnable);
		thread.start();

		System.out.println("=== (3) Simple implementation of a thread using lambdas and Executor===");
		ExecutorService exec = Executors.newSingleThreadExecutor();
		exec.submit(
			 () -> {
						String threadName = Thread.currentThread().getName();
						System.out.println("(executor)Hello " + threadName);
					}
		);
		System.out.println("===stopping executor after 10 seconds===");
		for (int i=0; i<10; i++) {
			System.out.println(i+1);
			try {
				TimeUnit.SECONDS.sleep(1);
			}
			catch (InterruptedException ie) {
				ie.printStackTrace();
			}
		}
		try {
		    System.out.println("attempt to shutdown executor");
		    exec.shutdown();
		    exec.awaitTermination(5, TimeUnit.SECONDS);
		}
		catch (InterruptedException e) {
		    System.err.println("tasks interrupted");
		}
		finally {
		    if (!exec.isTerminated()) {
		        System.err.println("cancel non-finished tasks");
		    }
		    exec.shutdownNow();
		    System.out.println("shutdown finished");
		}

		System.out.println("=== (4) Simple implementation of a thread using lambdas with Callable, Executor and Future===");

		Callable<Integer> callableTask = () -> {
			try {
				TimeUnit.SECONDS.sleep(5);
				return 123;
			}
			catch (InterruptedException ie) {
				throw new IllegalStateException("task interrupted", ie);
			}
		};
		exec = Executors.newFixedThreadPool(1);//equivalent to newSingleThreadExecutor but size of pool can be increased later
		Future<Integer> future = exec.submit(callableTask);
		System.out.println("future done? " + future.isDone());
		try {
			System.out.println("future value:" + future.get());
		} catch (ExecutionException | InterruptedException ee) {
			ee.printStackTrace();
		}
		System.out.println("future done? " + future.isDone());
		exec.shutdownNow();
		System.out.println("shutdown finished");

		System.out.println("=== (5) Simple implementation of a thread using lambdas with Callable, Executor and Future with Timeout===");
		exec = Executors.newFixedThreadPool(1);
		future = exec.submit(callableTask);		
		try {
			System.out.println("future value:" + future.get(1, TimeUnit.SECONDS));
		} catch (ExecutionException | InterruptedException | TimeoutException ee) {
			ee.printStackTrace();
		}
		exec.shutdownNow();
	}	
}