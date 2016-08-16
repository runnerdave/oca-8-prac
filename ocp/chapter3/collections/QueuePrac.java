import java.util.*;
public class QueuePrac {
	public static void main(String... a) {
		Queue<Integer> queue = new ArrayDeque<>();
		System.out.println(queue.offer(10));// true 
		System.out.println(queue.offer(4));// true

		System.out.println(queue);	

		System.out.println(queue.peek());// 10
		System.out.println("After peek" + queue);	

		System.out.println(queue.poll());// 10
		System.out.println("After poll" + queue);

		System.out.println(queue.poll());// 4
		System.out.println("After poll" + queue);
		
		System.out.println(queue.peek());// null

		System.out.println(queue);		
	}

}