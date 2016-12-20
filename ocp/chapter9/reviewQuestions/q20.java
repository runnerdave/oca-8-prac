import java.nio.file.*;
import java.nio.file.attribute.*;
import java.io.*;
import java.util.stream.*;

public class q20 {

	/*

	Assuming the current directory is /seals/harp/food, 
	what is the result of executing the following code?

	A. 0
	B. 1
	C. 2
	D. 3
	E. 4
	F. The code throws a runtime exception because of line h1.

	Answer 
	B. The normalize() method does not convert a relative path into an absolute path; 
	therefore, the path value after the first line is just the current directory symbol. 
	The for() loop iterates the name values, but since there is only one entry, 
	the loop terminates after a single iteration. Therefore, B is correct and the rest of 
	the answers are incorrect.


	
	*/
	public static void main(String... args) throws IOException {
		
		final Path path = Paths.get(".").normalize(); // h1 
		int count = 0;
		for(int i=0; i<path.getNameCount(); ++i) {
			count++; 
		}
		System.out.println(count);
	
	}

}