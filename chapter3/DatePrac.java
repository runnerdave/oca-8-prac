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
		System.out.println("Current time time: " + myDateTime);
		LocalTime myOtherTime = LocalTime.of(7,30);
		System.out.println("Other time: " + myOtherTime);
		//loop and add one minute ten times
		for(int i=1;i<=10;i++){
			System.out.println(myOtherTime.plusMinutes(i));
		}
		//check immutability of time
		System.out.println(myOtherTime);
		Period p = Period.ofMonths(1);
		System.out.println(myDate.plus(p));
		DateTimeFormatter f = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy MM dd");
		System.out.println(formatter.format(myDate));
		LocalDate myDate2 = LocalDate.of(1976, 2, 35);
		System.out.println(myDate2);
	}
}
