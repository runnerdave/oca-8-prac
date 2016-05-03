public interface Swim {

	void say();

	default void swimming() {
		System.out.println("I can swim");
	}

	int teeth=28;

}