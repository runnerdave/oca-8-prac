public class Daughter extends Mother {
	public Daughter(){
		super(0);
		System.out.println("Daughter Created");
	}

	public static void main(String... a){
		System.out.println("testing constructors");
		Mother m = new Daughter();
	}
}
