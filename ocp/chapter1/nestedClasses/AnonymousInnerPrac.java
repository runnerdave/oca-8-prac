public class AnonymousInnerPrac {
	public static void main(String... args) {
		System.out.println("local inner prac");
		AnonymousInnerPrac instance = new AnonymousInnerPrac();
		System.out.println("instance of inner value1:" + instance.innerClass.value1);
		//System.out.println("instance of inner value:" + instance.innerClass.value); DOES NOT COMPILE
		System.out.println("instance of innerInterface method call:");
		instance.innerInterface.myMethod();
		System.out.println("instance of innerAbstractClass value3:" + instance.innerAbstractClass.value3);
		System.out.println("method value of A:");
		instance.myOtherMethod();
	}

	//sample instance
	InnerClass innerClass = new InnerClass(){
		int value = 2;
		{System.out.println("instantiated!value:" + value);}
	};

	//sample interface
	InnerInterface innerInterface = new InnerInterface() {
		public void myMethod() {System.out.println("in myMethod");};
	};

	//sample instance
	InnerAbstractClass innerAbstractClass = new InnerAbstractClass(){
		int value = 2;
		{System.out.println("instantiated abstract!value:" + value);}
	};

	public void myOtherMethod() {
		class A {
			int value4 = 4;
		}
		System.out.println(new A().value4);
	}

}

class InnerClass {
	int value1 = 1;
}

interface InnerInterface {
	int value2 = 2;

	void myMethod();
}

abstract class InnerAbstractClass {
	int value3;
}