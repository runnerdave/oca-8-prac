import java.io.*;
public class PrintStreamSample {
	public static void main(String[] args) throws IOException {
		File source = new File("zoo.log");
		try (PrintStream out = new PrintStream(
			new BufferedOutputStream(new FileOutputStream(source)))) {
				out.println("==With PrintStream==");
				out.print("Today's weather is: ");
				out.println("Sunny");
				out.print("Today's temperature at the zoo is: ");
				out.print(1/3.0);
				out.println('C');
				out.format("It has rained 10.12 inches this year");
				out.println();
				out.printf("It may rain 21.2 more inches this year");
		}

		//to a file directly
		File sourceDirect = new File("zooDirect.log");
		try (PrintStream out = new PrintStream(sourceDirect)) {
				out.println("==With PrintStream==");
				out.println("to file directly");
				out.print("Today's weather is: ");
				out.println("Sunny");
				out.print("Today's temperature at the zoo is: ");
				out.print(1/3);
				out.println('C');
				out.format("It has rained 10.12 inches this year");
				out.println();
				out.printf("It may rain 21.2 more inches this year");
		}
	}
}
