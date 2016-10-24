/*
This model was picked from: http://tutorials.jenkov.com/java-concurrency/java-memory-model.html
*/

public class MemoryModelPrac {

	public static void main(String... a) {
		MyRunnable demo = new MyRunnable();
    	demo.start();
    	System.out.println("thread name: " + demo.thread.getName());
	}
}

class MyRunnable implements Runnable {

	static Thread thread;

    public void run() {
        methodOne();
        int counter = 0;
	    System.out.println("thread is alive? (in run method): " + thread.isAlive());
	    while (counter < 5) {
	      System.out.println("running " + counter);
	      counter++;
	    }
    }

    public void methodOne() {
        int localVariable1 = 45;

        MySharedObject localVariable2 =
            MySharedObject.sharedInstance;

        //... do more with local variables.

        methodTwo();
    }

    public void methodTwo() {
        Integer localVariable1 = new Integer(99);

        //... do more with local variable.
    }

    public void start() {
		thread = new Thread(this, "New Thread");
		thread.start();
	}
}

class MySharedObject {

    //static variable pointing to instance of MySharedObject

    public static final MySharedObject sharedInstance =
        new MySharedObject();


    //member variables pointing to two objects on the heap

    public Integer object2 = new Integer(22);
    public Integer object4 = new Integer(44);

    public long member1 = 12345;
    public long member2 = 67890;
}
