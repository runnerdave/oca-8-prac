import java.util.*;
public class L18nPrac {
	public static void main(String... args) {
		Locale locale = Locale.getDefault(); 
		System.out.println(locale);
		System.out.println(Locale.GERMANY);
		System.out.println(new Locale("es", "VE"));
	}
}
