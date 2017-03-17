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
	public static void printListLowerboundObject(List<? super Object> list) {
		for (Object x: list) System.out.println(x);
	}
	public static void main(String[] args) {
		List<String> keywords = new ArrayList<>();
		keywords.add("java");
		//printListBad(keywords); // DOES NOT COMPILE
		System.out.println("==Printing list unbound==");
		printListUnbound(keywords); //WORKS!!
		System.out.println("==Printing list upperbound==");
		printListUpperbound(keywords); //WORKS!!
		System.out.println("==Printing list lowerbound==");
		printListLowerbound(keywords); //WORKS!!
		//printListLowerboundObject(keywords); //DOES NOT COMPILE incompatible types: List<String> cannot be converted to List<? super Object>

		List<? super IOException> exceptions = new ArrayList<Exception>();
		//exceptions.add(new Exception()); // DOES NOT COMPILE because the list can be of IOException and Exception does not fit
		exceptions.add(new IOException());
		exceptions.add(new FileNotFoundException());
		System.out.println("==lower bound list (? super IOException) with exceptions==");
		System.out.println(exceptions);

		List<?> list1 = new ArrayList<A>();
		//list1.add(new A()); //DOES NOT COMPILE because list1 became immutable
		
		List<? extends A> list2 = new ArrayList<A>();
		//list2.add(new A()); //DOES NOT COMPILE because list2 became immutable

		List<? super A> list3 = new ArrayList<A>();
		list3.add(new A());
		list3.add(new B());
		list3.add(new C());
		//list3.add(new Object()); //DOES NOT COMPILE because list can be of A

		list3 = new ArrayList<Object>();
		//list3.add(new Object());  //DOES NOT COMPILE either
		list3.add(new C());

		//List<? extends B> list4 = new ArrayList<A>(); // DOES NOT COMPILE
		List<? super B> list5 = new ArrayList<A>();
		list5.add(new C());
		list5.add(new B());
		//list5.add(new A()); //DOES NOT COMPILE
		//List<?> list6 = new ArrayList<? extends A>(); // DOES NOT COMPILE

		List<? extends doAble> list6 = new ArrayList<doAble>();
		List<? extends doAble> list7 = new ArrayList<C>();
		//List<? extends doAble> list8 = new ArrayList<B>(); //DOES NOT COMPILE
		//list7.add(new C()); //DOES NOT COMPILE

		List<? super doAble> list8 = new ArrayList<doAble>();
		//List<? super doAble> list9 = new ArrayList<C>(); //DOES NOT COMPILE
		List<? super C> list10 = new ArrayList<doAble>();
		list10.add(new C());
	}
}
class A {}
class B extends A { }
class C extends B implements doAble { }
interface doAble {}