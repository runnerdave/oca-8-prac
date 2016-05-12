public class Son extends Father {
	private int j;

	public Son() {
		System.out.println("Son created");
	}

	public Son(int j) {
		this();
		this.j = j;
		System.out.println("Son type 2 created j:" + j);
	}

	public int getI(){
		return super.getI();
	}

	public int getJ(){
		return this.j;
	}

	public static void main(String... a) {
		System.out.println("===========");
		System.out.println("in Son");
		Son son = new Son();
		System.out.println("Son i:" + son.getI());
		System.out.println("===========");
		Son son2 = new Son(3);
		System.out.println("Son2 i:" + son2.getI() + "," + "j:" + son2.getJ());
	}
}