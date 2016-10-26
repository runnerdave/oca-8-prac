import java.util.concurrent.*;
import java.util.concurrent.locks.*;
import java.util.stream.*;
import java.util.*;
/*
from: http://winterbe.com/posts/2015/04/30/java8-concurrency-tutorial-synchronized-locks-examples/

When you execute this code sample you'll notice that both read tasks have to wait the whole second 
until the write task has finished. After the write lock has been released both read tasks are executed 
in parallel and print the result simultaneously to the console. They don't have to wait for each other 
to finish because read-locks can safely be acquired concurrently as long as no write-lock is held by 
another thread.
*/
public class ReadWriteLocksPrac {
	int count = 0;
	Map<String, String> map = new HashMap<>();
	ReadWriteLock lock = new ReentrantReadWriteLock();

	public static void main(String... args) {
		ReadWriteLocksPrac de = new ReadWriteLocksPrac();

		System.out.println("===Example of a read and write situation===");
		ExecutorService executor = Executors.newFixedThreadPool(2);

		executor.submit(() -> {
		    de.lock.writeLock().lock();
		    try {
		        ConcurrentUtils.sleep(1);
		        de.map.put("foo", "bar");
		    } finally {
		        de.lock.writeLock().unlock();
		    }
		});

		Runnable readTask = () -> {
		    de.lock.readLock().lock();
		    try {
		        System.out.println(de.map.get("foo"));
		        ConcurrentUtils.sleep(1);
		    } finally {
		        de.lock.readLock().unlock();
		    }
		};

		executor.submit(readTask);
		executor.submit(readTask);

		ConcurrentUtils.stop(executor);

	}
}