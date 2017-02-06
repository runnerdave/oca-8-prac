public class YieldRunnable implements Runnable {
 
	@Override
	public void run() {

		System.out.println("Current Thread:"+Thread.currentThread().getName()+" Priority "+Thread.currentThread().getPriority());
		Thread.yield();
		System.out.println("Current Thread:"+Thread.currentThread().getName()+" Priority "+Thread.currentThread().getPriority()+" -End");

	}
 
}