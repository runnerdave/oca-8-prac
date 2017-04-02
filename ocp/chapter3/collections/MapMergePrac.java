import java.util.*;
public class MapMergePrac {
	public static void main(String... args) {
		Map<Integer, Integer> map = new HashMap<>();
		map.put(1, 10);
		map.put(2, 20);
		map.put(3, null);
		System.out.println(map);
		map.merge(1, 3, (a,b) -> a + b);
		map.merge(3, 3, (a,b) -> a + b);

		System.out.println(map); //choose option from list below


		System.out.println("==lambda practice now==");
		//use a lambda to substract now
		map.merge(2, 3, (a,b) -> a - b);
		System.out.println(map);//should be 2=17
		map.merge(2, -3, (a,b) -> b - a);
		System.out.println(map);//should be 2=-20 

		map.put(3, null);
		map.merge(3, 3, (a,b) -> null);
		System.out.println(map);//should be 3=3
	}
}

/*
A. {1=10, 2=20}
B. {1=10, 2=20, 3=null}
C. {1=10, 2=20, 3=3}
D. {1=13, 2=20}
E. {1=13, 2=20, 3=null}
F. {1=13, 2=20, 3=3}
G. The code does not compile.
H. An exception is thrown.
*/