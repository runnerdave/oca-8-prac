import java.util.concurrent.*;

public class q3 {

	/*
	Which lines need to be changed to make the code compile?
	*/
	public static void main(String... args) {
		ExecutorService service = Executors.newSingleThreadScheduledExecutor(); 
		//ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor(); 
			service.scheduleWithFixedDelay(() -> { // w1
													System.out.println("Open Zoo");
													return null; // w2 - need to comment this one out
												}, 0, 1, TimeUnit.MINUTES);
		Future<?> result = service.submit(() -> System.out.println("Wake Staff")); // w3 
		System.out.println(result.get()); // w4 - need to catch this interrupted exception
	}
}
