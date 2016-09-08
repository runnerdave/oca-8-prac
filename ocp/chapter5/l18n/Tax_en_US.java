import java.util.*;
public class Tax_en_US extends ListResourceBundle {
	protected Object[][] getContents() {
		return new Object[][] { 
			{ "tax", new UsTaxCode() },
			{ "president", "Obama" }  
		};
	}
	public static void main(String[] args) {
		ResourceBundle rb = ResourceBundle.getBundle("Tax", Locale.US);
		System.out.println(rb.getObject("tax"));
		System.out.println(rb.getObject("president"));
	}
}

class UsTaxCode {
	double rate = 0.4;

	@Override
	public String toString() {
		return "" + rate;
	}
}