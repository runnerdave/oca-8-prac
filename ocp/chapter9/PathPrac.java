import java.nio.file.*;
import java.net.*;
import java.io.IOException;

public class PathPrac {
	public static void main(String... args) throws URISyntaxException {
		Path path1 = Paths.get("data/employees.csv");
		Path path2 = FileSystems.getDefault().getPath("data","employees2.csv");
		// FileSystem fileSystem = FileSystems.getFileSystem( new URI("http://www.selikoff.net"));
		//Exception in thread "main" java.nio.file.ProviderNotFoundException: Provider "http" not found
		
		Path path3 = Paths.get(new URI("file:////data/employees.csv"));

		System.out.println("====Path 1====");		
		printPathInformation(path1);
		System.out.println("====Path 2====");
		printPathInformation(path2);
		System.out.println("====Path 3====");
		printPathInformation(path3);

		System.out.println("===========Relativizing paths: =================");
		Path path4 = Paths.get("fish.txt");
		Path path5 = Paths.get("birds.txt");
		System.out.println(path4.relativize(path5));
		System.out.println(path5.relativize(path4));

		Path path6 = Paths.get("E:\\habitat");
		Path path7 = Paths.get("E:\\sanctuary\\raven");
		System.out.println(path6.relativize(path7));
		System.out.println(path7.relativize(path6));

		System.out.println("===========Evaluating real paths: =================");
		System.out.println("evaluating path1:" + realPath(path1));
		System.out.println("evaluating path4:" + realPath(path4));
		System.out.println("current working directory:" + realPath(Paths.get(".")));
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
		System.out.println("Path is Absolute? "+path.isAbsolute());
		System.out.println("Absolute Path: "+path.toAbsolutePath());
	}

	public static String realPath(Path path) {
		String realPath = "not real";
		try {
			realPath = path.toRealPath().toString();
		} catch(IOException e) {
			//suppress the following exception
			/*java.nio.file.NoSuchFileException: C:\dev\github\oca-8-prac\ocp\chapter9\fish.txt
			        at sun.nio.fs.WindowsException.translateToIOException(Unknown Source)
			        at sun.nio.fs.WindowsException.rethrowAsIOException(Unknown Source)
			        at sun.nio.fs.WindowsLinkSupport.getRealPath(Unknown Source)
			        at sun.nio.fs.WindowsPath.toRealPath(Unknown Source)
			        at sun.nio.fs.WindowsPath.toRealPath(Unknown Source)
			        at PathPrac.realPath(PathPrac.java:54)
			        at PathPrac.main(PathPrac.java:34)*/

		}
		return realPath;
	}
}
