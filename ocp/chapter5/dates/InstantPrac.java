import java.time.*;
import java.time.temporal.*;
import java.util.concurrent.*;

public class InstantPrac {
    public static void main(String... args) {
        Instant now = Instant.now();
        System.out.println("==Printing now==");
        System.out.println(now);
        System.out.println("==truncating now to minutes==");
        System.out.println(now.truncatedTo(ChronoUnit.MINUTES));
        System.out.println("==truncating now to hours==");
        System.out.println(now.truncatedTo(ChronoUnit.HOURS));
        System.out.println("==truncating now to days==");
        System.out.println(now.truncatedTo(ChronoUnit.DAYS));
        System.out.println("==truncating now to months==");
        try {
            System.out.println(now.truncatedTo(ChronoUnit.MONTHS));//throws exception
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("==calculate duration between instants==");
        Instant first = Instant.now();
        // wait some time while something happens
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            // Restore the interrupted status
             Thread.currentThread().interrupt();
        }
        
        Instant second = Instant.now();
        Duration duration = Duration.between(first, second);
        System.out.println(duration);

        System.out.println( Duration.between(first, first.plusSeconds(2)));
    }
}

