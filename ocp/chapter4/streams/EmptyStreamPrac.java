import java.util.stream.*;
import java.util.*;

public class EmptyStreamPrac {
	
	public static void main(String... argts) {
		//Which of the following are true? (Choose all that apply.)
		

	}

	private static void magic(Stream<Integer> s) {
	  Optional o = s.filter(x -> x > 5).peek(System.out::println).max((x, y) -> x - y);  
	  System.out.println(o.get());
	}
}

/**
A.magic(Stream.empty()); runs infinitely.
B.magic(Stream.empty()); throws an exception.
C.magic(Stream.iterate(1, x -> x++)); runs infinitely.
D.magic(Stream.iterate(1, x -> x++)); throws an exception.
E.magic(Stream.of(5,10)); runs infinitely.
F.magic(Stream.of(5, 10)); throws an exception.
G.The method does not compile.*/