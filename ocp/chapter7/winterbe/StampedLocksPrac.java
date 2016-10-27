import java.util.concurrent.*;
import java.util.concurrent.locks.*;
import java.util.stream.*;
import java.util.*;
/*
from: http://winterbe.com/posts/2015/04/30/java8-concurrency-tutorial-synchronized-locks-examples/

Obtaining a read or write lock via readLock() or writeLock() returns a stamp which is later used 
for unlocking within the finally block. Keep in mind that stamped locks don't implement reentrant 
characteristics. Each call to lock returns a new stamp and blocks if no lock is available even if 
the same thread already holds a lock. So you have to pay particular attention not to run into deadlocks.

Both read tasks have to wait until the write lock has been released. Then both read tasks print to 
the console simultaneously because multiple reads doesn't block each other as long as no 
write-lock is held.
*/
public class StampedLocksPrac {
	int count = 0;
	Map<String, String> map = new HashMap<>();
	StampedLock lock = new StampedLock();

	public static void main(String... args) {
		StampedLocksPrac de = new StampedLocksPrac();

		System.out.println("===Example of a read and write situation with StampedLock===");
		ExecutorService executor = Executors.newFixedThreadPool(2);

		executor.submit(() -> {
		    long stamp = de.lock.writeLock();
		    try {
		        ConcurrentUtils.sleep(1);
		        de.map.put("foo", "bar");
		    } finally {
		        de.lock.unlockWrite(stamp);
		    }
		});

		Runnable readTask = () -> {
		    long stamp = de.lock.readLock();
		    try {
		        System.out.println(de.map.get("foo"));
		        ConcurrentUtils.sleep(1);
		    } finally {
		        de.lock.unlockRead(stamp);
		    }
		};

		executor.submit(readTask);
		executor.submit(readTask);

		ConcurrentUtils.stop(executor);

		/*
		Sometimes it's useful to convert a read lock into a write lock without unlocking and locking again. 
		StampedLock provides the method tryConvertToWriteLock() for that purpose as seen in the next sample.

		The task first obtains a read lock and prints the current value of field count to the console. 
		But if the current value is zero we want to assign a new value of 23. We first have to convert the read lock 
		into a write lock to not break potential concurrent access by other threads. Calling tryConvertToWriteLock() 
		doesn't block but may return a zero stamp indicating that no write lock is currently available. 
		In that case we call writeLock() to block the current thread until a write lock is available.
		*/

		System.out.println("===Example of a read and write situation with StampedLock and using tryConvertToWriteLock===");
		ExecutorService executor2 = Executors.newFixedThreadPool(2);
		StampedLock lock2 = new StampedLock();

		executor2.submit(() -> {
		    long stamp = lock2.readLock();
		    try {
		        if (de.count == 0) {
		            stamp = lock2.tryConvertToWriteLock(stamp);
		            if (stamp == 0L) {
		                System.out.println("Could not convert to write lock");
		                stamp = lock2.writeLock();
		            }
		            de.count = 23;
		        }
		        System.out.println(de.count);
		    } finally {
		        lock2.unlock(stamp);
		    }
		});

		ConcurrentUtils.stop(executor2);

	}
}