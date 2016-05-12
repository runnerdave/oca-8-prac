public class Father {
	private int i = 1;

	public int getI() {
		return i;
	}

	Father(){
		System.out.println("new Father created with i:" + this.i);
		i++;
		System.out.println("new i:" + this.i);
	}
}