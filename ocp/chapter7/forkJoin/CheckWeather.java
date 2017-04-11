//12.What is the result of executing the following application? (Choose all that apply.)

import java.util.concurrent.*;

public class CheckWeather extends RecursiveTask { // j1   
    private int start;   
    private int end;   
    
    public CheckWeather(int start, int end) {
          this.start = start;      
          this.end = end;   
    }   

    protected void compute() { // j2
          if ((end-start)>2)
                   return;      
          else {
                   int middle = start + ((end-start) / 2);         
                   invokeAll(new CheckWeather(start, middle), new CheckWeather(middle, end)); // j3      
          }   
    }

    public static void main(String[] args) {
          ForkJoinTask task = new CheckWeather(0, 4);      
          ForkJoinPool pool = new ForkJoinPool();      
          pool.invoke(task);   
    }
}

/*
    A.It compiles and runs without issue.
    B.The code will not compile because of j1.
    C.The code will not compile because of j2.
    D.The code will not compile because of j3.
    E.It compiles but throws an exception at runtime.
    F.It compiles but hangs at runtime.
    */