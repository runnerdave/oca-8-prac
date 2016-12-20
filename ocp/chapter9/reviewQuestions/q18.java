import java.nio.file.*;
import java.nio.file.attribute.*;
import java.io.*;
import java.util.stream.*;

public class q18 {

	/*

	Assuming the directories and files referenced here all exist and are accessible 
	within the file system, what is the result of the following code?

	A. true true true
	B. false false false
	C. false true false
	D. true false true
	E. true false false
	F. The code does not compile.

	Answer 
	B

	D. The code compiles and runs without issue, so F is incorrect. The one thing to notice 
	about these paths is that they represent the same path within the file system. Therefore, 
	isSameFile() would return true and B and C are incorrect. The second output is false, 
	because Path.equals() does not resolve the path within the file system, so A is incorrect. 
	Finally, the normalized paths are equals(), since all extra symbols have been removed; 
	therefore D is correct and E is incorrect.
	*/
	public static void main(String... args) throws IOException {
		
		Path path1 = Paths.get("/lizard/./").resolve(Paths.get("walking.txt")); 
		Path path2 = new File("/lizard/././actions/../walking.txt").toPath();
		System.out.print(Files.isSameFile(path1,path2)); 
		System.out.print(" "+path1.equals(path2));
		System.out.print(" "+path1.normalize().equals(path2.normalize()));
	
	}

}