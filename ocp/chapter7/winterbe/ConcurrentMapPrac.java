import java.util.concurrent.*;
import java.util.concurrent.atomic.*;
import java.util.stream.*;
import java.util.*;
/*
from: http://winterbe.com/posts/2015/05/22/java8-concurrency-tutorial-atomic-concurrent-map-examples/


*/
public class ConcurrentMapPrac {

	static ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();
	
	public static void main(String... args) {			
		System.out.println("common parellilism processor:" + ForkJoinPool.getCommonPoolParallelism());  // 7 in RMIT box, 3 in mac
		fillMap();
		forEachSimple();
		forEachParallel();
		searchInParallel();
		searchOnlyValuesInParallel();
		reduceInParallel();
	}

	public static void fillMap() {
		map.put("foo", "bar");
		map.put("han", "solo");
		map.put("r2", "d2");
		map.put("c3", "p0");
	}

	public static void forEachSimple() {
		System.out.println("===Example of a forEach call on a simple ConcurrentMap===");
		map.forEach((key, value) -> System.out.printf("%s = %s\n", key, value));
	}

	public static void forEachParallel() {
		System.out.println("===Example of a forEach call on a parallel ConcurrentMap===");
		map.forEach(1, (key, value) ->
					    System.out.printf("key: %s; value: %s; thread: %s\n",
        					key, value, Thread.currentThread().getName()));

	}

	public static void searchInParallel() {
		System.out.println("===Example of a parallel search call on a ConcurrentMap===");
		String result = map.search(1, (key, value) -> {
		    System.out.println(Thread.currentThread().getName());
		    if ("foo".equals(key)) {
		        return value;
		    }
		    return null;
		});
		System.out.println("Result: " + result);
	}

	public static void searchOnlyValuesInParallel() {
		System.out.println("===Example of a parallel search for only values call on a ConcurrentMap===");
		String result = map.searchValues(1, value -> {
		    System.out.println(Thread.currentThread().getName());
		    if (value.length() > 3) {
		        return value;
		    }
		    return null;
		});
		System.out.println("Result: " + result);
	}

	public static void reduceInParallel() {
		System.out.println("===Example of a reduce call on a ConcurrentMap===");
		String result = map.reduce(1,
		    (key, value) -> {
		        System.out.println("Transform: " + Thread.currentThread().getName());
		        return key + "=" + value;
		    },
		    (s1, s2) -> {
		        System.out.println("Reduce: " + Thread.currentThread().getName());
		        return s1 + ", " + s2;
		    });

		System.out.println("Result: " + result);
	}
}