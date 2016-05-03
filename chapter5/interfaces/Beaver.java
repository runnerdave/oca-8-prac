public class Beaver extends Rodent implements Swim {

	//it does not conflict with teeth in interface, if commented out 28 is printed instead
	static int teeth = 30;	
	public static Integer chew() throws RuntimeException {
		System.out.println("Beaver is chewing on wood");
		return 2;
	}

	public void dropTeeth(int by) {
		teeth -= by;
	}

	public static void main(String... s) {
		System.out.println(Beaver.chew());
		System.out.println("how many teeth:" + teeth);
		Swim sw = new Beaver();
		System.out.println("number of teeth from the interface:" + sw.teeth);
		System.out.println("number of teeth from Beaver:" + ((Beaver)sw).teeth);
		((Beaver)sw).dropTeeth(1);
		System.out.println("how many teeth:" + teeth);
	}

	public void say() {};
}
