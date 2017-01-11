import java.util.*;

public class DequePrac {
	public static void main(String... a) {

		//What will be the contents of d at the end of the following code?
		Deque<Integer> d = new ArrayDeque<>();
		d.push(1);
		d.offerLast(2); 
		d.push(3); 
		d.peekFirst();
		d.removeLast();
		d.pop();
		System.out.println(d);

		/*
			a. 1
			b. 2
			c. 3
			d. Exception at runtime
			e. It will not compile

			answer: a. 1
			push() is a stack method that adds the element to the front. 
			Therefore, the contents of d change as follows: 
			1 
			offer(e) is a queue method that adds the element to the end 
			and offerLast(e) is equivalent to offer(e). 
			So the deque now contains: 
			1, 2 
			push(3) changes it to: 
			3, 1, 2 
			Now, peek methods don't modify the structure, 
			therefore even though peekFirst returns 3, the deque doesn't change. 
			removeLast() removes the element from the end, so d now contains: 
			3, 1 
			pop() is a stack method that removes the element from the front. 
			Therefore, the contents of d change to: 1

			Explanation:
			Deque is an important class for the exam. To answer the questions, 
			you must remember that a Deque can act as a Queue as well as a Stack. 
			Based on this fact, you can deduce the following:  

			1. Queue is a FIFO structure (i.e. add to the end and remove from the front). 
			It has methods offer(e)/add(e) and poll()/remove() for this purpose. 
			Note that offer and add are similar while poll and remove are similar.  

			2. Stack is a LIFO structure (i.e. add to the front and remove from the front). 
			It provides methods push(e) and pop() for this purpose, where push adds to the front 
			and pop removes from the front.  Besides the above methods, Deque also has variations 
			of the above methods. But it is easy to figure out what they do:  
			
			pollFirst()/pollLast() - poll is a Queue method. 
			Therefore pollFirst and pollLast will remove elements from the front and 
			from the end respectively. 

			offerFirst(e)/offerLast(e) - offer is a Queue method. 
			Therefore offerFirst and offerLast will add elements to the front and to the end respectively. 
			
			addFirst(e)/addLast(e) - add is a Queue method. 
			Therefore addFirst and addLast will add elements to the front and to the end respectively.  
			
			peek(), peekFirst(): return the first element from the front of the queue 
			but does not remove it from the queue. 

			peekLast() : returns the last element from the end of the queue but does not remove it 
			from the queue.  Notice that there is no pushFirst(e) and pushLast(e).  

			You may wonder why there are multiple methods for the same thing such as offer(e) and add(e). 
			Well, they are not exactly same. add(e) throws an exception if the element cannot be added 
			to the queue because of lack of capacity, while offer(e) does not. 
			There are similar differences in other methods but they are not too important for the exam. 
		*/

	}
}