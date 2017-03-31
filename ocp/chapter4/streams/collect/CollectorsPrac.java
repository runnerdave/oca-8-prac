import java.util.*;
import java.util.stream.*;

//taken from DZone article: https://dzone.com/articles/using-java-collectors

public class CollectorsPrac {
    
    public static void main(String... args) {
        Random random = new Random();

        List<Integer> numbers = random
                                    .ints(1, 100)
                                    .limit(10)
                                    .boxed()
                                    .collect(Collectors.toList());

        System.out.println("==List of randoms:==");
        System.out.println(numbers);

        System.out.println("==sum total==");
        int sum = numbers.stream().collect(Collectors.summingInt(Integer::valueOf)); //or x->x
        System.out.println(sum);

        System.out.println("==average==");
        double avg = numbers.stream().collect(Collectors.averagingInt(x->x));
        System.out.println(avg);

        System.out.println("==max and min==");

        System.out.println("with primitive streams:");
        int max = numbers.stream().mapToInt(x->x).max().getAsInt();
        int min = numbers.stream().mapToInt(x->x).min().getAsInt();
        System.out.println(max + "|" + min);

        System.out.println("with streams:");
        max = numbers.stream().max(Integer::compare).get();
        min = numbers.stream().min(Integer::compare).get();
        System.out.println(max + "|" + min);

        System.out.println("with collectors:");
        max = numbers.stream().collect(Collectors.maxBy(Integer::compare)).get();
        min = numbers.stream().collect(Collectors.minBy(Integer::compare)).get();
        System.out.println(max + "|" + min);

        System.out.println("==Summary with IntSummaryStatistics==");
        IntSummaryStatistics summary = numbers.stream().collect(Collectors.summarizingInt(x->x));
        System.out.println(summary);

        System.out.println("==Partitioning==");
        Map<Boolean, List<Integer>> oddEven = numbers.stream().collect(Collectors.partitioningBy(x->x%2==0));
        System.out.println(oddEven);

    }

}