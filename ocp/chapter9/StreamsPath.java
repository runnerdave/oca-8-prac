import java.nio.file.*;
import java.net.*;
import java.io.IOException;
import java.util.stream.*;

public class StreamsPath {
	public static void main(String... args) {
		System.out.println("==Welcome to the stream path class==");
		Path path = Paths.get("data/");

		System.out.println("==Files.walk example==");
		try {
			Files.walk(path)
				.filter(p->p.toString().endsWith(".csv"))
				.forEach(System.out::println);

		} catch (IOException io) {
			//do nothing
			io.printStackTrace();
		}

		System.out.println();
		System.out.println("==Files.find example==");
		long dateFilter = 1420070400000l;

		try {
			Stream<Path> stream = Files.find(path, 10, (p,a) -> p.toString().endsWith(".csv")
									&& a.lastModifiedTime().toMillis()>dateFilter); 
			stream.forEach(System.out::println);
		} catch (Exception e) {
		// Handle file I/O exception...
			e.printStackTrace();
		}

		System.out.println();
		System.out.println("==Files.list example==");
		
		try {
			Files.list(path)
					.filter(p -> !Files.isDirectory(p)) 
					.map(p -> p.toAbsolutePath()) 
					.forEach(System.out::println);
		} catch (IOException e) {
		// Handle file I/O exception...
		}

		System.out.println();
		System.out.println("==Files.lines example==");
		
		Path path0 = Paths.get("data/employees.csv"); 
		try {
			Files.lines(path0).forEach(System.out::println);
		} catch (IOException e) {
		// Handle file I/O exception...
		}

	}
}