import java.io.*;
import java.util.*;
public class ConsoleSamplePrint {
	public static void main(String[] args) throws NumberFormatException,
	IOException {
		Console console = System.console();
		if(console == null) {
			throw new RuntimeException("Console not available");
		} else {
			console.writer().println("Welcome to Our Zoo!");
			console.format("Our zoo has %d animals and employs %d people.", 391, 25);
			console.writer().println();
			console.printf("The zoo spans %.2f acres.", 128.91);
			console.writer().println();
			console.writer().format(new Locale("fr", "CA"),"Hello World");
		}
	}
}