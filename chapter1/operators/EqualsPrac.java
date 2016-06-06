public class EqualsPrac{
	
	public static void main(String... a) {
		System.out.println("===========Practice == with primitives ==== ");
		int i = 2;
		short s = 2;
		double d = 2.0;
		float f = 2.0f;
		boolean bool = true;

		if (i==s) {
			System.out.println("short and int contain 2 and are equal.");
		} else {
			System.out.println("short and int contain 2 and are not equal.");
		}
		s=3;
		if (i==s) {
			System.out.println("short contains 3 and int contain 2 and are equal.");
		} else {
			System.out.println("short contains 3 and int contain 2 and are not equal.");
		}
		if (i==d) {
			System.out.println("double and int contain 2 and are equal.");
		} else {
			System.out.println("double and int contain 2 and are not equal.");
		}
		if (d==i) {
			System.out.println("double and int contain 2 and are equal.");
		} else {
			System.out.println("double and int contain 2 and are not equal.");
		}
		if (f==i) {
			System.out.println("float and int contain 2 and are equal.");
		} else {
			System.out.println("float and int contain 2 and are not equal.");
		}
		//if (bool==i) {} //DOES NOT COMPILE

	}
}