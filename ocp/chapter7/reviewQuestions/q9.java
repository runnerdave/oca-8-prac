//<div class="ansText"></div>

import java.util.concurrent.*;


public class q9 {
    /*
    Assuming MyTask is an abstract class that implements the ForkJoinTask interface,
    what statements about the following code are true? (Choose all that apply.)

    A. The code correctly finds the minimum value in the array.
    B. MyTask inherits RecursiveAction.
    C. MyTask inherits RecursiveTask.
    D. The code produces a ForkJoinPool at runtime.
    E. The class produces single-threaded performance at runtime.
    F. The code does not compile.

    Answer:

     The code compiles without issue, so F is incorrect. Note that the compute() method is protected in the parent class,
     although you can override it with public without issue since this is a more accessible modifier. Since compute()
     returns a value, RecursiveTask must be inherited instead of RecursiveAction, so C is correct and B is incorrect.
     The code does correctly find the minimum value on a non-empty array without entering an infinite loop,
     so A is correct and D is incorrect. Finally, since the code calls join() immediately after fork(),
     causing the process to wait, it does not perform any faster if there are 100 threads versus 1 thread,
     so E is also correct.

     */
}

class FindMin extends MyTask {
    private Integer[] elements;
    private int a;
    private int b;

    public FindMin(Integer[] elements, int a, int b) {
        this.elements = elements;
        this.a = a;
        this.b = b;
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        Integer[] elements = new Integer[]{8, -3, 2, -54};
        MyTask task = new FindMin(elements, 0, elements.length-1); ForkJoinPool pool = new ForkJoinPool(1);
        //original line: Integer sum = pool.invoke(task);
        Integer sum = (Integer) pool.invoke(task);
        System.out.println("Min: " + sum);
    }

    public Integer compute() {
        if ((b - a) < 2)
            return Math.min(elements[a], elements[b]);
        else {
            int m = a + ((b - a) / 2);
            System.out.println(a + "," + m + "," + b);
            MyTask t1 = new FindMin(elements, a, m);
            //original line: int result = t1.fork().join();
            int result = (int) t1.fork().join();
            return Math.min(new FindMin(elements, m, b).compute(), result);
        }
    }

    @Override
    public Object getRawResult() {
        return null;
    }

    @Override
    protected void setRawResult(Object value) {

    }

    @Override
    protected boolean exec() {
        return false;
    }
}

abstract class MyTask extends ForkJoinTask {
}