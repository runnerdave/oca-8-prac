import java.nio.file.*;
import java.nio.file.attribute.*;
import java.io.IOException;
import java.util.stream.*;

public class q16 {

	/*

	Assuming /squid/food-schedule.csv exists as a regular non-empty file that a program 
	has access to read, what is correct about the following code snippet? (Choose all that apply.)
	
	A. It compiles but may throw an exception at runtime.
	B. The code will not compile because of line r1.
	C. The code will not compile because of line r2.
	D. The code will not compile because of line r3.
	E. It may not print anything at runtime.
	F. If it prints anything, it will not include commas.

	Answer:
	F
	The code compiles without issue, so B, C, and D are incorrect. The code snippet breaks a file 
	into lines and then further separates the lines by commas using the flatMap() method. 
	The result is printed with one entry on a single line, but all original line breaks and commas 
	from the file are removed; therefore F is correct. Since we are told that the file is non-empty 
	and regular, and the program has access to read it, A and E are incorrect.


	*/
	public static void main(String... args) throws IOException {
		
		Path path = Paths.get("squid/food-schedule.csv"); 
		Files.lines(path) // r1
			.flatMap(p -> Stream.of(p.split(","))) // r2 
			.map(s -> s.toUpperCase()) // r3 
			.forEach(System.out::println);
	
	
	}

}