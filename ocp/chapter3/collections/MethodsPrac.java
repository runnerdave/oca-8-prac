import java.util.*;
public class MethodsPrac {
	public static void main(String... d) {

		System.out.println("=====List=======");
		List<String> strList = new ArrayList<>();
		System.out.println("adding one:" + strList.add("one"));
		System.out.println("adding two:" + strList.add("two"));
		System.out.println("list before:" + strList);
		System.out.println("remove element at index 1:" + strList.remove(1));
		System.out.println("list after" + strList);
		System.out.println("adding four:");
		try { 
			strList.add(3, "four");
		} catch (IndexOutOfBoundsException e) {
			System.out.println("exception caught!");
			System.out.println(e.getMessage());
		}
		System.out.println("list after" + strList);

		System.out.println("=====Set=======");
		Set<String> strSet = new HashSet<>();
		System.out.println("adding one:" + strSet.add("one"));
		System.out.println("adding one:" + strSet.add("one"));
		System.out.println("adding two:" + strSet.add("two"));
		System.out.println("set before:" + strSet);
		System.out.println("remove element 300:" +strSet.remove(300)); //no exception
		System.out.println("remove element at index 1:" +strSet.remove(1)); //no index
		System.out.println("set after:" + strSet);
		System.out.println("remove element one:" +strSet.remove("one")); 
		System.out.println("set after:" + strSet);
	}

}