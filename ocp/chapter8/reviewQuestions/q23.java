 
import java.io.*;

public class q23 {

	/*
	Assume that you have an InputStream whose next bytes are XYZABC. 
	What is the result of calling the following method on the stream, using a count value of 3?

	A. It will return a String value of XYZ.
	B. It will return a String value of XYZA.
	C. It will return a String value of XYZX.
	D. It will return a String value of XYZB.
	E. It will return a String value of XYZY.
	F. The code does not compile.
	G. The code compiles but throws an exception at runtime.
	H. The result cannot be determined with the information given.

	Answer: H Not all java.io streams support the mark() operation; therefore, 
	without calling markSupported() on the stream, the result is unknown until runtime. 
	If the stream does support the mark() operation, then the result would be XYZY, 
	because the reset() operation puts the stream back in the position before the mark() was called, 
	and skip(1) will skip X, and E would be correct. If the stream does not support the mark() operation, 
	a runtime exception would likely be thrown, and G would be correct. Since you don't know if the 
	input stream supports the mark() operation, H is the only correct choice.


	*/
	public static void main(String... args) throws FileNotFoundException, IOException {
		System.out.println("Reading from pullBytes:");
		String str = "XYZABC";
		InputStream is = new  ByteArrayInputStream(str.getBytes());
		System.out.println(pullBytes(is, 3));
	}

	public static String pullBytes(InputStream is, int count) throws IOException {
		is.mark(count);
		final StringBuilder sb = new StringBuilder(); 
		for(int i=0; i<count; i++)
			sb.append((char)is.read()); 
		is.reset();
		is.skip(1); 
		sb.append((char)is.read()); 
		return sb.toString();
	}
}




