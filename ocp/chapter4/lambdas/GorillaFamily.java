interface Gorilla { String move(); }
public class GorillaFamily {
	String walk = "walk";
	void everyonePlay(boolean baby) {
		String approach = "amble"; 
		//approach = "run"; UNCOMMENTING this fails to compile since it makes approach not effectively final
		play(() -> walk);
		play(() -> baby ? "hitch a ride": "run"); 
		play(() -> approach);
	}
	void play(Gorilla g) {
		System.out.println(g.move());
	}
	public static void main(String... a) {
		GorillaFamily gf = new GorillaFamily();
		gf.everyonePlay(true);
	}
}