import java.nio.file.*;
import java.nio.file.attribute.*;
import java.io.IOException;

public class q10 {

	/*

	What is correct about the following code snippet? (Choose all that apply.)
	
	
	A. If /animals exists, it will be overwritten at runtime.
	B. If monkey.txt is a symbolic link, the file it points to will be moved at runtime.
	C. If another process is monitoring the file system, it will not see an incomplete file at runtime.
	D. The code will always throw an exception, since no filename is specified in the target folder path.
	E. The metadata of the monkey.txt will be moved along with the file.

	Answer:
	C, E. The REPLACE_EXISTING flag was not provided, so if the target exists, it will throw
	an exception at runtime and A is incorrect. Next, the NOFOLLOW_LINKS option means that if 
	the source is a symbolic link, the link itself and not the target will be copied at runtime, 
	so B is also incorrect. The option ATOMIC_MOVE means that any process monitoring the file system 
	will not see an incomplete file during the move, so C is correct. D is incorrect, since you could 
	rename a file not to have an extension. Note that in this example, if monkey.txt is a file, then 
	the resulting /animals would be a file, not a directory. Likewise, if the source
	is a directory, the result would also be a directory. E is correct, because moving always 
	preserves the metadata even if the COPY_ATTRIBUTES flag is not set.

	*/
	public static void main(String... args) throws IOException {
		Files.move(Paths.get("monkey.txt"), Paths.get("/animals"), 
					StandardCopyOption.ATOMIC_MOVE, 
					LinkOption.NOFOLLOW_LINKS);
	}

}