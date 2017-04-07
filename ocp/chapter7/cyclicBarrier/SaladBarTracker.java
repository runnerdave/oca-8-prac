//51.What is the result of executing the following application? (Choose all that apply.)
import java.util.concurrent.*;

public class SaladBarTracker {
   public static void await(CyclicBarrier cb) {
         try {
                  cb.await();      
        } catch (InterruptedException | BrokenBarrierException e) {
                 // Handle exception      
        }   
    }   

    public static void main(String[] args) {
          CyclicBarrier cb = new CyclicBarrier(4,         
            () -> System.out.println("Salad bar empty")); // r1      
          ExecutorService service = Executors.newFixedThreadPool(4); // r2      
          for(int i=0; i<12; i++) {
                   service.submit(() -> await(cb)); // r3      
            }      
            service.shutdown();   
    }
}

/*
    A.It outputs Salad bar empty exactly once.
    B.It outputs Salad bar empty multiple times.
    C.The code will not compile because of line r1.
    D.The code will not compile because of line r2.
    E.The code will not compile because of line r3.
    F.It compiles but throws an exception at runtime.
    G.It compiles but waits forever at runtime.

    explanation:

    The code compiles without issue, so C, D, and E are incorrect. The limit of the cyclic barrier is 
    4, and since we are sending 12 tasks to it, it is activated a total of three times. Therefore, B is the correct answer, and A, F, and G are incorrect. 
    Note that the thread pool is also 4, which means that we have just enough threads to break the barrier. 
    For example, if our thread pool was 3, then the barrier would never be reached and G would be the correct answer.
*/