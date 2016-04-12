package primaries;
public class IntegerPrac {
	public static void main(String[] a) {
		int i = 2;
		System.out.println("Should print i=2:" + i);

		System.out.println("binary representation of i=2:" + Integer.toBinaryString(i));
		System.out.println("binary representation of i=-2:" + Integer.toBinaryString(-i));

		i = new Integer(4);
		System.out.println("Can int receive Integer?:" + (i==4));

		short s = 3;
		System.out.println("Should print s=3:" + s);
		i = s;
		System.out.println("Should print i=3:" + i);

		byte b = 1;
		System.out.println("binary representation of b=1:" + binaryRepresentation(b));
		byte b1 = (byte)-b;
		System.out.println("binary representation of b=-1:" + binaryRepresentation(b1));
		byte b2 = (byte)252;
		System.out.println("252 to byte should print b2=-4:" + b2);

		b = 4;
		System.out.println("Should print b=4:" + b);


		i = b;
		System.out.println("Should print i=4:" + i);

		//b = s; does not compile!! lossy convertion
		b = (byte)s;
		System.out.println("Should print b=3:" + b);

		System.out.println("max value of short:" + Byte.MAX_VALUE);	
		//b = Byte.MAX_VALUE + 1; does not compile	
		b = (byte)(Byte.MAX_VALUE + 1);	
		System.out.println("Byte.MAX_VALUE + 1 - Should print b=-128:" + b);

		b = (byte)(-Byte.MIN_VALUE);	
		System.out.println("-Byte.MIN_VALUE - Should print b=-128:" + b);

		b = (byte)(128+128);
		System.out.println("b=128+128  - Should print b=0:" + b);
		
		b = (byte)(Byte.MAX_VALUE + Byte.MIN_VALUE);
		System.out.println("b=(Byte.MAX_VALUE + Byte.MIN_VALUE)  - Should print b=-1:" + b);

	}

	public static String binaryRepresentation(byte b1) {
		String s1 = String.format("%8s", Integer.toBinaryString(b1 & 0xFF)).replace(' ', '0');
		return s1;
	}
}