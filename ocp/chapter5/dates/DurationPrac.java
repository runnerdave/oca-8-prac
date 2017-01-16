import java.time.*;

public class DurationPrac {
	public static void main(String... args) {

		//What will the following code print?

		Duration d = Duration.ofMillis(1100);
		System.out.println(d);
		d = Duration.ofSeconds(61);
		System.out.println(d);

		/* 
		a. 	PT1S
			PT1M1S
		b.  PT1S1m
			PT1M1S
		c. 	PT1.1S
			PT61S
		d.	PT1.1S
			PT1M1S


		Answer:
		d.

		Explanation:
		This question is based on how the toString method of java.time.Duration works -  

		It generates a string representation of the duration object using ISO-8601 seconds based 
		representation, such as PT8H6M12.345S.  

		The format of the returned string will be PTnHnMnS, where n is the relevant hours, minutes or 
		seconds part of the duration. Any fractional seconds are placed after a decimal point i the 
		seconds section. If a section has a zero value, it is omitted. The hours, minutes and seconds 
		will all have the same sign. 

		Examples:
		     "20.345 seconds"                 -- "PT20.345S
		      "15 minutes" (15 * 60 seconds)   -- "PT15M"
		       "10 hours" (10 * 3600 seconds)   -- "PT10H"
		        "2 days" (2 * 86400 seconds)     -- "PT48H"

		Note that multiples of 24 hours are not output as days to avoid confusion with Period.
		*/

		d = Duration.ofMillis(110);
		System.out.println(d);

		d = Duration.ofNanos(110);
		System.out.println(d);

	}
}