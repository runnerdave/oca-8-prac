import java.nio.file.*;
import java.nio.file.attribute.*;
import java.io.IOException;

public class q5 {

	/*

	Assume /kang exists as a symbolic link to the directory /mammal/kangaroo within the file
	system. Which of the following statements are correct about this code snippet? (Choose all
	that apply.)
	
	A. A new directory will always be created.
	B. A new directory will be created only if /mammal/kangaroo exists.
	C. If the code creates a directory, it will be reachable at /kang/joey.
	D. If the code creates a directory, it will be reachable at /mammal/kangaroo/joey.
	E. The code does not compile.
	F. The code will compile but always throws an exception at runtime.

	Answer
	D
	B, C, D. The first clause of the if/then statement will be true only if the target of the
	symbolic link, /mammal/kangaroo, exists, since by default isDirectory() follows sym-
	bolic links, so B is correct. Option A is incorrect because /mammal/kangaroo may not exist
	or /mammal/kangaroo/joey may already exist. If /mammal/kangaroo does exist, then the
	directory will be created at /mammal/kangaroo/joey, and because the symbolic link would
	be accessible as /kang/joey, C and D are both correct. E is incorrect, because the code
	compiles without issue. F is incorrect because the code may throw an exception at runtime,
	such as when the file system is unavailable or locked for usage; thus it is not guaranteed to
	throw an exception at runtime.

	*/
	public static void main(String... args) throws IOException {
		Path path = Paths.get("/kang");
		if(Files.isDirectory(path) && Files.isSymbolicLink(path))
			Files.createDirectory(path.resolve("joey"));
	}

}