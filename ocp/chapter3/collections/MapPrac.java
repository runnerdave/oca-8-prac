import java.util.*;
import java.util.function.*;
public class MapPrac {
	public static void main(String... a) {
		System.out.println("===========hashmap==============");
		Map<String, String> map = new HashMap<>();
		map.put("koala", "gumtree"); 
		map.put("lion", "meat"); 
		map.put("giraffe", "leaf");
		String food = map.get("koala"); // gumtree 
		System.out.println("get with key=koala:" + food);
		for (String key: map.keySet())
			System.out.println(key + "|hashcode:" + key.hashCode()); // koala,giraffe,lion,
		System.out.println("");

		System.out.println("===========treemap==============");
		Map<String, String> treeMap = new TreeMap<>();
		treeMap.put("koala", "gumtree"); 
		treeMap.put("lion", "meat"); 
		treeMap.put("giraffe", "leaf");
		food = treeMap.get("koala"); // gumtree 
		System.out.println("get with key=koala:" + food);
		for (String key: treeMap.keySet())
			System.out.println(key + "|hashcode:" + key.hashCode()); // giraffe,koala,lion,

		for (String value: treeMap.values())
			System.out.println(value); // leaf,gumtree,meat,

		//System.out.println(treeMap.contains("lion")); // DOES NOT COMPILE 
		System.out.println(treeMap.containsKey("lion")); // true 
		System.out.println(treeMap.containsValue("lion")); // false 
		System.out.println(treeMap.size()); // 3

		treeMap.forEach((K,V) -> System.out.println(K + ":" + V));

		System.out.println("===========putIfAbsent==============");
		System.out.println("putIfAbsent kookaburra:" + treeMap.putIfAbsent("kookaburra","worm"));
		System.out.println("putIfAbsent lion:" + treeMap.putIfAbsent("lion","ham"));

		treeMap.forEach((K,V) -> System.out.println(K + ":" + V));

		System.out.println("===========merge==============");
		BiFunction<String, String, String> mapper = (v1, v2) 
											-> v1.startsWith("g") ? v1.concat("-" + v2) : v1;
		//BiFunction<String, String, String> mapper = (v1, v2)
		//											-> v1.length() > v2.length() ? v1: v2;
		treeMap.merge("koala","eucaliptus",mapper);

		treeMap.forEach((K,V) -> System.out.println(K + ":" + V));

		System.out.println("");
	}
}