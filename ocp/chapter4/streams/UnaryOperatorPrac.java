import java.util.stream.*;
import java.time.*;
import java.time.temporal.*;
import java.util.function.*;

public class UnaryOperatorPrac {
	
	public static void main(String... args) {
		//Assume that today is June 1, 2016. What is the result of the following?

		Stream<LocalDate> s = Stream.of(LocalDate.now());
		UnaryOperator<LocalDate> u = l->l;
		System.out.println(s.filter(l->l != null).map(u));

		//my own thing
		UnaryOperator<LocalDate> uu = l->l.plus(1, ChronoUnit.DAYS);
		Stream<LocalDate> ss = Stream.of(LocalDate.now());
		ss
//			.filter(l->l != null)
			.map(uu)
			.forEach(System.out::println);
	}
	
	//explanation, because map is an intermediate operation it prints the stream object to make it print something you need to use a terminal op
}
