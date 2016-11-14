import java.nio.file.*;
import java.net.*;

public class PathPrac {
	public static void main(String... args) throws URISyntaxException {
		Path path1 = Paths.get("data/employees.csv");
		Path path2 = FileSystems.getDefault().getPath("data","employees2.csv");
		//FileSystem fileSystem = FileSystems.getFileSystem( new URI("http://www.selikoff.net"));
		//Exception in thread "main" java.nio.file.ProviderNotFoundException: Provider "http" not found
		
		Path path3 = Paths.get(new URI("file:////data/employees.csv"));

		System.out.println("====Path 1====");		
		printPathInformation(path1);
		System.out.println("====Path 2====");
		printPathInformation(path2);
		System.out.println("====Path 3====");
		printPathInformation(path3);
	}
	public static void printPathInformation(Path path) {
		System.out.println("The Path Name is: "+path);
		for(int i=0; i<path.getNameCount(); i++) {
			System.out.println(" Element "+i+" is: "+path.getName(i));
		}
		System.out.println("Filename is: "+path.getFileName()); 
		System.out.println("Root is: "+path.getRoot());
		Path currentParent = path;
		while((currentParent = currentParent.getParent()) != null) {
			System.out.println(" Current parent is: "+currentParent); 
		}
	}
}
