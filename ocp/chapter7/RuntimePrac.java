public class RuntimePrac {
	
	public static void main(String... args) {
		int numberOfProcessors = Runtime.getRuntime().availableProcessors();
		System.out.println("number of processors:" + numberOfProcessors);
	}
}