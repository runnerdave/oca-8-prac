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
		System.out.println("====Path 4====");		
		printPathInformation(path4);
		System.out.println("====Path 5====");
		printPathInformation(path5);
		System.out.println("====path4.relativize(path5)====");
		// System.out.println(path4.relativize(path5));		
		printPathInformation(path4.relativize(path5));
		System.out.println("====path5.relativize(path4)====");
		System.out.println(path5.relativize(path4));

		Path path6 = Paths.get("E:\\habitat");
		System.out.println("====Path6====");
		printPathInformation(path6);
		Path path7 = Paths.get("E:\\sanctuary\\raven");
		System.out.println("====Path7====");
		printPathInformation(path7);
		System.out.println("====path6.relativize(path7)====");
		System.out.println(path6.relativize(path7));
		System.out.println("====path7.relativize(path6)====");
		System.out.println(path7.relativize(path6));

		System.out.println("===========Evaluating real paths: =================");
		System.out.println("evaluating path1:" + realPath(path1));
		System.out.println("evaluating path4:" + realPath(path4));
		System.out.println("current working directory:" + realPath(Paths.get(".")));

		System.out.println("===========Sub paths: =================");
		System.out.println("path1.subPath(0,1):" + path1.subpath(0,1));
		System.out.println("path1.subPath(1,2):" + path1.subpath(1,2));
		System.out.println("path1.getName(1):" + path1.getName(1));
		// System.out.println("path1.getName(2):" + path1.getName(2));//THROWS EXCEPTION

		System.out.println("===========Yet another relativize paths prac: =================");
		Path p8 = Paths.get("home");
		Path p9 = Paths.get("home/sally/bar");
		System.out.println("p8:" + p8);
		System.out.println("p9:" + p9);
		// Result is sally/bar
		Path p8_to_p9 = p8.relativize(p9);
		System.out.println("p8.relativize(p9):" + p8_to_p9);
		// Result is ../..
		Path p9_to_p8 = p9.relativize(p8);
		System.out.println("p9.relativize(p8):" + p9_to_p8);
		// Result is 
		Path p9_to_p9 = p9.relativize(p9);
		System.out.println("p9.relativize(p9):" + p9_to_p9); //because relativizing the same file returns an empty path


		System.out.println("===========resolving paths prac: =================");
		Path p8_resolve_to_p9 = p8.resolve(p9);
		//Result is home\home\sally\bar
		System.out.println("p8.resolve(p9):" + p8_resolve_to_p9);
		Path p9_resolve_to_p8 = p9.resolve(p8);
		//Result is home\sally\bar\home
		System.out.println("p9.resolve(p8):" + p9_resolve_to_p8);

		System.out.println("===========normalizing paths prac: =================");
		Path path10 = Paths.get("home/../../foo/../bar");
		//Result is ..\bar
		System.out.println("path10.normalize():" + path10.normalize());
		Path path11 = Paths.get("foo/../bar");
		//Result is bar
		System.out.println("path11.normalize():" + path11.normalize());

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
			        at PathPrac.main(PathPrac.java:34)

			 or in mac:
			 java.nio.file.NoSuchFileException: fish.txt
				at sun.nio.fs.UnixException.translateToIOException(UnixException.java:86)
				at sun.nio.fs.UnixException.rethrowAsIOException(UnixException.java:102)
				at sun.nio.fs.UnixException.rethrowAsIOException(UnixException.java:107)
				at sun.nio.fs.UnixPath.toRealPath(UnixPath.java:837)
				at PathPrac.realPath(PathPrac.java:68)
				at PathPrac.main(PathPrac.java:47)*/
			// e.printStackTrace();

		}
		return realPath;
	}
}
