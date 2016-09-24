import java.time.*;
import java.util.*;
public class ZonedDatePrac {
	public static void main(String... args) {

		System.out.println("=====10 zone ids that contain America:====");
		ZoneId.getAvailableZoneIds().stream()
			.filter(z -> z.contains("America"))
			.limit(10)
			.sorted().forEach(System.out::println);

		System.out.println("=====zone id for Caracas:====");
		ZoneId.getAvailableZoneIds().stream()
			.filter(z -> z.contains("Caracas"))
			.sorted().forEach(System.out::println);	

		System.out.println("=====zone id for Melbourne:====");
		ZoneId.getAvailableZoneIds().stream()
			.filter(z -> z.contains("Melbourne"))
			.sorted().forEach(System.out::println);

		System.out.println("=====zone id for GMT +2:====");	
		System.out.println(ZoneId.of("GMT+2"));
		System.out.println("getDisplayName:" + ZoneId.of("GMT+2").getDisplayName(java.time.format.TextStyle.FULL, Locale.getDefault()));

		System.out.println("=====zone id for ZoneOffset +2:====");	
		System.out.println(ZoneId.of("+02:00"));

		System.out.println("=====zone id for UTC+01:00:====");	
		System.out.println(ZoneId.of("UTC+01:00"));

		System.out.println("=====zone id for UT+01:00:====");	
		System.out.println(ZoneId.of("UT+01:00"));

		System.out.println("=====zone id for default:====");	
		//System.out.println(TimeZone.getDefault()); //PRINTS A WHOLE LOT OF THINGS
		System.out.println(ZoneId.systemDefault()); 

		System.out.println("=====get daylight savings for Melbourne:====");
		ZonedDateTime zonedDateTimeNow = ZonedDateTime.now();
		System.out.println("zoneId:" + zonedDateTimeNow.getZone());

		//the following is the period of the offset for daylight savings but not the actual daylight savings
		Duration dls = zonedDateTimeNow.getZone().getRules().getDaylightSavings(zonedDateTimeNow.toInstant());
		System.out.println("daylight savings:" + dls);

		//zonedDateTimeNow.getZone().getRules().getTransitions().stream().forEach(System.out::println);
		System.out.println("next Daylight Savings (next transition):" + zonedDateTimeNow.getZone().getRules().nextTransition(zonedDateTimeNow.toInstant()));



		System.out.println("=====converting zoneid to instant:====");
		LocalDate date = LocalDate.of(2015, 5, 25);
		LocalTime time = LocalTime.of(11, 55, 00);
		ZoneId zone = ZoneId.of("US/Eastern");
		ZonedDateTime zonedDateTime = ZonedDateTime.of(date, time, zone);
		Instant instant = zonedDateTime.toInstant(); // 2015–05–25T15:55:00Z
		System.out.println(zonedDateTime); // 2015–05–25T11:55–04:00[US/Eastern]
		System.out.println(instant); // 2015–05–25T15:55:00Z

		System.out.println("=====daylight savings prac:====");
		LocalDate dateMelbourne = LocalDate.of(2016, Month.OCTOBER, 2);
		LocalTime timeMelbourne = LocalTime.of(1, 30);
		ZoneId zoneMelbourne = ZoneId.of("Australia/Sydney");
		ZonedDateTime dateTimeMelbourne = ZonedDateTime.of(dateMelbourne, timeMelbourne, zoneMelbourne);
		System.out.println(dateTimeMelbourne); // 2016-10-02T01:30+10:00[Australia/Sydney]
		dateTimeMelbourne = dateTimeMelbourne.plusHours(1);
		System.out.println(dateTimeMelbourne); // 2016-10-02T03:30+11:00[Australia/Sydney]

	}	
}