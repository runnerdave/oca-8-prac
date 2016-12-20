import java.nio.file.*;
import java.nio.file.attribute.*;
import java.io.IOException;

public class q8 {

	/*

	What is the output of the following code?
	
	A. /pets/../cat.txt/./dog.txt /pets/../cat.txt
	B. /pets/../cat.txt/./dog.txt ./dog.txt/pets/../cat.txt
	C. /cats.txt /dog.txt
	D. /cats.txt/dog.txt /cat.txt
	E. It compiles but throws an exception at runtime.


	Answer
	A. The code compiles and runs without issue, so E is incorrect. For this question, 
	you have to remember two things. First, the resolve() method does not normalize any path symbols, 
	so C and D are not correct. Second, calling resolve() with an absolute path as a parameter returns 
	the absolute path, so A is correct and B is incorrect.
	
	*/
	public static void main(String... args) throws IOException {
		Path path1 = Paths.get("/pets/../cat.txt"); 
		Path path2 = Paths.get("./dog.txt"); 
		System.out.println(path1.resolve(path2)); 
		System.out.println(path2.resolve(path1));

		//my stuff
		System.out.println("is path1 absolute:" + path1.isAbsolute());
		System.out.println("is path2 absolute:" + path2.isAbsolute());
	}

}