import java.util.*;
public class ParallelStreamsIntroPrac {
	public static void main(String... a) {
		System.out.println("Serial Stream:");
		Arrays.asList(1,2,3,4,5,6)
				.stream()
				.forEach(s -> System.out.print(s+" "));

		System.out.println(); 

		System.out.println("Paralell Stream:");
		Arrays.asList(1,2,3,4,5,6)
				.parallelStream()
				.forEach(s -> System.out.print(s+" "));

		System.out.println(); 

		System.out.println("Paralell Stream Ordered:");
		Arrays.asList(1,2,3,4,5,6)
				.parallelStream()
				.forEachOrdered(s -> System.out.print(s+" "));

		System.out.println(); 

		System.out.println("====time comparisons for WhaleDataCalculator====");

		WhaleDataCalculator calculator = new WhaleDataCalculator();
		// Define the data
		List<Integer> data = new ArrayList<Integer>(); 

		for(int i=0; i<4000; i++) 
			data.add(i);
		// Process the data
		long start = System.currentTimeMillis();
		calculator.processAllData(data);
		double time = (System.currentTimeMillis() - start)/1000.0;
		// Report results
		System.out.println("\nTasks completed in: "+time+" seconds"); 

		// Process the data
		start = System.currentTimeMillis();
		calculator.processAllDataInParallel(data);
		time = (System.currentTimeMillis() - start)/1000.0;
		// Report results
		System.out.println("\nTasks completed in parallel in: "+time+" seconds"); 

	}
}

class WhaleDataCalculator {
	public int processRecord(int input) { 
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// Handle interrupted exception 
		}
		return input+1; 
		
	}
		
	public void processAllData(List<Integer> data) {
		data.stream().map(a -> processRecord(a)).count();
	}

	public void processAllDataInParallel(List<Integer> data) {
		data.parallelStream().map(a -> processRecord(a)).count();
	}
	
}