import java.time.*;
import java.time.format.*;
public class FormattingDatesPrac {
	public static void main(String... args) {
		LocalDate date = LocalDate.of(2016, Month.SEPTEMBER, 9);
		LocalTime time = LocalTime.of(13,13,00);
		ZonedDateTime dtz = ZonedDateTime.of(date, time, ZoneId.of("Europe/Berlin"));	
		System.out.println(dtz.format(DateTimeFormatter.ISO_ZONED_DATE_TIME));
		System.out.println(dtz.format(DateTimeFormatter.ISO_DATE_TIME));
		System.out.println(dtz.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
		System.out.println(dtz.format(DateTimeFormatter.ISO_WEEK_DATE));

		DateTimeFormatter shortF = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT); 
		DateTimeFormatter mediumF = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
		System.out.println(dtz.format(shortF));
		System.out.println(shortF.format(dtz));
		System.out.println(dtz.format(mediumF));

		DateTimeFormatter f = DateTimeFormatter.ofPattern("MM dd yyyy"); 
		LocalDate dateF = LocalDate.parse("01 02 2015", f);
		LocalTime timeF = LocalTime.parse("11:22"); 
		System.out.println(dateF); // 2015–01–02 
		System.out.println(timeF); // 11:22
	}
}
