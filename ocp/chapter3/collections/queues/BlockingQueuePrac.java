import java.util.concurrent.*;

public class BlockingQueuePrac {
	//What is the result of calling the following method?

	public static void printData(BlockingDeque<Boolean> deque) throws InterruptedException {
	   deque.offerLast(true, 4, TimeUnit.MICROSECONDS);   
	   deque.offer(true);   
	   deque.offerFirst(false, 25, TimeUnit.SECONDS);   
	   System.out.print(deque.pollFirst(5, TimeUnit.DAYS));   
	   System.out.print(" "+deque.pollLast(2, TimeUnit.NANOSECONDS));
	}

	public static void main(String... args) throws InterruptedException {
		BlockingDeque<Boolean> deque = new LinkedBlockingDeque<>();
		printData(deque);
	}
}

/*
G
A.It outputs true false.
B.It outputs false true.
C.It outputs true true.
D.It outputs false false.
E.The code will not compile.
F.It compiles but throws an exception at runtime.
G.The output cannot be determined ahead of time.

G.
explanation:
The code compiles and runs without issue, although the deque may be blocked 
at runtime when the offerFirst(), offerLast(), pollFirst(), and pollLast() 
operations are called; therefore the answer is G. 
If it were not blocked and there were no other operations on the deque, 
then the output would be false true, and B would be correct.
*/