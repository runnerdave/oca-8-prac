import java.nio.file.*;
import java.net.*;
import java.io.IOException;

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
	}
}