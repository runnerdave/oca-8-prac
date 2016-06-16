import java.time.*;
import java.time.format.*;
import java.time.temporal.TemporalAdjusters;
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
		System.out.println("now (instant):" + now);
		System.out.println("plus nano    :" + oneNanoLater);
		System.out.println("plus second  :" + oneSecondLater);
		System.out.println("now (LocalDateTime):" + LocalDateTime.now());

		System.out.println("========Playing with TemporalAdjusters:");
		//You want to print the date that represents upcoming tuesday from now even if the current day is a tuesday.
		// Which of the following lines of code accomplishe(s) this?

		System.out.println(LocalDate.now().with(TemporalAdjusters.next(DayOfWeek.TUESDAY)));//this one
		System.out.println(LocalDate.now().with(TemporalAdjusters.nextOrSame(DayOfWeek.TUESDAY)));//This will return today's date if it is a tuesday, which is not what the question wants.
		//System.out.println(new LocalDate().with(TemporalAdjusters.next(DayOfWeek.TUESDAY))); DOES NOT COMPILE
		//System.out.println(new LocalDate().adjust(TemporalAdjusters.next(DayOfWeek.TUESDAY))); DOES NOT COMPILE
		System.out.println(TemporalAdjusters.next(DayOfWeek.TUESDAY).adjustInto(LocalDate.now()));//and this one



        /*         The JavaDoc description of java.time.temporal.TemporalAdjusters is very helpful:  Adjusters are a key
		tool for modifying temporal objects. 

		They exist to externalize the process of adjustment, permitting different
		approaches, as per the strategy design pattern. 

		Examples might be an adjuster that sets the date avoiding weekends, or
		one that sets the date to the last day of the month. 

		There are two equivalent ways of using a TemporalAdjuster. 
		The	first is to invoke the method on the interface directly. 
		The second is to use Temporal.with(TemporalAdjuster):    
		these two lines are equivalent, but the second approach is recommended

		    temporal = thisAdjuster.adjustInto(temporal);
			temporal = temporal.with(thisAdjuster);  

			It is recommended to use the second approach, with(TemporalAdjuster), as it is
		a lot clearer to read in code. This class contains a standard set of adjusters, available as static methods. 
		These include: finding the first or last day of the month finding the first day of next month finding the first or last day of
		the year finding the first day of next year finding the first or last day-of-week within a month, such as "first
		Wednesday in June" finding the next or previous day-of-week, such as "next Thursday"         */     } }
