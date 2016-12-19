import java.nio.file.*;
import java.nio.file.attribute.*;

public class q4 {

	/*

	If the current working directory is /user/home, then what is the output of the following
	code?
	
	A. animals/bear
	B. koala
	C. /user/home/bear
	D. /user/home/koala/koala
	E. /user/home/food.txt
	F. /user/home/koala/food.txt
	G. The code does not compile.

	Answer
	C
	C. First off, the code compiles without issue, so G is incorrect. Let’s take this one step at a
	time. First, the subpath() method is applied to the absolute path, which returns the relative
	path animals/bear. Next, the getName() method is applied to the relative path, and since
	this is indexed from zero, it returns the relative path bear. Finally, the toAbsolutePath()
	method is applied to the relative path bear, resulting in the current directory being incorpo-
	rated into the path. The final output is the absolute path /user/home/bear, so C is correct.

	*/
	public static void main(String... args) {
		Path path = Paths.get("/zoo/animals/bear/koala/food.txt");
		System.out.println(path.subpath(1,3).getName(1).toAbsolutePath());	
	}

}