import java.util.*;
public class QueuePrac {
	public static void main(String... a) {

		System.out.println("=========queue example=============");
		Queue<Integer> queue = new ArrayDeque<>();
		System.out.println(queue.offer(10));// true 
		System.out.println(queue.offer(4));// true

		System.out.println(queue);	

		System.out.println("peek:" + queue.peek());// 10
		System.out.println("After peek" + queue);	

		System.out.println("poll:" + queue.poll());// 10
		System.out.println("After poll" + queue);

		System.out.println("poll:" + queue.poll());// 4
		System.out.println("After poll" + queue);
		
		System.out.println("peek:" + queue.peek());// null

		System.out.println(queue);		

		System.out.println("=========stack example=============");
		ArrayDeque<Integer> stack = new ArrayDeque<>();
		stack.push(10);
		stack.push(4);

		System.out.println(stack);	

		System.out.println("peek:" + stack.peek());// 10
		System.out.println("After peek" + stack);	

		System.out.println("poll:" + stack.poll());// 10
		System.out.println("After poll" + stack);

		System.out.println("poll:" + stack.poll());// 4
		System.out.println("After poll" + stack);
		
		System.out.println("peek:" + stack.peek());// null

		System.out.println(stack);

		System.out.println("offer 10:" + stack.offer(10));// true 
		System.out.println("offer 4:" + stack.offer(4));// true

		System.out.println(stack); //notice they are added to the back of the queue

	}

}