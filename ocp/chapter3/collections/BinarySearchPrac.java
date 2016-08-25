import java.util.*;
public class BinarySearchPrac {
	public static void main(String... a) {
		Comparator<Integer> c = (o1, o2) -> o2-o1;
		List<Integer> list = Arrays.asList(5, 4, 7, 1);
		System.out.println("Before sorting:" + list);
		Collections.sort(list, c);
		System.out.println("After sorting:" + list);
		System.out.println(Collections.binarySearch(list, 1));//result is undefined because sorting is not ascending

		Comparator<Integer> asc = (o1, o2) -> o1-o2;
		Collections.sort(list, asc);
		System.out.println("After sorting asc:" + list);
		System.out.println(Collections.binarySearch(list, 1)); //this time finds it in position 0
	}
}