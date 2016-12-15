import java.nio.file.*;
import java.net.*;
import java.io.IOException;
import java.io.*;

public class FilesPrac {
	public static void main(String... args) {
		System.out.println("======Check for file and directory existance: =======");
		System.out.println("'data/employees.csv' should be true:" + Files.exists(Paths.get("data/employees.csv"))); 
		System.out.println("'/ostrich' should be false:" + Files.exists(Paths.get("/ostrich")));

		System.out.println("======Directory creation: =======");
		Path path1 = Paths.get("data/field");
		Path path2 = Paths.get("data/field/pasture/green");
		Path path3 = path2.subpath(0,3);
		try {
			Files.deleteIfExists(path2);
			Files.deleteIfExists(path3);
			Files.deleteIfExists(path1);

			Files.createDirectory(path1);
			Files.createDirectories(path2);
			System.out.println("both directories exist? should be true,true:" 
					+ Files.exists(path1) + "," + Files.exists(path2));
			//delete directories
			Files.deleteIfExists(path2);
			Files.deleteIfExists(path3);
			Files.deleteIfExists(path1);			
		} catch (IOException e) {
		// Handle file I/O exception...
			e.printStackTrace();
		} 

		System.out.println("======Directory copying: =======");
		try {
			Path path0 = Paths.get("data/employees.csv");
			Path path01 = Paths.get("data/employees3.csv");
			Files.copy(path0, path01, StandardCopyOption.REPLACE_EXISTING);
			System.out.println("both directories exist? should be true,true:" 
					+ Files.exists(path0) + "," + Files.exists(path01));
		} catch (IOException e) {
		// Handle file I/O exception...
			e.printStackTrace();
		} 

		try (InputStream is = new FileInputStream("data/employees.csv");
				OutputStream out = new FileOutputStream("data/employees3.csv")) {		 
			// Copy stream data to file
			Files.copy(is, Paths.get("data/wolf.txt"));
			// Copy file data to stream
			Files.copy(Paths.get("data/employees.csv"), out);
		} catch (IOException e) {
		// Handle file I/O exception...
		}
	}
}