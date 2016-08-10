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
	}
}
