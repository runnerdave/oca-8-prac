public class Parent {
	private int i = 1;

	public int getI() {
		return i;
	}

	Parent(){		
		System.out.println("new Parent created with i:" + this.i);
		i++;
		System.out.println("new i:" + this.i);
	}
}