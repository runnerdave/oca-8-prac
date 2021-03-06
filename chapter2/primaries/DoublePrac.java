public class DoublePrac {
	public static void main(String... s) {
		double dd = 012; 
		System.out.println(dd);
		/*
		001 in octal is 1 in decimal
		002 in octal is 2 in decimal
		003 in octal is 3 in decimal
		004 in octal is 4 in decimal
		005 in octal is 5 in decimal
		006 in octal is 6 in decimal
		007 in octal is 7 in decimal
		010 in octal is 8 in decimal
		011 in octal is 9 in decimal
		012 in octal is 10 in decimal
		*/

		System.out.println(methodX((byte)2));
		System.out.println(methodY((byte)2));
	}


	//What should be the return type of the following method?
	//A: double, note that long only applies to "by" 
	public static double methodX( byte by){
	    double d = 10;
	    return (long) by/d*3;
	}

	public static long methodY( byte by){
	    double d = 10.0;
	    return (long)(by/d*3);
	}
}