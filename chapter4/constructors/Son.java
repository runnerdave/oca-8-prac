public class Son extends Father {
	private int j;
	private int k;

	public Son() {
		System.out.println("Son created");
	}

	public Son(int j) {
		this();
		this.j = j;
		System.out.println("Son type 2 created j:" + j);
	}

	public Son(int j, int k) throws Exception {
		this();
		this.j = j;
		this.k = k;
		System.out.println("Son type 3 created j:" + j + ", k:" + k);
		throw new Exception();
	}

	public int getI(){
		return super.getI();
	}

	public int getJ(){
		return this.j;
	}

	public static void main(String... a) throws Exception {
		System.out.println("===========");
		System.out.println("in Son");
		Son son = new Son();
		System.out.println("Son i:" + son.getI());
		System.out.println("===========");
		Son son2 = new Son(3);
		System.out.println("Son2 i:" + son2.getI() + "," + "j:" + son2.getJ());
		System.out.println("===========");
		Son son3 = new Son(3,4);
		System.out.println("Son3 i:" + son3.getI() + "," + "j:" + son3.getJ() + "," + "k:" + son3.k);
	}
}