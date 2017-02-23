
//Q 36. What will be the output when the following code is run?

class MyRunnable implements Runnable
{
   MyRunnable(String name)
   {
      new Thread(this, name).start();
   }
   public void run()
   {
      System.out.println(Thread.currentThread().getName());
   }
}
public class TestClass
{
   public static void main(String[] args)
   {
      Thread.currentThread().setName("MainThread");
      MyRunnable mr = new MyRunnable("MyRunnable");
      mr.run();
   }
}

/*
a. MainThread 
b. MyRunnable
c. MainThread will be printed twice. 
d. MyRunnable will be printed twice.
e.  It will print MainThread as well as MyRunnable 

answer e:

1. The statement : Thread.currentThread().setName("MainThread"); 
in the main() method sets the name of the current thread. 
This is the thread that is running the main method. 

2. The statement: MyRunnable mr = new MyRunnable("MyRunnable"); creates a new 
MyRunnable object. In its constructor, it creates a new threads with the name 
"MyRunnable" and also starts this thread. 

3. Now there are two threads running: The main thread (having the name "MainThread")
 and the MyRunnable thread (having the name "MyRunnable"). 

4. The myrunnable thread executes the run method and prints "MyRunnable" because that
 is the name of the thread that called the run() method. On the other hand when the 
 main method calls mr.run(), it prints "MainThread" because that is the name of the 
 thread that has called the run method(). Therefore, both, Main and MyRunnable will be 
 printed. Note that the order cannot be determined because the OS decides which thread
 to schedule when.

*/
