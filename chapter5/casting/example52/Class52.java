interface I{
}
class A implements I{
}

class B extends A {
}

class C extends B{
}
public class Class52 {
	A a = new A();
	B b = new B();

	public Class52() {
		//b = (B)(I) a; //FAILS AT RUNTIME - note that b and the last cast match therefore it compiles but a cannot be cast to B
		//I i = (C) a; //FAILS AT RUNTIME - note that C implements I via inheritance
		//a = (I) b; //DOES NOT COMPILE - note that a cannot be converted to I
		a = (B)(I)b; //CORRECT ANSWER - note that the casting is unnecessary if it was only (B) but because of (I) is necessary

		
	}
	
	public static void main(String... args) {
		Class52 class52 = new Class52();
		
		System.out.println("testing equality and inheritance: " + (class52.d == class52.e));
		System.out.println("testing equality and inheritance: " + (class52.d == class52.d));
		System.out.println("testing equality and inheritance: " + (class52.f == class52.e));
		//class52.e = class52.f; //DOES NOT COMPILE
		System.out.println("testing equality and inheritance: " + (class52.f == class52.e));
		System.out.println("test!!!");
		
		class52.otherExamples();
	}

	A d = new C();
	A e = new A(); //so it does not interfere with "a"
	I f = new A();

	public void otherExamples() {
		//I i = (I)b; //WORKS
		//I i = b; //WORKS TOO
		//I i = e; //WORKS TOO
		//I i = (I)e; //WORKS TOO

		//I i = (I)new A(); //WORKS FINE

		//e = (I)e; //DOES NOT COMPILE

		//b = (B)e; //FAILS AT RUNTIME

		//example of narrowing
		//b = (B)d;

		d = (A)b; //WORKS

		//e = (B)b; //WORKS FINE

		//b = (I)e; //DOES NOT COMPILE

		//b = (A)e; //DOES NOT COMPILE
		//b = (C)e; //DOES NOT COMPILE


		//b = (C)d; //WORKS FINE
		//b = (B)d; //WORKS FINE

		//C c = (A)b; //DOES NOT COMPILE

	}
}