import java.nio.file.*;
import java.io.IOException;

public class WalkFindListPrac {
	public static void main(String... args) throws IOException {
		Path p1 = Paths.get("../data");

		System.out.println("==walk full depth==");
		Files.walk(p1).forEach(System.out::println);

		System.out.println("==walk one level deep==");
		Files.walk(p1, 1, FileVisitOption.FOLLOW_LINKS).forEach(System.out::println);

		System.out.println("==find full depth==");
		Files.find(p1, 2, (p, basicFileAttributes) -> String.valueOf(p).endsWith(".txt"), FileVisitOption.FOLLOW_LINKS).forEach(System.out::println);
		
		System.out.println("==find matches 'emp' full depth==");
		Files.find(p1, 2, (p, basicFileAttributes) -> String.valueOf(p).indexOf("emp") > -1, FileVisitOption.FOLLOW_LINKS).forEach(System.out::println);

		System.out.println("==list (notice is one level only)==");
		Files.list(p1).forEach(System.out::println);

		System.out.println("==list contents of a file==");
		Files.lines(Paths.get("../data/subData/hello.txt")).forEach(System.out::println);

	}
}
