import java.io.IOException;
public class GrandChild extends Parent {
	
	int age = 18;

	public int giveAge() throws Exception, IOException {

		return this.age;
	}

	public static void main(String... args) throws Throwable {
		GrandChild gc = new GrandChild();

		System.out.println("GrandChild age is:" + gc.giveAge());

	}
}