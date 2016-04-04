public class UpcastingDowncastingPrac {
	
	public static void main(String... k) {
		Cat c1 = new Cat();
		System.out.println(c1);
		Animal a = c1; //automatic upcasting to Animal
		Cat c2 = (Cat) a; //manual downcasting back to a Cat
		System.out.println(c2);
	}

}

class Cat extends Animal {}