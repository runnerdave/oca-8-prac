import java.util.*;
import java.io.*;
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
	public static void printListLowerbound(List<? super String> list) {
		for (Object x: list) System.out.println(x);
	}
	public static void main(String[] args) {
		List<String> keywords = new ArrayList<>();
		keywords.add("java");
		//printListBad(keywords); // DOES NOT COMPILE
		printListUnbound(keywords); //WORKS!!
		printListUpperbound(keywords); //WORKS!!
		printListLowerbound(keywords); //WORKS!!

		List<? super IOException> exceptions = new ArrayList<Exception>();
		//exceptions.add(new Exception()); // DOES NOT COMPILE because the list can be of IOException and Exception does not fit
		exceptions.add(new IOException());
		exceptions.add(new FileNotFoundException());

		List<?> list1 = new ArrayList<A>();
		List<? extends A> list2 = new ArrayList<A>();
		List<? super A> list3 = new ArrayList<A>();
		//List<? extends B> list4 = new ArrayList<A>(); // DOES NOT COMPILE
		List<? super B> list5 = new ArrayList<A>();
		//List<?> list6 = new ArrayList<? extends A>(); // DOES NOT COMPILE
	}
}
class A {}
class B extends A { }
class C extends B { }