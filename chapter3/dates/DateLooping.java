import java.time.*;
import java.time.format.*;
import java.time.temporal.*;

public class DateLooping {

	public static void main(String... g) throws InterruptedException {
		DateTimeFormatter fs = DateTimeFormatter.ofPattern("MMM d yyyy ss");
		DateTimeFormatter f = DateTimeFormatter.ofPattern("MMM d yyyy");
		System.out.println("date of now:" + LocalDate.now());
		int i = 0;
		while(i < 3) {
			System.out.println("time of now:" + LocalDateTime.now());

			System.out.println("time of now - formatted:" + LocalDateTime.now().format(fs));

			System.out.println("date of now - formatted:" + LocalDate.now().format(f));			

			System.out.println("date of now - TemporalAdjusters and with:" + LocalDate.now().with(TemporalAdjusters.firstDayOfMonth()));

			System.out.println("date of now - TemporalAdjusters and adjustInto:" + LocalDate.now().adjustInto(LocalDate.parse("2015-07-12")));


			Thread.sleep(3000);
			i++;
		}

	}
}