import java.util.concurrent.*;
import java.util.concurrent.atomic.*;
import java.util.stream.*;
import java.util.*;
/*
from: http://winterbe.com/posts/2015/05/22/java8-concurrency-tutorial-atomic-concurrent-map-examples/


*/
public class ConcurrentMapPrac {

	static ConcurrentMap<String, String> map = new ConcurrentHashMap<>();
	
	public static void main(String... args) {			
		System.out.println(ForkJoinPool.getCommonPoolParallelism());  // 7 in RMIT box
	
	}
}