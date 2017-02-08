/*
* q32 - it does not compile, you need to fix it based on the options of the question first.
*/
import java.util.concurrent.*;


class ItemProcessor implements Runnable{  //LINE 1
    CyclicBarrier cb;
    public ItemProcessor(CyclicBarrier cb){
        this.cb = cb;
    }
    public void run(){
       System.out.println("processed");
        try {
            cb.await();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

class Merger implements Runnable{ //LINE 2
    public void run(){
        System.out.println("Value Merged");
    }
}

/**
* What should be inserted in the following code such that run method of Merger 
* will be executed only after the thread started at 4 and the main thread have both 
* invoked await?
* 
* a. Make ItemProcessor extend Thread instead of implementing Runnable and add 
* CyclicBarrier cb = new CyclicBarrier(1, m); to //LINE 3
* b. Make ItemProcessor extend Thread instead of implementing Runnable and add 
* CyclicBarrier cb = new CyclicBarrier(2, m); to //LINE 3
* c. Make Merger extend Thread instead of implementing Runnable and add 
* CyclicBarrier cb = new CyclicBarrier(1, m); to //LINE 3
* d. Make Merger extend Thread instead of implementing Runnable and add 
* CyclicBarrier cb = new CyclicBarrier(2, m); to //LINE 3
* e. Just add CyclicBarrier cb = new CyclicBarrier(1, m); to //LINE 3
* f. Just add CyclicBarrier cb = new CyclicBarrier(2, m); to //LINE 3
*
* Answer: b
*  1. ItemProcessor needs to extend Thread otherwise ip.start() will not compile. 
*  2. Since there are a total two threads that are calling cb.await 
* ( one is the ItemProcessor thread and another one is the main thread), 
* you need to create a CyclicBarrier with number of parties parameter as 2. 
* If you specify the number of parties parameter as 1, Merger's run will be invoke 
* as soon as the any thread invokes await but that is not what the problem statement wants.
*
* Explanation:
* Briefly, a CyclicBarrier allows multiple threads to run independently but wait at 
* one point until all of the coordinating threads arrive at that point. 
* Once all the threads arrive at that point, all the threads can then proceed. 
* It is like multiple cyclists taking different routes to reach a particular junction. 
* They may arrive at different times but they will wait there until everyone arrives. 
* Once everyone is there, they can go on futher independent of each other. 
*
* It is important for you to understand how CyclicBarrier works and is used. 
* Make sure you understand both the constructors of CyclicBarrier.
*
* Here are a few links that explain it quite well: 
* http://examples.javacodegeeks.com/core-java/util/concurrent/cyclicbarrier/java-util-concurrent-cyclicbarrier-example/
* https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/CyclicBarrier.html 
* http://www.sourcetricks.com/2014/09/java-cyclicbarrier.html#.VZIPPvlVif8
*    
*/

public class MergerPrac {
	public static void main(String[] args) throws Exception{
        Merger m = new Merger();

        //LINE 3

        ItemProcessor ip = new ItemProcessor(cb);
        ip.start(); //LINE 4
        cb.await();
    }
}