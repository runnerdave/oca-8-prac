import java.nio.file.*;
import java.nio.charset.*;
import java.net.*;
import java.io.IOException;
import java.io.*;
import java.nio.file.attribute.UserPrincipal;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.FileTime;
import java.time.*;

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

		System.out.println("======Reading a file (employees.csv): =======");
		Path path = Paths.get("data/employees.csv");
		try (BufferedReader reader = Files.newBufferedReader(path, Charset.forName("US-ASCII"))) {
			// Read from the stream
			String currentLine = null;
			while((currentLine = reader.readLine()) != null)
			System.out.println(currentLine); 

			System.out.println("---Last modification:" + Files.getLastModifiedTime(path).toMillis());
			System.out.println("---Last modification:" + Files.getLastModifiedTime(path).toString());
		} 
		catch (IOException e) {
			// Handle file I/O exception... 
		}

		System.out.println("======Writing to a file (employees.csv): =======");
		try (BufferedWriter writer = Files.newBufferedWriter(path, Charset.forName("US-ASCII"), 
					StandardOpenOption.APPEND);
			BufferedReader reader = Files.newBufferedReader(path, Charset.forName("US-ASCII"))) {

			
			//write to file only if last line is not petra
			if (checkLastLine("petra,3,77789,Anaco", reader)) {
				writer.write("\npetra,3,77789,Anaco");
			}
			 
		} catch (IOException e) {
			// Handle file I/O exception... 
		}
		try (BufferedReader reader = Files.newBufferedReader(path, Charset.forName("US-ASCII"))) {
			// Read from the stream
			String currentLine = null;
			while((currentLine = reader.readLine()) != null)
			System.out.println(currentLine); } 
		catch (IOException e) {
			// Handle file I/O exception... 
		}

		System.out.println("======get the owner information for file (employees.csv): =======");

		try {
			System.out.println(Files.getOwner(path).getName());
			UserPrincipal owner = path.getFileSystem()
				.getUserPrincipalLookupService().lookupPrincipalByName("davidajimenez");
			System.out.println(owner);	
			Files.setOwner(path, owner);
		} catch (IOException e) {
			//will print info if the owner is not present
			e.printStackTrace();
		} 

		System.out.println("======get the information using Views (BasicFileAttributes) for file (employees.csv): =======");
		try {

			getFileAttributesReadOnly(path);
			System.out.println("%%%%%% modify file:");
			setFileAttributes(path);
			System.out.println("%%%%%% read file again:");
			getFileAttributesReadOnly(path);
		} catch (IOException e) {
			//will print info if the owner is not present
			e.printStackTrace();
		} 
	}

	private static boolean checkLastLine(String value, BufferedReader reader) throws IOException {
		boolean hasValueAsLastLine = false;
		//reader.lines().peek(System.out::println).forEach(s->s.toString());
		hasValueAsLastLine = reader.lines().noneMatch(s->s.trim().equalsIgnoreCase(value));
		return hasValueAsLastLine;
	}

	private static void getFileAttributesReadOnly(Path path) throws IOException {
		BasicFileAttributes data = Files.readAttributes(path, BasicFileAttributes.class);
		System.out.println("Is path a directory? "+data.isDirectory());
		System.out.println("Is path a regular file? "+data.isRegularFile());
		System.out.println("Is path a symbolic link? "+data.isSymbolicLink());
		System.out.println("Path not a file, directory, nor symbolic link? "+ data.isOther());
		System.out.println("Size (in bytes): "+data.size());
		System.out.println("Creation date/time: "+data.creationTime());
		System.out.println("Last modified date/time: "+data.lastModifiedTime());
		System.out.println("Last accessed date/time: "+data.lastAccessTime());
		System.out.println("Unique file identifier (if available): "+ data.fileKey());
	}

	private static void setFileAttributes(Path path) throws IOException {
		BasicFileAttributeView view = Files.getFileAttributeView(path,BasicFileAttributeView.class);
		BasicFileAttributes data = view.readAttributes();
		FileTime now = FileTime.from( Instant.now());
		view.setTimes(now,null,null);
	}
}