import java.time.*;
import java.time.format.*;
import java.util.*;
public class FormattingDatesPrac {
	public static void main(String... args) {
		LocalDate date = LocalDate.of(2016, Month.SEPTEMBER, 11);
		LocalTime time = LocalTime.of(13,13,00);
		ZonedDateTime dtz = ZonedDateTime.of(date, time, ZoneId.of("Europe/Berlin"));	
		System.out.println(dtz);

		System.out.println("ISO_ZONED_DATE_TIME:" + dtz.format(DateTimeFormatter.ISO_ZONED_DATE_TIME));
		System.out.println("ISO_DATE_TIME:" + dtz.format(DateTimeFormatter.ISO_DATE_TIME));
		System.out.println("ISO_LOCAL_DATE_TIME:" + dtz.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
		System.out.println("ISO_WEEK_DATE:" + dtz.format(DateTimeFormatter.ISO_WEEK_DATE));

		DateTimeFormatter shortF = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT); 
		DateTimeFormatter mediumF = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
		DateTimeFormatter shortF_forUS = shortF.withLocale(Locale.US);
		System.out.println("FormatStyle.SHORT:" + dtz.format(shortF));
		System.out.println("FormatStyle.SHORT(reversed):" + shortF.format(dtz));
		System.out.println("FormatStyle.SHORT(for US):" + shortF_forUS.format(dtz));
		System.out.println("FormatStyle.MEDIUM:" + dtz.format(mediumF));

		DateTimeFormatter f = DateTimeFormatter.ofPattern("MM dd yyyy"); 
		LocalDate dateF = LocalDate.parse("01 02 2015", f);
		LocalTime timeF = LocalTime.parse("11:22"); 
		System.out.println("parse\"01 02 2015\":" + dateF); // 2015–01–02 
		System.out.println("parse\"11:22\":" + timeF); // 11:22

	}
}
