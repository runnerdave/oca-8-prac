import java.util.*;
import java.util.stream.*;

public class q61 {
	

	public static void main(String... args) {
		//Given:	
		String sentence1 = "Carpe diem. Seize the day, boys. Make your lives extraordinary.";
		String sentence2 = "Frankly, my dear, I don't give a damn!";
		String sentence3 = "Do I look like I give a damn?";
		List<String> sentences = Arrays.asList(sentence1, sentence2, sentence3);

		//Which of the following options will create a stream containing all the words in the three sentences without repetition?

		
		//A
		Stream<String> strm = sentences.stream()
			.flatMap(str->Stream.of(str.split("[ ,.!?\r\n]")))
			.filter(s->s.length()>0)
			.distinct();

		/*
		//B
		Stream<String> strm = sentences.stream()
			.map(str->Stream.of(str.split("[ ,.!?\r\n]")))
			.filter(s->s.length()>0)
			.distinct();
		
		
		//C
		Stream<String> strm = sentences.stream()
			.forEach(str->Stream.of(str.split("[ ,.!?\r\n]")))
			.filter(s->s.length()>0)
			.distinct();		
		
		//D
		Stream<String> strm = sentences.stream()
			.flatMap(str->Stream.of(str.split("[ ,.!?\r\n]")))
			.filter(s->s.length()>0)
			.merge();
		
		//E
		Stream<String> strm = sentences.stream()
			.flatMap(str->str.split("[ ,.!?\r\n]"))
			.filter(s->s.length()>0)
			.distinct();
		*/

		System.out.println("===BEFORE===");
		sentences.forEach(s -> System.out.print(s + "|"));

		System.out.println("\r\n===AFTER===");
		strm.forEach(s -> System.out.print(s + "|"));

		//Explanation:
		/*
		A. 	1. The flatMap method replaces one element of a stream with elements of a new stream generated using the original element. 
		Here, the original elements are the sentences. Each of these elements are replaced in the stream with the elements generated 
		by applying str.split("[ ,.!?\r\n]", which basically converts the stream of sentences into a stream of words. 
			2. The stream is now filtered and only thoses elements where the length is greater than 0 are allowed to be in the stream. 
			3. Finally, distinct removes all the duplicates.

		B. The map method is meant to replace one element of stream with another. While the flatMap method replaces one element of a stream 
		with elements of a new stream generated using the original element. Therefore, map is not useful here.

		C. forEach is a terminal operation. You can't chain methods after forEach.

		D. There is no merge method in Stream.

		E. This will not compile because flatMap expects a Function object that returns a Stream. 
		Here, you have a Function object that returns String[].
		*/

	}
	
}
