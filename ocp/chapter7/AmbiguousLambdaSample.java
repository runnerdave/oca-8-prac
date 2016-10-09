import java.util.concurrent.*;
import java.util.function.*;
import java.io.*;
public class AmbiguousLambdaSample {
	public static void useCallable(Callable<Integer> expression) {}
	public static void useSupplier(Supplier<Integer> expression) {}
	public static void use(Supplier<Integer> expression) {} 
	public static void use(Callable<Integer> expression) {} 
	public static void main(String[] args) {
	useCallable(() -> {throw new IOException();}); // COMPILES 
	//useSupplier(() -> {throw new IOException();}); // DOES NOT COMPILE 

	//use(() -> {throw new IOException();}); // DOES NOT COMPILE
	use((Callable<Integer>)() -> {throw new IOException();}); // COMPILES using explicit cast
	} 
}
