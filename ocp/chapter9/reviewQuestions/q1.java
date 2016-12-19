import java.nio.file.*;

public class q1 {

	/*
	What is the output of the following code?
	

	A. /user/.././root/../kodiacbear.txt
	B. /user/./root/kodiacbear.txt/lion
	C. /kodiacbear.txt
	D. kodiacbear.txt
	E. ../lion
	F. The code does not compile.

	Answer: 
	
	F. The code snippet will not compile due to a bug on the first and second lines. The first
	line should use Paths.get(), because there is no method Path.get(). The second line
	passes a String to relativize() instead of a Path object. If both lines were corrected
	to use Paths.get(), then the correct answer would be A. Remember that the normal-
	ize() method, like most methods in the Path interface, does not modify the Path object,
	but instead it returns a new Path object. If it was corrected to reassign the new value to the
	existing path variable, then E would be correct.

	*/
	public static void main(String... args) {
		Path path = Path.get("/user/.././root","../kodiacbear.txt");
		path.normalize().relativize("/lion");
		System.out.println(path);

		//corrected version
		// Path path = Paths.get("/user/.././root","../kodiacbear.txt");
		// path.normalize().relativize(Paths.get("/lion"));
		// System.out.println(path);
	}

}