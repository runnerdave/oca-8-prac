public interface Live {
	public void live();

     public final static int heart = 2;

     public static int numberOfLegs = 4;

	public static void sysoutLive(){
		System.out.println("I am showing i can live");
	}

     public default void showDefault() {
          System.out.println("default from Live");
     }
}
