import java.nio.file.*;

public class q2 {

	/*
	For which values of path inserted on the blank line would it be possible for the following
	code to output Success? (Choose all that apply.)

	Path path = ____________________;
		if(Files.isDirectory(path))
		System.out.println(Files.deleteIfExists(path) ? "Success": "Try Again");

	A. path refers to a regular file in the file system.
	B. path refers to a symbolic link in the file system.
	C. path refers to an empty directory in the file system.
	D. path refers to a directory with content in the file system.
	E. path does not refer to a record that exists within the file system.
	F. The code does not compile.

	Answer:
	B, C. The code snippet compiles without issue, so F is incorrect. If the value refers to a
	regular file, isDirectory() will return false and the statement will be skipped, so A is
	incorrect. Likewise, if the directory does not exist, the method also returns false, so E is
	also incorrect. A symbolic link can point to a real directory, and by default isDirectory()
	follows links, so B is possible. In this case, the symbolic link, not the directory, would be
	deleted. C is also possible and is the simple case of deleting an empty directory. D would
	allow the code to reach the execution block of the if/then statement, but the method
	deleteIfExists() would throw a DirectoryNotEmptyException if it had contents.

	*/
	public static void main(String... args) {
		//
	}

}