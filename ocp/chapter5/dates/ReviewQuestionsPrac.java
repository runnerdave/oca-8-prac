import java.time.*;
import java.time.temporal.*;
import java.time.format.*;
public class ReviewQuestionsPrac {
	public static void main(String... a) {

		/*
		10. What is the output of the following code?

		A. 3/7/14 11:22 AM
		B. 5/10/15 11:22 AM
		C. 3/7/14
		D. 5/10/15
		E. 11:22 AM
		F. The code does not compile.
		G. A runtime exception is thrown.
		*/
		System.out.println("===Question 10===");
		LocalDateTime d = LocalDateTime.of(2015, 5, 10, 11, 22, 33); 
		Period p = Period.of(1, 2, 3);//2014-3-7
		d = d.minus(p);
		DateTimeFormatter f = DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT); 
		System.out.println(d.format(f));//

		System.out.println("for full date:" + d.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT)));


		/*
		12. Which of the answer choices is true given the following code? (Choose all that apply.)

		2016–08–28T05:00 GMT-04:00  -- 09:00 GMT
		2016–08–28T09:00 GMT-06:00  -- 15:00 GMT

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
		LocalDate date12 = LocalDate.parse("2016-08-28");
		
		LocalTime time12_a = LocalTime.of(5, 0, 0);
		LocalTime time12_b = LocalTime.of(9, 0, 0);
		
		ZoneId zoneId12_a = ZoneId.of("GMT-4");
		ZoneId zoneId12_b = ZoneId.of("GMT-6");

		ZonedDateTime zoneDT12_a = ZonedDateTime.of(date12, time12_a, zoneId12_a);
		ZonedDateTime zoneDT12_b = ZonedDateTime.of(date12, time12_b, zoneId12_b);

		System.out.println("ZDT 1:" + zoneDT12_a);		
		System.out.println("ZDT 2:" + zoneDT12_b);	

		System.out.println("Difference 1 and 2:" + Duration.between(zoneDT12_a, zoneDT12_b));

		System.out.println("Difference 2 and 1:" + Duration.between(zoneDT12_b, zoneDT12_a));			

		System.out.println("Is date 1 earlier than date 2:" + (zoneDT12_a.compareTo(zoneDT12_b) < 0));

		/*
		13. Note that March 13, 2016, is the weekend that clocks spring ahead for daylight savings time. 
		What is the output of the following?

		LocalDate date = LocalDate.of(2016, Month.MARCH, 13); 
		LocalTime time = LocalTime.of(1, 30);
		ZoneId zone = ZoneId.of("US/Eastern");
		ZonedDateTime dateTime1 = ZonedDateTime.of(date, time, zone); 
		ZonedDateTime dateTime2 = dateTime1.plus(1, ChronoUnit.HOURS);
		long hours = ChronoUnit.HOURS.between(dateTime1, dateTime2); 
		int clock1 = dateTime1.getHour();
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

		LocalDate date = LocalDate.of(2016, Month.MARCH, 13); 
		LocalTime time = LocalTime.of(1, 30);
		ZoneId zone = ZoneId.of("US/Eastern");
		ZonedDateTime dateTime1 = ZonedDateTime.of(date, time, zone); 
		ZonedDateTime dateTime2 = dateTime1.plus(1, ChronoUnit.HOURS);
		long hours = ChronoUnit.HOURS.between(dateTime1, dateTime2); //1 -- not 2 because offset changes as well
		int clock1 = dateTime1.getHour(); //1
		int clock2 = dateTime2.getHour(); //3
		System.out.println(hours + "," + clock1 + "," + clock2);

		System.out.println("Difference " + dateTime1 + " and " + dateTime2 + ":" + Duration.between(dateTime1, dateTime2));

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