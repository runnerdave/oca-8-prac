import java.io.*;
public class SystemInSample {
	public static void main(String[] args) throws IOException {
		System.out.println("Please enter your text:");
		BufferedReader reader = new BufferedReader(
												new InputStreamReader(System.in));
		String userInput = reader.readLine();
		System.out.println("You entered the following: " + userInput);

		System.out.println("Object for System.out:" + System.out);

		System.out.println("==== Equivalent for console ====");

		System.console().writer().println("You entered the following: " + userInput);

		System.out.println("Object for System.console().writer():" + System.console().writer());
		System.out.println("Object for System.console().writer() instanceof PrintWriter?:" 
						+ (System.console().writer() instanceof PrintWriter));

	}
}