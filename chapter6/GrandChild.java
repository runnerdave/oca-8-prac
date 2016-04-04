import java.io.IOException;
public class GrandChild extends Parent {
	
	int age = 18;

	public int giveAge() throws Exception, IOException {

		return this.age;
	}

	public static void main(String... args) throws Throwable {
		GrandChild gc = new GrandChild();

		System.out.println("GrandChild age is:" + gc.giveAge());
		System.out.println("GrandChild age via instance variable is:" + gc.age);

		Parent p = gc;

		System.out.println("GrandChild (reference upcasted to parent) " + 
								"age via instance variable is:" + p.age);

		GrandParent gp = gc;

		System.out.println("GrandChild (reference upcasted to Grandparent) " + 
								"age via instance variable is:" + gp.age);

		System.out.println("p is instanceof Parent?:" + (p instanceof Parent));
		System.out.println("gc is instanceof Parent?:" + (gc instanceof Parent));
		System.out.println("p is instanceof GrandChild?:" + (p instanceof GrandChild));
		

		p = new Parent();

		System.out.println("p is instanceof Parent?:" + (p instanceof Parent));
		System.out.println("p is instanceof GrandChild?:" + (p instanceof GrandChild));

		//GrandChild gc2 = (Parent)p;		DOES NOT COMPILE
	}
}