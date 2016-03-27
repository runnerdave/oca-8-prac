public class SlingShot extends Sling {
	public int width = 2;
     public static int length = 4;

     public int getWidth() {
          return width;
     }

     public static int getLength() {
          return length;
     }

	public SlingShot() {
		super("called super constructor");
		System.out.println("see no args!!");
	}
}
