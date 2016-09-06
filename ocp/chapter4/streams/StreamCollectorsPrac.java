import java.util.stream.*;
import java.util.*;
public class StreamCollectorsPrac {

	public static void main(String... args) {

		System.out.println("=============basic collect==============");
		Stream<String> animals = Stream.of("lion", "bear", "dog");
		List<String> asList = animals.collect(Collectors.toList());
		System.out.println("class of the list:" + asList.getClass()); 

		System.out.println("=============joining==============");
		animals = Stream.of("lion", "bear", "dog");
		asList = animals.collect(Collectors.toList());
		System.out.println(asList); 
		animals = Stream.of("lion", "bear", "dog");
		String joined = animals.collect(Collectors.joining("-"));
		System.out.println(joined); 

		System.out.println("=============averaging ==============");

		animals = Stream.of("lion", "bear", "dog");
		Double ave = animals.collect(Collectors.averagingDouble(s->s.length()));
		System.out.println("double value with averagingDouble:" + ave);

		animals = Stream.of("lion", "bear", "dog");
		ave = animals.collect(Collectors.averagingInt(s->s.length()));
		System.out.println("double value with averagingInt:" + ave);

		System.out.println("=============boxed ==============");
		IntStream myInts = IntStream.of(5,6,7);
		List<Integer> ints = myInts.boxed().collect(Collectors.toList());
		System.out.println(ints); 

		System.out.println("=============counting ==============");
		animals = Stream.of("lion", "bear", "dog");
		Long count = animals.collect(Collectors.counting());
		System.out.println("long value with counting:" + count);

		System.out.println("=============mapping  ==============");
		Stream<String> cars = Stream.of("mazda", "maserati", "lancia", "volkswagen", "lotus");
		Map<String,String> carsMapped = cars.collect(Collectors.toMap(s->s.substring(0,3), s->s));
		System.out.println(carsMapped);

		/*System.out.println("=============grouping ==============");
		Stream<String> cars = Stream.of("mazda", "maserati", "lancia", "volkswagen", "lotus");
		Map<String,List<String>> carsMapped = cars.collect(Collectors.groupingBy(s->s.substring(0,1), HashMap::new,
															mapping(s->s,Collectors.toList())));
		System.out.println(carsMapped);*/
	}

}