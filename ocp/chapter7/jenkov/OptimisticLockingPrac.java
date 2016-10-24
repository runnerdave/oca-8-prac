import java.util.concurrent.atomic.AtomicLong;
/*
The code shown in the below is called optimistic locking. 
Optimistic locking is different from traditional locking, sometimes also called pessimistic locking. 
Traditional locking blocks the access to the shared memory with a synchronized block or a lock of 
some kind. A synchronized block or lock may result in threads being suspended.

Optimistic locking allows all threads to create a copy of the shared memory without any blocking. 
The threads may then make modifications to their copy, and attempt to write their modified version 
back into the shared memory. If no other thread has made any modifications to the shared memory, 
the compare-and-swap operation allows the thread to write its changes to shared memory. 
If another thread has already changed the shared memory, the thread will have to obtain a new copy, 
make its changes and attempt to write them to shared memory again.

The reason this is called optimistic locking is that threads obtain a copy of the data they want to 
change and apply their changes, under the optimistic assumption that no other thread will have 
made changes to the shared memory in the meantime. When this optimistic assumption holds true, 
the thread just managed to update shared memory without locking. When this assumption is false, 
the work was wasted, but still no locking was applied.

Optimistic locking tends to work best with low to medium contention on the shared memory. 
If the content is very high on the shared memory, threads will waste a lot of CPU cycles 
copying and modifying the shared memory only to fail writing the changes back to the shared memory. 
But, if you have a lot of content on shared memory, you should anyways consider redesigning your code 
to lower the contention.

from: http://tutorials.jenkov.com/java-concurrency/non-blocking-algorithms.html

*/
public class OptimisticLockingPrac {
	public static void main(String... args) {
		System.out.println("===Example of optimistic locking===");
		AtomicCounter hs = new AtomicCounter();
		System.out.println("AtomicCounter initial value:" + hs.count());
		hs.inc();
		System.out.println("AtomicCounter incremented value:" + hs.count());
	}
}

class AtomicCounter {
    private AtomicLong count = new AtomicLong(0);

    public void inc() {
        boolean updated = false;
        while(!updated){
            long prevCount = this.count.get();
            updated = this.count.compareAndSet(prevCount, prevCount + 1);
        }
    }

    public long count() {
        return this.count.get();
    }
}