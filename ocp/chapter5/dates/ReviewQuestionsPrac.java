import java.time.*;
import java.time.temporal.*;
public class ReviewQuestionsPrac {
	public static void main(String... a) {
		/*
		12. Which of the answer choices is true given the following code? (Choose all that apply.)

		2016–08–28T05:00 GMT-04:00 2016–08–28T09:00 GMT-06:00
		280 Chapter 5 Dates, Strings, and Localization

		A. The first date/time is earlier.
		B. The second date/time is earlier.
		C. Both date/times are the same.
		D. The date/times are 2 hours apart.
		E. The date/times are 6 hours apart.
		F. The date/times are 10 hours apart.

		Answer: A;E

		When dealing with time zones, it is best to convert to GMT first by subtracting the time zone. 
		The first date/time is 9:00 GMT, and the second is 15:00 GMT. 
		Therefore, the first one is earlier by 6 hours.

		*/

		System.out.println("===Question 12===");
		System.out.println("TODO: print time difference and boolean testing that dateTime1 is earlier than dateTime2");

		/*
		13. Note that March 13, 2016, is the weekend that clocks spring ahead for daylight savings time. 
		What is the output of the following?

		LocalDate date = LocalDate.of(2016, Month.MARCH, 13); LocalTime time = LocalTime.of(1, 30);
		ZoneId zone = ZoneId.of("US/Eastern");
		ZonedDateTime dateTime1 = ZonedDateTime.of(date, time, zone); ZonedDateTime dateTime2 = dateTime1.plus(1, ChronoUnit.HOURS);
		long hours = ChronoUnit.HOURS.between(dateTime1, dateTime2); int clock1 = dateTime1.getHour();
		int clock2 = dateTime2.getHour();
		System.out.println(hours + "," + clock1 + "," + clock2);

		A. 1,1,2
		B. 1,1,3
		C. 2,1,2
		D. 2,1,3
		E. The code does not compile.
		F. A runtime exception is thrown.

		Answer: B

		dateTime1 is 2016–03–13T01:30–05:00[US/Eastern] 
		and dateTime2 is 2016–03–13T03:30–04:00[US/Eastern]. 
		While the values are two hours apart, the time zone offset changes as well, 
		making it only change from 6:30 GMT to 7:30 GMT.


		*/

		System.out.println("===Question 13===");

		LocalDate date = LocalDate.of(2016, Month.MARCH, 13); LocalTime time = LocalTime.of(1, 30);
		ZoneId zone = ZoneId.of("US/Eastern");
		ZonedDateTime dateTime1 = ZonedDateTime.of(date, time, zone); ZonedDateTime dateTime2 = dateTime1.plus(1, ChronoUnit.HOURS);
		long hours = ChronoUnit.HOURS.between(dateTime1, dateTime2); int clock1 = dateTime1.getHour();
		int clock2 = dateTime2.getHour();
		System.out.println(hours + "," + clock1 + "," + clock2);

		/*
		14. Note that March 13, 2016, is the weekend that we spring forward, 
		and November 6, 2016, is when we fall back for daylight savings time. 
		Which of the following can fill in the blank without the code throwing an exception?
		ZoneId zone = ZoneId.of("US/Eastern");
		LocalDate date =   ;
		LocalTime time1 = LocalTime.of(2, 15);
		ZonedDateTime a = ZonedDateTime.of(date4, time1, zone);

		A. LocalDate.of(2016, 3, 13) 
		B. LocalDate.of(2016, 3, 40) 
		C. LocalDate.of(2016, 11, 6) 
		D. LocalDate.of(2016, 11, 7) 
		E. LocalDate.of(2017, 2, 29)

		Answer: A;C;D

		Option B is incorrect because there is no March 40th. 
		Option E is incorrect because 2017 isn't a leap year and therefore has no February 29th. 
		Option D is correct because it is just a regular date 
		and has nothing to do with daylight savings time. 
		Options A and C are correct because Java is smart enough to adjust for daylight savings time.
		*/

		System.out.println("===Question 14===");

		ZoneId zoneId = ZoneId.of("US/Eastern");		

		LocalTime time1 = LocalTime.of(2, 15);

		LocalDate dateA = LocalDate.of(2016, 3, 13);
		ZonedDateTime zdtA = ZonedDateTime.of(dateA, time1, zoneId);
		System.out.println(zdtA);

		try {
			LocalDate dateB = LocalDate.of(2016, 3, 40);
			ZonedDateTime zdtB = ZonedDateTime.of(dateB, time1, zoneId);
			System.out.println(zdtB);
		} catch(Exception e) {
			System.out.println(e);
		}

		LocalDate dateC = LocalDate.of(2016, 11, 6);
		ZonedDateTime zdtC = ZonedDateTime.of(dateC, time1, zoneId);
		System.out.println(zdtC);

		LocalDate dateD = LocalDate.of(2016, 11, 7);
		ZonedDateTime zdtD = ZonedDateTime.of(dateD, time1, zoneId);
		System.out.println(zdtD);

		try {
			LocalDate dateE = LocalDate.of(2017, 2, 29);
			ZonedDateTime zdtE = ZonedDateTime.of(dateE, time1, zoneId);
			System.out.println(zdtE);
		} catch(Exception e) {
			System.out.println(e);
		}
		
	}
}