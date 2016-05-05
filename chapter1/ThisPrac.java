public class ThisPrac {
	
	static int i = 1;

	int j;

	public static void main(String... a){
		//System.out.println("Prac for this i:" + this.i); DOES NOT COMPILE
		//System.out.println("Prac for this j:" + this.j); DOES NOT COMPILE
		ThisPrac tp = new ThisPrac();		
		tp.printerI();
		tp.printerJ();
		//this.printerIStatic(); DOES NOT COMPILE
	}

	void printerJ() {
		System.out.println(this.j);
	}

	void printerI() {
		System.out.println(this.i);
	}

	static void printerStatic() {
		System.out.println("static print");	
	}

}