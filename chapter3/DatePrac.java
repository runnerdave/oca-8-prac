import java.time.*;
import java.time.format.*;
public class DatePrac {
	public static void main(String[] args){
		String myInt = 4 + "";
		LocalTime myTime = LocalTime.now();
		LocalDate myDate = LocalDate.now();
		LocalDateTime myDateTime = LocalDateTime.now();
		System.out.println(myInt);
		System.out.println("Current time: " + myTime);
		System.out.println("Current date: " + myDate);
		System.out.println("Current date time: " + myDateTime);

		System.out.println("Date of 13/02/2013: " + LocalDate.of(2013,02,13));
		System.out.println("LocalDateTime of 13/02/2013 11:51am: " + LocalDateTime.of(2013,02,13,11,51));

		LocalTime myOtherTime = LocalTime.of(7,30);
		System.out.println("Other time(7:30): " + myOtherTime);
		System.out.println("Other time(7:30) plus a duration of 30 minutes: " + myOtherTime.plus(Duration.ofMinutes(30)));
		//loop and add one minute ten times
		for(int i=1;i<=10;i++){
			System.out.println(myOtherTime.plusMinutes(i));
		}
		//check immutability of time
		System.out.println("after going through a loop of 10 minutes notice immutability:" + myOtherTime);
		Period p = Period.ofDays(2).ofYears(5).ofMonths(1);
		System.out.println("after adding, via period, a month and a year and a day (only month is added):" + myDate.plus(p));
		DateTimeFormatter f = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy MM dd");
		System.out.println("formatting current time using yyyy MM dd pattern:" + formatter.format(myDate));
		System.out.println("formatting current time using FormatStyle.MEDIUM:" + formatter.format(myDate));
		//LocalDate myDate2 = LocalDate.of(1976, 2, 35);
		//System.out.println("print out a date of 35/2/1976:" + myDate2);//throws exception

		System.out.println("========Playing with instant:");
		Instant now = Instant.now();
		Instant oneNanoLater = Instant.now().plusNanos(1);
		Instant oneSecondLater = Instant.now().plusSeconds(1);
		System.out.println("instant of now compared with instant one nano and second later:");
		System.out.println("now        :" + now);
		System.out.println("plus nano  :" + oneNanoLater);
		System.out.println("plus second:" + oneSecondLater);
	}
}
