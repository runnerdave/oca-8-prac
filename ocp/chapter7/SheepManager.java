import java.util.concurrent.*;
import java.util.concurrent.atomic.*;
public class SheepManager {
	private int sheepCount = 0;
	private AtomicInteger sheepCountAtomic = new AtomicInteger(0);
	private int sheepCountToSync = 0;
	private void incrementAndReport() {
		System.out.print((++sheepCount)+" ");
	}
	private void incrementAndReportAtomic() {
		System.out.print((sheepCountAtomic.incrementAndGet())+" ");
	}
	private void incrementAndReportSynchronized() {
		synchronized(this) {
			System.out.print((++sheepCountToSync)+" ");
		}
	}
	public static void main(String[] args) {
		ExecutorService service = null;
		try {
			/**service = Executors.newFixedThreadPool(10);
			SheepManager manager = new SheepManager();
			System.out.println("none: ");
			for(int i=0; i<10; i++) {
				service.submit(() -> manager.incrementAndReport());
			}	
			service = Executors.newFixedThreadPool(10);
			SheepManager managerAtomic = new SheepManager();
			System.out.println("\natomic: ");
			for(int i=0; i<10; i++) {
				service.submit(() -> managerAtomic.incrementAndReportAtomic());
			}*/
			/**/	service = Executors.newFixedThreadPool(10);
			SheepManager managerSync = new SheepManager();
			System.out.println("\nsynchronized block: ");
			for(int i=0; i<10; i++) {
				service.submit(() -> managerSync.incrementAndReportSynchronized());
			}					
		} finally {
			if(service != null) service.shutdown();
		}
	}
}