import java.util.*; 
public class ZooOpen {
	public static void main(String[] args) {
	 	Locale us = new Locale("en", "US");
	 	Locale france = new Locale("fr", "FR");
		printProperties(us); 
		System.out.println(); 
		printProperties(france);

		System.out.println("====using Properties object===");
		usePropertiesObject(france);
	}
	public static void printProperties(Locale locale) { 
		ResourceBundle rb = ResourceBundle.getBundle("Zoo", locale); 
		System.out.println(rb.getString("hello")); 
		System.out.println(rb.getString("open"));
		//System.out.println(rb.getString("hola")); THROWS EXCEPTION
	} 

	public static void usePropertiesObject(Locale locale) {
		Properties props = new Properties();

		ResourceBundle rb = ResourceBundle.getBundle("Zoo", locale); 
		rb.keySet().stream()
			.forEach(k -> props.put(k, rb.getString(k)));

		System.out.println("with getProperty:" + props.getProperty("hello"));
		System.out.println("with get:" + props.get("hello"));
		System.out.println("with getProperty for property that does not exist:" + props.getProperty("hola")); //retuns null
		System.out.println("with getProperty for property that does not exist with default:" + props.getProperty("hola", "defaulte")); //retuns defaulte
	}
}