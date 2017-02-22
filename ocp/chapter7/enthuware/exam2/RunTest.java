
//Q29. What will the following code print when run?


public class RunTest {
    public static volatile int counter = 0;
    static class RunnerDec implements Runnable{
        public void run(){
            for(int i=0;i<5000; i++){
                counter--;
            }
        }
    }

    static class RunnerInc implements Runnable{
        public void run(){
            for(int i=0;i<5000; i++){
                counter++;
            }
        }
    }
    
    public static void main(String[] args) {
        RunnerDec rd = new RunnerDec();
        RunnerInc ri = new RunnerInc();
        Thread t1 = new Thread(rd);
        Thread t2 = new Thread(ri);
        t1.start();
        t2.start();
        try{
            t1.join();
            t2.join();
        }catch(Exception e){
            e.printStackTrace();
        }
        System.out.println(counter);
    }
    
}

/*
a. It will always print 0.
b. It may print any number between -5000 to 5000.
c. It may print any number between -5000 to 5000 except 0.
d. The program will keep running for ever.

answer b
Making variable counter volatile only ensures that if it is updated by one thread, 
another thread will see the updated value. 
However, it still does not ensure that the increment and decrement operations 
will be done atomically. Thus, it is possible that while one thread is performing 
counter++, another thread corrupts the value by doing counter--. 
Because of this corruption, it is not possible to determine the final value of counter.

about the join:

The main thread is calling join on t1 and t2. Therefore, the join condition is 
between main and t1 (and then main and t2). There is no ordering between t1 and t2. 
It is the main thread that will pause until t1 finishes. It will then pause for t2 
to finish. It is possible that t2 finishes before t1 because t2 doesn't join on t1.


*/
