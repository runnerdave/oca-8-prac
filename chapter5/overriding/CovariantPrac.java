//FAILS TO COMPILE
public class CovariantPrac {
	public Integer myMethod() {
		return 1;
	}
	public static void main(String[] args) {
		CovariantPrac cp = new CovariantChild();
		System.out.println(cp.myMethod());
	}
}

class CovariantChild extends CovariantPrac {
	public int myMethod() {
		return 2;
	}
}