package rope;
//import rope.Rope; //EXAMPLE OF VALID UNNECESSARY IMPORT
import static java.lang.System.*;
public class Rope {
	{
		System.out.println("in instance constructor");
	}
	static {
		out.println("in static constructor");
	}
	public static int length = 0;
	
}