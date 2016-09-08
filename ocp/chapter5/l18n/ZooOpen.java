import java.util.*; 
public class ZooOpen {
	public static void main(String[] args) {
	 	Locale us = new Locale("en", "US");
	 	Locale france = new Locale("fr", "FR");
	 	Locale venezuela = new Locale("es", "VE");
	 	Locale spain = new Locale("es", "ES");
		printProperties(us); 
		System.out.println(); 
		printProperties(france);
		System.out.println(); 
		printProperties(venezuela);
		System.out.println(); 
		printProperties(spain);
	}
	public static void printProperties(Locale locale) { 
		ResourceBundle rb = ResourceBundle.getBundle("Zoo", locale); 
		System.out.println(rb.getString("hello")); 
		System.out.println(rb.getString("open"));
	} 
}