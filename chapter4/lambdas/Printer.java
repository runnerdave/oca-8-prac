public class Printer {
	public static void main(String... d) {
		Printable aja = s -> System.out.println(s);
		aja.printMe("aqui estoy");

		printMessage("aqui no estoy", aja);
	}

	public static void printMessage(String message, Printable printable) {
		printable.printMe(message);
	}
}

interface Printable {
	public void printMe(String message);
}