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
		//b = (B)(I) a; //FAILS AT RUNTIME
		//I i = (C) a; //FAILS AT RUNTIME
		//a = (I) b; //DOES NOT COMPILE
		a = (B)(I)b;
	}
	
	public static void main(String... args) {
		new Class52();
		System.out.println("test!!!");
	}
}