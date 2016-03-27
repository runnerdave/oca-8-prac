public class Lambda {
	public static void main(String[] args){
		System.out.println("############");
		MathOperation addition = (a, b) -> a + b;
		System.out.println(Lambda.operate(1,1,addition));
	}

	private static int operate(int a, int b, MathOperation mo){
		return mo.operation(a,b);
	}

	interface MathOperation {
		int operation(int a, int b);
	}
}
