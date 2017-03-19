import java.time.temporal.*;
import java.time.*;

public class PrintOutPrac {
	public static void main(String... args) {
	
		//What will the following code print when compiled and run?
		Instant start = Instant.parse("2015-06-25T16:13:30.00z");
		start.plus(10, ChronoUnit.HOURS);
		System.out.println(start);
		Duration timeToCook = Duration.ofHours(1);
		Instant readyTime = start.plus(timeToCook);
		System.out.println(readyTime);
		LocalDateTime ltd = LocalDateTime.ofInstant(readyTime, ZoneId.of("GMT+2"));
		System.out.println(ltd);

		/*options
		a. 2015-06-25T16:13:30Z
		2015-06-25T17:13:30Z
		2015-06-25T15:13:30

		b. T16:13:30Z
		T17:13:30Z
		2015-06-25T19:13:30

		c. 2015-06-25T16:13:30Z
		2015-06-25T17:13:30Z
		2015-06-25T19:13:30

		d. T16:13:30Z
		T17:13:30Z
		2015-06-25T15:13:30

		e. T16:13:30Z
		T17:13:30Z
		<exception stack trace>

		f. <exception stack trace>
		*/
		
		//my own stuff
		System.out.println("=== printing Duration and then period for comparisons==");

		System.out.println(timeToCook);
		ZonedDateTime ztd = ZonedDateTime.ofInstant(start, ZoneId.of("GMT"));
		System.out.println(ztd);
		System.out.println(ZonedDateTime.now());
		
		
	}
}
