import java.util.concurrent.*;
public class CyclicBarrierPrac {
	public static void main(String[] args) { 
		ExecutorService service = null;
		try {
			service = Executors.newFixedThreadPool(4); 

			System.out.println("===Running the simple version:====");
			LionPenManagerSimple manager = new LionPenManagerSimple(); 
			for(int i=0; i<4; i++) {
				service.submit(() -> manager.performTask());
			}

			TimeUnit.SECONDS.sleep(2);

			System.out.println("\n\n\n===Running the advanced version:====");
			LionPenManagerAdvanced advancedManager = new LionPenManagerAdvanced(); 
			CyclicBarrier c1 = new CyclicBarrier(4); 
			CyclicBarrier c2 = new CyclicBarrier(4, () -> System.out.println("*** Pen Cleaned!"));
			for(int i=0; i<4; i++) {
				service.submit(() -> advancedManager.performTask(c1,c2));
			}
			 
		} catch(InterruptedException ie) {
			//do nothing
		} finally {
			if(service != null) service.shutdown(); }
		} 

}

class LionPenManagerSimple {
	private void removeAnimals() { 
		System.out.println("Removing animals - simple"); 
	} 
	private void cleanPen() { 
		System.out.println("Cleaning the pen - simple"); 
	} 
	private void addAnimals() { 
		System.out.println("Adding animals - simple"); 
	}
	public void performTask() { 
		removeAnimals(); 
		cleanPen(); 
		addAnimals();
	}
}

class LionPenManagerAdvanced {
	private void removeAnimals() { 
		System.out.println("Removing animals"); 
	} 
	private void cleanPen() { 
		System.out.println("Cleaning the pen"); 
	} 
	private void addAnimals() { 
		System.out.println("Adding animals"); 
	}
	public void performTask(CyclicBarrier c1, CyclicBarrier c2) { 
		try {
			removeAnimals();	
			c1.await();
			cleanPen();
			c2.await();
			addAnimals();
		} catch (InterruptedException | BrokenBarrierException e) {
		// Handle checked exceptions here }
		}
	}
}