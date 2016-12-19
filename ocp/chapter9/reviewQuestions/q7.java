import java.nio.file.*;
import java.nio.file.attribute.*;
import java.io.IOException;

public class q7 {

	/*

	If the current working directory is /zoo, and the path /zoo/turkey does not exist, then
	what is the result of executing the following code? (Choose all that apply.)
	
	A. The code compiles and runs without issue, but it does not create any directories.
	B. The directory /zoo/turkey is created.
	C. The directory /zoo/turkey/info is created.
	D. The code will not compile because of line x1.
	E. The code will not compile because of line x2.
	F. It compiles but throws an exception at runtime.

	Answer

	F. The code compiles without issue, so D and E are incorrect. The method Files.isSame-
	File() first checks to see if the Path values are the same in terms of equals(). Since the
	first path is relative and the second path is absolute, this comparison will return false,
	forcing isSameFile() to check for the existence of both paths in the file system. Since we
	know /zoo/turkey does not exist, a NoSuchFileException is thrown and F is the correct
	answer. A, B, and C are incorrect since an exception is thrown at runtime.	
	
	*/
	public static void main(String... args) throws IOException {
		Path path = Paths.get("turkey");
		if(Files.isSameFile(path,Paths.get("/zoo/turkey"))) // x1
			Files.createDirectory(path.resolve("info")); // x2
	}

}