import java.text.*;
import java.util.*;
public class FormattingNumbersPrac {
	public static void main(String... args) {
		int distanceToEarth = 10_000_000;
		double moneyWise = 10_365.99;
		NumberFormat d = NumberFormat.getInstance(Locale.GERMANY);		
		NumberFormat u = NumberFormat.getInstance(Locale.US);		
		System.out.println(d.format(distanceToEarth));
		System.out.println(u.format(distanceToEarth));
		NumberFormat dollars = NumberFormat.getCurrencyInstance(Locale.US);		
		NumberFormat euros = NumberFormat.getCurrencyInstance(Locale.GERMANY);		
		System.out.println(dollars.format(moneyWise));
		System.out.println(euros.format(moneyWise));

		String amt = "$92,807.99";
		try {
			double valueInDollars = (Double)dollars.parse(amt);
			System.out.println("parsed in US:" + valueInDollars);
			double valueInEuros = (Double)euros.parse(amt);
			System.out.println("parsed in GER" + valueInEuros);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		String amt2 = "92,807.99x";
		try {
			double valueInUs = (Double)u.parse(amt2);
			System.out.println("parsed in US:" + valueInUs);
			double valueInGer = (Double)d.parse(amt2);
			System.out.println("parsed in GER:" + valueInGer);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
