public class ThreadLocalPrac {
	public static void main(String... args) throws InterruptedException {
		ThreadLocal<String> myThreadLocal = new ThreadLocal<String>();

		myThreadLocal.set("Hello ThreadLocal");

		String threadLocalValue = myThreadLocal.get();

		System.out.println("===ThreadLocal prac get and set===");
		System.out.println("ThreadLocal value:" + threadLocalValue);


		/*
 		This example creates a single MyRunnable instance which is passed to two different threads. 
 		Both threads execute the run() method, and thus sets different values on the ThreadLocal instance. 
 		If the access to the set() call had been synchronized, and it had not been a ThreadLocal object, 
 		the second thread would have overridden the value set by the first thread.

		However, since it is a ThreadLocal object then the two threads cannot see each other's values. 
		Thus, they set and get different values. 
		*/
		System.out.println("===ThreadLocal prac runnable===");
		MyRunnable sharedRunnableInstance = new MyRunnable();

		Thread thread1 = new Thread(sharedRunnableInstance);
        Thread thread2 = new Thread(sharedRunnableInstance);

        thread1.start();
        thread2.start();

        thread1.join(); //wait for thread 1 to terminate
        thread2.join(); //wait for thread 2 to terminate
	}

	public static class MyRunnable implements Runnable {

        private ThreadLocal<Integer> threadLocal =
               new ThreadLocal<Integer>();

        @Override
        public void run() {
            threadLocal.set( (int) (Math.random() * 100D) );
    
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
            }
    
            System.out.println(threadLocal.get());
        }
    }
}