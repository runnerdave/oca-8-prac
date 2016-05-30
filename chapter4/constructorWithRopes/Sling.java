public class Sling {

	public int width = 1;
     public static int length = 2;

     public int getWidth() {
          return width;
     }

     public static int getLength() {
          return length;
     }

	public Sling(String s) {
		System.out.println("created Sling with string:"+s);
	}

     void getJewels() {
          System.out.println("grand parent");
     }
}
