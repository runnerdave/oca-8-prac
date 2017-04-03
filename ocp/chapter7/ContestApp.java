/*Assuming that an implementation of the trackParticipants() method is provided prior to runtime, which of the following are possible results of executing this application? (Choose all that apply.)*/

import java.util.*;
import java.util.concurrent.*;
import java.util.stream.*;

public class ContestApp {
   public static Object trackParticipants(int count) {
         // IMPLEMENTATION OMITTED  
   		System.out.println("participant #:" + count);
         return new Object(); 
   }   

   public static void viewWinners(Future<?> f) {
         try {
                //System.out.println(f.get(100)); // a1 -- line commented out that makes the exercise
         		System.out.println(f.get());
         } catch (Exception e) {
                  System.out.println("No Winner");      
         }   
   }

   public static void main(String[] args) throws InterruptedException, 
   													ExecutionException {
         ExecutorService service = Executors.newSingleThreadExecutor();
         final List<Future<?>> results = new ArrayList<Future<?>>();      
         IntStream.range(100, 105)         
         	.forEach(i -> results.add(
         	            //service.submit(p -> trackParticipants(i)))); // a2  -- line commented out that makes the exercise
         				service.submit(() -> trackParticipants(i))));
         results.stream().forEach(f -> viewWinners(f));      
         service.shutdown();   
    }

}


/*

A.It outputs a number five times.
B.It outputs a Boolean value five times.
C.It outputs a null value five times.
D.It outputs No Winner five times.
E.It hangs indefinitely at runtime.
F.It throws an unhandled exception at runtime.
G.The code will not compile because of line a1.
H.The code will not compile because of line a2.

Answer is G, future has two get methods: get(long timeout,
      TimeUnit unit) and get()
  and H since service.submit receives Callable or Runnable, 
  which take no parameters. */