import java.util.concurrent.*;
import java.util.concurrent.locks.*;
import java.util.stream.*;
/*
from: http://winterbe.com/posts/2015/04/30/java8-concurrency-tutorial-synchronized-locks-examples/
*/
public class LocksPrac {
	int count = 0;
	ReentrantLock lock = new ReentrantLock();

	public static void main(String... args) {
		LocksPrac de = new LocksPrac();

		System.out.println("===Example of a multithread problem===");
		ExecutorService executor = Executors.newFixedThreadPool(2);

		IntStream.range(0, 10000)
		    .forEach(i -> executor.submit(de::increment));

		ConcurrentUtils.stop(executor);

		System.out.println("Not synchronized:" + de.count);  // 9965

		de.count = 0;

		System.out.println("===Example of a solution with locks ===");

		ExecutorService executor2 = Executors.newFixedThreadPool(2);

		IntStream.range(0, 10000)
		    .forEach(i -> executor2.submit(de::incrementWithLock));

		ConcurrentUtils.stop(executor2);

		System.out.println("Synchronized with lock:" + de.count);  // 10000

		

		System.out.println("===Example of lock implementations ===");

		ExecutorService executor3 = Executors.newFixedThreadPool(2);

		executor3.submit(() -> {
		    de.lock.lock();
		    try {
		        ConcurrentUtils.sleep(1);
		    } finally {
		        de.lock.unlock();
		    }
		});

		executor3.submit(() -> {
		    System.out.println("Locked: " + de.lock.isLocked());
		    System.out.println("Held by me: " + de.lock.isHeldByCurrentThread());
		    boolean locked = de.lock.tryLock();
		    System.out.println("Lock acquired: " + locked);
		});

		ConcurrentUtils.stop(executor3);
	}

	void increment() {
	    count = count + 1;
	}

	void incrementWithLock() {
	    lock.lock();
	    try {
	        count++;
	    } finally {
	        lock.unlock();
	    }
	}
}