import java.util.*;
import java.util.concurrent.*;


public class ForkJoinPrac {
	public static void main(String[] args) { 
		Double[] weights = new Double[10];

		System.out.println("=====With RecursiveAction===="); 
		ForkJoinTask<?> task = new WeighAnimalAction(weights,0,weights.length); 
		ForkJoinPool pool = new ForkJoinPool();
		pool.invoke(task);
		// Print results
		System.out.println(); 
		System.out.print("Weights: "); 
		Arrays.asList(weights).stream().forEach(d -> System.out.print(d.intValue()+" "));

		System.out.println(); 
		System.out.println("=====With RecursiveTask===="); 
		task = new WeighAnimalTask(weights,0,weights.length); 
		pool = new ForkJoinPool();
		pool.invoke(task);
		// Print results
		System.out.println(); 
		System.out.print("Weights: "); 
		Arrays.asList(weights).forEach(d -> System.out.print(d.intValue()+" "));
	}
}

class WeighAnimalAction extends RecursiveAction { 
	private int start;
	private int end;
	private Double[] weights;
	public WeighAnimalAction(Double[] weights, int start, int end) { 
		this.start = start;
		this.end = end;
		this.weights = weights;
	}
	protected void compute() { 
		if(end-start <= 3) {
			for(int i=start; i<end; i++) {
				weights[i] = (double)new Random().nextInt(100); 
				System.out.println("Animal Weighed: "+i);
			}	
		} else {
			int middle = start+((end-start)/2); 
			System.out.println("[start="+start+",middle="+middle+",end="+end+"]"); 
			invokeAll(new WeighAnimalAction(weights,start,middle),
					  new WeighAnimalAction(weights,middle,end));
		} 
	}
}

class WeighAnimalTask extends RecursiveTask<Double> {
	private int start;
	private int end;
	private Double[] weights;
	public WeighAnimalTask(Double[] weights, int start, int end) {
		this.start = start;
		this.end = end;
		this.weights = weights;
	}
	protected Double compute() {
		if(end-start <= 3) {
			double sum = 0;
			for(int i=start; i<end; i++) {
				weights[i] = (double)new Random().nextInt(100);
				System.out.println("Animal Weighed: "+i);
				sum += weights[i];
			}
			return sum;
		} else {
			int middle = start+((end-start)/2);
			System.out.println("[start="+start+",middle="+middle+",end="+end+"]");
			RecursiveTask<Double> otherTask = new WeighAnimalTask(weights,start,middle);
			otherTask.fork();
			return new WeighAnimalTask(weights,middle,end).compute() + otherTask.join();
		}
	}
}