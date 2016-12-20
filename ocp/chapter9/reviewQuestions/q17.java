import java.nio.file.*;
import java.nio.file.attribute.*;
import java.io.IOException;
import java.util.stream.*;

public class q17 {

	/*

	Assuming the current directory is /animals/cute, which are possible results of executing the following code? (Choose all that apply.)
	
	A. It compiles but may throw an exception at runtime.
	B. The code will not compile because of line u1.
	C. The code will not compile because of line u2.
	D. The code will not compile because of line u3.
	E. It prints all .java files in the /animals directory tree.
	F. It prints all .java files in the /animals/cute directory tree.
	G. It prints all .java files in the root directory tree.

	Answer
	G
	A, G. The code compiles without issue, so B, C, and D are incorrect. The first line actually 
	resolves to the root path since .. and getParent() are conceptually equivalent. 
	Therefore, G is correct and E and F are incorrect. 
	A is also correct since it may encounter a file that it does not have access to read, 
	swhich is common when trying to read an entire file system.

	*/
	public static void main(String... args) throws IOException {
		
		Files.walk(Paths.get("..").toRealPath().getParent()) // u1 
				.map(p -> p.toAbsolutePath().toString()) // u2
				.filter(s -> s.endsWith(".java")) // u3 
				.collect(Collectors.toList()) 
				.forEach(System.out::println);	
	
	}

}