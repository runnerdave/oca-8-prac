import java.util.*;
import java.nio.file.*;
import java.util.stream.*;
import java.io.*;

public class NormalizePrac {
	public static void main(String... args) throws IOException {
		System.out.println("==");
		Path path = Paths.get("bear/polar/./environment").normalize().getRoot(); // w1
		   System.out.println(Files.list(path)
		         .filter(p -> !Files.isDirectory(p)) // w2
		         .map(p -> p) // w3      
		         .collect(Collectors.toSet())      
		         .size());
	}
}

/*
this was a question to note that the code compiles but throws an exception.
*/
