import java.util.*;
public class ArrayListPrac {
	public static void main(String... a) {
		List myList = new ArrayList();
		myList.add("hola");
		myList.add("bola");
		myList.add(4);
		System.out.println(myList.toString());
		for(Object s : myList) {
			System.out.println(s);
		}
	}
}