//34.Assuming an implementation of the calculateFuture() method is provided prior to runtime, 
//which of the following are possible results of executing the following application? (Choose all that apply.)

import java.util.*;
import java.util.concurrent.*;
import java.util.stream.*;
public class FuturePrac {
    public static void calculateFuture(int seed) {
         // IMPLEMENTATION OMITTED   
    }   

    public static void seeFuture(Future<?> f) {
        try {
                System.out.println(f.get(100, TimeUnit.DAYS)); // i1      
        } catch (Exception e) {
                System.out.println("Problem");      
        }   
    }   

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService service = Executors.newSingleThreadExecutor();      
        final List<Future<?>> results = new ArrayList<>();      
        IntStream.range(10, 15)
                   .forEach(i -> results.add(
                               service.submit(() -> calculateFuture(i)))); // i2      
        results.stream().forEach(f -> seeFuture(f));      
        service.shutdown();   
    }

}

/*
    A.It outputs a number five times.
    B.It outputs a String value five times.
    C.It outputs a null value five times.
    D.It outputs Problem five times.
    E.It hangs indefinitely at runtime.
    F.It throws an unhandled exception at runtime.
    G.The code will not compile because of line i1.
    H.The code will not compile because of line i2.

    explanation:
    The code compiles and runs without issue, so G and H are incorrect. 
    The return type of calculateFuture() is void, so the submit() is interpreted as being applied to a Runnable value. 
    In this manner, the Future<?> can only return null or throw an exception; 
    therefore C and D are correct and A and B are incorrect. 
    The get() method we used takes a parameter that will wait up to 100 days for a result. 
    While this may seem like a lot of time, it is not the same as hanging indefinitely; 
    therefore E is incorrect. 
    Finally, any exception thrown in calculateFuture() will appear as an exception in the get() operation. 
    Since the get() operations are caught in a try/catch block in seeFuture(), none of them will be unhandled, and F is incorrect.

*/