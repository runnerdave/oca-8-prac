import java.util.concurrent.*;
import java.util.stream.*;
import java.util.*;

public class q13 {

	/*
	What statements about the following code are true? (Choose all that apply.)
	
	A. It outputs 3 4.
	B. It outputs 4 3.
	C. The code will not compile because of line 6.
	D. The code will not compile because of line 7.
	E. The code will not compile because of line 8.
	F. It compiles but throws an exception at runtime.
	G. The collect() operation is always executed in a single-threaded fashion.
	*/
	public static void main(String... args) {
		Stream<String> cats = Stream.of("leopard","lynx","ocelot","puma").parallel();
		Stream<String> bears = Stream.of("panda","grizzly","polar").parallel();
		ConcurrentMap<Boolean, List<String>> data = Stream.of(cats,bears)
			.flatMap(s -> s)
			.collect(Collectors.groupingByConcurrent(s -> !s.startsWith("p")));
		System.out.println(data.get(false).size()+" "+data.get(true).size());
	}
}