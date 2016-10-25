import java.util.concurrent.*;
import java.util.stream.*;
public class NeedForSynchronizationPrac {
	public static void main(String... args) {
		NeedForSynchronizationPrac de = new NeedForSynchronizationPrac();

		System.out.println("===Example of a multithread problem===");
		ExecutorService executor = Executors.newFixedThreadPool(2);

		IntStream.range(0, 10000)
		    .forEach(i -> executor.submit(de::increment));

		ConcurrentUtils.stop(executor);

		System.out.println("Not synchronized:" + de.count);  // 9965

		de.count = 0;

		ExecutorService executor2 = Executors.newFixedThreadPool(2);

		IntStream.range(0, 10000)
		    .forEach(i -> executor2.submit(de::incrementSync));

		ConcurrentUtils.stop(executor2);

		System.out.println("Synchronized:" + de.count);  // 10000

		de.count = 0;

		ExecutorService executor3 = Executors.newFixedThreadPool(2);

		IntStream.range(0, 10000)
		    .forEach(i -> executor3.submit(de::incrementSyncBlock));

		ConcurrentUtils.stop(executor3);

		System.out.println("Synchronized block:" + de.count);  // 10000

	}

	int count = 0;

	void increment() {
	    count = count + 1;
	}

	synchronized void incrementSync() {
	    count = count + 1;
	}

	void incrementSyncBlock() {
	    synchronized (this) {
	        count = count + 1;
    }
}
}