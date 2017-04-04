//Q30. what will be the result of attempting to compile and run the following program

public class MyThread extends Thread {
	String msg = "default";
	public MyThread(String s)
	{
		msg = s;
	}

	public void run()
	{
		System.out.println(msg);
	}

	public static void main(String args[])
	{
		new MyThread("String1").run();
		new MyThread("String2").run();
		System.out.println("end");
	}
}

/*
a. The program will fail to compile.
b. It will always print String1, String2, and end, in that order.
c. It will always print String1 and String2 in random order followed by end.
d. It will always print end first.
e. No order is guaranteed.

Answer b.
Although two new threads are created but none of them is started 
(remember run() does not start a thread. start() does)
Here, run is called just like any other ordinary method in the main thread.

*/