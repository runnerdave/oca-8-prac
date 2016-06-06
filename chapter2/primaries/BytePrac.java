public class BytePrac {
	
	public static void main(String[] a) {
		final byte b=35;//REMOVE final to see it fail at compile time
		char c=b; 

		//char c = (byte) 35;
		System.out.println ("And the character is:\t" + c);

		short s = 1;
		byte bb = 2;
		final int i = 3;
		final short fs = 4;
		byte fb = 5;

		s = i;//i has to be final
		bb = i;
		c = fs;//fs has to be final

		System.out.println ("s:" + s + "|bb:" + bb + "|c:" + c);

		s = fb;//fb can be final or not
		bb = fs;//fs has to be final

		System.out.println ("s:" + s + "|bb:" + bb);

		final char fc = 2;
		s = fc;//has to be final

		System.out.println ("s:" + s);

		//implicit narrowing requires final and only applies between short, int, byte and char
		
	}
}