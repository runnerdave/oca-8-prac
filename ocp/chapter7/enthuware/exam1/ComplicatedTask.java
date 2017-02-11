import java.util.concurrent.*;
/*Q74*/
class ComplicatedTask extends RecursiveTask<Integer>{
    int[] ia; int from; int to;
    public ComplicatedTask(int[] ia, int from, int to){
        this.ia = ia;
        this.from = from;
        this.to = to;
    }
    public int transform(int t){
      //this is a CPU intensive operation that
      //transforms t and returns the value
        return 1;
    }
    protected Integer compute() {
        if(from == to){
            return transform(ia[from]);
        }
        else if(from+1==to){
            return transform(ia[from])+transform(ia[to]);
        }
        else{
            
            int mid = (from+to)/2;
            ComplicatedTask newtask1 = new ComplicatedTask(ia, from, mid);
            ComplicatedTask newtask2 = new ComplicatedTask(ia, mid+1, to);
            newtask1.fork();

            int x = newtask2.compute();  //LINE A
            int y = newtask1.join(); //LINE B

            return x+y;
        }
    }
    /* TODO- it does not compile
    public static void main(String[] args) {
        int[] values = new int[10];
        ForkJoinTask<?> task = new ComplicatedTask(values,0,values.length);
        ForkJoinPool pool = new ForkJoinPool();
        int myResult = pool.invoke(task);
        // Print results
        System.out.println();
        System.out.print("Result: " + myResult);
    }
    */
}

/*
What will happen if LINE A and LINE B are flipped i.e. LINE B is moved before LINE A?

a. An exception will be thrown at run time.
b. There will not be any impact on the final answer but performance will be degraded.
c. There will be no impact on the final answer or the performance.
d. There will not be any impact on the final answer but the performance will be better.
e. The final answer will be incorrect.

answer c:
The order of join() and compute() is critical. Remember that fork() causes the sub-task to be submitted to the pool 
and another thread can execute that task in parallel to the current thread. Therefore, if you call join() on the
 newly created sub task, you are basically waiting until that task finishes. This means you are using up both the 
 threads (current thread and another thread from the pool that executes the subtask) for that sub task. Instead of 
 waiting, you should use the current thread to compute another subtask and when done, wait for another thread to 
 finish. This means, both the threads will execute their respective tasks in parallel instead of in sequence.  
 Therefore, even though the final answer will be the same, the performance will not be the same.
*/