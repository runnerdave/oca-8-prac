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

		cars = Stream.of("mazda", "maserati", "lancia", "volkswagen", "lotus");
		carsMapped = cars.collect(Collectors.toMap(s->s.substring(0,2), s->s, (s, a) -> s + ", " + a));
		System.out.println(carsMapped);//THIS WAY solves the problem of same key for "ma"
		System.out.println("get(\"ma\"):" + carsMapped.get("ma"));

		System.out.println("=============grouping ==============");
		cars = Stream.of("mazda", "maserati", "lancia", "volkswagen", "lotus");
		Map<String,List<String>> carsGrouped = cars.collect(Collectors.groupingBy(s->s.substring(0,1)));
		System.out.println(carsGrouped);
		System.out.println("class of the map:" + carsGrouped.getClass());
		System.out.println("class of the values:" + carsGrouped.get("v").getClass());

		cars = Stream.of("mazda", "maserati", "lancia", "volkswagen", "lotus");
		Map<String,Set<String>> carsGroupedToSet = cars.collect(Collectors.groupingBy(s->s.substring(0,1), Collectors.toSet()));
		System.out.println(carsGroupedToSet);		
		System.out.println("class of the map:" + carsGroupedToSet.getClass());
		System.out.println("class of the values:" + carsGroupedToSet.get("v").getClass());

		cars = Stream.of("mazda", "maserati", "lancia", "volkswagen", "lotus");
		Map<String,Set<String>> carsGroupedToHashSet = cars.collect(Collectors.groupingBy(s->s.substring(0,1), TreeMap::new, Collectors.toSet()));
		System.out.println(carsGroupedToHashSet);		
		System.out.println("class of the map:" + carsGroupedToHashSet.getClass());
		System.out.println("class of the values:" + carsGroupedToHashSet.get("v").getClass());

		System.out.println("=============partitioning ==============");
		cars = Stream.of("mazda", "maserati", "lancia", "volkswagen", "lotus");
		Map<Boolean, List<String>> partitioned = cars.collect(Collectors.partitioningBy(s -> s.indexOf("m") == 0));
		System.out.println("partitioned by starting with \"m\"");
		System.out.println(partitioned);

		
	}

}