import java.nio.file.*;
import java.nio.file.attribute.*;
import java.io.IOException;

public class q6 {

	/*

	Given that /animals is a directory that exists and it is empty, what is the result of the fol-
	lowing code?
	
	A. It prints No Sub-directory.
	B. It prints Has Sub-directory.
	C. The code will not compile because of line w1.
	D. The code will not compile because of line w2.
	E. The output cannot be determined.
	F. It produces an infinite loop at runtime.

	Answer
	C. The code does not compile since the stream output by Files.walk() is Stream<Path>,
	therefore we need a Predictate, not a BiPredicate, on line w1, and the answer is C. If the
	Files.find() method had been used instead, and the lambda had been passed as an argu-
	ment to the method instead of on filter(), the output would be B, Has Sub-directory,
	since the directory is given to be empty. For fun, we reversed the expected output of the
	ternary operation to make sure that you understood the process.
	*/
	public static void main(String... args) throws IOException {
		Path path = Paths.get("/animals");
		boolean myBoolean = Files.walk(path)
								.filter((p,a) -> a.isDirectory() && !path.equals(p)) // w1
								.findFirst().isPresent(); // w2
		System.out.println(myBoolean ? "No Sub-directory": "Has Sub-directory");
	}

}