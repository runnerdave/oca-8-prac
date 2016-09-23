public class FormattingString {
	public static void main(String... a) {

		String myString = "AKKA";
		System.out.println(String.format("(%s : %d) %-5s %s", "A", 20, "-", myString));

		System.out.printf("%-12s%-12s\n", "Column 1", "Column 2");
		
		System.out.printf("%-12.5f%.20f", 12.23429837482, 9.10212023134);
	}
}