//FAILS TO COMPILE
//Because reuturn type in CovariantChild is not compatible with Integer
//it would work if parent myMethod returned Number and child myMethod returned Integer
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