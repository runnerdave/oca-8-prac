import java.nio.file.*;
import java.nio.file.attribute.*;

public class q3 {

	/*

	What is the result of executing the following code? (Choose all that apply.)

	
	A. It compiles and runs without issue.
	B. The code will not compile because of line 2.
	C. The code will not compile because of line 3.
	D. The code will not compile because of line 4.
	E. The code compiles but throws an exception at runtime.

	Answer:
	D. The setTimes() method is available only on BasicFileAttributeView, not the read-
	only BasicFileAttributes class, so line 4 will not compile and D is correct. You need to
	retrieve an instance of the view class to update the data. The rest of the lines compile with-
	out issue and only D is correct.

	*/
	public static void main(String... args) {
		Path path = Paths.get("sloth.schedule");
		BasicFileAttributes attributes = Files.readAttributes(path, BasicFileAttributes.class);
		if(attributes.size()>0 && attributes.creationTime().toMillis()>0) {
			attributes.setTimes(null,null,null);
		}
	}

}