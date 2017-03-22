class A extends Thread {
  static protected int i = 0;
  public void run() {
    for(; i<5; i++) 
      System.out.println("Hello"); 
  } 

} 

public class TestClass extends A {
  public void run() {
    for(; i<5; i++)
      System.out.println("World"); 
  }

  public static void main(String args []) {
    Thread t1 = new A(); 
    Thread t2 = new TestClass(); 
    t2.start(); t1.start();
  } 
}

/*
explanation:
Notice that i is a static variable and there are 2 threads that are accessing it. None of the threads has synchronized access to the variable. 
So there is no guarantee which thread will access it when. Further, one thread might increment i while another is executing i<5. 
So it is possible that more than 5 words may be printed. For example, lets say i is 0 and thread1 starts first loop. 
It will print Hello. Now, before thread1 could do i++, thread2 might run and it will print "World" while i is still 0.

run the TestClassExtendedVersion for a better example that runs slower.
*/
