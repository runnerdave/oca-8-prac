/*Q42
* What will be the result of attempting to compile and run the program shown in exhibit?
*/


public class MyThread implements Runnable
{
   String msg = "default";
   public MyThread(String s)
   {
      msg = s;
   }
   public void run( )
   {
      System.out.println(msg);
   }
   public static void main(String args[])
   {
      new Thread(new MyThread("String1")).run();
      new Thread(new MyThread("String2")).run();
      System.out.println("end");
   }
}

/*
* a. The program will compile and print only end.
* b. It will always print String1, String2, and end, in that order.
* c. It will always print String1, String2 in random order followed by end.
* d. It will always print end first.
* e. No order is guaranteed.
*
* Answer c
* Although two new threads are created but none of them is started.(Remember run() does not 
* start a thread. start() does.)
* Here, run is called but NOT of MyThread class but of Thread class. Thread class's run() is
* an interesting method. If the thread object was constructed using a separate Runnable 
* object, then that Runnable object's run method is called otherwise, this method does nothing 
* and returns. Here, Thread's run calls MyThread's run() which prints the string and returns. 
* Everything is done in one thread (the main thread) and so the order is known.
*/