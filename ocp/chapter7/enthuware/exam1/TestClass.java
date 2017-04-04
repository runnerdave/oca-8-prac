
//Question 10. Consider the following program.

public class TestClass implements Runnable
{
  volatile int x;
  public void run(){ x = 5; }

  public static void main(String[] args)
  {
      TestClass tc = new TestClass();
      tc.x = 10;
      new Thread(tc).start(); // 1
      System.out.println(tc.x);
  }

}

/* What will it print when run?

	5
	10
	It will not compile
	Exception at runtime
	The output cannot be determined

	Answer E:
	Note that when you create and start a new Thread (at line 1) there are two threads running. (The main() thread and the thread that you just started!). 
  Both the threads are trying to use the same variable. 
  Now, which thread will run first cannot be determined so whether the main() thread reads 'x' first or the new thread changes 'x' first is not known. 
  So the output of the program cannot be determined.
*/