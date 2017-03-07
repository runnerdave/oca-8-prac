import java.util.*;
public class NavigableSetPrac {
	public static void main(String... a) {
		NavigableSet<Integer> set = new TreeSet<>();
		for (int i = 1; i <= 20; i++) set.add(i);
		System.out.println(set.lower(10)); // 9
		System.out.println(set.floor(10)); // 10
		System.out.println(set.ceiling(20)); // 20
		System.out.println(set.higher(20)); // null

		System.out.println("===with strings===");
		NavigableSet<String> stringSet = new TreeSet<>();
		stringSet.add("ee");
		stringSet.add("a");
		stringSet.add("b");
		stringSet.add("aa");
		stringSet.add("d");

		for(String s: stringSet) {
			System.out.println(s);
		}

	}
}