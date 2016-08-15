import java.util.*;
public class BoundPrac {
	public static void printListBad(List<Object> list) {
		for (Object x: list) System.out.println(x);
	}
	public static void printListUnbound(List<?> list) {
		for (Object x: list) System.out.println(x);
	}
	public static void printListUpperbound(List<? extends Object> list) {
		for (Object x: list) System.out.println(x);
	}
	public static void main(String[] args) {
		List<String> keywords = new ArrayList<>();
		keywords.add("java");
		//printListBad(keywords); // DOES NOT COMPILE
		printListUnbound(keywords); //WORKS!!
		printListUpperbound(keywords); //WORKS!!
	}
}