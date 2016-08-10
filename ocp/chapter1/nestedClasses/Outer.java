public class Outer {
	String greeting = "Hi!";

	private class Inner {
		void sayHello(){
			System.out.println(greeting);
		}
	}

	public void callInner() {
		Inner inner = new Inner();
		inner.sayHello();
	}

	public static void main(String... a){
		Outer outer = new Outer();
		outer.callInner();
		Inner inner = outer.new Inner();
		inner.sayHello();

		Outer.Inner in = new Outer().new Inner();

		//Inner in = new Inner(); //DOES NOT COMPILE BECAUSE IS NOT STATIC
		//Inner in = Outer.new Inner(); //DOES NOT FIND SYMBOL FOR VARIABLE OUTER
		//Outer.Inner in = new Outer.Inner(); //DOES NOT COMPILE BECAUSE IS NOT STATIC
		//Outer.Inner in = new Outer().Inner(); //DOES NOT COMPILE BECAUSE Inner() is seen as a method
		//Outer.Inner in = Outer.new Inner(); //DOES NOT FIND SYMBOL FOR VARIABLE OUTER
	}
}
