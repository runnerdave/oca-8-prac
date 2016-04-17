public class CastingPrac {
	
	public static void main(String... a) {
		System.out.println("=======casting prac 1 automatic casting: \n\tbyte to short to int to long to float to double");
		byte b = 97;
		System.out.println("byte b:" + b);
		short s = b;
		System.out.println("short s:" + s);
		int i = s;
		System.out.println("int i:" + i);
		long l = i;
		System.out.println("long l:" + l);
		float f = l;
		System.out.println("float f:" + f);
		double d = f;
		System.out.println("double d:" + d);
		

		System.out.println("=======casting prac 2 when casting is not implicit using char: \n\tbyte to char to short to char to int to char and float to char");
		char c;
		b = 97;
		s = 97;
		i = 97;
		l = 97;
		f = 97;
		
		c = (char)b; //c = b; NOT GODD
		c = (char)s; //c = s; NOT GOOD
		c = (char)i; //c = i; NOT GOOD
		c = (char)d; //c = d; NOT GOOD
		c = (char)l; //c = l; NOT GOOD
		c = (char)f; //c = f; NOT GOOD

		boolean bool = false;
		//c = (char)bool; NOT GOOD

		System.out.println("char c:" + c);

		i = c;

		System.out.println("the other way int i:" + i);

		System.out.println("=======casting prac 3 automatic casting using char and final:");
		final char cc = 1;//without final it does not compile and with value of 200 fails even with final
		byte bb = cc;
		System.out.println("byte bb:" + bb);

		/*
		final short s = 1; byte b = s; => This is fine because s is a constant and the value fits into a byte.
		final short s = 200; byte b = s; => This is invalid because although s is a constant but the value does not fit into a byte.

		Implicit narrowing occurs only for byte, char, short, and int. 
		Remember that it does not occur for long, float, or double. So, this will not compile: int i = 129L;
		*/

		System.out.println("=======casting prac 4 automatic casting using int and long:");
		//final int ii = 129L;//without final it does not compile and with value of 200 fails even with final
		//long ll = ii;
		//System.out.println("long ll:" + ll);
	}

}